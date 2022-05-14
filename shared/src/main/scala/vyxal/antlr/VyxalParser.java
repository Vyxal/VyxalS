// Generated from .\shared\src\main\antlr\VyxalParser.g4 by ANTLR 4.10.1
package vyxal;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VyxalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PREFIX=1, CONTEXT_VAR=2, MONADIC_MODIFIER=3, DYADIC_MODIFIER=4, TRIADIC_MODIFIER=5, 
		TETRADIC_MODIFIER=6, INFINITE_MODIFIER=7, COMMENT=8, BLOCK_COMMENT=9, 
		DIGIT=10, MINUS=11, ALPHA=12, WHITESPACE=13, ASSN_SIGN=14, LAMBDA_TYPE=15, 
		NORMAL_STRING=16, COMPRESSED_STRING=17, SINGLE_CHAR_STRING=18, DOUBLE_CHAR_STRING=19, 
		PIPE=20, WHILE_OPEN=21, CLOSE=22, IF_OPEN=23, FOR_OPEN=24, LIST_OPEN=25, 
		LIST_CLOSE=26, PERIOD=27, SEMICOLON=28, AT_SIGN=29, COMPRESSED_NUMBER=30, 
		COMPLEX_SEPARATOR=31, LITERALLY_ANY_TEXT=32;
	public static final int
		RULE_file = 0, RULE_program = 1, RULE_program_node = 2, RULE_literal = 3, 
		RULE_string = 4, RULE_number = 5, RULE_integer = 6, RULE_complex_number = 7, 
		RULE_list = 8, RULE_statement = 9, RULE_if_statement = 10, RULE_for_loop = 11, 
		RULE_while_loop = 12, RULE_lambda = 13, RULE_variable_assn = 14, RULE_variable = 15, 
		RULE_modifier = 16, RULE_monadic_modifier = 17, RULE_dyadic_modifier = 18, 
		RULE_triadic_modifier = 19, RULE_tetradic_modifier = 20, RULE_infinite_modifier = 21, 
		RULE_element = 22, RULE_element_type = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "program", "program_node", "literal", "string", "number", "integer", 
			"complex_number", "list", "statement", "if_statement", "for_loop", "while_loop", 
			"lambda", "variable_assn", "variable", "modifier", "monadic_modifier", 
			"dyadic_modifier", "triadic_modifier", "tetradic_modifier", "infinite_modifier", 
			"element", "element_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'n'", null, null, null, null, null, null, null, null, "'-'", 
			null, null, null, null, null, null, null, null, "'|'", "'{'", "'}'", 
			"'['", "'('", "'\\u27E8'", "'\\u27E9'", "'.'", "';'", "'@'", null, "'\\u00B0'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PREFIX", "CONTEXT_VAR", "MONADIC_MODIFIER", "DYADIC_MODIFIER", 
			"TRIADIC_MODIFIER", "TETRADIC_MODIFIER", "INFINITE_MODIFIER", "COMMENT", 
			"BLOCK_COMMENT", "DIGIT", "MINUS", "ALPHA", "WHITESPACE", "ASSN_SIGN", 
			"LAMBDA_TYPE", "NORMAL_STRING", "COMPRESSED_STRING", "SINGLE_CHAR_STRING", 
			"DOUBLE_CHAR_STRING", "PIPE", "WHILE_OPEN", "CLOSE", "IF_OPEN", "FOR_OPEN", 
			"LIST_OPEN", "LIST_CLOSE", "PERIOD", "SEMICOLON", "AT_SIGN", "COMPRESSED_NUMBER", 
			"COMPLEX_SEPARATOR", "LITERALLY_ANY_TEXT"
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
	public String getGrammarFileName() { return "VyxalParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public VyxalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode EOF() { return getToken(VyxalParser.EOF, 0); }
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			program();
			setState(49);
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

	public static class ProgramContext extends ParserRuleContext {
		public List<Program_nodeContext> program_node() {
			return getRuleContexts(Program_nodeContext.class);
		}
		public Program_nodeContext program_node(int i) {
			return getRuleContext(Program_nodeContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(VyxalParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(VyxalParser.WHITESPACE, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(53);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PREFIX:
					case CONTEXT_VAR:
					case MONADIC_MODIFIER:
					case DYADIC_MODIFIER:
					case TRIADIC_MODIFIER:
					case TETRADIC_MODIFIER:
					case INFINITE_MODIFIER:
					case DIGIT:
					case ALPHA:
					case ASSN_SIGN:
					case LAMBDA_TYPE:
					case NORMAL_STRING:
					case COMPRESSED_STRING:
					case SINGLE_CHAR_STRING:
					case DOUBLE_CHAR_STRING:
					case WHILE_OPEN:
					case IF_OPEN:
					case FOR_OPEN:
					case LIST_OPEN:
					case COMPRESSED_NUMBER:
					case LITERALLY_ANY_TEXT:
						{
						setState(51);
						program_node();
						}
						break;
					case WHITESPACE:
						{
						setState(52);
						match(WHITESPACE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(57);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class Program_nodeContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public Program_nodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program_node; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitProgram_node(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Program_nodeContext program_node() throws RecognitionException {
		Program_nodeContext _localctx = new Program_nodeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_program_node);
		try {
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				modifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				element();
				}
				break;
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

	public static class LiteralContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode COMPRESSED_NUMBER() { return getToken(VyxalParser.COMPRESSED_NUMBER, 0); }
		public Complex_numberContext complex_number() {
			return getRuleContext(Complex_numberContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_literal);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				string();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				number();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(COMPRESSED_NUMBER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				complex_number();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				list();
				}
				break;
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode NORMAL_STRING() { return getToken(VyxalParser.NORMAL_STRING, 0); }
		public TerminalNode COMPRESSED_STRING() { return getToken(VyxalParser.COMPRESSED_STRING, 0); }
		public TerminalNode SINGLE_CHAR_STRING() { return getToken(VyxalParser.SINGLE_CHAR_STRING, 0); }
		public TerminalNode DOUBLE_CHAR_STRING() { return getToken(VyxalParser.DOUBLE_CHAR_STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NORMAL_STRING) | (1L << COMPRESSED_STRING) | (1L << SINGLE_CHAR_STRING) | (1L << DOUBLE_CHAR_STRING))) != 0)) ) {
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

	public static class NumberContext extends ParserRuleContext {
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public TerminalNode PERIOD() { return getToken(VyxalParser.PERIOD, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			integer();
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PERIOD) {
				{
				setState(74);
				match(PERIOD);
				setState(75);
				integer();
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

	public static class IntegerContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(VyxalParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(VyxalParser.DIGIT, i);
		}
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_integer);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(79); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(78);
					match(DIGIT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(81); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class Complex_numberContext extends ParserRuleContext {
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public TerminalNode COMPLEX_SEPARATOR() { return getToken(VyxalParser.COMPLEX_SEPARATOR, 0); }
		public Complex_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complex_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitComplex_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Complex_numberContext complex_number() throws RecognitionException {
		Complex_numberContext _localctx = new Complex_numberContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_complex_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			number();
			setState(84);
			match(COMPLEX_SEPARATOR);
			setState(85);
			number();
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

	public static class ListContext extends ParserRuleContext {
		public TerminalNode LIST_OPEN() { return getToken(VyxalParser.LIST_OPEN, 0); }
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public List<TerminalNode> PIPE() { return getTokens(VyxalParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(VyxalParser.PIPE, i);
		}
		public TerminalNode LIST_CLOSE() { return getToken(VyxalParser.LIST_CLOSE, 0); }
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(LIST_OPEN);
			setState(88);
			program();
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(89);
					match(PIPE);
					setState(90);
					program();
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(96);
				match(LIST_CLOSE);
				}
				break;
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

	public static class StatementContext extends ParserRuleContext {
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public For_loopContext for_loop() {
			return getRuleContext(For_loopContext.class,0);
		}
		public While_loopContext while_loop() {
			return getRuleContext(While_loopContext.class,0);
		}
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public Variable_assnContext variable_assn() {
			return getRuleContext(Variable_assnContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				if_statement();
				}
				break;
			case FOR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				for_loop();
				}
				break;
			case WHILE_OPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				while_loop();
				}
				break;
			case LAMBDA_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
				lambda();
				}
				break;
			case ASSN_SIGN:
				enterOuterAlt(_localctx, 5);
				{
				setState(103);
				variable_assn();
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

	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode IF_OPEN() { return getToken(VyxalParser.IF_OPEN, 0); }
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public TerminalNode PIPE() { return getToken(VyxalParser.PIPE, 0); }
		public TerminalNode CLOSE() { return getToken(VyxalParser.CLOSE, 0); }
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(IF_OPEN);
			setState(107);
			program();
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(108);
				match(PIPE);
				setState(109);
				program();
				}
				break;
			}
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(112);
				match(CLOSE);
				}
				break;
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

	public static class For_loopContext extends ParserRuleContext {
		public TerminalNode FOR_OPEN() { return getToken(VyxalParser.FOR_OPEN, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode PIPE() { return getToken(VyxalParser.PIPE, 0); }
		public TerminalNode CLOSE() { return getToken(VyxalParser.CLOSE, 0); }
		public For_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_loop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitFor_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_loopContext for_loop() throws RecognitionException {
		For_loopContext _localctx = new For_loopContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_for_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(FOR_OPEN);
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(116);
				variable();
				setState(117);
				match(PIPE);
				}
				break;
			}
			setState(121);
			program();
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(122);
				match(CLOSE);
				}
				break;
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

	public static class While_loopContext extends ParserRuleContext {
		public ProgramContext cond;
		public ProgramContext body;
		public TerminalNode WHILE_OPEN() { return getToken(VyxalParser.WHILE_OPEN, 0); }
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public TerminalNode PIPE() { return getToken(VyxalParser.PIPE, 0); }
		public TerminalNode CLOSE() { return getToken(VyxalParser.CLOSE, 0); }
		public While_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_loop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitWhile_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_loopContext while_loop() throws RecognitionException {
		While_loopContext _localctx = new While_loopContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_while_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(WHILE_OPEN);
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(126);
				((While_loopContext)_localctx).cond = program();
				setState(127);
				match(PIPE);
				}
				break;
			}
			setState(131);
			((While_loopContext)_localctx).body = program();
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(132);
				match(CLOSE);
				}
				break;
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

	public static class LambdaContext extends ParserRuleContext {
		public TerminalNode LAMBDA_TYPE() { return getToken(VyxalParser.LAMBDA_TYPE, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode PIPE() { return getToken(VyxalParser.PIPE, 0); }
		public TerminalNode CLOSE() { return getToken(VyxalParser.CLOSE, 0); }
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_lambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(LAMBDA_TYPE);
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(136);
				integer();
				setState(137);
				match(PIPE);
				}
				break;
			}
			setState(141);
			program();
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(142);
				match(CLOSE);
				}
				break;
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

	public static class Variable_assnContext extends ParserRuleContext {
		public TerminalNode ASSN_SIGN() { return getToken(VyxalParser.ASSN_SIGN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Variable_assnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_assn; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitVariable_assn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_assnContext variable_assn() throws RecognitionException {
		Variable_assnContext _localctx = new Variable_assnContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variable_assn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(ASSN_SIGN);
			setState(146);
			variable();
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

	public static class VariableContext extends ParserRuleContext {
		public List<TerminalNode> ALPHA() { return getTokens(VyxalParser.ALPHA); }
		public TerminalNode ALPHA(int i) {
			return getToken(VyxalParser.ALPHA, i);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variable);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(148);
					match(ALPHA);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(151); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class ModifierContext extends ParserRuleContext {
		public Monadic_modifierContext monadic_modifier() {
			return getRuleContext(Monadic_modifierContext.class,0);
		}
		public Dyadic_modifierContext dyadic_modifier() {
			return getRuleContext(Dyadic_modifierContext.class,0);
		}
		public Triadic_modifierContext triadic_modifier() {
			return getRuleContext(Triadic_modifierContext.class,0);
		}
		public Tetradic_modifierContext tetradic_modifier() {
			return getRuleContext(Tetradic_modifierContext.class,0);
		}
		public Infinite_modifierContext infinite_modifier() {
			return getRuleContext(Infinite_modifierContext.class,0);
		}
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_modifier);
		try {
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MONADIC_MODIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				monadic_modifier();
				}
				break;
			case DYADIC_MODIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				dyadic_modifier();
				}
				break;
			case TRIADIC_MODIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(155);
				triadic_modifier();
				}
				break;
			case TETRADIC_MODIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(156);
				tetradic_modifier();
				}
				break;
			case INFINITE_MODIFIER:
				enterOuterAlt(_localctx, 5);
				{
				setState(157);
				infinite_modifier();
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

	public static class Monadic_modifierContext extends ParserRuleContext {
		public TerminalNode MONADIC_MODIFIER() { return getToken(VyxalParser.MONADIC_MODIFIER, 0); }
		public Program_nodeContext program_node() {
			return getRuleContext(Program_nodeContext.class,0);
		}
		public Monadic_modifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_monadic_modifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitMonadic_modifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Monadic_modifierContext monadic_modifier() throws RecognitionException {
		Monadic_modifierContext _localctx = new Monadic_modifierContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_monadic_modifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(MONADIC_MODIFIER);
			setState(161);
			program_node();
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

	public static class Dyadic_modifierContext extends ParserRuleContext {
		public TerminalNode DYADIC_MODIFIER() { return getToken(VyxalParser.DYADIC_MODIFIER, 0); }
		public List<Program_nodeContext> program_node() {
			return getRuleContexts(Program_nodeContext.class);
		}
		public Program_nodeContext program_node(int i) {
			return getRuleContext(Program_nodeContext.class,i);
		}
		public Dyadic_modifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dyadic_modifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitDyadic_modifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dyadic_modifierContext dyadic_modifier() throws RecognitionException {
		Dyadic_modifierContext _localctx = new Dyadic_modifierContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_dyadic_modifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(DYADIC_MODIFIER);
			setState(164);
			program_node();
			setState(165);
			program_node();
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

	public static class Triadic_modifierContext extends ParserRuleContext {
		public TerminalNode TRIADIC_MODIFIER() { return getToken(VyxalParser.TRIADIC_MODIFIER, 0); }
		public List<Program_nodeContext> program_node() {
			return getRuleContexts(Program_nodeContext.class);
		}
		public Program_nodeContext program_node(int i) {
			return getRuleContext(Program_nodeContext.class,i);
		}
		public Triadic_modifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triadic_modifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitTriadic_modifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Triadic_modifierContext triadic_modifier() throws RecognitionException {
		Triadic_modifierContext _localctx = new Triadic_modifierContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_triadic_modifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(TRIADIC_MODIFIER);
			setState(168);
			program_node();
			setState(169);
			program_node();
			setState(170);
			program_node();
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

	public static class Tetradic_modifierContext extends ParserRuleContext {
		public TerminalNode TETRADIC_MODIFIER() { return getToken(VyxalParser.TETRADIC_MODIFIER, 0); }
		public List<Program_nodeContext> program_node() {
			return getRuleContexts(Program_nodeContext.class);
		}
		public Program_nodeContext program_node(int i) {
			return getRuleContext(Program_nodeContext.class,i);
		}
		public Tetradic_modifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tetradic_modifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitTetradic_modifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tetradic_modifierContext tetradic_modifier() throws RecognitionException {
		Tetradic_modifierContext _localctx = new Tetradic_modifierContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_tetradic_modifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(TETRADIC_MODIFIER);
			setState(173);
			program_node();
			setState(174);
			program_node();
			setState(175);
			program_node();
			setState(176);
			program_node();
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

	public static class Infinite_modifierContext extends ParserRuleContext {
		public TerminalNode INFINITE_MODIFIER() { return getToken(VyxalParser.INFINITE_MODIFIER, 0); }
		public List<Program_nodeContext> program_node() {
			return getRuleContexts(Program_nodeContext.class);
		}
		public Program_nodeContext program_node(int i) {
			return getRuleContext(Program_nodeContext.class,i);
		}
		public Infinite_modifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infinite_modifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitInfinite_modifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Infinite_modifierContext infinite_modifier() throws RecognitionException {
		Infinite_modifierContext _localctx = new Infinite_modifierContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_infinite_modifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(INFINITE_MODIFIER);
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(179);
					program_node();
					}
					} 
				}
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class ElementContext extends ParserRuleContext {
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public TerminalNode PREFIX() { return getToken(VyxalParser.PREFIX, 0); }
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_element);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PREFIX) {
				{
				setState(185);
				match(PREFIX);
				}
			}

			setState(188);
			element_type();
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

	public static class Element_typeContext extends ParserRuleContext {
		public TerminalNode ALPHA() { return getToken(VyxalParser.ALPHA, 0); }
		public TerminalNode LITERALLY_ANY_TEXT() { return getToken(VyxalParser.LITERALLY_ANY_TEXT, 0); }
		public TerminalNode CONTEXT_VAR() { return getToken(VyxalParser.CONTEXT_VAR, 0); }
		public TerminalNode DIGIT() { return getToken(VyxalParser.DIGIT, 0); }
		public Element_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitElement_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Element_typeContext element_type() throws RecognitionException {
		Element_typeContext _localctx = new Element_typeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_element_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONTEXT_VAR) | (1L << DIGIT) | (1L << ALPHA) | (1L << LITERALLY_ANY_TEXT))) != 0)) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001 \u00c1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u00016\b\u0001\n\u0001\f\u0001"+
		"9\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"?\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003F\b\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005M\b\u0005\u0001\u0006\u0004\u0006P\b\u0006\u000b"+
		"\u0006\f\u0006Q\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0005\b\\\b\b\n\b\f\b_\t\b\u0001\b\u0003\b"+
		"b\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\ti\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\no\b\n\u0001\n\u0003\nr\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000bx\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b|\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0082"+
		"\b\f\u0001\f\u0001\f\u0003\f\u0086\b\f\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0003\r\u008c\b\r\u0001\r\u0001\r\u0003\r\u0090\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0004\u000f\u0096\b\u000f\u000b\u000f\f"+
		"\u000f\u0097\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u009f\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0005\u0015\u00b5\b\u0015"+
		"\n\u0015\f\u0015\u00b8\t\u0015\u0001\u0016\u0003\u0016\u00bb\b\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0000\u0000\u0018"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.\u0000\u0002\u0001\u0000\u0010\u0013\u0004\u0000"+
		"\u0002\u0002\n\n\f\f  \u00c8\u00000\u0001\u0000\u0000\u0000\u00027\u0001"+
		"\u0000\u0000\u0000\u0004>\u0001\u0000\u0000\u0000\u0006E\u0001\u0000\u0000"+
		"\u0000\bG\u0001\u0000\u0000\u0000\nI\u0001\u0000\u0000\u0000\fO\u0001"+
		"\u0000\u0000\u0000\u000eS\u0001\u0000\u0000\u0000\u0010W\u0001\u0000\u0000"+
		"\u0000\u0012h\u0001\u0000\u0000\u0000\u0014j\u0001\u0000\u0000\u0000\u0016"+
		"s\u0001\u0000\u0000\u0000\u0018}\u0001\u0000\u0000\u0000\u001a\u0087\u0001"+
		"\u0000\u0000\u0000\u001c\u0091\u0001\u0000\u0000\u0000\u001e\u0095\u0001"+
		"\u0000\u0000\u0000 \u009e\u0001\u0000\u0000\u0000\"\u00a0\u0001\u0000"+
		"\u0000\u0000$\u00a3\u0001\u0000\u0000\u0000&\u00a7\u0001\u0000\u0000\u0000"+
		"(\u00ac\u0001\u0000\u0000\u0000*\u00b2\u0001\u0000\u0000\u0000,\u00ba"+
		"\u0001\u0000\u0000\u0000.\u00be\u0001\u0000\u0000\u000001\u0003\u0002"+
		"\u0001\u000012\u0005\u0000\u0000\u00012\u0001\u0001\u0000\u0000\u0000"+
		"36\u0003\u0004\u0002\u000046\u0005\r\u0000\u000053\u0001\u0000\u0000\u0000"+
		"54\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001\u0000\u0000"+
		"\u000078\u0001\u0000\u0000\u00008\u0003\u0001\u0000\u0000\u000097\u0001"+
		"\u0000\u0000\u0000:?\u0003\u0012\t\u0000;?\u0003\u0006\u0003\u0000<?\u0003"+
		" \u0010\u0000=?\u0003,\u0016\u0000>:\u0001\u0000\u0000\u0000>;\u0001\u0000"+
		"\u0000\u0000><\u0001\u0000\u0000\u0000>=\u0001\u0000\u0000\u0000?\u0005"+
		"\u0001\u0000\u0000\u0000@F\u0003\b\u0004\u0000AF\u0003\n\u0005\u0000B"+
		"F\u0005\u001e\u0000\u0000CF\u0003\u000e\u0007\u0000DF\u0003\u0010\b\u0000"+
		"E@\u0001\u0000\u0000\u0000EA\u0001\u0000\u0000\u0000EB\u0001\u0000\u0000"+
		"\u0000EC\u0001\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000F\u0007\u0001"+
		"\u0000\u0000\u0000GH\u0007\u0000\u0000\u0000H\t\u0001\u0000\u0000\u0000"+
		"IL\u0003\f\u0006\u0000JK\u0005\u001b\u0000\u0000KM\u0003\f\u0006\u0000"+
		"LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000M\u000b\u0001\u0000"+
		"\u0000\u0000NP\u0005\n\u0000\u0000ON\u0001\u0000\u0000\u0000PQ\u0001\u0000"+
		"\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000R\r\u0001"+
		"\u0000\u0000\u0000ST\u0003\n\u0005\u0000TU\u0005\u001f\u0000\u0000UV\u0003"+
		"\n\u0005\u0000V\u000f\u0001\u0000\u0000\u0000WX\u0005\u0019\u0000\u0000"+
		"X]\u0003\u0002\u0001\u0000YZ\u0005\u0014\u0000\u0000Z\\\u0003\u0002\u0001"+
		"\u0000[Y\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001\u0000"+
		"\u0000\u0000]^\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001"+
		"\u0000\u0000\u0000`b\u0005\u001a\u0000\u0000a`\u0001\u0000\u0000\u0000"+
		"ab\u0001\u0000\u0000\u0000b\u0011\u0001\u0000\u0000\u0000ci\u0003\u0014"+
		"\n\u0000di\u0003\u0016\u000b\u0000ei\u0003\u0018\f\u0000fi\u0003\u001a"+
		"\r\u0000gi\u0003\u001c\u000e\u0000hc\u0001\u0000\u0000\u0000hd\u0001\u0000"+
		"\u0000\u0000he\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hg\u0001"+
		"\u0000\u0000\u0000i\u0013\u0001\u0000\u0000\u0000jk\u0005\u0017\u0000"+
		"\u0000kn\u0003\u0002\u0001\u0000lm\u0005\u0014\u0000\u0000mo\u0003\u0002"+
		"\u0001\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0001"+
		"\u0000\u0000\u0000pr\u0005\u0016\u0000\u0000qp\u0001\u0000\u0000\u0000"+
		"qr\u0001\u0000\u0000\u0000r\u0015\u0001\u0000\u0000\u0000sw\u0005\u0018"+
		"\u0000\u0000tu\u0003\u001e\u000f\u0000uv\u0005\u0014\u0000\u0000vx\u0001"+
		"\u0000\u0000\u0000wt\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000"+
		"xy\u0001\u0000\u0000\u0000y{\u0003\u0002\u0001\u0000z|\u0005\u0016\u0000"+
		"\u0000{z\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|\u0017\u0001"+
		"\u0000\u0000\u0000}\u0081\u0005\u0015\u0000\u0000~\u007f\u0003\u0002\u0001"+
		"\u0000\u007f\u0080\u0005\u0014\u0000\u0000\u0080\u0082\u0001\u0000\u0000"+
		"\u0000\u0081~\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0085\u0003\u0002\u0001\u0000"+
		"\u0084\u0086\u0005\u0016\u0000\u0000\u0085\u0084\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0019\u0001\u0000\u0000\u0000"+
		"\u0087\u008b\u0005\u000f\u0000\u0000\u0088\u0089\u0003\f\u0006\u0000\u0089"+
		"\u008a\u0005\u0014\u0000\u0000\u008a\u008c\u0001\u0000\u0000\u0000\u008b"+
		"\u0088\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\u0001\u0000\u0000\u0000\u008d\u008f\u0003\u0002\u0001\u0000\u008e"+
		"\u0090\u0005\u0016\u0000\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u001b\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0005\u000e\u0000\u0000\u0092\u0093\u0003\u001e\u000f\u0000\u0093"+
		"\u001d\u0001\u0000\u0000\u0000\u0094\u0096\u0005\f\u0000\u0000\u0095\u0094"+
		"\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0095"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u001f"+
		"\u0001\u0000\u0000\u0000\u0099\u009f\u0003\"\u0011\u0000\u009a\u009f\u0003"+
		"$\u0012\u0000\u009b\u009f\u0003&\u0013\u0000\u009c\u009f\u0003(\u0014"+
		"\u0000\u009d\u009f\u0003*\u0015\u0000\u009e\u0099\u0001\u0000\u0000\u0000"+
		"\u009e\u009a\u0001\u0000\u0000\u0000\u009e\u009b\u0001\u0000\u0000\u0000"+
		"\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009d\u0001\u0000\u0000\u0000"+
		"\u009f!\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\u0003\u0000\u0000\u00a1"+
		"\u00a2\u0003\u0004\u0002\u0000\u00a2#\u0001\u0000\u0000\u0000\u00a3\u00a4"+
		"\u0005\u0004\u0000\u0000\u00a4\u00a5\u0003\u0004\u0002\u0000\u00a5\u00a6"+
		"\u0003\u0004\u0002\u0000\u00a6%\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005"+
		"\u0005\u0000\u0000\u00a8\u00a9\u0003\u0004\u0002\u0000\u00a9\u00aa\u0003"+
		"\u0004\u0002\u0000\u00aa\u00ab\u0003\u0004\u0002\u0000\u00ab\'\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ad\u0005\u0006\u0000\u0000\u00ad\u00ae\u0003\u0004"+
		"\u0002\u0000\u00ae\u00af\u0003\u0004\u0002\u0000\u00af\u00b0\u0003\u0004"+
		"\u0002\u0000\u00b0\u00b1\u0003\u0004\u0002\u0000\u00b1)\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b6\u0005\u0007\u0000\u0000\u00b3\u00b5\u0003\u0004\u0002"+
		"\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b7+\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b9\u00bb\u0005\u0001\u0000\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bc\u00bd\u0003.\u0017\u0000\u00bd-\u0001\u0000\u0000\u0000\u00be\u00bf"+
		"\u0007\u0001\u0000\u0000\u00bf/\u0001\u0000\u0000\u0000\u001557>ELQ]a"+
		"hnqw{\u0081\u0085\u008b\u008f\u0097\u009e\u00b6\u00ba";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}