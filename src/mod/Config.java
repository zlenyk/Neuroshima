package mod;

import javax.swing.DefaultListModel;

/**
 * @author zygmunt
 *	Stores main configuration for the game.
 */
public class Config {
	private static int PLAYERS;
	private static DefaultListModel<String> armiesList;
	
	static {
		armiesList = new DefaultListModel<String>();
		armiesList.addElement("Borgo");
		armiesList.addElement("Hegemonia");
		armiesList.addElement("Moloch");
		armiesList.addElement("Posterunek");
	}
	
	public static DefaultListModel<String> getArmies(){
		return armiesList;
	}
	/**
	 * @return number of players.
	 */
	public static int getPLAYERS() {
		return PLAYERS;
	}
	/**
	 * @param pLAYERS
	 * Sets number of players.
	 * @throws InvalidConfigException 
	 */
	public static void setPLAYERS(int pLAYERS) {
		//if(pLAYERS < 2 || pLAYERS > 4) throw new InvalidConfigException("Wrong number of players.");
		PLAYERS = pLAYERS;
	}

}