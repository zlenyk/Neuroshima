package mod;

/**
 * @author zygmunt
 *	Stores main configuration for the game and visual appearance.
 */
public class Config {
	private static int HEIGHT;
	private static int WIDTH;
	private static int PLAYERS;
	/**
	 * @return height of the main window.
	 */
	public static int getHEIGHT() {
		return HEIGHT;
	}
	/**
	 * @param hEIGHT
	 * @throws InvalidConfigException
	 * Sets height of the main window.
	 */
	public static void setHEIGHT(int hEIGHT) throws InvalidConfigException {
		if(hEIGHT < 200) throw new InvalidConfigException("Height below 200.");
		HEIGHT = hEIGHT;
	}
	/**
	 * @return width of the main win
	 * @param hEIGHTdow.
	 */
	public static int getWIDTH() {
		return WIDTH;
	}
	/**
	 * @param wIDTH
	 * @throws InvalidConfigException
	 * Sets width of the main window.
	 */
	public static void setWIDTH(int wIDTH) throws InvalidConfigException {
		if(wIDTH < 200) throw new InvalidConfigException("Width below 200.");
		WIDTH = wIDTH;
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
	 */
	public static void setPLAYERS(int pLAYERS) {
		PLAYERS = pLAYERS;
	}

}