package cont;

import gui.Board;
import gui.MainWindow;
import gui.PlayerInfo;

import java.util.List;

import mod.Player;
import mod.Tile;
import cont.game.GameController;

/**
 * @author zygmunt
 *	Class controls game window behavior. 
 *	Implements its button actions and provides couple of functions to modify main window appearance.
 */
public class MainWindowController implements WindowController {
	
	GUIController guiController;
	GameController gameController;
	MainWindow mainWindow;
	public MainWindowController(MainWindow mw,GUIController gui){
		guiController = gui;
		mainWindow = mw;
	}
	public void setGameContoller(GameController game){
		gameController = game;
	}
	/**
	 * @param gui
	 * @param armies
	 * @return controller to a new MainWindow
	 * Creates and displays new MainWindow.
	 */
	public static MainWindowController openNewMainWindow(GUIController gui){
		MainWindow mw = new MainWindow(gui);
		mw.getFrame().setVisible(true);
		return mw.getController();
	}

	/**
	 * @param playersList
	 * Creates content for PlayerInfo panels.
	 */
	public void fillPlayersInfo(List<Player> playersList){
		mainWindow.fillPlayersList(playersList);
	}
	public GameController getGameController(){
		return gameController;
	}
	/**
	 * Implementation of next-turn-button. Calls method from GUIController.
	 */
	public void nextTurn(){
		guiController.nextTurn();
	}
	/**
	 * Implementation of close-game-button. Calls method from GUIController.
	 */
	public void closeGame(){
		guiController.closeGame();
	}

	public void addBoard(Board b){
		mainWindow.addBoard(b);
	}
	/**
	 * @param player
	 * @param tileList
	 * Sends tiles in tileList to PlayerInfo panel that belongs to "player".
	 */
	public void givePlayerTiles(Player player,List<Tile> tileList){
		PlayerInfo pi = null;
		for(PlayerInfo p : mainWindow.getPlayerInfoList()){
			if(p.getPlayer() == player){
				pi = p;
				break;
			}
		}
		pi.giveTiles(tileList);
		mainWindow.repaint();
	}
	public void putTile(){
		gameController.putTileFromPlayerInfo();
	}
	public void discardTile(){
		getActivePlayerInfo().getAndDeleteSelectedTile();
		mainWindow.repaint();
		setDiscardButtonEnabled(false);
		if(gameController.isWaitingForDiscard()){
			gameController.tileDiscarded();
		}
	}
	public void rotateField(){
		gameController.rotateSelectedField();
	}
	public void acceptTile(){
		gameController.acceptTile();
	}
	/**
	 * Refreshes information about player(like hp of Sztab tile, TIles left)
	 */
	public void refreshPlayerInfo(){
		for(PlayerInfo pi : mainWindow.getPlayerInfoList()){
			pi.refreshText();
		}
	}
	/**
	 * @return PlayerInfo that belongs to the active player.
	 */
	public PlayerInfo getActivePlayerInfo(){
		Player p = gameController.getActivePlayer();
		for(PlayerInfo pi : mainWindow.getPlayerInfoList()){
			if(pi.getPlayer() == p){
				return pi;
			}
		}
		return null;
	}
	
	public void setPutButtonEnabled(boolean b){
		mainWindow.setPutTileEnabled(b);
	}
	public void setRotateButtonEnabled(boolean b){
		mainWindow.setRotateFieldEnabled(b);
	}
	public void setNextTurnButtonEnabled(boolean b){
		mainWindow.setNextTurnEnabled(b);
	}
	public void setAcceptButtonEnabled(boolean b){
		mainWindow.setAcceptEnabled(b);
	}
	public void setDiscardButtonEnabled(boolean b){
		mainWindow.setDiscardEnabled(b);
	}
	@Override
	public void show() {
		mainWindow.getFrame().setVisible(true);
	}
	@Override
	public void hide() {
		mainWindow.getFrame().setVisible(false);
	}
	@Override
	public void repaint() {
		mainWindow.getFrame().repaint();
	}

}
