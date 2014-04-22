package mod;

/**
 * @author zygmunt
 *	Stores main configuration for the game.
 */
public class Config {
	private static int PLAYERS;
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
	public static void setPLAYERS(int pLAYERS) throws InvalidConfigException {
		if(pLAYERS < 2 || pLAYERS > 4) throw new InvalidConfigException("Wrong number of players.");
		PLAYERS = pLAYERS;
	}

}