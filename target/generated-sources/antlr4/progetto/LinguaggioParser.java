// Generated from progetto/Linguaggio.g4 by ANTLR 4.13.2
package progetto;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LinguaggioParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, ADD=6, SUB=7, MUL=8, DIV=9, MOD=10, 
		POW=11, INCR=12, DECR=13, ADDEQ=14, SUBEQ=15, DIVEQ=16, MULEQ=17, EQQ=18, 
		NEQ=19, LEQ=20, GEQ=21, LT=22, GT=23, NOT=24, AND=25, OR=26, DOLL=27, 
		CONCAT=28, STRING_START=29, IF=30, ELSE=31, WHILE=32, ASSIGN=33, OUT=34, 
		INPUT=35, NOP=36, FOR=37, FROM=38, TO=39, BREAK=40, SWITCH=41, CASE=42, 
		DEFAULT=43, EXIT=44, DLOW=45, DGRT=46, COLON=47, QUESTIONMARK=48, LBRACK=49, 
		RBRACK=50, LPAR=51, RPAR=52, LBRACE=53, RBRACE=54, COMMA=55, SEMICOLON=56, 
		AT=57, STRING=58, BOOL=59, INT=60, DEC=61, CHAR=62, ID=63, COMMENT=64, 
		COMMENT_ML=65, WS=66;
	public static final int
		RULE_main = 0, RULE_decl = 1, RULE_varDec = 2, RULE_com = 3, RULE_exp = 4, 
		RULE_type = 5, RULE_baseType = 6, RULE_num = 7, RULE_switchBody = 8, RULE_caseBranch = 9, 
		RULE_defaultBranch = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "decl", "varDec", "com", "exp", "type", "baseType", "num", "switchBody", 
			"caseBranch", "defaultBranch"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'dec'", "'bool'", "'string'", "'char'", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'^'", "'++'", "'--'", "'+='", "'-='", "'/='", "'*='", 
			"'=='", "'!='", "'<='", "'>='", "'<'", "'>'", "'not'", "'and'", "'or'", 
			"'$'", null, null, "'if'", "'else'", "'while'", "'='", "'print'", "'input'", 
			"'nop'", "'for'", "'from'", "'to'", "'break'", "'switch'", "'case'", 
			"'default'", "'exit'", "'<<'", "'>>'", "':'", "'?'", "'['", "']'", "'('", 
			"')'", "'{'", "'}'", "','", "';'", "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "ADD", "SUB", "MUL", "DIV", "MOD", 
			"POW", "INCR", "DECR", "ADDEQ", "SUBEQ", "DIVEQ", "MULEQ", "EQQ", "NEQ", 
			"LEQ", "GEQ", "LT", "GT", "NOT", "AND", "OR", "DOLL", "CONCAT", "STRING_START", 
			"IF", "ELSE", "WHILE", "ASSIGN", "OUT", "INPUT", "NOP", "FOR", "FROM", 
			"TO", "BREAK", "SWITCH", "CASE", "DEFAULT", "EXIT", "DLOW", "DGRT", "COLON", 
			"QUESTIONMARK", "LBRACK", "RBRACK", "LPAR", "RPAR", "LBRACE", "RBRACE", 
			"COMMA", "SEMICOLON", "AT", "STRING", "BOOL", "INT", "DEC", "CHAR", "ID", 
			"COMMENT", "COMMENT_ML", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Linguaggio.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LinguaggioParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LinguaggioParser.EOF, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			decl();
			setState(23);
			com(0);
			setState(24);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public List<VarDecContext> varDec() {
			return getRuleContexts(VarDecContext.class);
		}
		public VarDecContext varDec(int i) {
			return getRuleContext(VarDecContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 62L) != 0)) {
				{
				{
				setState(26);
				varDec();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(LinguaggioParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(LinguaggioParser.SEMICOLON, 0); }
		public TerminalNode ASSIGN() { return getToken(LinguaggioParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VarDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitVarDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecContext varDec() throws RecognitionException {
		VarDecContext _localctx = new VarDecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			type();
			setState(33);
			match(ID);
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(34);
				match(ASSIGN);
				setState(35);
				exp(0);
				}
			}

			setState(38);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComContext extends ParserRuleContext {
		public ComContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_com; }
	 
		public ComContext() { }
		public void copyFrom(ComContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BreakCmdContext extends ComContext {
		public TerminalNode BREAK() { return getToken(LinguaggioParser.BREAK, 0); }
		public BreakCmdContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitBreakCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NonDetContext extends ComContext {
		public TerminalNode DLOW() { return getToken(LinguaggioParser.DLOW, 0); }
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public TerminalNode DGRT() { return getToken(LinguaggioParser.DGRT, 0); }
		public List<TerminalNode> AT() { return getTokens(LinguaggioParser.AT); }
		public TerminalNode AT(int i) {
			return getToken(LinguaggioParser.AT, i);
		}
		public NonDetContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitNonDet(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAssignContext extends ComContext {
		public TerminalNode ID() { return getToken(LinguaggioParser.ID, 0); }
		public TerminalNode LBRACK() { return getToken(LinguaggioParser.LBRACK, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode RBRACK() { return getToken(LinguaggioParser.RBRACK, 0); }
		public TerminalNode ASSIGN() { return getToken(LinguaggioParser.ASSIGN, 0); }
		public ArrayAssignContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitArrayAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FastAssignContext extends ComContext {
		public Token op;
		public TerminalNode ID() { return getToken(LinguaggioParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ADDEQ() { return getToken(LinguaggioParser.ADDEQ, 0); }
		public TerminalNode SUBEQ() { return getToken(LinguaggioParser.SUBEQ, 0); }
		public TerminalNode DIVEQ() { return getToken(LinguaggioParser.DIVEQ, 0); }
		public TerminalNode MULEQ() { return getToken(LinguaggioParser.MULEQ, 0); }
		public FastAssignContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitFastAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SwitchCmdContext extends ComContext {
		public TerminalNode SWITCH() { return getToken(LinguaggioParser.SWITCH, 0); }
		public TerminalNode LPAR() { return getToken(LinguaggioParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(LinguaggioParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(LinguaggioParser.LBRACE, 0); }
		public SwitchBodyContext switchBody() {
			return getRuleContext(SwitchBodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(LinguaggioParser.RBRACE, 0); }
		public SwitchCmdContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitSwitchCmd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ComContext {
		public TerminalNode WHILE() { return getToken(LinguaggioParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(LinguaggioParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(LinguaggioParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(LinguaggioParser.LBRACE, 0); }
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(LinguaggioParser.RBRACE, 0); }
		public WhileContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NopContext extends ComContext {
		public TerminalNode NOP() { return getToken(LinguaggioParser.NOP, 0); }
		public NopContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitNop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OutContext extends ComContext {
		public TerminalNode OUT() { return getToken(LinguaggioParser.OUT, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public OutContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitOut(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PreDecrIncContext extends ComContext {
		public Token op;
		public TerminalNode ID() { return getToken(LinguaggioParser.ID, 0); }
		public TerminalNode DECR() { return getToken(LinguaggioParser.DECR, 0); }
		public TerminalNode INCR() { return getToken(LinguaggioParser.INCR, 0); }
		public PreDecrIncContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitPreDecrInc(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InputContext extends ComContext {
		public TerminalNode INPUT() { return getToken(LinguaggioParser.INPUT, 0); }
		public TerminalNode ID() { return getToken(LinguaggioParser.ID, 0); }
		public InputContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExitContext extends ComContext {
		public TerminalNode EXIT() { return getToken(LinguaggioParser.EXIT, 0); }
		public ExitContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitExit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostDecrIncContext extends ComContext {
		public Token op;
		public TerminalNode ID() { return getToken(LinguaggioParser.ID, 0); }
		public TerminalNode DECR() { return getToken(LinguaggioParser.DECR, 0); }
		public TerminalNode INCR() { return getToken(LinguaggioParser.INCR, 0); }
		public PostDecrIncContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitPostDecrInc(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ComContext {
		public TerminalNode IF() { return getToken(LinguaggioParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(LinguaggioParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(LinguaggioParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(LinguaggioParser.LBRACE, 0); }
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(LinguaggioParser.RBRACE, 0); }
		public IfContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfElseContext extends ComContext {
		public TerminalNode IF() { return getToken(LinguaggioParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(LinguaggioParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(LinguaggioParser.RPAR, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(LinguaggioParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(LinguaggioParser.LBRACE, i);
		}
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(LinguaggioParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(LinguaggioParser.RBRACE, i);
		}
		public TerminalNode ELSE() { return getToken(LinguaggioParser.ELSE, 0); }
		public IfElseContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitIfElse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForWithFinalContext extends ComContext {
		public TerminalNode FOR() { return getToken(LinguaggioParser.FOR, 0); }
		public TerminalNode ID() { return getToken(LinguaggioParser.ID, 0); }
		public TerminalNode FROM() { return getToken(LinguaggioParser.FROM, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TO() { return getToken(LinguaggioParser.TO, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(LinguaggioParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(LinguaggioParser.LBRACE, i);
		}
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(LinguaggioParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(LinguaggioParser.RBRACE, i);
		}
		public TerminalNode ELSE() { return getToken(LinguaggioParser.ELSE, 0); }
		public ForWithFinalContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitForWithFinal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SeqContext extends ComContext {
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(LinguaggioParser.SEMICOLON, 0); }
		public SeqContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitSeq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ComContext {
		public TerminalNode ID() { return getToken(LinguaggioParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(LinguaggioParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssignContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComContext com() throws RecognitionException {
		return com(0);
	}

	private ComContext com(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ComContext _localctx = new ComContext(_ctx, _parentState);
		ComContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_com, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new PreDecrIncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(41);
				((PreDecrIncContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INCR || _la==DECR) ) {
					((PreDecrIncContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(42);
				match(ID);
				}
				break;
			case 2:
				{
				_localctx = new PostDecrIncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43);
				match(ID);
				setState(44);
				((PostDecrIncContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INCR || _la==DECR) ) {
					((PostDecrIncContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				match(ID);
				setState(46);
				match(ASSIGN);
				setState(47);
				exp(0);
				}
				break;
			case 4:
				{
				_localctx = new FastAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				match(ID);
				setState(49);
				((FastAssignContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0)) ) {
					((FastAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(50);
				exp(0);
				}
				break;
			case 5:
				{
				_localctx = new ArrayAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				match(ID);
				setState(52);
				match(LBRACK);
				setState(53);
				exp(0);
				setState(54);
				match(RBRACK);
				setState(55);
				match(ASSIGN);
				setState(56);
				exp(0);
				}
				break;
			case 6:
				{
				_localctx = new IfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58);
				match(IF);
				setState(59);
				match(LPAR);
				setState(60);
				exp(0);
				setState(61);
				match(RPAR);
				setState(62);
				match(LBRACE);
				setState(63);
				com(0);
				setState(64);
				match(RBRACE);
				}
				break;
			case 7:
				{
				_localctx = new IfElseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				match(IF);
				setState(67);
				match(LPAR);
				setState(68);
				exp(0);
				setState(69);
				match(RPAR);
				setState(70);
				match(LBRACE);
				setState(71);
				com(0);
				setState(72);
				match(RBRACE);
				setState(73);
				match(ELSE);
				setState(74);
				match(LBRACE);
				setState(75);
				com(0);
				setState(76);
				match(RBRACE);
				}
				break;
			case 8:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(WHILE);
				setState(79);
				match(LPAR);
				setState(80);
				exp(0);
				setState(81);
				match(RPAR);
				setState(82);
				match(LBRACE);
				setState(83);
				com(0);
				setState(84);
				match(RBRACE);
				}
				break;
			case 9:
				{
				_localctx = new OutContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(OUT);
				setState(87);
				exp(0);
				}
				break;
			case 10:
				{
				_localctx = new NopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				match(NOP);
				}
				break;
			case 11:
				{
				_localctx = new InputContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				match(INPUT);
				setState(90);
				match(ID);
				}
				break;
			case 12:
				{
				_localctx = new NonDetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				match(DLOW);
				setState(92);
				com(0);
				setState(95); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(93);
					match(AT);
					setState(94);
					com(0);
					}
					}
					setState(97); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==AT );
				setState(99);
				match(DGRT);
				}
				break;
			case 13:
				{
				_localctx = new ForWithFinalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				match(FOR);
				setState(102);
				match(ID);
				setState(103);
				match(FROM);
				setState(104);
				exp(0);
				setState(105);
				match(TO);
				setState(106);
				exp(0);
				setState(107);
				match(LBRACE);
				setState(108);
				com(0);
				setState(109);
				match(RBRACE);
				setState(115);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(110);
					match(ELSE);
					setState(111);
					match(LBRACE);
					setState(112);
					com(0);
					setState(113);
					match(RBRACE);
					}
					break;
				}
				}
				break;
			case 14:
				{
				_localctx = new BreakCmdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(BREAK);
				}
				break;
			case 15:
				{
				_localctx = new SwitchCmdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				match(SWITCH);
				setState(119);
				match(LPAR);
				setState(120);
				exp(0);
				setState(121);
				match(RPAR);
				setState(122);
				match(LBRACE);
				setState(123);
				switchBody();
				setState(124);
				match(RBRACE);
				}
				break;
			case 16:
				{
				_localctx = new ExitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126);
				match(EXIT);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SeqContext(new ComContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_com);
					setState(129);
					if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
					setState(130);
					match(SEMICOLON);
					setState(131);
					com(10);
					}
					} 
				}
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivModContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode MUL() { return getToken(LinguaggioParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(LinguaggioParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(LinguaggioParser.MOD, 0); }
		public MulDivModContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitMulDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PreDecrIncExpContext extends ExpContext {
		public Token op;
		public TerminalNode ID() { return getToken(LinguaggioParser.ID, 0); }
		public TerminalNode DECR() { return getToken(LinguaggioParser.DECR, 0); }
		public TerminalNode INCR() { return getToken(LinguaggioParser.INCR, 0); }
		public PreDecrIncExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitPreDecrIncExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExpContext {
		public TerminalNode STRING() { return getToken(LinguaggioParser.STRING, 0); }
		public StringContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumericContext extends ExpContext {
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public NumericContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitNumeric(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharLiteralContext extends ExpContext {
		public TerminalNode CHAR() { return getToken(LinguaggioParser.CHAR, 0); }
		public CharLiteralContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitCharLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode ADD() { return getToken(LinguaggioParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(LinguaggioParser.SUB, 0); }
		public AddSubContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConcatContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode CONCAT() { return getToken(LinguaggioParser.CONCAT, 0); }
		public ConcatContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode QUESTIONMARK() { return getToken(LinguaggioParser.QUESTIONMARK, 0); }
		public TerminalNode COLON() { return getToken(LinguaggioParser.COLON, 0); }
		public IfStatementContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComplexStringContext extends ExpContext {
		public TerminalNode STRING_START() { return getToken(LinguaggioParser.STRING_START, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(LinguaggioParser.RBRACE, 0); }
		public ComplexStringContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitComplexString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndOrContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode AND() { return getToken(LinguaggioParser.AND, 0); }
		public TerminalNode OR() { return getToken(LinguaggioParser.OR, 0); }
		public AndOrContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitAndOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CastContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(LinguaggioParser.LPAR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(LinguaggioParser.RPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public CastContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitCast(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ExpContext {
		public TerminalNode NOT() { return getToken(LinguaggioParser.NOT, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public NotContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqExpContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode EQQ() { return getToken(LinguaggioParser.EQQ, 0); }
		public TerminalNode NEQ() { return getToken(LinguaggioParser.NEQ, 0); }
		public EqExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitEqExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ExpContext {
		public TerminalNode BOOL() { return getToken(LinguaggioParser.BOOL, 0); }
		public BooleanContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CmpExpContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode LT() { return getToken(LinguaggioParser.LT, 0); }
		public TerminalNode LEQ() { return getToken(LinguaggioParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(LinguaggioParser.GEQ, 0); }
		public TerminalNode GT() { return getToken(LinguaggioParser.GT, 0); }
		public CmpExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitCmpExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ExpContext {
		public TerminalNode LBRACK() { return getToken(LinguaggioParser.LBRACK, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode RBRACK() { return getToken(LinguaggioParser.RBRACK, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LinguaggioParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LinguaggioParser.COMMA, i);
		}
		public ArrayContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParExpContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(LinguaggioParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(LinguaggioParser.RPAR, 0); }
		public ParExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitParExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PowContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode POW() { return getToken(LinguaggioParser.POW, 0); }
		public PowContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitPow(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccessContext extends ExpContext {
		public TerminalNode ID() { return getToken(LinguaggioParser.ID, 0); }
		public TerminalNode LBRACK() { return getToken(LinguaggioParser.LBRACK, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(LinguaggioParser.RBRACK, 0); }
		public ArrayAccessContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ExpContext {
		public TerminalNode ID() { return getToken(LinguaggioParser.ID, 0); }
		public IdContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostDecrIncExpContext extends ExpContext {
		public Token op;
		public TerminalNode ID() { return getToken(LinguaggioParser.ID, 0); }
		public TerminalNode DECR() { return getToken(LinguaggioParser.DECR, 0); }
		public TerminalNode INCR() { return getToken(LinguaggioParser.INCR, 0); }
		public PostDecrIncExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitPostDecrIncExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new ArrayAccessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(138);
				match(ID);
				setState(139);
				match(LBRACK);
				setState(140);
				exp(0);
				setState(141);
				match(RBRACK);
				}
				break;
			case 2:
				{
				_localctx = new CastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(LPAR);
				setState(144);
				type();
				setState(145);
				match(RPAR);
				setState(146);
				exp(20);
				}
				break;
			case 3:
				{
				_localctx = new CharLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				match(CHAR);
				}
				break;
			case 4:
				{
				_localctx = new NumericContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				num();
				}
				break;
			case 5:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				match(BOOL);
				}
				break;
			case 6:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				match(STRING);
				}
				break;
			case 7:
				{
				_localctx = new ComplexStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				match(STRING_START);
				setState(153);
				exp(0);
				setState(154);
				match(RBRACE);
				}
				break;
			case 8:
				{
				_localctx = new ParExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				match(LPAR);
				setState(157);
				exp(0);
				setState(158);
				match(RPAR);
				}
				break;
			case 9:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				match(NOT);
				setState(161);
				exp(12);
				}
				break;
			case 10:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				match(ID);
				}
				break;
			case 11:
				{
				_localctx = new ArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				match(LBRACK);
				setState(164);
				exp(0);
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(165);
					match(COMMA);
					setState(166);
					exp(0);
					}
					}
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(172);
				match(RBRACK);
				}
				break;
			case 12:
				{
				_localctx = new PreDecrIncExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				((PreDecrIncExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INCR || _la==DECR) ) {
					((PreDecrIncExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(175);
				match(ID);
				}
				break;
			case 13:
				{
				_localctx = new PostDecrIncExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176);
				match(ID);
				setState(177);
				((PostDecrIncExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INCR || _la==DECR) ) {
					((PostDecrIncExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(209);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(207);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new PowContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(180);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(181);
						match(POW);
						setState(182);
						exp(13);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(183);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(184);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(185);
						exp(12);
						}
						break;
					case 3:
						{
						_localctx = new AddSubContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(186);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(187);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(188);
						exp(11);
						}
						break;
					case 4:
						{
						_localctx = new CmpExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(189);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(190);
						((CmpExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15728640L) != 0)) ) {
							((CmpExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(191);
						exp(10);
						}
						break;
					case 5:
						{
						_localctx = new EqExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(192);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(193);
						((EqExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQQ || _la==NEQ) ) {
							((EqExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(194);
						exp(9);
						}
						break;
					case 6:
						{
						_localctx = new AndOrContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(195);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(196);
						((AndOrContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((AndOrContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(197);
						exp(8);
						}
						break;
					case 7:
						{
						_localctx = new ConcatContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(198);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(199);
						match(CONCAT);
						setState(200);
						exp(7);
						}
						break;
					case 8:
						{
						_localctx = new IfStatementContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(201);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(202);
						match(QUESTIONMARK);
						setState(203);
						exp(0);
						setState(204);
						match(COLON);
						setState(205);
						exp(5);
						}
						break;
					}
					} 
				}
				setState(211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(LinguaggioParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(LinguaggioParser.RBRACK, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			baseType();
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(213);
				match(LBRACK);
				setState(214);
				match(RBRACK);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BaseTypeContext extends ParserRuleContext {
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 62L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumContext extends ParserRuleContext {
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
	 
		public NumContext() { }
		public void copyFrom(NumContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecNumContext extends NumContext {
		public TerminalNode DEC() { return getToken(LinguaggioParser.DEC, 0); }
		public DecNumContext(NumContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitDecNum(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntNumContext extends NumContext {
		public TerminalNode INT() { return getToken(LinguaggioParser.INT, 0); }
		public IntNumContext(NumContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitIntNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_num);
		try {
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntNumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				match(INT);
				}
				break;
			case DEC:
				_localctx = new DecNumContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				match(DEC);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchBodyContext extends ParserRuleContext {
		public List<CaseBranchContext> caseBranch() {
			return getRuleContexts(CaseBranchContext.class);
		}
		public CaseBranchContext caseBranch(int i) {
			return getRuleContext(CaseBranchContext.class,i);
		}
		public DefaultBranchContext defaultBranch() {
			return getRuleContext(DefaultBranchContext.class,0);
		}
		public SwitchBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitSwitchBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchBodyContext switchBody() throws RecognitionException {
		SwitchBodyContext _localctx = new SwitchBodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_switchBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(223);
				caseBranch();
				}
				}
				setState(226); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE );
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(228);
				defaultBranch();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseBranchContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(LinguaggioParser.CASE, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode COLON() { return getToken(LinguaggioParser.COLON, 0); }
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(LinguaggioParser.SEMICOLON, 0); }
		public CaseBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBranch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitCaseBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseBranchContext caseBranch() throws RecognitionException {
		CaseBranchContext _localctx = new CaseBranchContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_caseBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(CASE);
			setState(232);
			exp(0);
			setState(233);
			match(COLON);
			setState(234);
			com(0);
			setState(235);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultBranchContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(LinguaggioParser.DEFAULT, 0); }
		public TerminalNode COLON() { return getToken(LinguaggioParser.COLON, 0); }
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public DefaultBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultBranch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaggioVisitor ) return ((LinguaggioVisitor<? extends T>)visitor).visitDefaultBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultBranchContext defaultBranch() throws RecognitionException {
		DefaultBranchContext _localctx = new DefaultBranchContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_defaultBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(DEFAULT);
			setState(238);
			match(COLON);
			setState(239);
			com(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return com_sempred((ComContext)_localctx, predIndex);
		case 4:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean com_sempred(ComContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001B\u00f2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0005\u0001\u001c\b\u0001\n\u0001\f\u0001"+
		"\u001f\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"%\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003`\b\u0003"+
		"\u000b\u0003\f\u0003a\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003t\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003\u0080\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"\u0085\b\u0003\n\u0003\f\u0003\u0088\t\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u00a8\b\u0004\n"+
		"\u0004\f\u0004\u00ab\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00b3\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004\u00d0\b\u0004\n\u0004\f\u0004\u00d3\t\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00d8\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u00de\b\u0007\u0001\b"+
		"\u0004\b\u00e1\b\b\u000b\b\f\b\u00e2\u0001\b\u0003\b\u00e6\b\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0000\u0002\u0006\b\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0000\b\u0001\u0000\f\r\u0001\u0000\u000e\u0011\u0001"+
		"\u0000\b\n\u0001\u0000\u0006\u0007\u0001\u0000\u0014\u0017\u0001\u0000"+
		"\u0012\u0013\u0001\u0000\u0019\u001a\u0001\u0000\u0001\u0005\u0113\u0000"+
		"\u0016\u0001\u0000\u0000\u0000\u0002\u001d\u0001\u0000\u0000\u0000\u0004"+
		" \u0001\u0000\u0000\u0000\u0006\u007f\u0001\u0000\u0000\u0000\b\u00b2"+
		"\u0001\u0000\u0000\u0000\n\u00d4\u0001\u0000\u0000\u0000\f\u00d9\u0001"+
		"\u0000\u0000\u0000\u000e\u00dd\u0001\u0000\u0000\u0000\u0010\u00e0\u0001"+
		"\u0000\u0000\u0000\u0012\u00e7\u0001\u0000\u0000\u0000\u0014\u00ed\u0001"+
		"\u0000\u0000\u0000\u0016\u0017\u0003\u0002\u0001\u0000\u0017\u0018\u0003"+
		"\u0006\u0003\u0000\u0018\u0019\u0005\u0000\u0000\u0001\u0019\u0001\u0001"+
		"\u0000\u0000\u0000\u001a\u001c\u0003\u0004\u0002\u0000\u001b\u001a\u0001"+
		"\u0000\u0000\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d\u001b\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u0003\u0001"+
		"\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000 !\u0003\n\u0005"+
		"\u0000!$\u0005?\u0000\u0000\"#\u0005!\u0000\u0000#%\u0003\b\u0004\u0000"+
		"$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000"+
		"\u0000&\'\u00058\u0000\u0000\'\u0005\u0001\u0000\u0000\u0000()\u0006\u0003"+
		"\uffff\uffff\u0000)*\u0007\u0000\u0000\u0000*\u0080\u0005?\u0000\u0000"+
		"+,\u0005?\u0000\u0000,\u0080\u0007\u0000\u0000\u0000-.\u0005?\u0000\u0000"+
		"./\u0005!\u0000\u0000/\u0080\u0003\b\u0004\u000001\u0005?\u0000\u0000"+
		"12\u0007\u0001\u0000\u00002\u0080\u0003\b\u0004\u000034\u0005?\u0000\u0000"+
		"45\u00051\u0000\u000056\u0003\b\u0004\u000067\u00052\u0000\u000078\u0005"+
		"!\u0000\u000089\u0003\b\u0004\u00009\u0080\u0001\u0000\u0000\u0000:;\u0005"+
		"\u001e\u0000\u0000;<\u00053\u0000\u0000<=\u0003\b\u0004\u0000=>\u0005"+
		"4\u0000\u0000>?\u00055\u0000\u0000?@\u0003\u0006\u0003\u0000@A\u00056"+
		"\u0000\u0000A\u0080\u0001\u0000\u0000\u0000BC\u0005\u001e\u0000\u0000"+
		"CD\u00053\u0000\u0000DE\u0003\b\u0004\u0000EF\u00054\u0000\u0000FG\u0005"+
		"5\u0000\u0000GH\u0003\u0006\u0003\u0000HI\u00056\u0000\u0000IJ\u0005\u001f"+
		"\u0000\u0000JK\u00055\u0000\u0000KL\u0003\u0006\u0003\u0000LM\u00056\u0000"+
		"\u0000M\u0080\u0001\u0000\u0000\u0000NO\u0005 \u0000\u0000OP\u00053\u0000"+
		"\u0000PQ\u0003\b\u0004\u0000QR\u00054\u0000\u0000RS\u00055\u0000\u0000"+
		"ST\u0003\u0006\u0003\u0000TU\u00056\u0000\u0000U\u0080\u0001\u0000\u0000"+
		"\u0000VW\u0005\"\u0000\u0000W\u0080\u0003\b\u0004\u0000X\u0080\u0005$"+
		"\u0000\u0000YZ\u0005#\u0000\u0000Z\u0080\u0005?\u0000\u0000[\\\u0005-"+
		"\u0000\u0000\\_\u0003\u0006\u0003\u0000]^\u00059\u0000\u0000^`\u0003\u0006"+
		"\u0003\u0000_]\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a_\u0001"+
		"\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000"+
		"cd\u0005.\u0000\u0000d\u0080\u0001\u0000\u0000\u0000ef\u0005%\u0000\u0000"+
		"fg\u0005?\u0000\u0000gh\u0005&\u0000\u0000hi\u0003\b\u0004\u0000ij\u0005"+
		"\'\u0000\u0000jk\u0003\b\u0004\u0000kl\u00055\u0000\u0000lm\u0003\u0006"+
		"\u0003\u0000ms\u00056\u0000\u0000no\u0005\u001f\u0000\u0000op\u00055\u0000"+
		"\u0000pq\u0003\u0006\u0003\u0000qr\u00056\u0000\u0000rt\u0001\u0000\u0000"+
		"\u0000sn\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t\u0080\u0001"+
		"\u0000\u0000\u0000u\u0080\u0005(\u0000\u0000vw\u0005)\u0000\u0000wx\u0005"+
		"3\u0000\u0000xy\u0003\b\u0004\u0000yz\u00054\u0000\u0000z{\u00055\u0000"+
		"\u0000{|\u0003\u0010\b\u0000|}\u00056\u0000\u0000}\u0080\u0001\u0000\u0000"+
		"\u0000~\u0080\u0005,\u0000\u0000\u007f(\u0001\u0000\u0000\u0000\u007f"+
		"+\u0001\u0000\u0000\u0000\u007f-\u0001\u0000\u0000\u0000\u007f0\u0001"+
		"\u0000\u0000\u0000\u007f3\u0001\u0000\u0000\u0000\u007f:\u0001\u0000\u0000"+
		"\u0000\u007fB\u0001\u0000\u0000\u0000\u007fN\u0001\u0000\u0000\u0000\u007f"+
		"V\u0001\u0000\u0000\u0000\u007fX\u0001\u0000\u0000\u0000\u007fY\u0001"+
		"\u0000\u0000\u0000\u007f[\u0001\u0000\u0000\u0000\u007fe\u0001\u0000\u0000"+
		"\u0000\u007fu\u0001\u0000\u0000\u0000\u007fv\u0001\u0000\u0000\u0000\u007f"+
		"~\u0001\u0000\u0000\u0000\u0080\u0086\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\n\t\u0000\u0000\u0082\u0083\u00058\u0000\u0000\u0083\u0085\u0003\u0006"+
		"\u0003\n\u0084\u0081\u0001\u0000\u0000\u0000\u0085\u0088\u0001\u0000\u0000"+
		"\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000"+
		"\u0000\u0087\u0007\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0006\u0004\uffff\uffff\u0000\u008a\u008b\u0005?\u0000"+
		"\u0000\u008b\u008c\u00051\u0000\u0000\u008c\u008d\u0003\b\u0004\u0000"+
		"\u008d\u008e\u00052\u0000\u0000\u008e\u00b3\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u00053\u0000\u0000\u0090\u0091\u0003\n\u0005\u0000\u0091\u0092"+
		"\u00054\u0000\u0000\u0092\u0093\u0003\b\u0004\u0014\u0093\u00b3\u0001"+
		"\u0000\u0000\u0000\u0094\u00b3\u0005>\u0000\u0000\u0095\u00b3\u0003\u000e"+
		"\u0007\u0000\u0096\u00b3\u0005;\u0000\u0000\u0097\u00b3\u0005:\u0000\u0000"+
		"\u0098\u0099\u0005\u001d\u0000\u0000\u0099\u009a\u0003\b\u0004\u0000\u009a"+
		"\u009b\u00056\u0000\u0000\u009b\u00b3\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u00053\u0000\u0000\u009d\u009e\u0003\b\u0004\u0000\u009e\u009f\u0005"+
		"4\u0000\u0000\u009f\u00b3\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\u0018"+
		"\u0000\u0000\u00a1\u00b3\u0003\b\u0004\f\u00a2\u00b3\u0005?\u0000\u0000"+
		"\u00a3\u00a4\u00051\u0000\u0000\u00a4\u00a9\u0003\b\u0004\u0000\u00a5"+
		"\u00a6\u00057\u0000\u0000\u00a6\u00a8\u0003\b\u0004\u0000\u00a7\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ac"+
		"\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00ad"+
		"\u00052\u0000\u0000\u00ad\u00b3\u0001\u0000\u0000\u0000\u00ae\u00af\u0007"+
		"\u0000\u0000\u0000\u00af\u00b3\u0005?\u0000\u0000\u00b0\u00b1\u0005?\u0000"+
		"\u0000\u00b1\u00b3\u0007\u0000\u0000\u0000\u00b2\u0089\u0001\u0000\u0000"+
		"\u0000\u00b2\u008f\u0001\u0000\u0000\u0000\u00b2\u0094\u0001\u0000\u0000"+
		"\u0000\u00b2\u0095\u0001\u0000\u0000\u0000\u00b2\u0096\u0001\u0000\u0000"+
		"\u0000\u00b2\u0097\u0001\u0000\u0000\u0000\u00b2\u0098\u0001\u0000\u0000"+
		"\u0000\u00b2\u009c\u0001\u0000\u0000\u0000\u00b2\u00a0\u0001\u0000\u0000"+
		"\u0000\u00b2\u00a2\u0001\u0000\u0000\u0000\u00b2\u00a3\u0001\u0000\u0000"+
		"\u0000\u00b2\u00ae\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b3\u00d1\u0001\u0000\u0000\u0000\u00b4\u00b5\n\r\u0000\u0000"+
		"\u00b5\u00b6\u0005\u000b\u0000\u0000\u00b6\u00d0\u0003\b\u0004\r\u00b7"+
		"\u00b8\n\u000b\u0000\u0000\u00b8\u00b9\u0007\u0002\u0000\u0000\u00b9\u00d0"+
		"\u0003\b\u0004\f\u00ba\u00bb\n\n\u0000\u0000\u00bb\u00bc\u0007\u0003\u0000"+
		"\u0000\u00bc\u00d0\u0003\b\u0004\u000b\u00bd\u00be\n\t\u0000\u0000\u00be"+
		"\u00bf\u0007\u0004\u0000\u0000\u00bf\u00d0\u0003\b\u0004\n\u00c0\u00c1"+
		"\n\b\u0000\u0000\u00c1\u00c2\u0007\u0005\u0000\u0000\u00c2\u00d0\u0003"+
		"\b\u0004\t\u00c3\u00c4\n\u0007\u0000\u0000\u00c4\u00c5\u0007\u0006\u0000"+
		"\u0000\u00c5\u00d0\u0003\b\u0004\b\u00c6\u00c7\n\u0006\u0000\u0000\u00c7"+
		"\u00c8\u0005\u001c\u0000\u0000\u00c8\u00d0\u0003\b\u0004\u0007\u00c9\u00ca"+
		"\n\u0005\u0000\u0000\u00ca\u00cb\u00050\u0000\u0000\u00cb\u00cc\u0003"+
		"\b\u0004\u0000\u00cc\u00cd\u0005/\u0000\u0000\u00cd\u00ce\u0003\b\u0004"+
		"\u0005\u00ce\u00d0\u0001\u0000\u0000\u0000\u00cf\u00b4\u0001\u0000\u0000"+
		"\u0000\u00cf\u00b7\u0001\u0000\u0000\u0000\u00cf\u00ba\u0001\u0000\u0000"+
		"\u0000\u00cf\u00bd\u0001\u0000\u0000\u0000\u00cf\u00c0\u0001\u0000\u0000"+
		"\u0000\u00cf\u00c3\u0001\u0000\u0000\u0000\u00cf\u00c6\u0001\u0000\u0000"+
		"\u0000\u00cf\u00c9\u0001\u0000\u0000\u0000\u00d0\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d2\t\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d7\u0003\f\u0006\u0000\u00d5\u00d6\u00051\u0000\u0000\u00d6"+
		"\u00d8\u00052\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d8\u000b\u0001\u0000\u0000\u0000\u00d9\u00da"+
		"\u0007\u0007\u0000\u0000\u00da\r\u0001\u0000\u0000\u0000\u00db\u00de\u0005"+
		"<\u0000\u0000\u00dc\u00de\u0005=\u0000\u0000\u00dd\u00db\u0001\u0000\u0000"+
		"\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de\u000f\u0001\u0000\u0000"+
		"\u0000\u00df\u00e1\u0003\u0012\t\u0000\u00e0\u00df\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e4\u00e6\u0003\u0014\n\u0000\u00e5\u00e4\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e6\u0001\u0000\u0000\u0000\u00e6\u0011\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e8\u0005*\u0000\u0000\u00e8\u00e9\u0003\b\u0004\u0000\u00e9\u00ea"+
		"\u0005/\u0000\u0000\u00ea\u00eb\u0003\u0006\u0003\u0000\u00eb\u00ec\u0005"+
		"8\u0000\u0000\u00ec\u0013\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005+\u0000"+
		"\u0000\u00ee\u00ef\u0005/\u0000\u0000\u00ef\u00f0\u0003\u0006\u0003\u0000"+
		"\u00f0\u0015\u0001\u0000\u0000\u0000\u000e\u001d$as\u007f\u0086\u00a9"+
		"\u00b2\u00cf\u00d1\u00d7\u00dd\u00e2\u00e5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}