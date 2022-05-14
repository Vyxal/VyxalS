lexer grammar VyxalLexer;

PREFIX: [#Þø∆k];

CONTEXT_VAR: 'n';

MONADIC_MODIFIER: [¡¿¤©®æð$&/;];

DYADIC_MODIFIER: [¢\]];

TRIADIC_MODIFIER: [€];

TETRADIC_MODIFIER: [§];

INFINITE_MODIFIER: [)];

COMMENT: '#' (~'\n' .)* -> skip;

BLOCK_COMMENT: '#{' .*? '}#' -> skip;

DIGIT: [0-9];

MINUS: '-';

ALPHA: [A-Za-z];

WHITESPACE: [ \t\r\n];

ASSN_SIGN: '→' | '←';

LAMBDA_TYPE: [λƛΩΛµ];

NORMAL_STRING: '"' .*? '"';

COMPRESSED_STRING: '▲' .*? '▲';

SINGLE_CHAR_STRING: '\'' .;

DOUBLE_CHAR_STRING: '‛' . .;

// syntax elements
PIPE: '|';

WHILE_OPEN: '{';

CLOSE: '}';

IF_OPEN: '[';

FOR_OPEN: '(';

LIST_OPEN: '⟨';

LIST_CLOSE: '⟩';

PERIOD: '.';

SEMICOLON: ';';

AT_SIGN: '@';

COMPRESSED_NUMBER: '▼' .*? '▼';

COMPLEX_SEPARATOR: '°';

LITERALLY_ANY_TEXT: [\u0010-\uFFFF];