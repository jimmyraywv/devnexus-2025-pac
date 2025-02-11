grammar Gradle;

// Parser Rules
buildFile
    : (statement)* EOF
    ;

statement
    : blockDeclaration
    | assignmentStatement
    | methodCall
    | applyStatement
    | dependencyStatement
    | pluginStatement
    | expression
    | applicationStatement
    | repositoriesStatement
    | tasksStatement
    | javaStatement
    ;

blockDeclaration
    : IDENTIFIER block
    | IDENTIFIER parenthesesBlock block
    ;

block
    : '{' statement* '}'
    ;

parenthesesBlock
    : '(' (argument (',' argument)*)? ')'
    ;

assignmentStatement
    : IDENTIFIER '=' expression
    ;

methodCall
    : IDENTIFIER parenthesesBlock
    ;

applyStatement
    : 'apply' parenthesesBlock
    ;

pluginStatement
    : 'plugins' block
    ;

dependencyStatement
    : 'dependencies' block
    ;

applicationStatement
    : 'application' block
    ;

repositoriesStatement
    : 'repositories' block
    ;

tasksStatement
    : 'tasks' ('.' tasksMethod)+ block?
    ;

tasksMethod
    : tasksNamedMethod
    | identifierMethod
    | tasksRegisterMethod
    ;

tasksNamedMethod
    : 'named' '(' STRING_LITERAL ')'
    ;

tasksRegisterMethod
    : 'register' '(' STRING_LITERAL ',' IDENTIFIER ')'
    ;

identifierMethod
    : IDENTIFIER
    ;

javaStatement
    : 'java' block
    ;

expression
    : literal
    | IDENTIFIER
    | methodCall
    | expression operator expression
    | '(' expression ')'
    ;

argument
    : expression
    | namedArgument
    ;

namedArgument
    : IDENTIFIER ':' expression
    ;

literal
    : STRING_LITERAL
    | NUMBER_LITERAL
    | BOOLEAN_LITERAL
    | NULL_LITERAL
    ;

operator
    : '+'
    | '-'
    | '*'
    | '/'
    | '=='
    | '!='
    | '>'
    | '<'
    | '>='
    | '<='
    | '&&'
    | '||'
    ;

// Lexer Rules
BOOLEAN_LITERAL: 'true' | 'false';
NULL_LITERAL: 'null';

STRING_LITERAL
    : '"' (~["\r\n\\] | '\\' .)* '"'
    | '\'' (~['\r\n\\] | '\\' .)* '\''
    ;

NUMBER_LITERAL
    : [0-9]+ ('.' [0-9]+)?
    ;

IDENTIFIER
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

// Skip whitespace and comments
WHITESPACE
    : [ \t\r\n]+ -> skip
    ;

SINGLE_LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;

MULTI_LINE_COMMENT
    : '/*' .*? '*/' -> skip
    ;

TASKS_REGISTER_LABEL
    : [a-zA-Z0-9]+
    ;
