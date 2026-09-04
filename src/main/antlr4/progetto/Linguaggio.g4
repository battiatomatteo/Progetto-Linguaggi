grammar Linguaggio;

main : decl com EOF ;

decl : varDec* ;
varDec: type ID (ASSIGN exp)? SEMICOLON ;

com :  op=(DECR|INCR) ID                                            # preDecrInc
     | ID op=(DECR|INCR)                                            # postDecrInc
     | ID ASSIGN exp                                                # assign
     | ID op=(ADDEQ|SUBEQ|DIVEQ|MULEQ) exp                          # fastAssign
     | ID LBRACK exp RBRACK ASSIGN exp                              # arrayAssign
     | IF LPAR exp RPAR LBRACE com RBRACE                           # if
     | IF LPAR exp RPAR LBRACE com RBRACE ELSE LBRACE com RBRACE    # ifElse
     | WHILE LPAR exp RPAR LBRACE com RBRACE                        # while
     | com SEMICOLON com                                            # seq
     | OUT exp                                                      # out
     | INPUT ID                                                     # input
     | DLOW com (AT com)+ DGRT                                      # nonDet
     | FOR ID FROM exp TO exp LBRACE com RBRACE (ELSE LBRACE com RBRACE)?   # forWithFinal
     | BREAK                                                        # breakCmd
     | SWITCH LPAR exp RPAR LBRACE switchBody RBRACE                # switchCmd
     | EXIT                                                         # exit
     ;


exp : ID LBRACK exp RBRACK                # arrayAccess
    | LPAR type RPAR exp                  # cast
    | CHAR                                # charLiteral
    | num                                 # numeric
    | BOOL                                # boolean
    | STRING                              # string
    | STRING_START exp RBRACE             # complexString
    | LPAR exp RPAR                       # parExp
    | <assoc=right> exp POW exp           # pow
    | NOT exp                             # not
    | exp op=(MUL | DIV | MOD) exp        # mulDivMod
    | exp op=(ADD | SUB) exp              # addSub
    | exp op=(LT | LEQ | GEQ | GT) exp    # cmpExp
    | exp op=(EQQ | NEQ) exp              # eqExp
    | exp op=(AND | OR) exp               # andOr
    | exp CONCAT exp                      # concat
    | <assoc=right> exp QUESTIONMARK exp COLON exp      # ifStatement
    | ID                                  # id
    | LBRACK exp (COMMA exp)* RBRACK      # array
    | op=(DECR|INCR) ID                   # preDecrIncExp
    | ID op=(DECR|INCR)                   # postDecrIncExp

    ;

// in caso di problemi mettere stessa priorita per basetype e type
type
    : baseType (LBRACK RBRACK)?
    //| type LBRACK RBRACK      // array di qualunque tipo
    ;

baseType
    : 'int'
    | 'dec'
    | 'bool'
    | 'string'
    | 'char'
    ;

num : INT     # intNum
    | DEC     # decNum
    ;

// switch per flusso di controllo condizionato
switchBody
    : (caseBranch)+ (defaultBranch)?
    ;

caseBranch
    : CASE exp COLON com SEMICOLON
    ;

defaultBranch
    : DEFAULT COLON com
    ;

// operazioni con valori numerici
ADD : '+'   ;
SUB : '-'   ;
MUL : '*'   ;
DIV : '/'   ;
MOD : '%' ;
POW : '^'   ;
INCR : '++'  ;
DECR : '--'  ;
ADDEQ : '+=' ;
SUBEQ : '-=' ;
DIVEQ : '/=' ;
MULEQ : '*=' ;

// operazioni con i booleani
EQQ : '=='  ;
NEQ : '!='  ;
LEQ : '<='  ;
GEQ : '>='  ;
LT  : '<'   ;
GT  : '>'   ;
NOT : 'not' ;
AND : 'and' ;
OR  : 'or'  ;
DOLL : '$'  ;

// operazioni con le stringhe
CONCAT : COLON COLON;
STRING_START : DOLL LBRACE;

// comandi
IF     : 'if'    ;
ELSE   : 'else'  ;
WHILE  : 'while' ;
ASSIGN : '='     ;
OUT    : 'print' ;
INPUT  : 'input' ;
FOR     : 'for';
FROM    : 'from';
TO      : 'to';
BREAK   : 'break';
SWITCH  : 'switch';
CASE    : 'case';
DEFAULT : 'default';
EXIT : 'exit';


//simboli sintattici

DLOW : '<<';
DGRT : '>>';
COLON : ':';
QUESTIONMARK : '?';
LBRACK    : '[' ;
RBRACK    : ']' ;
LPAR      : '(' ;
RPAR      : ')' ;
LBRACE    : '{' ;
RBRACE    : '}' ;
COMMA     : ',' ;
SEMICOLON : ';' ;
AT        : '@' ;

//tipi dei dati
STRING : '"' STRCHR* '"'  ;
BOOL : 'true' | 'false' ;
INT  : NAT | '-' POS    ;
DEC  : (INT | '-' '0') '.' DIGIT+   ;
CHAR : '\'' CHARCHR '\'' ;

fragment NAT      : '0' | POS       ;
fragment POS      : POSDIGIT DIGIT* ;
fragment DIGIT    : '0' | POSDIGIT  ;
fragment POSDIGIT : [1-9]           ;
fragment STRCHR : ~["\\\r\n] | ESC ;
fragment ESC    : '\\' [btnfr"'\\] ;
fragment CHARCHR : ~['\\\r\n] | ESC ;

ID : [a-zA-Z] [a-zA-Z0-9]* ;

COMMENT : '//' ~[\r\n]* -> skip;
COMMENT_ML : '/*' (.)*? '*/' -> skip;
WS : [ \t\r\n]+ -> skip ;