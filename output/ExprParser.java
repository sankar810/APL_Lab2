// $ANTLR 3.5.1 I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g 2017-10-19 11:55:30

package expressionparser;
import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings("all")
public class ExprParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "NEWLINE", "WS", 
		"'('", "')'", "'*'", "'+'", "'-'", "'='"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int ID=4;
	public static final int INT=5;
	public static final int NEWLINE=6;
	public static final int WS=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "prog", "atom", "expr", "multExpr", "stat"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public ExprParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public ExprParser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this, port, null);

		setDebugListener(proxy);
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
	}

	public ExprParser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg, new RecognizerSharedState());
	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

	@Override public String[] getTokenNames() { return ExprParser.tokenNames; }
	@Override public String getGrammarFileName() { return "I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g"; }


	/** Map variable name to Integer object holding value */
	HashMap memory = new HashMap();



	// $ANTLR start "prog"
	// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:13:1: prog : ( stat )+ ;
	public final void prog() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "prog");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(13, 0);

		try {
			// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:13:5: ( ( stat )+ )
			dbg.enterAlt(1);

			// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:13:9: ( stat )+
			{
			dbg.location(13,9);
			// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:13:9: ( stat )+
			int cnt1=0;
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=2;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= ID && LA1_0 <= NEWLINE)||LA1_0==8) ) {
					alt1=1;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:13:9: stat
					{
					dbg.location(13,9);
					pushFollow(FOLLOW_stat_in_prog23);
					stat();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt1++;
			}
			} finally {dbg.exitSubRule(1);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(13, 14);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "prog");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "prog"



	// $ANTLR start "stat"
	// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:15:1: stat : ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE );
	public final void stat() throws RecognitionException {
		Token ID2=null;
		int expr1 =0;
		int expr3 =0;

		try { dbg.enterRule(getGrammarFileName(), "stat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(15, 0);

		try {
			// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:15:5: ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE )
			int alt2=3;
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			switch ( input.LA(1) ) {
			case INT:
			case 8:
				{
				alt2=1;
				}
				break;
			case ID:
				{
				int LA2_2 = input.LA(2);
				if ( (LA2_2==13) ) {
					alt2=2;
				}
				else if ( (LA2_2==NEWLINE||(LA2_2 >= 10 && LA2_2 <= 12)) ) {
					alt2=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 2, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case NEWLINE:
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:15:9: expr NEWLINE
					{
					dbg.location(15,9);
					pushFollow(FOLLOW_expr_in_stat50);
					expr1=expr();
					state._fsp--;
					dbg.location(15,14);
					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat52); dbg.location(15,22);
					System.out.println(expr1);
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:16:9: ID '=' expr NEWLINE
					{
					dbg.location(16,9);
					ID2=(Token)match(input,ID,FOLLOW_ID_in_stat64); dbg.location(16,12);
					match(input,13,FOLLOW_13_in_stat66); dbg.location(16,16);
					pushFollow(FOLLOW_expr_in_stat68);
					expr3=expr();
					state._fsp--;
					dbg.location(16,21);
					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat70); dbg.location(17,9);
					memory.put((ID2!=null?ID2.getText():null), new Integer(expr3));
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:18:9: NEWLINE
					{
					dbg.location(18,9);
					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat90); dbg.location(18,17);
					System.out.println("A newline has been issued");
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(19, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "stat"



	// $ANTLR start "expr"
	// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:21:1: expr returns [int value] : e= multExpr ( '+' e= multExpr | '-' e= multExpr )* ;
	public final int expr() throws RecognitionException {
		int value = 0;


		int e =0;

		try { dbg.enterRule(getGrammarFileName(), "expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(21, 0);

		try {
			// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:22:5: (e= multExpr ( '+' e= multExpr | '-' e= multExpr )* )
			dbg.enterAlt(1);

			// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:22:9: e= multExpr ( '+' e= multExpr | '-' e= multExpr )*
			{
			dbg.location(22,10);
			pushFollow(FOLLOW_multExpr_in_expr117);
			e=multExpr();
			state._fsp--;
			dbg.location(22,20);
			value = e;dbg.location(23,9);
			// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:23:9: ( '+' e= multExpr | '-' e= multExpr )*
			try { dbg.enterSubRule(3);

			loop3:
			while (true) {
				int alt3=3;
				try { dbg.enterDecision(3, decisionCanBacktrack[3]);

				int LA3_0 = input.LA(1);
				if ( (LA3_0==11) ) {
					alt3=1;
				}
				else if ( (LA3_0==12) ) {
					alt3=2;
				}

				} finally {dbg.exitDecision(3);}

				switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:23:13: '+' e= multExpr
					{
					dbg.location(23,13);
					match(input,11,FOLLOW_11_in_expr133); dbg.location(23,18);
					pushFollow(FOLLOW_multExpr_in_expr137);
					e=multExpr();
					state._fsp--;
					dbg.location(23,28);
					value += e;   
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:24:13: '-' e= multExpr
					{
					dbg.location(24,13);
					match(input,12,FOLLOW_12_in_expr153); dbg.location(24,18);
					pushFollow(FOLLOW_multExpr_in_expr157);
					e=multExpr();
					state._fsp--;
					dbg.location(24,28);
					value -= e;
					}
					break;

				default :
					break loop3;
				}
			}
			} finally {dbg.exitSubRule(3);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(26, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return value;
	}
	// $ANTLR end "expr"



	// $ANTLR start "multExpr"
	// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:28:1: multExpr returns [int value] : e= atom ( '*' e= atom )* ;
	public final int multExpr() throws RecognitionException {
		int value = 0;


		int e =0;

		try { dbg.enterRule(getGrammarFileName(), "multExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(28, 0);

		try {
			// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:29:5: (e= atom ( '*' e= atom )* )
			dbg.enterAlt(1);

			// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:29:9: e= atom ( '*' e= atom )*
			{
			dbg.location(29,10);
			pushFollow(FOLLOW_atom_in_multExpr195);
			e=atom();
			state._fsp--;
			dbg.location(29,16);
			value = e;dbg.location(29,37);
			// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:29:37: ( '*' e= atom )*
			try { dbg.enterSubRule(4);

			loop4:
			while (true) {
				int alt4=2;
				try { dbg.enterDecision(4, decisionCanBacktrack[4]);

				int LA4_0 = input.LA(1);
				if ( (LA4_0==10) ) {
					alt4=1;
				}

				} finally {dbg.exitDecision(4);}

				switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:29:38: '*' e= atom
					{
					dbg.location(29,38);
					match(input,10,FOLLOW_10_in_multExpr200); dbg.location(29,43);
					pushFollow(FOLLOW_atom_in_multExpr204);
					e=atom();
					state._fsp--;
					dbg.location(29,49);
					value *= e;
					}
					break;

				default :
					break loop4;
				}
			}
			} finally {dbg.exitSubRule(4);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(30, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "multExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return value;
	}
	// $ANTLR end "multExpr"



	// $ANTLR start "atom"
	// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:32:1: atom returns [int value] : ( INT | ID | '(' expr ')' );
	public final int atom() throws RecognitionException {
		int value = 0;


		Token INT4=null;
		Token ID5=null;
		int expr6 =0;

		try { dbg.enterRule(getGrammarFileName(), "atom");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(32, 0);

		try {
			// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:33:5: ( INT | ID | '(' expr ')' )
			int alt5=3;
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			switch ( input.LA(1) ) {
			case INT:
				{
				alt5=1;
				}
				break;
			case ID:
				{
				alt5=2;
				}
				break;
			case 8:
				{
				alt5=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(5);}

			switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:33:9: INT
					{
					dbg.location(33,9);
					INT4=(Token)match(input,INT,FOLLOW_INT_in_atom232); dbg.location(33,13);
					value = Integer.parseInt((INT4!=null?INT4.getText():null));
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:34:9: ID
					{
					dbg.location(34,9);
					ID5=(Token)match(input,ID,FOLLOW_ID_in_atom244); dbg.location(35,9);

					        Integer v = (Integer)memory.get((ID5!=null?ID5.getText():null));
					        if ( v!=null ) value = v.intValue();
					        else System.err.println("undefined variable "+(ID5!=null?ID5.getText():null));
					        
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// I:\\College\\Semester 1\\CECS 524 Advanced Topics in Programming Languages\\Lab Assignments\\5th\\output\\Expr.g:40:9: '(' expr ')'
					{
					dbg.location(40,9);
					match(input,8,FOLLOW_8_in_atom264); dbg.location(40,13);
					pushFollow(FOLLOW_expr_in_atom266);
					expr6=expr();
					state._fsp--;
					dbg.location(40,18);
					match(input,9,FOLLOW_9_in_atom268); dbg.location(40,22);
					value = expr6;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(41, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "atom");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return value;
	}
	// $ANTLR end "atom"

	// Delegated rules



	public static final BitSet FOLLOW_stat_in_prog23 = new BitSet(new long[]{0x0000000000000172L});
	public static final BitSet FOLLOW_expr_in_stat50 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NEWLINE_in_stat52 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat64 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_stat66 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_expr_in_stat68 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NEWLINE_in_stat70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_stat90 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr117 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_11_in_expr133 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_multExpr_in_expr137 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_12_in_expr153 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_multExpr_in_expr157 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_atom_in_multExpr195 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_multExpr200 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_atom_in_multExpr204 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_INT_in_atom232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_atom264 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_expr_in_atom266 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_atom268 = new BitSet(new long[]{0x0000000000000002L});
}
