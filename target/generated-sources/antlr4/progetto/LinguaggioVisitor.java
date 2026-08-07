// Generated from progetto/Linguaggio.g4 by ANTLR 4.13.2
package progetto;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LinguaggioParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LinguaggioVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LinguaggioParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(LinguaggioParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaggioParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(LinguaggioParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaggioParser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDec(LinguaggioParser.VarDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakCmd}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakCmd(LinguaggioParser.BreakCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nonDet}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonDet(LinguaggioParser.NonDetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssign(LinguaggioParser.ArrayAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fastAssign}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFastAssign(LinguaggioParser.FastAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code switchCmd}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchCmd(LinguaggioParser.SwitchCmdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(LinguaggioParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nop}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNop(LinguaggioParser.NopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code out}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOut(LinguaggioParser.OutContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preDecrInc}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecrInc(LinguaggioParser.PreDecrIncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code input}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(LinguaggioParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exit}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExit(LinguaggioParser.ExitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postDecrInc}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrInc(LinguaggioParser.PostDecrIncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(LinguaggioParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifElse}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(LinguaggioParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forWithFinal}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForWithFinal(LinguaggioParser.ForWithFinalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seq}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq(LinguaggioParser.SeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LinguaggioParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(LinguaggioParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivMod}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivMod(LinguaggioParser.MulDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preDecrIncExp}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecrIncExp(LinguaggioParser.PreDecrIncExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(LinguaggioParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numeric}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric(LinguaggioParser.NumericContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charLiteral}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteral(LinguaggioParser.CharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(LinguaggioParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code concat}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcat(LinguaggioParser.ConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(LinguaggioParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code complexString}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexString(LinguaggioParser.ComplexStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andOr}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOr(LinguaggioParser.AndOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cast}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCast(LinguaggioParser.CastContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(LinguaggioParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExp}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(LinguaggioParser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(LinguaggioParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cmpExp}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmpExp(LinguaggioParser.CmpExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code array}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(LinguaggioParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExp}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExp(LinguaggioParser.ParExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pow}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(LinguaggioParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAccess}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(LinguaggioParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(LinguaggioParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postDecrIncExp}
	 * labeled alternative in {@link LinguaggioParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrIncExp(LinguaggioParser.PostDecrIncExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaggioParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LinguaggioParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaggioParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseType(LinguaggioParser.BaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intNum}
	 * labeled alternative in {@link LinguaggioParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntNum(LinguaggioParser.IntNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decNum}
	 * labeled alternative in {@link LinguaggioParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecNum(LinguaggioParser.DecNumContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaggioParser#switchBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBody(LinguaggioParser.SwitchBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaggioParser#caseBranch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseBranch(LinguaggioParser.CaseBranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaggioParser#defaultBranch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultBranch(LinguaggioParser.DefaultBranchContext ctx);
}