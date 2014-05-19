package cont;

import gui.Board;
import gui.MainWindow;
import gui.PlayerInfo;

import java.util.List;

import mod.Player;
import mod.Tile;

/**
 * @author zygmunt
 *	Class controls game window behavior. 
 *	Implements its button actions and provides couple of functions to modify main window appearance.
 */
public class MainWindowController implements WindowController {
	
	GUIController guiController;
	MainWindow mainWindow;
	public MainWindowController(MainWindow mw,GUIController gui){
		guiController = gui;
		mainWindow = mw;
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
