grammar SILGrammar;

@header {
package SILG;
import java.util.HashMap;
import java.util.*; 
}

@members {
/** Map variable name to Integer object holding value */
HashMap memory = new HashMap();
}

prog	
	:program+ end;
program
	:expr NEWLINE{System.out.println($expr.value);}
	|'NEWLINE' 
	|'INTEGER' (ID{memory.put($ID.text, new Integer(0));} | NEWLINE |',')*
	|'PRINT' (STRING{System.out.print($STRING.text.toString().split("\"")[l]);} |ID{System.out.print(memory.get($ID.text));})* {System.out.println();}
	|'PRINTLN' (STRING{System.out.print($STRING.text.toString().split("\"")[l]);} |ID{System.out.print(memory.get($ID.text));})* {System.out.println();}
	|'INPUT' 
	|'LET' ID '=' expr {memory.put($ID.text, new Integer($expr.value));}
	;
	
input	:	
(ID{memory.put($ID.text, (Integer.parseInt((new InputStreamReader(System.in)).readline())));} | ',')+
	;
end     
	:'END' {System.out.println();}
	;
	
expr returns [int value]
	:e=multExpr {$value = $e.value;}
        (   '+' e=multExpr {$value += $e.value;}
        |   '-' e=multExpr {$value -= $e.value;}
        )*
	;
multExpr returns [int value]
	:e=atom {$value = $e.value;} 
	('*' e=atom {$value *= $e.value;}
	|'/' e=atom {$value *= $e.value;})*
	;

atom returns [int value]
	:INT {$value = Integer.parseInt($INT.text);}
	|ID{
        Integer v = (Integer)memory.get($ID.text);
        if ( v!=null ) $value = v.intValue();
        else System.err.println("undefined variable "+$ID.text);}
	|'(' expr ')' {$value = $expr.value;}
	;
     
NEWLINE 
	:(' ' |'\r' |'\t' |'\n' )
	;
ID  
	:('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	;
    
INT 
	:'0'..'9'+
	;

COMMENT
	:   '//' ~('\n'|'\r')* '\r'? '\n' |   '/*' '*/' 
	;

WS  
	:   ( ' ' | '\t' | '\r' | '\n'+ ) 
	;

STRING
	:  '"' ( ~('\\'|'"') )* '"'
	;

CHAR
	:  '\'' ( ~('\''|'\\') ) '\''
	;
