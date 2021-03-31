package app;

import antlr.GramaticaLexer;
import antlr.GramaticaParser;
import expression.AntlrToProgram;
import expression.Declaracao;
import expression.Programa;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Semantico {

    public static void main(String[] args) {
        if(args.length!=1){
            System.err.println("Nome do Arquivo");
        } else{
            String fileName = args[0];
            GramaticaParser parser = getParser(fileName);


            ParseTree ast = parser.prog();

            AntlrToProgram progVisitor = new AntlrToProgram();
            System.out.println("***Visitando AST");
            Programa prog = progVisitor.visit(ast);

            if(progVisitor.semanticError.isEmpty()){
                System.out.println("Resultado da Análise: OK");
            } else {
                System.out.println("Resultado da Análise: "+progVisitor.semanticError.size()+ " erros encontrados");
                for(String err: progVisitor.semanticError){
                    System.out.println(err);
                }
            }

            if(progVisitor.tabelaDeSimbolos.isEmpty()){
                System.out.println("Nenhuma váriavel foi declarada.");
            }else{
                System.out.println("Imprimindo Tabela de Simbolos");
                for (Declaracao item : progVisitor.tabelaDeSimbolos) {
                    System.out.println(item);
                }
            }
        }

    }

    private static GramaticaParser getParser(String fileName) {
        GramaticaParser parser = null;

        try{
            CharStream input = CharStreams.fromFileName(fileName);
            GramaticaLexer lexer = new GramaticaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new GramaticaParser(tokens);
        } catch (IOException e){
            e.printStackTrace();
        }

        return parser;
    }

}
