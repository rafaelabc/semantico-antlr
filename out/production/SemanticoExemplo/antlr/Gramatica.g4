grammar Gramatica;

@header{
    package antlr;
}

prog: (decl|expr)+ EOF                      #Programa
    ;
decl: TYPE ID'='NUM ENDLINE                 #Declaracao
    ;
expr: expr SOM expr ENDLINE                 #Adicao
    | expr MUL expr ENDLINE                 #Multiplicacao
    | '(' expr ')'                          #Parenteses
    | NUM                                   #Numero
    | ID                                    #Variavel
    ;

TYPE: ('int'|'float');
ID:([a-z]|[A-Z])+;
WS:[ \n\t\r]+ -> skip;
NUM: [0-9]+('.'[0-9]+)?;
SOM: '+';
MUL: '*';
ENDLINE: ';';