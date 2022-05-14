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
		PREFIX=1, CONTEXT_VAR=2, ALIAS=3, MODIFIER=4, COMMENT=5, DIGIT=6, MINUS=7, 
		ALPHA=8, WHITESPACE=9, ASSN_SIGN=10, LAMBDA_TYPE=11, NORMAL_STRING=12, 
		COMPRESSED_STRING=13, SINGLE_CHAR_STRING=14, DOUBLE_CHAR_STRING=15, PIPE=16, 
		WHILE_OPEN=17, WHILE_CLOSE=18, IF_OPEN=19, IF_CLOSE=20, FOR_OPEN=21, FOR_CLOSE=22, 
		LIST_OPEN=23, LIST_CLOSE=24, PERIOD=25, SEMICOLON=26, AT_SIGN=27, STAR=28, 
		COLON=29, COMPRESSED_NUMBER=30, COMPLEX_SEPARATOR=31, ONE_ELEMENT_LAMBDA=32, 
		TWO_ELEMENT_LAMBDA=33, THREE_ELEMENT_LAMBDA=34, LITERALLY_ANY_TEXT=35;
	public static final int
		RULE_file = 0, RULE_alias = 1, RULE_program = 2, RULE_program_node = 3, 
		RULE_literal = 4, RULE_string = 5, RULE_number = 6, RULE_integer = 7, 
		RULE_compressed_number = 8, RULE_complex_number = 9, RULE_list = 10, RULE_statement = 11, 
		RULE_if_statement = 12, RULE_fori_loop = 13, RULE_for_loop = 14, RULE_while_loop = 15, 
		RULE_lambda = 16, RULE_one_element_lambda = 17, RULE_two_element_lambda = 18, 
		RULE_three_element_lambda = 19, RULE_variable_assn = 20, RULE_variable = 21, 
		RULE_modifier = 22, RULE_element = 23, RULE_element_type = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "alias", "program", "program_node", "literal", "string", "number", 
			"integer", "compressed_number", "complex_number", "list", "statement", 
			"if_statement", "fori_loop", "for_loop", "while_loop", "lambda", "one_element_lambda", 
			"two_element_lambda", "three_element_lambda", "variable_assn", "variable", 
			"modifier", "element", "element_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'n'", "'\\u00A2'", null, null, null, "'-'", null, null, 
			null, null, null, null, null, null, "'|'", "'{'", "'}'", "'['", "']'", 
			"'('", "')'", "'\\u27E8'", "'\\u27E9'", "'.'", "';'", "'@'", "'*'", "':'", 
			"'\\u00BB'", "'\\u00B0'", "'\\u207D'", "'\\u2021'", "'\\u226C'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PREFIX", "CONTEXT_VAR", "ALIAS", "MODIFIER", "COMMENT", "DIGIT", 
			"MINUS", "ALPHA", "WHITESPACE", "ASSN_SIGN", "LAMBDA_TYPE", "NORMAL_STRING", 
			"COMPRESSED_STRING", "SINGLE_CHAR_STRING", "DOUBLE_CHAR_STRING", "PIPE", 
			"WHILE_OPEN", "WHILE_CLOSE", "IF_OPEN", "IF_CLOSE", "FOR_OPEN", "FOR_CLOSE", 
			"LIST_OPEN", "LIST_CLOSE", "PERIOD", "SEMICOLON", "AT_SIGN", "STAR", 
			"COLON", "COMPRESSED_NUMBER", "COMPLEX_SEPARATOR", "ONE_ELEMENT_LAMBDA", 
			"TWO_ELEMENT_LAMBDA", "THREE_ELEMENT_LAMBDA", "LITERALLY_ANY_TEXT"
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


	boolean isAlias = false;

	public VyxalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode EOF() { return getToken(VyxalParser.EOF, 0); }
		public List<AliasContext> alias() {
			return getRuleContexts(AliasContext.class);
		}
		public AliasContext alias(int i) {
			return getRuleContext(AliasContext.class,i);
		}
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			isAlias = true;
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(51);
					alias();
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			isAlias = false;
			setState(58);
			program();
			setState(59);
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

	public static class AliasContext extends ParserRuleContext {
		public ElementContext theAlias;
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode ALIAS() { return getToken(VyxalParser.ALIAS, 0); }
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(VyxalParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(VyxalParser.WHITESPACE, i);
		}
		public AliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AliasContext alias() throws RecognitionException {
		AliasContext _localctx = new AliasContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_alias);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			program();
			setState(62);
			match(ALIAS);
			setState(63);
			((AliasContext)_localctx).theAlias = element();
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(64);
					match(WHITESPACE);
					}
					} 
				}
				setState(69);
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
		enterRule(_localctx, 4, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(72);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PREFIX:
					case CONTEXT_VAR:
					case MODIFIER:
					case DIGIT:
					case MINUS:
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
					case STAR:
					case COMPRESSED_NUMBER:
					case ONE_ELEMENT_LAMBDA:
					case TWO_ELEMENT_LAMBDA:
					case THREE_ELEMENT_LAMBDA:
					case LITERALLY_ANY_TEXT:
						{
						setState(70);
						program_node();
						}
						break;
					case WHITESPACE:
						{
						setState(71);
						match(WHITESPACE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		enterRule(_localctx, 6, RULE_program_node);
		try {
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				modifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
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
		public Compressed_numberContext compressed_number() {
			return getRuleContext(Compressed_numberContext.class,0);
		}
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
		enterRule(_localctx, 8, RULE_literal);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				string();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				number();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				compressed_number();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				complex_number();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
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
		enterRule(_localctx, 10, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
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
		public TerminalNode MINUS() { return getToken(VyxalParser.MINUS, 0); }
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
		enterRule(_localctx, 12, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(92);
				match(MINUS);
				}
			}

			setState(95);
			integer();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PERIOD) {
				{
				setState(96);
				match(PERIOD);
				setState(97);
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
		enterRule(_localctx, 14, RULE_integer);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(100);
					match(DIGIT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(103); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class Compressed_numberContext extends ParserRuleContext {
		public List<TerminalNode> COMPRESSED_NUMBER() { return getTokens(VyxalParser.COMPRESSED_NUMBER); }
		public TerminalNode COMPRESSED_NUMBER(int i) {
			return getToken(VyxalParser.COMPRESSED_NUMBER, i);
		}
		public Compressed_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compressed_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitCompressed_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compressed_numberContext compressed_number() throws RecognitionException {
		Compressed_numberContext _localctx = new Compressed_numberContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_compressed_number);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(COMPRESSED_NUMBER);
			setState(109);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(106);
					matchWildcard();
					}
					} 
				}
				setState(111);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(112);
			match(COMPRESSED_NUMBER);
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
		enterRule(_localctx, 18, RULE_complex_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			number();
			setState(115);
			match(COMPLEX_SEPARATOR);
			setState(116);
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
		enterRule(_localctx, 20, RULE_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(LIST_OPEN);
			setState(119);
			program();
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(120);
					match(PIPE);
					setState(121);
					program();
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(127);
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
		public Fori_loopContext fori_loop() {
			return getRuleContext(Fori_loopContext.class,0);
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
		public One_element_lambdaContext one_element_lambda() {
			return getRuleContext(One_element_lambdaContext.class,0);
		}
		public Two_element_lambdaContext two_element_lambda() {
			return getRuleContext(Two_element_lambdaContext.class,0);
		}
		public Three_element_lambdaContext three_element_lambda() {
			return getRuleContext(Three_element_lambdaContext.class,0);
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
		enterRule(_localctx, 22, RULE_statement);
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				if_statement();
				}
				break;
			case DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				fori_loop();
				}
				break;
			case FOR_OPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				for_loop();
				}
				break;
			case WHILE_OPEN:
				enterOuterAlt(_localctx, 4);
				{
				setState(133);
				while_loop();
				}
				break;
			case LAMBDA_TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(134);
				lambda();
				}
				break;
			case ONE_ELEMENT_LAMBDA:
				enterOuterAlt(_localctx, 6);
				{
				setState(135);
				one_element_lambda();
				}
				break;
			case TWO_ELEMENT_LAMBDA:
				enterOuterAlt(_localctx, 7);
				{
				setState(136);
				two_element_lambda();
				}
				break;
			case THREE_ELEMENT_LAMBDA:
				enterOuterAlt(_localctx, 8);
				{
				setState(137);
				three_element_lambda();
				}
				break;
			case ASSN_SIGN:
				enterOuterAlt(_localctx, 9);
				{
				setState(138);
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
		public TerminalNode IF_CLOSE() { return getToken(VyxalParser.IF_CLOSE, 0); }
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
		enterRule(_localctx, 24, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(IF_OPEN);
			setState(142);
			program();
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(143);
				match(PIPE);
				setState(144);
				program();
				}
				break;
			}
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(147);
				match(IF_CLOSE);
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

	public static class Fori_loopContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(VyxalParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(VyxalParser.DIGIT, i);
		}
		public TerminalNode FOR_OPEN() { return getToken(VyxalParser.FOR_OPEN, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode FOR_CLOSE() { return getToken(VyxalParser.FOR_CLOSE, 0); }
		public Fori_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fori_loop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitFori_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fori_loopContext fori_loop() throws RecognitionException {
		Fori_loopContext _localctx = new Fori_loopContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fori_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(DIGIT);
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(151);
				match(DIGIT);
				}
				break;
			}
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(154);
				match(DIGIT);
				}
				break;
			}
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(157);
				match(DIGIT);
				}
				break;
			}
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(160);
				match(DIGIT);
				}
				break;
			}
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(163);
				match(DIGIT);
				}
				break;
			}
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(166);
				match(DIGIT);
				}
				break;
			}
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(169);
				match(DIGIT);
				}
				break;
			}
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DIGIT) {
				{
				setState(172);
				match(DIGIT);
				}
			}

			setState(175);
			match(FOR_OPEN);
			setState(176);
			program();
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(177);
				match(FOR_CLOSE);
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
		public TerminalNode FOR_CLOSE() { return getToken(VyxalParser.FOR_CLOSE, 0); }
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
		enterRule(_localctx, 28, RULE_for_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(FOR_OPEN);
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(181);
				variable();
				setState(182);
				match(PIPE);
				}
				break;
			}
			setState(186);
			program();
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(187);
				match(FOR_CLOSE);
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
		public TerminalNode WHILE_CLOSE() { return getToken(VyxalParser.WHILE_CLOSE, 0); }
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
		enterRule(_localctx, 30, RULE_while_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(WHILE_OPEN);
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(191);
				((While_loopContext)_localctx).cond = program();
				setState(192);
				match(PIPE);
				}
				break;
			}
			setState(196);
			((While_loopContext)_localctx).body = program();
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(197);
				match(WHILE_CLOSE);
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
		public TerminalNode SEMICOLON() { return getToken(VyxalParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 32, RULE_lambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(LAMBDA_TYPE);
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(201);
				integer();
				setState(202);
				match(PIPE);
				}
				break;
			}
			setState(206);
			program();
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(207);
				match(SEMICOLON);
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

	public static class One_element_lambdaContext extends ParserRuleContext {
		public TerminalNode ONE_ELEMENT_LAMBDA() { return getToken(VyxalParser.ONE_ELEMENT_LAMBDA, 0); }
		public Program_nodeContext program_node() {
			return getRuleContext(Program_nodeContext.class,0);
		}
		public One_element_lambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_element_lambda; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitOne_element_lambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final One_element_lambdaContext one_element_lambda() throws RecognitionException {
		One_element_lambdaContext _localctx = new One_element_lambdaContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_one_element_lambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(ONE_ELEMENT_LAMBDA);
			setState(211);
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

	public static class Two_element_lambdaContext extends ParserRuleContext {
		public TerminalNode TWO_ELEMENT_LAMBDA() { return getToken(VyxalParser.TWO_ELEMENT_LAMBDA, 0); }
		public List<Program_nodeContext> program_node() {
			return getRuleContexts(Program_nodeContext.class);
		}
		public Program_nodeContext program_node(int i) {
			return getRuleContext(Program_nodeContext.class,i);
		}
		public Two_element_lambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_two_element_lambda; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitTwo_element_lambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Two_element_lambdaContext two_element_lambda() throws RecognitionException {
		Two_element_lambdaContext _localctx = new Two_element_lambdaContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_two_element_lambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(TWO_ELEMENT_LAMBDA);
			setState(214);
			program_node();
			setState(215);
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

	public static class Three_element_lambdaContext extends ParserRuleContext {
		public TerminalNode THREE_ELEMENT_LAMBDA() { return getToken(VyxalParser.THREE_ELEMENT_LAMBDA, 0); }
		public List<Program_nodeContext> program_node() {
			return getRuleContexts(Program_nodeContext.class);
		}
		public Program_nodeContext program_node(int i) {
			return getRuleContext(Program_nodeContext.class,i);
		}
		public Three_element_lambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_three_element_lambda; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof VyxalParserVisitor ) return ((VyxalParserVisitor<? extends T>)visitor).visitThree_element_lambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Three_element_lambdaContext three_element_lambda() throws RecognitionException {
		Three_element_lambdaContext _localctx = new Three_element_lambdaContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_three_element_lambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(THREE_ELEMENT_LAMBDA);
			setState(218);
			program_node();
			setState(219);
			program_node();
			setState(220);
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
		enterRule(_localctx, 40, RULE_variable_assn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(ASSN_SIGN);
			setState(223);
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
		public List<TerminalNode> DIGIT() { return getTokens(VyxalParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(VyxalParser.DIGIT, i);
		}
		public List<TerminalNode> CONTEXT_VAR() { return getTokens(VyxalParser.CONTEXT_VAR); }
		public TerminalNode CONTEXT_VAR(int i) {
			return getToken(VyxalParser.CONTEXT_VAR, i);
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
		enterRule(_localctx, 42, RULE_variable);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(226); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(225);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONTEXT_VAR) | (1L << DIGIT) | (1L << ALPHA))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(228); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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
		public TerminalNode MODIFIER() { return getToken(VyxalParser.MODIFIER, 0); }
		public Program_nodeContext program_node() {
			return getRuleContext(Program_nodeContext.class,0);
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
		enterRule(_localctx, 44, RULE_modifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(MODIFIER);
			setState(231);
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

	public static class ElementContext extends ParserRuleContext {
		public boolean isInAlias;
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
		enterRule(_localctx, 46, RULE_element);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PREFIX) {
				{
				setState(233);
				match(PREFIX);
				}
			}

			setState(236);
			element_type();
			((ElementContext)_localctx).isInAlias =  isAlias;
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
		public TerminalNode MODIFIER() { return getToken(VyxalParser.MODIFIER, 0); }
		public TerminalNode MINUS() { return getToken(VyxalParser.MINUS, 0); }
		public TerminalNode STAR() { return getToken(VyxalParser.STAR, 0); }
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
		enterRule(_localctx, 48, RULE_element_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONTEXT_VAR) | (1L << MODIFIER) | (1L << DIGIT) | (1L << MINUS) | (1L << ALPHA) | (1L << STAR) | (1L << LITERALLY_ANY_TEXT))) != 0)) ) {
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
		"\u0004\u0001#\u00f2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0001\u0000\u0005\u00005\b\u0000\n\u0000\f\u00008\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001B\b\u0001\n\u0001\f\u0001E\t\u0001"+
		"\u0001\u0002\u0001\u0002\u0005\u0002I\b\u0002\n\u0002\f\u0002L\t\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003R\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"Y\b\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0003\u0006^\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006c\b\u0006\u0001\u0007\u0004"+
		"\u0007f\b\u0007\u000b\u0007\f\u0007g\u0001\b\u0001\b\u0005\bl\b\b\n\b"+
		"\f\bo\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\n{\b\n\n\n\f\n~\t\n\u0001\n\u0003\n\u0081\b\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u008c\b\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u0092\b\f\u0001\f\u0003\f\u0095\b\f\u0001"+
		"\r\u0001\r\u0003\r\u0099\b\r\u0001\r\u0003\r\u009c\b\r\u0001\r\u0003\r"+
		"\u009f\b\r\u0001\r\u0003\r\u00a2\b\r\u0001\r\u0003\r\u00a5\b\r\u0001\r"+
		"\u0003\r\u00a8\b\r\u0001\r\u0003\r\u00ab\b\r\u0001\r\u0003\r\u00ae\b\r"+
		"\u0001\r\u0001\r\u0001\r\u0003\r\u00b3\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u00b9\b\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u00bd\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00c3\b\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00c7\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00cd\b\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u00d1\b\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0004\u0015\u00e3\b\u0015\u000b\u0015\f\u0015"+
		"\u00e4\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0003\u0017\u00eb"+
		"\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001m\u0000\u0019\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0\u0000\u0003\u0001\u0000"+
		"\f\u000f\u0003\u0000\u0002\u0002\u0006\u0006\b\b\u0005\u0000\u0002\u0002"+
		"\u0004\u0004\u0006\b\u001c\u001c##\u0104\u00002\u0001\u0000\u0000\u0000"+
		"\u0002=\u0001\u0000\u0000\u0000\u0004J\u0001\u0000\u0000\u0000\u0006Q"+
		"\u0001\u0000\u0000\u0000\bX\u0001\u0000\u0000\u0000\nZ\u0001\u0000\u0000"+
		"\u0000\f]\u0001\u0000\u0000\u0000\u000ee\u0001\u0000\u0000\u0000\u0010"+
		"i\u0001\u0000\u0000\u0000\u0012r\u0001\u0000\u0000\u0000\u0014v\u0001"+
		"\u0000\u0000\u0000\u0016\u008b\u0001\u0000\u0000\u0000\u0018\u008d\u0001"+
		"\u0000\u0000\u0000\u001a\u0096\u0001\u0000\u0000\u0000\u001c\u00b4\u0001"+
		"\u0000\u0000\u0000\u001e\u00be\u0001\u0000\u0000\u0000 \u00c8\u0001\u0000"+
		"\u0000\u0000\"\u00d2\u0001\u0000\u0000\u0000$\u00d5\u0001\u0000\u0000"+
		"\u0000&\u00d9\u0001\u0000\u0000\u0000(\u00de\u0001\u0000\u0000\u0000*"+
		"\u00e2\u0001\u0000\u0000\u0000,\u00e6\u0001\u0000\u0000\u0000.\u00ea\u0001"+
		"\u0000\u0000\u00000\u00ef\u0001\u0000\u0000\u000026\u0006\u0000\uffff"+
		"\uffff\u000035\u0003\u0002\u0001\u000043\u0001\u0000\u0000\u000058\u0001"+
		"\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"79\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u00009:\u0006\u0000\uffff"+
		"\uffff\u0000:;\u0003\u0004\u0002\u0000;<\u0005\u0000\u0000\u0001<\u0001"+
		"\u0001\u0000\u0000\u0000=>\u0003\u0004\u0002\u0000>?\u0005\u0003\u0000"+
		"\u0000?C\u0003.\u0017\u0000@B\u0005\t\u0000\u0000A@\u0001\u0000\u0000"+
		"\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000"+
		"\u0000\u0000D\u0003\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000"+
		"FI\u0003\u0006\u0003\u0000GI\u0005\t\u0000\u0000HF\u0001\u0000\u0000\u0000"+
		"HG\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000"+
		"\u0000JK\u0001\u0000\u0000\u0000K\u0005\u0001\u0000\u0000\u0000LJ\u0001"+
		"\u0000\u0000\u0000MR\u0003\u0016\u000b\u0000NR\u0003\b\u0004\u0000OR\u0003"+
		",\u0016\u0000PR\u0003.\u0017\u0000QM\u0001\u0000\u0000\u0000QN\u0001\u0000"+
		"\u0000\u0000QO\u0001\u0000\u0000\u0000QP\u0001\u0000\u0000\u0000R\u0007"+
		"\u0001\u0000\u0000\u0000SY\u0003\n\u0005\u0000TY\u0003\f\u0006\u0000U"+
		"Y\u0003\u0010\b\u0000VY\u0003\u0012\t\u0000WY\u0003\u0014\n\u0000XS\u0001"+
		"\u0000\u0000\u0000XT\u0001\u0000\u0000\u0000XU\u0001\u0000\u0000\u0000"+
		"XV\u0001\u0000\u0000\u0000XW\u0001\u0000\u0000\u0000Y\t\u0001\u0000\u0000"+
		"\u0000Z[\u0007\u0000\u0000\u0000[\u000b\u0001\u0000\u0000\u0000\\^\u0005"+
		"\u0007\u0000\u0000]\\\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000"+
		"^_\u0001\u0000\u0000\u0000_b\u0003\u000e\u0007\u0000`a\u0005\u0019\u0000"+
		"\u0000ac\u0003\u000e\u0007\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000"+
		"\u0000\u0000c\r\u0001\u0000\u0000\u0000df\u0005\u0006\u0000\u0000ed\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000"+
		"gh\u0001\u0000\u0000\u0000h\u000f\u0001\u0000\u0000\u0000im\u0005\u001e"+
		"\u0000\u0000jl\t\u0000\u0000\u0000kj\u0001\u0000\u0000\u0000lo\u0001\u0000"+
		"\u0000\u0000mn\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000np\u0001"+
		"\u0000\u0000\u0000om\u0001\u0000\u0000\u0000pq\u0005\u001e\u0000\u0000"+
		"q\u0011\u0001\u0000\u0000\u0000rs\u0003\f\u0006\u0000st\u0005\u001f\u0000"+
		"\u0000tu\u0003\f\u0006\u0000u\u0013\u0001\u0000\u0000\u0000vw\u0005\u0017"+
		"\u0000\u0000w|\u0003\u0004\u0002\u0000xy\u0005\u0010\u0000\u0000y{\u0003"+
		"\u0004\u0002\u0000zx\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000"+
		"|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u0080\u0001\u0000"+
		"\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0081\u0005\u0018\u0000\u0000"+
		"\u0080\u007f\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000"+
		"\u0081\u0015\u0001\u0000\u0000\u0000\u0082\u008c\u0003\u0018\f\u0000\u0083"+
		"\u008c\u0003\u001a\r\u0000\u0084\u008c\u0003\u001c\u000e\u0000\u0085\u008c"+
		"\u0003\u001e\u000f\u0000\u0086\u008c\u0003 \u0010\u0000\u0087\u008c\u0003"+
		"\"\u0011\u0000\u0088\u008c\u0003$\u0012\u0000\u0089\u008c\u0003&\u0013"+
		"\u0000\u008a\u008c\u0003(\u0014\u0000\u008b\u0082\u0001\u0000\u0000\u0000"+
		"\u008b\u0083\u0001\u0000\u0000\u0000\u008b\u0084\u0001\u0000\u0000\u0000"+
		"\u008b\u0085\u0001\u0000\u0000\u0000\u008b\u0086\u0001\u0000\u0000\u0000"+
		"\u008b\u0087\u0001\u0000\u0000\u0000\u008b\u0088\u0001\u0000\u0000\u0000"+
		"\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008a\u0001\u0000\u0000\u0000"+
		"\u008c\u0017\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0013\u0000\u0000"+
		"\u008e\u0091\u0003\u0004\u0002\u0000\u008f\u0090\u0005\u0010\u0000\u0000"+
		"\u0090\u0092\u0003\u0004\u0002\u0000\u0091\u008f\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0094\u0001\u0000\u0000\u0000"+
		"\u0093\u0095\u0005\u0014\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0019\u0001\u0000\u0000\u0000"+
		"\u0096\u0098\u0005\u0006\u0000\u0000\u0097\u0099\u0005\u0006\u0000\u0000"+
		"\u0098\u0097\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000"+
		"\u0099\u009b\u0001\u0000\u0000\u0000\u009a\u009c\u0005\u0006\u0000\u0000"+
		"\u009b\u009a\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000"+
		"\u009c\u009e\u0001\u0000\u0000\u0000\u009d\u009f\u0005\u0006\u0000\u0000"+
		"\u009e\u009d\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000"+
		"\u009f\u00a1\u0001\u0000\u0000\u0000\u00a0\u00a2\u0005\u0006\u0000\u0000"+
		"\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3\u00a5\u0005\u0006\u0000\u0000"+
		"\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a7\u0001\u0000\u0000\u0000\u00a6\u00a8\u0005\u0006\u0000\u0000"+
		"\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00ab\u0005\u0006\u0000\u0000"+
		"\u00aa\u00a9\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ad\u0001\u0000\u0000\u0000\u00ac\u00ae\u0005\u0006\u0000\u0000"+
		"\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b0\u0005\u0015\u0000\u0000"+
		"\u00b0\u00b2\u0003\u0004\u0002\u0000\u00b1\u00b3\u0005\u0016\u0000\u0000"+
		"\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b3\u001b\u0001\u0000\u0000\u0000\u00b4\u00b8\u0005\u0015\u0000\u0000"+
		"\u00b5\u00b6\u0003*\u0015\u0000\u00b6\u00b7\u0005\u0010\u0000\u0000\u00b7"+
		"\u00b9\u0001\u0000\u0000\u0000\u00b8\u00b5\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bc\u0003\u0004\u0002\u0000\u00bb\u00bd\u0005\u0016\u0000\u0000\u00bc"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd"+
		"\u001d\u0001\u0000\u0000\u0000\u00be\u00c2\u0005\u0011\u0000\u0000\u00bf"+
		"\u00c0\u0003\u0004\u0002\u0000\u00c0\u00c1\u0005\u0010\u0000\u0000\u00c1"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c2\u00bf\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c6\u0003\u0004\u0002\u0000\u00c5\u00c7\u0005\u0012\u0000\u0000\u00c6"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7"+
		"\u001f\u0001\u0000\u0000\u0000\u00c8\u00cc\u0005\u000b\u0000\u0000\u00c9"+
		"\u00ca\u0003\u000e\u0007\u0000\u00ca\u00cb\u0005\u0010\u0000\u0000\u00cb"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cc\u00c9\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce"+
		"\u00d0\u0003\u0004\u0002\u0000\u00cf\u00d1\u0005\u001a\u0000\u0000\u00d0"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1"+
		"!\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005 \u0000\u0000\u00d3\u00d4\u0003"+
		"\u0006\u0003\u0000\u00d4#\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005!\u0000"+
		"\u0000\u00d6\u00d7\u0003\u0006\u0003\u0000\u00d7\u00d8\u0003\u0006\u0003"+
		"\u0000\u00d8%\u0001\u0000\u0000\u0000\u00d9\u00da\u0005\"\u0000\u0000"+
		"\u00da\u00db\u0003\u0006\u0003\u0000\u00db\u00dc\u0003\u0006\u0003\u0000"+
		"\u00dc\u00dd\u0003\u0006\u0003\u0000\u00dd\'\u0001\u0000\u0000\u0000\u00de"+
		"\u00df\u0005\n\u0000\u0000\u00df\u00e0\u0003*\u0015\u0000\u00e0)\u0001"+
		"\u0000\u0000\u0000\u00e1\u00e3\u0007\u0001\u0000\u0000\u00e2\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5+\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e7\u0005\u0004\u0000\u0000\u00e7\u00e8\u0003\u0006"+
		"\u0003\u0000\u00e8-\u0001\u0000\u0000\u0000\u00e9\u00eb\u0005\u0001\u0000"+
		"\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ed\u00030\u0018\u0000"+
		"\u00ed\u00ee\u0006\u0017\uffff\uffff\u0000\u00ee/\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f0\u0007\u0002\u0000\u0000\u00f01\u0001\u0000\u0000\u0000 6"+
		"CHJQX]bgm|\u0080\u008b\u0091\u0094\u0098\u009b\u009e\u00a1\u00a4\u00a7"+
		"\u00aa\u00ad\u00b2\u00b8\u00bc\u00c2\u00c6\u00cc\u00d0\u00e4\u00ea";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}