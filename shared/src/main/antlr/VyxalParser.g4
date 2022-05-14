parser grammar VyxalParser;

options {
	tokenVocab = VyxalLexer;
}

file: program EOF;

program: (program_node | WHITESPACE)*;

program_node: statement | literal | modifier | element;

literal:
	string
	| number
	| COMPRESSED_NUMBER
	| complex_number
	| list;

string:
	NORMAL_STRING
	| COMPRESSED_STRING
	| SINGLE_CHAR_STRING
	| DOUBLE_CHAR_STRING;

number: integer (PERIOD integer)?;

integer: DIGIT+;

complex_number: number COMPLEX_SEPARATOR number;

list: LIST_OPEN program (PIPE program)* LIST_CLOSE?;

statement:
	if_statement
	| for_loop
	| while_loop
	| lambda
	| variable_assn;

if_statement: IF_OPEN program (PIPE program)? CLOSE?;

for_loop: FOR_OPEN (variable PIPE)? program CLOSE?;

while_loop:
	WHILE_OPEN (cond = program PIPE)? body = program CLOSE?;

lambda: LAMBDA_TYPE (integer PIPE)? program CLOSE?;

variable_assn: ASSN_SIGN variable;

variable: ALPHA+;

modifier:
	monadic_modifier
	| dyadic_modifier
	| triadic_modifier
	| tetradic_modifier
	| infinite_modifier;

monadic_modifier: MONADIC_MODIFIER program_node;

dyadic_modifier: DYADIC_MODIFIER program_node program_node;

triadic_modifier:
	TRIADIC_MODIFIER program_node program_node program_node;

tetradic_modifier:
	TETRADIC_MODIFIER program_node program_node program_node program_node;

infinite_modifier: INFINITE_MODIFIER program_node*;

element: PREFIX? element_type;

element_type: ALPHA | LITERALLY_ANY_TEXT | CONTEXT_VAR | DIGIT;

