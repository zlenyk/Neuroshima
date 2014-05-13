package cont.game;

import java.util.ArrayList;
import java.util.List;

import mod.Player;
import cont.GUIController;

/**
 * @author zygmunt
 * Class controls game-flow.
 */
public class GameController {
	private GUIController guiController;
	private List<Player> players;
	private int activePlayer;
	public GameController(GUIController gui,List<String>playersNames){
		guiController = gui;
		players = new ArrayList<Player>();
		for(int i = 0; i<playersNames.size(); i++){
			players.add(new Player(playersNames.get(i)));
		}
	}
	
	public void startNewGame(){
		activePlayer = 0;
	}
	public void nextTurn(){
		activePlayer++;
		activePlayer %= players.size();
	}
	public void endGame(){}
	public void endGameManually(){}
	
	
	private Player getActivePlayer(){
		return players.get(activePlayer);
	}
	public String getActivePlayerName(){
		return getActivePlayer().getName();
	}
	public List<Player> getPlayers(){
		return players;
	}
}
