package mod;

import javax.swing.DefaultListModel;

/**
 * @author zygmunt
 *	Stores main configuration for the game.
 */
public class Config {
	private static int PLAYERS;
	private static DefaultListModel<String> armiesList;
	private static DefaultListModel<String> unchosenArmiesList;

	
	static {
		armiesList = new DefaultListModel<String>();
		armiesList.addElement("Borgo");
		armiesList.addElement("Hegemonia");
		armiesList.addElement("Moloch");
		armiesList.addElement("Posterunek");
		
		fillArmies();
		
	}

	public static void fillArmies(){
		unchosenArmiesList = new DefaultListModel<String>();
		unchosenArmiesList.addElement("Borgo");
		unchosenArmiesList.addElement("Hegemonia");
		unchosenArmiesList.addElement("Moloch");
		unchosenArmiesList.addElement("Posterunek");
	}
	public static void chooseArmy(String army){
		for(int i = 0; i<unchosenArmiesList.size(); i++){
			if(unchosenArmiesList.get(i).equals(army)){
				unchosenArmiesList.remove(i);
			}
		}
	}
	public static DefaultListModel<String> getUnchosenArmies(){
		return unchosenArmiesList;
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