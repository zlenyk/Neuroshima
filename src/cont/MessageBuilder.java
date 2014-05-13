package cont;

import mod.Config;

/**
 * @author zygmunt
 *	Class manages content of all the messages displayed to the players.
 *	Every message should come from this class.
 */
public class MessageBuilder {
	
	public static String nextTurnMessage(String name){
		return "Player: " + name + "'s turn";
	}
	public static String armiesErrorMessage(){
		return "You must choose exactly 2 armies.";
	}
	public static String lettersErrorMessage(){
		return "Name must have between 2 and 20 characters";
	}
	public static String playersCountErrorMessage(){
		return "There must be exactly " + Config.getPLAYERS() + " players.";
	}
}
