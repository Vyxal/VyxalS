// Generated from .\shared\src\main\antlr\VyxalLexer.g4 by ANTLR 4.10.1
package vyxal;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VyxalLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PREFIX", "CONTEXT_VAR", "ALIAS", "MODIFIER", "COMMENT", "DIGIT", "MINUS", 
			"ALPHA", "WHITESPACE", "ASSN_SIGN", "LAMBDA_TYPE", "NORMAL_STRING", "COMPRESSED_STRING", 
			"SINGLE_CHAR_STRING", "DOUBLE_CHAR_STRING", "PIPE", "WHILE_OPEN", "WHILE_CLOSE", 
			"IF_OPEN", "IF_CLOSE", "FOR_OPEN", "FOR_CLOSE", "LIST_OPEN", "LIST_CLOSE", 
			"PERIOD", "SEMICOLON", "AT_SIGN", "STAR", "COLON", "COMPRESSED_NUMBER", 
			"COMPLEX_SEPARATOR", "ONE_ELEMENT_LAMBDA", "TWO_ELEMENT_LAMBDA", "THREE_ELEMENT_LAMBDA", 
			"LITERALLY_ANY_TEXT"
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


	public VyxalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "VyxalLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000#\u00a9\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003Q\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004V\b\u0004\n\u0004"+
		"\f\u0004Y\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0005\u000bk\b\u000b\n\u000b"+
		"\f\u000bn\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0005\ft\b\f"+
		"\n\f\f\fw\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0002lu\u0000#\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#\u0001"+
		"\u0000\t\u0005\u0000kk\u00a8\u00a8\u00de\u00de\u00f8\u00f8\u2206\u2206"+
		"\b\u0000&&vv~~\u00df\u00df\u0192\u0192\u0256\u0256\u207a\u207a\u208c\u208d"+
		"\u0001\u0000\n\n\u0001\u000009\u0002\u0000AZaz\u0003\u0000\t\n\r\r  \u0002"+
		"\u0000\u2190\u2190\u2192\u2192\u0004\u0000\'\'\u00b5\u00b5\u019b\u019b"+
		"\u03bb\u03bb\u0001\u0000\u0010\u8000\uffff\u00ac\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0000"+
		"1\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001"+
		"\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000"+
		"\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000"+
		"?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001"+
		"\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0001G\u0001\u0000\u0000"+
		"\u0000\u0003I\u0001\u0000\u0000\u0000\u0005K\u0001\u0000\u0000\u0000\u0007"+
		"P\u0001\u0000\u0000\u0000\tR\u0001\u0000\u0000\u0000\u000b\\\u0001\u0000"+
		"\u0000\u0000\r^\u0001\u0000\u0000\u0000\u000f`\u0001\u0000\u0000\u0000"+
		"\u0011b\u0001\u0000\u0000\u0000\u0013d\u0001\u0000\u0000\u0000\u0015f"+
		"\u0001\u0000\u0000\u0000\u0017h\u0001\u0000\u0000\u0000\u0019q\u0001\u0000"+
		"\u0000\u0000\u001bz\u0001\u0000\u0000\u0000\u001d}\u0001\u0000\u0000\u0000"+
		"\u001f\u0081\u0001\u0000\u0000\u0000!\u0083\u0001\u0000\u0000\u0000#\u0085"+
		"\u0001\u0000\u0000\u0000%\u0087\u0001\u0000\u0000\u0000\'\u0089\u0001"+
		"\u0000\u0000\u0000)\u008b\u0001\u0000\u0000\u0000+\u008d\u0001\u0000\u0000"+
		"\u0000-\u008f\u0001\u0000\u0000\u0000/\u0091\u0001\u0000\u0000\u00001"+
		"\u0093\u0001\u0000\u0000\u00003\u0095\u0001\u0000\u0000\u00005\u0097\u0001"+
		"\u0000\u0000\u00007\u0099\u0001\u0000\u0000\u00009\u009b\u0001\u0000\u0000"+
		"\u0000;\u009d\u0001\u0000\u0000\u0000=\u009f\u0001\u0000\u0000\u0000?"+
		"\u00a1\u0001\u0000\u0000\u0000A\u00a3\u0001\u0000\u0000\u0000C\u00a5\u0001"+
		"\u0000\u0000\u0000E\u00a7\u0001\u0000\u0000\u0000GH\u0007\u0000\u0000"+
		"\u0000H\u0002\u0001\u0000\u0000\u0000IJ\u0005n\u0000\u0000J\u0004\u0001"+
		"\u0000\u0000\u0000KL\u0005\u00a2\u0000\u0000L\u0006\u0001\u0000\u0000"+
		"\u0000MQ\u0007\u0001\u0000\u0000NO\u0005\u00a8\u0000\u0000OQ\u0005=\u0000"+
		"\u0000PM\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000Q\b\u0001\u0000"+
		"\u0000\u0000RW\u0005#\u0000\u0000ST\b\u0002\u0000\u0000TV\t\u0000\u0000"+
		"\u0000US\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000"+
		"\u0000\u0000WX\u0001\u0000\u0000\u0000XZ\u0001\u0000\u0000\u0000YW\u0001"+
		"\u0000\u0000\u0000Z[\u0006\u0004\u0000\u0000[\n\u0001\u0000\u0000\u0000"+
		"\\]\u0007\u0003\u0000\u0000]\f\u0001\u0000\u0000\u0000^_\u0005-\u0000"+
		"\u0000_\u000e\u0001\u0000\u0000\u0000`a\u0007\u0004\u0000\u0000a\u0010"+
		"\u0001\u0000\u0000\u0000bc\u0007\u0005\u0000\u0000c\u0012\u0001\u0000"+
		"\u0000\u0000de\u0007\u0006\u0000\u0000e\u0014\u0001\u0000\u0000\u0000"+
		"fg\u0007\u0007\u0000\u0000g\u0016\u0001\u0000\u0000\u0000hl\u0005\"\u0000"+
		"\u0000ik\t\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000"+
		"\u0000lm\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mo\u0001\u0000"+
		"\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0005\"\u0000\u0000p\u0018\u0001"+
		"\u0000\u0000\u0000qu\u0005\u00ab\u0000\u0000rt\t\u0000\u0000\u0000sr\u0001"+
		"\u0000\u0000\u0000tw\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000vx\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000"+
		"\u0000xy\u0005\u00ab\u0000\u0000y\u001a\u0001\u0000\u0000\u0000z{\u0005"+
		"\\\u0000\u0000{|\t\u0000\u0000\u0000|\u001c\u0001\u0000\u0000\u0000}~"+
		"\u0005\u201b\u0000\u0000~\u007f\t\u0000\u0000\u0000\u007f\u0080\t\u0000"+
		"\u0000\u0000\u0080\u001e\u0001\u0000\u0000\u0000\u0081\u0082\u0005|\u0000"+
		"\u0000\u0082 \u0001\u0000\u0000\u0000\u0083\u0084\u0005{\u0000\u0000\u0084"+
		"\"\u0001\u0000\u0000\u0000\u0085\u0086\u0005}\u0000\u0000\u0086$\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0005[\u0000\u0000\u0088&\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0005]\u0000\u0000\u008a(\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0005(\u0000\u0000\u008c*\u0001\u0000\u0000\u0000\u008d\u008e\u0005"+
		")\u0000\u0000\u008e,\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u27e8\u0000"+
		"\u0000\u0090.\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u27e9\u0000\u0000"+
		"\u00920\u0001\u0000\u0000\u0000\u0093\u0094\u0005.\u0000\u0000\u00942"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0005;\u0000\u0000\u00964\u0001\u0000"+
		"\u0000\u0000\u0097\u0098\u0005@\u0000\u0000\u00986\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0005*\u0000\u0000\u009a8\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0005:\u0000\u0000\u009c:\u0001\u0000\u0000\u0000\u009d\u009e\u0005\u00bb"+
		"\u0000\u0000\u009e<\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u00b0\u0000"+
		"\u0000\u00a0>\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005\u207d\u0000\u0000"+
		"\u00a2@\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u2021\u0000\u0000\u00a4"+
		"B\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u226c\u0000\u0000\u00a6D\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a8\u0007\b\u0000\u0000\u00a8F\u0001\u0000"+
		"\u0000\u0000\u0005\u0000PWlu\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}