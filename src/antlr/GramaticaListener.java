// Generated from Gramatica.g4 by ANTLR 4.9

    package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaticaParser}.
 */
public interface GramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Programa}
	 * labeled alternative in {@link GramaticaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(GramaticaParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Programa}
	 * labeled alternative in {@link GramaticaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(GramaticaParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Declaracao}
	 * labeled alternative in {@link GramaticaParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(GramaticaParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Declaracao}
	 * labeled alternative in {@link GramaticaParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(GramaticaParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplicacao}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicacao(GramaticaParser.MultiplicacaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplicacao}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicacao(GramaticaParser.MultiplicacaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Numero}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumero(GramaticaParser.NumeroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Numero}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumero(GramaticaParser.NumeroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(GramaticaParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(GramaticaParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenteses}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenteses(GramaticaParser.ParentesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenteses}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenteses(GramaticaParser.ParentesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Adicao}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdicao(GramaticaParser.AdicaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Adicao}
	 * labeled alternative in {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdicao(GramaticaParser.AdicaoContext ctx);
}