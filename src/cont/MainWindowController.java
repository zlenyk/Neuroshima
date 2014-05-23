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
	public void enablePutButtonOrNot(boolean b){
		if(b){
			mainWindow.enablePutTile();
		}
		else{
			mainWindow.disablePutTile();
		}
	}
	public void enableRotateButtonOrNot(boolean b){
		if (b){
			mainWindow.enableRotateField();
		}
		else{
			mainWindow.disableRotateField();
		}
	}
	public void addBoard(Board b){
		mainWindow.addBoard(b);
	}
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
	public void rotateField(){
		gameController.rotateSelectedField();
	}
	public void refreshPlayerInfo(){
		for(PlayerInfo pi : mainWindow.getPlayerInfoList()){
			pi.refreshText();
		}
	}
	public PlayerInfo getActivePlayerInfo(){
		Player p = gameController.getActivePlayer();
		for(PlayerInfo pi : mainWindow.getPlayerInfoList()){
			if(pi.getPlayer() == p){
				return pi;
			}
		}
		return null;
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
