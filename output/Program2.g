grammar Program2;

@header {
package assignment;
import java.util.HashMap;
import java.util.Scanner;  
}

@members {
/** Map variable name to Integer object holding value */
HashMap memory = new HashMap();
}

prog:   statement+ end;
                
statement:   expr NEWLINE {System.out.println($expr.value);}
    |   ID '=' expr NEWLINE {memory.put($ID.text, new Integer($expr.value));}
    |   'NEWLINE'
    |   'INTEGER' ID 
    |   'INPUT' input 
    |   'PRINT' print {System.out.println($print.text.replace("\"",""));} NEWLINE
    |   'PRINTLN' println {System.out.println($print.text.replace("\"",""));} NEWLINE
    |   'LET' ID '=' expr {memory.put($ID.text, new Integer($expr.value));}
    |   'END'
    ;
    
end	:	     
	'END' {System.Exit(0);}
	;
    
print returns [String value]: 
	e=STRING {$value = $e.toString();}
	;   

println returns [String value]: 
        e=STRING {$value = $e.toString();}
        ;    
    
input :	
	ID
        {
        String temp = $NEWID.text;
        System.out.println("Enter a value");
        String[] I = temp.split(",");
        Scanner sc=new Scanner(System.in); 
        int i = 0;
        while (sc.hasNext()){
        String idn = I[i];
        memory.put(idn, new Integer(0));
        Integer v = (Integer)memory.get(idn);
        if ( v!=null ) {
        v=sc.nextInt(); 
        memory.put(idn, v);
        System.out.println("Variable : "+I[i] + "\nvalue : "+v);
        }
        else System.err.println("undefined variable "+I[i]);
        i++;
        }
        
        } 
	;    

expr returns [int value]
    :   e=multExpr {$value = $e.value;}
        (   '+' e=multExpr {$value += $e.value;}
        |   '-' e=multExpr {$value -= $e.value;}
        )*
    ;

multExpr returns [int value]
    :   e=atom {$value = $e.value;} ('*' e=atom {$value *= $e.value;})*
    ; 

atom returns [int value]
    :   INT {$value = Integer.parseInt($INT.text);}
    |   ID
        {
        Integer v = (Integer)memory.get($ID.text);
        if ( v!=null ) $value = v.intValue();
        else System.err.println("variable undefined "+$ID.text);
        }
    |   '(' expr ')' {$value = $expr.value;}
    ;

INT :   '0'..'9'+ ;
NEWLINE :(' ' |'\r' |'\t' |'\n' ) ;
WS  :   ( ' ' | '\t' | '\r' | '\n'+ );
ID  :('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
STRING : '"' (~('\\'|'"'))* '"';