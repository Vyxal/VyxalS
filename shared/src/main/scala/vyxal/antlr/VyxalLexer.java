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
		PREFIX=1, CONTEXT_VAR=2, MONADIC_MODIFIER=3, DYADIC_MODIFIER=4, TRIADIC_MODIFIER=5, 
		TETRADIC_MODIFIER=6, INFINITE_MODIFIER=7, COMMENT=8, BLOCK_COMMENT=9, 
		DIGIT=10, MINUS=11, ALPHA=12, WHITESPACE=13, ASSN_SIGN=14, LAMBDA_TYPE=15, 
		NORMAL_STRING=16, COMPRESSED_STRING=17, SINGLE_CHAR_STRING=18, DOUBLE_CHAR_STRING=19, 
		PIPE=20, WHILE_OPEN=21, CLOSE=22, IF_OPEN=23, FOR_OPEN=24, LIST_OPEN=25, 
		LIST_CLOSE=26, PERIOD=27, SEMICOLON=28, AT_SIGN=29, COMPRESSED_NUMBER=30, 
		COMPLEX_SEPARATOR=31, LITERALLY_ANY_TEXT=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PREFIX", "CONTEXT_VAR", "MONADIC_MODIFIER", "DYADIC_MODIFIER", "TRIADIC_MODIFIER", 
			"TETRADIC_MODIFIER", "INFINITE_MODIFIER", "COMMENT", "BLOCK_COMMENT", 
			"DIGIT", "MINUS", "ALPHA", "WHITESPACE", "ASSN_SIGN", "LAMBDA_TYPE", 
			"NORMAL_STRING", "COMPRESSED_STRING", "SINGLE_CHAR_STRING", "DOUBLE_CHAR_STRING", 
			"PIPE", "WHILE_OPEN", "CLOSE", "IF_OPEN", "FOR_OPEN", "LIST_OPEN", "LIST_CLOSE", 
			"PERIOD", "SEMICOLON", "AT_SIGN", "COMPRESSED_NUMBER", "COMPLEX_SEPARATOR", 
			"LITERALLY_ANY_TEXT"
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
		"\u0004\u0000 \u00ad\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007S\b\u0007\n\u0007\f\u0007V\t"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b"+
		"^\b\b\n\b\f\ba\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0005\u000fv\b\u000f"+
		"\n\u000f\f\u000fy\t\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u007f\b\u0010\n\u0010\f\u0010\u0082\t\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0005"+
		"\u001d\u00a3\b\u001d\n\u001d\f\u001d\u00a6\t\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0004_w\u0080\u00a4\u0000"+
		" \u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? \u0001\u0000"+
		"\r\u0005\u0000##kk\u00de\u00de\u00f8\u00f8\u2206\u2206\u000b\u0000$$&"+
		"&//;;\u00a1\u00a1\u00a4\u00a4\u00a9\u00a9\u00ae\u00ae\u00bf\u00bf\u00e6"+
		"\u00e6\u00f0\u00f0\u0002\u0000]]\u00a2\u00a2\u0001\u0000\u20ac\u20ac\u0001"+
		"\u0000\u00a7\u00a7\u0001\u0000))\u0001\u0000\n\n\u0001\u000009\u0002\u0000"+
		"AZaz\u0003\u0000\t\n\r\r  \u0002\u0000\u2190\u2190\u2192\u2192\u0005\u0000"+
		"\u00b5\u00b5\u019b\u019b\u039b\u039b\u03a9\u03a9\u03bb\u03bb\u0001\u0000"+
		"\u0010\u8000\uffff\u00b1\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u0000"+
		"7\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001"+
		"\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000"+
		"\u0000\u0001A\u0001\u0000\u0000\u0000\u0003C\u0001\u0000\u0000\u0000\u0005"+
		"E\u0001\u0000\u0000\u0000\u0007G\u0001\u0000\u0000\u0000\tI\u0001\u0000"+
		"\u0000\u0000\u000bK\u0001\u0000\u0000\u0000\rM\u0001\u0000\u0000\u0000"+
		"\u000fO\u0001\u0000\u0000\u0000\u0011Y\u0001\u0000\u0000\u0000\u0013g"+
		"\u0001\u0000\u0000\u0000\u0015i\u0001\u0000\u0000\u0000\u0017k\u0001\u0000"+
		"\u0000\u0000\u0019m\u0001\u0000\u0000\u0000\u001bo\u0001\u0000\u0000\u0000"+
		"\u001dq\u0001\u0000\u0000\u0000\u001fs\u0001\u0000\u0000\u0000!|\u0001"+
		"\u0000\u0000\u0000#\u0085\u0001\u0000\u0000\u0000%\u0088\u0001\u0000\u0000"+
		"\u0000\'\u008c\u0001\u0000\u0000\u0000)\u008e\u0001\u0000\u0000\u0000"+
		"+\u0090\u0001\u0000\u0000\u0000-\u0092\u0001\u0000\u0000\u0000/\u0094"+
		"\u0001\u0000\u0000\u00001\u0096\u0001\u0000\u0000\u00003\u0098\u0001\u0000"+
		"\u0000\u00005\u009a\u0001\u0000\u0000\u00007\u009c\u0001\u0000\u0000\u0000"+
		"9\u009e\u0001\u0000\u0000\u0000;\u00a0\u0001\u0000\u0000\u0000=\u00a9"+
		"\u0001\u0000\u0000\u0000?\u00ab\u0001\u0000\u0000\u0000AB\u0007\u0000"+
		"\u0000\u0000B\u0002\u0001\u0000\u0000\u0000CD\u0005n\u0000\u0000D\u0004"+
		"\u0001\u0000\u0000\u0000EF\u0007\u0001\u0000\u0000F\u0006\u0001\u0000"+
		"\u0000\u0000GH\u0007\u0002\u0000\u0000H\b\u0001\u0000\u0000\u0000IJ\u0007"+
		"\u0003\u0000\u0000J\n\u0001\u0000\u0000\u0000KL\u0007\u0004\u0000\u0000"+
		"L\f\u0001\u0000\u0000\u0000MN\u0007\u0005\u0000\u0000N\u000e\u0001\u0000"+
		"\u0000\u0000OT\u0005#\u0000\u0000PQ\b\u0006\u0000\u0000QS\t\u0000\u0000"+
		"\u0000RP\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001"+
		"\u0000\u0000\u0000WX\u0006\u0007\u0000\u0000X\u0010\u0001\u0000\u0000"+
		"\u0000YZ\u0005#\u0000\u0000Z[\u0005{\u0000\u0000[_\u0001\u0000\u0000\u0000"+
		"\\^\t\u0000\u0000\u0000]\\\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000"+
		"\u0000_`\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`b\u0001\u0000"+
		"\u0000\u0000a_\u0001\u0000\u0000\u0000bc\u0005}\u0000\u0000cd\u0005#\u0000"+
		"\u0000de\u0001\u0000\u0000\u0000ef\u0006\b\u0000\u0000f\u0012\u0001\u0000"+
		"\u0000\u0000gh\u0007\u0007\u0000\u0000h\u0014\u0001\u0000\u0000\u0000"+
		"ij\u0005-\u0000\u0000j\u0016\u0001\u0000\u0000\u0000kl\u0007\b\u0000\u0000"+
		"l\u0018\u0001\u0000\u0000\u0000mn\u0007\t\u0000\u0000n\u001a\u0001\u0000"+
		"\u0000\u0000op\u0007\n\u0000\u0000p\u001c\u0001\u0000\u0000\u0000qr\u0007"+
		"\u000b\u0000\u0000r\u001e\u0001\u0000\u0000\u0000sw\u0005\"\u0000\u0000"+
		"tv\t\u0000\u0000\u0000ut\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000xz\u0001\u0000\u0000"+
		"\u0000yw\u0001\u0000\u0000\u0000z{\u0005\"\u0000\u0000{ \u0001\u0000\u0000"+
		"\u0000|\u0080\u0005\u25b2\u0000\u0000}\u007f\t\u0000\u0000\u0000~}\u0001"+
		"\u0000\u0000\u0000\u007f\u0082\u0001\u0000\u0000\u0000\u0080\u0081\u0001"+
		"\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0083\u0001\u0000"+
		"\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u25b2"+
		"\u0000\u0000\u0084\"\u0001\u0000\u0000\u0000\u0085\u0086\u0005\'\u0000"+
		"\u0000\u0086\u0087\t\u0000\u0000\u0000\u0087$\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0005\u201b\u0000\u0000\u0089\u008a\t\u0000\u0000\u0000\u008a"+
		"\u008b\t\u0000\u0000\u0000\u008b&\u0001\u0000\u0000\u0000\u008c\u008d"+
		"\u0005|\u0000\u0000\u008d(\u0001\u0000\u0000\u0000\u008e\u008f\u0005{"+
		"\u0000\u0000\u008f*\u0001\u0000\u0000\u0000\u0090\u0091\u0005}\u0000\u0000"+
		"\u0091,\u0001\u0000\u0000\u0000\u0092\u0093\u0005[\u0000\u0000\u0093."+
		"\u0001\u0000\u0000\u0000\u0094\u0095\u0005(\u0000\u0000\u00950\u0001\u0000"+
		"\u0000\u0000\u0096\u0097\u0005\u27e8\u0000\u0000\u00972\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u0005\u27e9\u0000\u0000\u00994\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0005.\u0000\u0000\u009b6\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u0005;\u0000\u0000\u009d8\u0001\u0000\u0000\u0000\u009e\u009f\u0005@"+
		"\u0000\u0000\u009f:\u0001\u0000\u0000\u0000\u00a0\u00a4\u0005\u25bc\u0000"+
		"\u0000\u00a1\u00a3\t\u0000\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a6\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u25bc\u0000\u0000"+
		"\u00a8<\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u00b0\u0000\u0000\u00aa"+
		">\u0001\u0000\u0000\u0000\u00ab\u00ac\u0007\f\u0000\u0000\u00ac@\u0001"+
		"\u0000\u0000\u0000\u0006\u0000T_w\u0080\u00a4\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}