// Generated from ../java/input/Gradle.g4 by ANTLR 4.13.2
package compliance.parser.antlr.gradle.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GradleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, BOOLEAN_LITERAL=30, 
		NULL_LITERAL=31, STRING_LITERAL=32, NUMBER_LITERAL=33, IDENTIFIER=34, 
		WHITESPACE=35, SINGLE_LINE_COMMENT=36, MULTI_LINE_COMMENT=37, TASKS_REGISTER_LABEL=38;
	public static final int
		RULE_buildFile = 0, RULE_statement = 1, RULE_blockDeclaration = 2, RULE_block = 3, 
		RULE_parenthesesBlock = 4, RULE_assignmentStatement = 5, RULE_methodCall = 6, 
		RULE_applyStatement = 7, RULE_pluginStatement = 8, RULE_dependencyStatement = 9, 
		RULE_applicationStatement = 10, RULE_repositoriesStatement = 11, RULE_tasksStatement = 12, 
		RULE_tasksMethod = 13, RULE_tasksNamedMethod = 14, RULE_tasksRegisterMethod = 15, 
		RULE_identifierMethod = 16, RULE_javaStatement = 17, RULE_expression = 18, 
		RULE_argument = 19, RULE_namedArgument = 20, RULE_literal = 21, RULE_operator = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"buildFile", "statement", "blockDeclaration", "block", "parenthesesBlock", 
			"assignmentStatement", "methodCall", "applyStatement", "pluginStatement", 
			"dependencyStatement", "applicationStatement", "repositoriesStatement", 
			"tasksStatement", "tasksMethod", "tasksNamedMethod", "tasksRegisterMethod", 
			"identifierMethod", "javaStatement", "expression", "argument", "namedArgument", 
			"literal", "operator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "','", "')'", "'='", "'apply'", "'plugins'", 
			"'dependencies'", "'application'", "'repositories'", "'tasks'", "'.'", 
			"'named'", "'register'", "'java'", "':'", "'+'", "'-'", "'*'", "'/'", 
			"'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'&&'", "'||'", null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "BOOLEAN_LITERAL", "NULL_LITERAL", 
			"STRING_LITERAL", "NUMBER_LITERAL", "IDENTIFIER", "WHITESPACE", "SINGLE_LINE_COMMENT", 
			"MULTI_LINE_COMMENT", "TASKS_REGISTER_LABEL"
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
	public String getGrammarFileName() { return "Gradle.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GradleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BuildFileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GradleParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BuildFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_buildFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterBuildFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitBuildFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitBuildFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuildFileContext buildFile() throws RecognitionException {
		BuildFileContext _localctx = new BuildFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_buildFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33286070152L) != 0)) {
				{
				{
				setState(46);
				statement();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
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
	public static class StatementContext extends ParserRuleContext {
		public BlockDeclarationContext blockDeclaration() {
			return getRuleContext(BlockDeclarationContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public ApplyStatementContext applyStatement() {
			return getRuleContext(ApplyStatementContext.class,0);
		}
		public DependencyStatementContext dependencyStatement() {
			return getRuleContext(DependencyStatementContext.class,0);
		}
		public PluginStatementContext pluginStatement() {
			return getRuleContext(PluginStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ApplicationStatementContext applicationStatement() {
			return getRuleContext(ApplicationStatementContext.class,0);
		}
		public RepositoriesStatementContext repositoriesStatement() {
			return getRuleContext(RepositoriesStatementContext.class,0);
		}
		public TasksStatementContext tasksStatement() {
			return getRuleContext(TasksStatementContext.class,0);
		}
		public JavaStatementContext javaStatement() {
			return getRuleContext(JavaStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				blockDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				assignmentStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				methodCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				applyStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(58);
				dependencyStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(59);
				pluginStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(60);
				expression(0);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(61);
				applicationStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(62);
				repositoriesStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(63);
				tasksStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(64);
				javaStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockDeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GradleParser.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParenthesesBlockContext parenthesesBlock() {
			return getRuleContext(ParenthesesBlockContext.class,0);
		}
		public BlockDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterBlockDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitBlockDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitBlockDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockDeclarationContext blockDeclaration() throws RecognitionException {
		BlockDeclarationContext _localctx = new BlockDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockDeclaration);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(IDENTIFIER);
				setState(68);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(IDENTIFIER);
				setState(70);
				parenthesesBlock();
				setState(71);
				block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__0);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33286070152L) != 0)) {
				{
				{
				setState(76);
				statement();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			match(T__1);
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
	public static class ParenthesesBlockContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public ParenthesesBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesesBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterParenthesesBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitParenthesesBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitParenthesesBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesesBlockContext parenthesesBlock() throws RecognitionException {
		ParenthesesBlockContext _localctx = new ParenthesesBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parenthesesBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__2);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33285996552L) != 0)) {
				{
				setState(85);
				argument();
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(86);
					match(T__3);
					setState(87);
					argument();
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(95);
			match(T__4);
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
	public static class AssignmentStatementContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GradleParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(IDENTIFIER);
			setState(98);
			match(T__5);
			setState(99);
			expression(0);
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
	public static class MethodCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GradleParser.IDENTIFIER, 0); }
		public ParenthesesBlockContext parenthesesBlock() {
			return getRuleContext(ParenthesesBlockContext.class,0);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(IDENTIFIER);
			setState(102);
			parenthesesBlock();
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
	public static class ApplyStatementContext extends ParserRuleContext {
		public ParenthesesBlockContext parenthesesBlock() {
			return getRuleContext(ParenthesesBlockContext.class,0);
		}
		public ApplyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_applyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterApplyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitApplyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitApplyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplyStatementContext applyStatement() throws RecognitionException {
		ApplyStatementContext _localctx = new ApplyStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_applyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__6);
			setState(105);
			parenthesesBlock();
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
	public static class PluginStatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public PluginStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pluginStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterPluginStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitPluginStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitPluginStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PluginStatementContext pluginStatement() throws RecognitionException {
		PluginStatementContext _localctx = new PluginStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pluginStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__7);
			setState(108);
			block();
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
	public static class DependencyStatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DependencyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dependencyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterDependencyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitDependencyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitDependencyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DependencyStatementContext dependencyStatement() throws RecognitionException {
		DependencyStatementContext _localctx = new DependencyStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dependencyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__8);
			setState(111);
			block();
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
	public static class ApplicationStatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ApplicationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_applicationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterApplicationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitApplicationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitApplicationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplicationStatementContext applicationStatement() throws RecognitionException {
		ApplicationStatementContext _localctx = new ApplicationStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_applicationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__9);
			setState(114);
			block();
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
	public static class RepositoriesStatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public RepositoriesStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repositoriesStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterRepositoriesStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitRepositoriesStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitRepositoriesStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepositoriesStatementContext repositoriesStatement() throws RecognitionException {
		RepositoriesStatementContext _localctx = new RepositoriesStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_repositoriesStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__10);
			setState(117);
			block();
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
	public static class TasksStatementContext extends ParserRuleContext {
		public List<TasksMethodContext> tasksMethod() {
			return getRuleContexts(TasksMethodContext.class);
		}
		public TasksMethodContext tasksMethod(int i) {
			return getRuleContext(TasksMethodContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TasksStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tasksStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterTasksStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitTasksStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitTasksStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TasksStatementContext tasksStatement() throws RecognitionException {
		TasksStatementContext _localctx = new TasksStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tasksStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__11);
			setState(122); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(120);
				match(T__12);
				setState(121);
				tasksMethod();
				}
				}
				setState(124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 );
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(126);
				block();
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
	public static class TasksMethodContext extends ParserRuleContext {
		public TasksNamedMethodContext tasksNamedMethod() {
			return getRuleContext(TasksNamedMethodContext.class,0);
		}
		public IdentifierMethodContext identifierMethod() {
			return getRuleContext(IdentifierMethodContext.class,0);
		}
		public TasksRegisterMethodContext tasksRegisterMethod() {
			return getRuleContext(TasksRegisterMethodContext.class,0);
		}
		public TasksMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tasksMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterTasksMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitTasksMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitTasksMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TasksMethodContext tasksMethod() throws RecognitionException {
		TasksMethodContext _localctx = new TasksMethodContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tasksMethod);
		try {
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				tasksNamedMethod();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				identifierMethod();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				tasksRegisterMethod();
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
	public static class TasksNamedMethodContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(GradleParser.STRING_LITERAL, 0); }
		public TasksNamedMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tasksNamedMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterTasksNamedMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitTasksNamedMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitTasksNamedMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TasksNamedMethodContext tasksNamedMethod() throws RecognitionException {
		TasksNamedMethodContext _localctx = new TasksNamedMethodContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tasksNamedMethod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__13);
			setState(135);
			match(T__2);
			setState(136);
			match(STRING_LITERAL);
			setState(137);
			match(T__4);
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
	public static class TasksRegisterMethodContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(GradleParser.STRING_LITERAL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GradleParser.IDENTIFIER, 0); }
		public TasksRegisterMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tasksRegisterMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterTasksRegisterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitTasksRegisterMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitTasksRegisterMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TasksRegisterMethodContext tasksRegisterMethod() throws RecognitionException {
		TasksRegisterMethodContext _localctx = new TasksRegisterMethodContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tasksRegisterMethod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(T__14);
			setState(140);
			match(T__2);
			setState(141);
			match(STRING_LITERAL);
			setState(142);
			match(T__3);
			setState(143);
			match(IDENTIFIER);
			setState(144);
			match(T__4);
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
	public static class IdentifierMethodContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GradleParser.IDENTIFIER, 0); }
		public IdentifierMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterIdentifierMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitIdentifierMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitIdentifierMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierMethodContext identifierMethod() throws RecognitionException {
		IdentifierMethodContext _localctx = new IdentifierMethodContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_identifierMethod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(IDENTIFIER);
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
	public static class JavaStatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public JavaStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_javaStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterJavaStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitJavaStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitJavaStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JavaStatementContext javaStatement() throws RecognitionException {
		JavaStatementContext _localctx = new JavaStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_javaStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__15);
			setState(149);
			block();
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
	public static class ExpressionContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(GradleParser.IDENTIFIER, 0); }
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(152);
				literal();
				}
				break;
			case 2:
				{
				setState(153);
				match(IDENTIFIER);
				}
				break;
			case 3:
				{
				setState(154);
				methodCall();
				}
				break;
			case 4:
				{
				setState(155);
				match(T__2);
				setState(156);
				expression(0);
				setState(157);
				match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(161);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(162);
					operator();
					setState(163);
					expression(3);
					}
					} 
				}
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
	public static class ArgumentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NamedArgumentContext namedArgument() {
			return getRuleContext(NamedArgumentContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_argument);
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				namedArgument();
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

	@SuppressWarnings("CheckReturnValue")
	public static class NamedArgumentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GradleParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NamedArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterNamedArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitNamedArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitNamedArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedArgumentContext namedArgument() throws RecognitionException {
		NamedArgumentContext _localctx = new NamedArgumentContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_namedArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(IDENTIFIER);
			setState(175);
			match(T__16);
			setState(176);
			expression(0);
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
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(GradleParser.STRING_LITERAL, 0); }
		public TerminalNode NUMBER_LITERAL() { return getToken(GradleParser.NUMBER_LITERAL, 0); }
		public TerminalNode BOOLEAN_LITERAL() { return getToken(GradleParser.BOOLEAN_LITERAL, 0); }
		public TerminalNode NULL_LITERAL() { return getToken(GradleParser.NULL_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16106127360L) != 0)) ) {
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
	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GradleListener ) ((GradleListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GradleVisitor ) return ((GradleVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1073479680L) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 18:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001&\u00b7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0005\u00000\b\u0000\n\u0000\f\u0000"+
		"3\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001B\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002J\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0005\u0003N\b\u0003\n\u0003\f\u0003Q\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004Y\b\u0004\n\u0004\f\u0004\\\t\u0004\u0003\u0004^\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0004\f{\b\f\u000b"+
		"\f\f\f|\u0001\f\u0003\f\u0080\b\f\u0001\r\u0001\r\u0001\r\u0003\r\u0085"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u00a0\b\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u00a6\b\u0012\n\u0012\f\u0012\u00a9\t\u0012"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u00ad\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0000\u0001$\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,\u0000\u0002\u0001\u0000"+
		"\u001e!\u0001\u0000\u0012\u001d\u00b7\u00001\u0001\u0000\u0000\u0000\u0002"+
		"A\u0001\u0000\u0000\u0000\u0004I\u0001\u0000\u0000\u0000\u0006K\u0001"+
		"\u0000\u0000\u0000\bT\u0001\u0000\u0000\u0000\na\u0001\u0000\u0000\u0000"+
		"\fe\u0001\u0000\u0000\u0000\u000eh\u0001\u0000\u0000\u0000\u0010k\u0001"+
		"\u0000\u0000\u0000\u0012n\u0001\u0000\u0000\u0000\u0014q\u0001\u0000\u0000"+
		"\u0000\u0016t\u0001\u0000\u0000\u0000\u0018w\u0001\u0000\u0000\u0000\u001a"+
		"\u0084\u0001\u0000\u0000\u0000\u001c\u0086\u0001\u0000\u0000\u0000\u001e"+
		"\u008b\u0001\u0000\u0000\u0000 \u0092\u0001\u0000\u0000\u0000\"\u0094"+
		"\u0001\u0000\u0000\u0000$\u009f\u0001\u0000\u0000\u0000&\u00ac\u0001\u0000"+
		"\u0000\u0000(\u00ae\u0001\u0000\u0000\u0000*\u00b2\u0001\u0000\u0000\u0000"+
		",\u00b4\u0001\u0000\u0000\u0000.0\u0003\u0002\u0001\u0000/.\u0001\u0000"+
		"\u0000\u000003\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001"+
		"\u0000\u0000\u000024\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"45\u0005\u0000\u0000\u00015\u0001\u0001\u0000\u0000\u00006B\u0003\u0004"+
		"\u0002\u00007B\u0003\n\u0005\u00008B\u0003\f\u0006\u00009B\u0003\u000e"+
		"\u0007\u0000:B\u0003\u0012\t\u0000;B\u0003\u0010\b\u0000<B\u0003$\u0012"+
		"\u0000=B\u0003\u0014\n\u0000>B\u0003\u0016\u000b\u0000?B\u0003\u0018\f"+
		"\u0000@B\u0003\"\u0011\u0000A6\u0001\u0000\u0000\u0000A7\u0001\u0000\u0000"+
		"\u0000A8\u0001\u0000\u0000\u0000A9\u0001\u0000\u0000\u0000A:\u0001\u0000"+
		"\u0000\u0000A;\u0001\u0000\u0000\u0000A<\u0001\u0000\u0000\u0000A=\u0001"+
		"\u0000\u0000\u0000A>\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000"+
		"A@\u0001\u0000\u0000\u0000B\u0003\u0001\u0000\u0000\u0000CD\u0005\"\u0000"+
		"\u0000DJ\u0003\u0006\u0003\u0000EF\u0005\"\u0000\u0000FG\u0003\b\u0004"+
		"\u0000GH\u0003\u0006\u0003\u0000HJ\u0001\u0000\u0000\u0000IC\u0001\u0000"+
		"\u0000\u0000IE\u0001\u0000\u0000\u0000J\u0005\u0001\u0000\u0000\u0000"+
		"KO\u0005\u0001\u0000\u0000LN\u0003\u0002\u0001\u0000ML\u0001\u0000\u0000"+
		"\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000"+
		"\u0000\u0000PR\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000RS\u0005"+
		"\u0002\u0000\u0000S\u0007\u0001\u0000\u0000\u0000T]\u0005\u0003\u0000"+
		"\u0000UZ\u0003&\u0013\u0000VW\u0005\u0004\u0000\u0000WY\u0003&\u0013\u0000"+
		"XV\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000"+
		"\u0000Z[\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000"+
		"\u0000\u0000]U\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001"+
		"\u0000\u0000\u0000_`\u0005\u0005\u0000\u0000`\t\u0001\u0000\u0000\u0000"+
		"ab\u0005\"\u0000\u0000bc\u0005\u0006\u0000\u0000cd\u0003$\u0012\u0000"+
		"d\u000b\u0001\u0000\u0000\u0000ef\u0005\"\u0000\u0000fg\u0003\b\u0004"+
		"\u0000g\r\u0001\u0000\u0000\u0000hi\u0005\u0007\u0000\u0000ij\u0003\b"+
		"\u0004\u0000j\u000f\u0001\u0000\u0000\u0000kl\u0005\b\u0000\u0000lm\u0003"+
		"\u0006\u0003\u0000m\u0011\u0001\u0000\u0000\u0000no\u0005\t\u0000\u0000"+
		"op\u0003\u0006\u0003\u0000p\u0013\u0001\u0000\u0000\u0000qr\u0005\n\u0000"+
		"\u0000rs\u0003\u0006\u0003\u0000s\u0015\u0001\u0000\u0000\u0000tu\u0005"+
		"\u000b\u0000\u0000uv\u0003\u0006\u0003\u0000v\u0017\u0001\u0000\u0000"+
		"\u0000wz\u0005\f\u0000\u0000xy\u0005\r\u0000\u0000y{\u0003\u001a\r\u0000"+
		"zx\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000}\u007f\u0001\u0000\u0000\u0000~\u0080"+
		"\u0003\u0006\u0003\u0000\u007f~\u0001\u0000\u0000\u0000\u007f\u0080\u0001"+
		"\u0000\u0000\u0000\u0080\u0019\u0001\u0000\u0000\u0000\u0081\u0085\u0003"+
		"\u001c\u000e\u0000\u0082\u0085\u0003 \u0010\u0000\u0083\u0085\u0003\u001e"+
		"\u000f\u0000\u0084\u0081\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000"+
		"\u0000\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u001b\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0005\u000e\u0000\u0000\u0087\u0088\u0005\u0003"+
		"\u0000\u0000\u0088\u0089\u0005 \u0000\u0000\u0089\u008a\u0005\u0005\u0000"+
		"\u0000\u008a\u001d\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u000f\u0000"+
		"\u0000\u008c\u008d\u0005\u0003\u0000\u0000\u008d\u008e\u0005 \u0000\u0000"+
		"\u008e\u008f\u0005\u0004\u0000\u0000\u008f\u0090\u0005\"\u0000\u0000\u0090"+
		"\u0091\u0005\u0005\u0000\u0000\u0091\u001f\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0005\"\u0000\u0000\u0093!\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0005\u0010\u0000\u0000\u0095\u0096\u0003\u0006\u0003\u0000\u0096#\u0001"+
		"\u0000\u0000\u0000\u0097\u0098\u0006\u0012\uffff\uffff\u0000\u0098\u00a0"+
		"\u0003*\u0015\u0000\u0099\u00a0\u0005\"\u0000\u0000\u009a\u00a0\u0003"+
		"\f\u0006\u0000\u009b\u009c\u0005\u0003\u0000\u0000\u009c\u009d\u0003$"+
		"\u0012\u0000\u009d\u009e\u0005\u0005\u0000\u0000\u009e\u00a0\u0001\u0000"+
		"\u0000\u0000\u009f\u0097\u0001\u0000\u0000\u0000\u009f\u0099\u0001\u0000"+
		"\u0000\u0000\u009f\u009a\u0001\u0000\u0000\u0000\u009f\u009b\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a7\u0001\u0000\u0000\u0000\u00a1\u00a2\n\u0002\u0000"+
		"\u0000\u00a2\u00a3\u0003,\u0016\u0000\u00a3\u00a4\u0003$\u0012\u0003\u00a4"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a5\u00a1\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a9\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0001\u0000\u0000\u0000\u00a8%\u0001\u0000\u0000\u0000\u00a9\u00a7"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ad\u0003$\u0012\u0000\u00ab\u00ad\u0003"+
		"(\u0014\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ad\'\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\"\u0000"+
		"\u0000\u00af\u00b0\u0005\u0011\u0000\u0000\u00b0\u00b1\u0003$\u0012\u0000"+
		"\u00b1)\u0001\u0000\u0000\u0000\u00b2\u00b3\u0007\u0000\u0000\u0000\u00b3"+
		"+\u0001\u0000\u0000\u0000\u00b4\u00b5\u0007\u0001\u0000\u0000\u00b5-\u0001"+
		"\u0000\u0000\u0000\f1AIOZ]|\u007f\u0084\u009f\u00a7\u00ac";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}