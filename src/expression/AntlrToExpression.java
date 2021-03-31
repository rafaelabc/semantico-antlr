package expression;

import antlr.GramaticaBaseVisitor;
import antlr.GramaticaParser;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AntlrToExpression extends GramaticaBaseVisitor<Expression> {

    private ArrayList<Declaracao> declaredVariables;
    private List<String> semanticErrors;

    /*
     * Semantic Errors:
     * (1) Duplicate variable declaration;
     * (2) Variable not declared.
     * (3) Type conflict
     * */

    public AntlrToExpression(List<String> semanticErrors, ArrayList<Declaracao> tabelaDeSimbolos) {
        this.declaredVariables = tabelaDeSimbolos;
        this.semanticErrors = semanticErrors;
    }

    @Override
    public Expression visitDeclaracao(GramaticaParser.DeclaracaoContext ctx) {
        Token token = ctx.TYPE().getSymbol();
        int linha = token.getLine();
        int coluna = token.getCharPositionInLine();
        String type = ctx.TYPE().getText();
        String id = ctx.ID().getText();
        String value = ctx.NUM().getText();

        Declaracao decl = new Declaracao(id,type);

        for (Declaracao variavelDeclarada : declaredVariables) {
            if(variavelDeclarada.id.equals(decl.id)){
                semanticErrors.add("Erro: Variavel " + decl.id + " já foi declarada anteriormente");
                return decl;
            }
        }

        String expectedType;
        if (value.matches("[0-9]*\\.[0-9]+")) {
            expectedType= "float";
            decl.fvalue = Float.parseFloat(value);

        }else{
            expectedType= "int";
            decl.ivalue=Integer.parseInt(value);
        }
        if (!Objects.equals(type,expectedType)){
            semanticErrors.add("Erro: Variável " + id + " é "+type+", mas o valor atribuído é "+expectedType+" (" + linha + "," + coluna + ").");
        }else{
            declaredVariables.add(decl);
        }
        return decl;
    }


    @Override
    public Expression visitNumero(GramaticaParser.NumeroContext ctx) {
        String numtxt = ctx.getChild(0).getText();
        if(numtxt.matches("[-+]?[0-9]*\\.[0-9]+")){
            return new Numero(Float.parseFloat(numtxt));
        } else{
            return new Numero(Integer.parseInt(numtxt));
        }

    }

    @Override
    public Expression visitVariavel(GramaticaParser.VariavelContext ctx) {
        String id=ctx.getChild(0).getText();
        return new Variavel(id);
    }

    @Override
    public Expression visitAdicao(GramaticaParser.AdicaoContext ctx) {
        Expression left=visit(ctx.getChild(0));
        Expression right=visit(ctx.getChild(2));
        Adicao adicao = new Adicao(left,right);
        if (left.type=="int" && right.type=="int"){
            adicao.setType("int");
        }
        else{
            adicao.setType("float");
        }
        return adicao;
    }

    @Override
    public Expression visitMultiplicacao(GramaticaParser.MultiplicacaoContext ctx){
        Expression left=visit(ctx.getChild(0));
        Expression right=visit(ctx.getChild(2));
        Multiplicacao multiplicacao = new Multiplicacao(left,right);
        if (left.type=="int" && right.type=="int"){
            multiplicacao.setType("int");
        }
        else{
            multiplicacao.setType("float");
        }
        return  multiplicacao;

    }

}
