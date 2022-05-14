// Generated from .\shared\src\main\antlr\VyxalParser.g4 by ANTLR 4.10.1
package vyxal;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link VyxalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface VyxalParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link VyxalParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(VyxalParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(VyxalParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#program_node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram_node(VyxalParser.Program_nodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(VyxalParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(VyxalParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(VyxalParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(VyxalParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#complex_number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplex_number(VyxalParser.Complex_numberContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(VyxalParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(VyxalParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(VyxalParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#for_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_loop(VyxalParser.For_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#while_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_loop(VyxalParser.While_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(VyxalParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#variable_assn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_assn(VyxalParser.Variable_assnContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(VyxalParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(VyxalParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#monadic_modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMonadic_modifier(VyxalParser.Monadic_modifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#dyadic_modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDyadic_modifier(VyxalParser.Dyadic_modifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#triadic_modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriadic_modifier(VyxalParser.Triadic_modifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#tetradic_modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTetradic_modifier(VyxalParser.Tetradic_modifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#infinite_modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfinite_modifier(VyxalParser.Infinite_modifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(VyxalParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link VyxalParser#element_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement_type(VyxalParser.Element_typeContext ctx);
}