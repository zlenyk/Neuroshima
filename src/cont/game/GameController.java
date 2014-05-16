package cont.game;

import java.util.ArrayList;
import java.util.List;

import mod.Player;
import cont.GUIController;
import cont.MessageBuilder;
import cont.board.BoardController;

/**
 * @author zygmunt
 * Class controls game-flow.
 */
public class GameController {
	private GUIController guiController;
	private BoardController boardController;
	private List<Player> players;
	private int activePlayer;
	private int turns;
	public GameController(GUIController gui,List<String>playersNames,List<String> armies){
		guiController = gui;
		boardController = BoardController.createNewBoard(gui, this);
		players = new ArrayList<Player>();
		for(int i = 0; i<playersNames.size(); i++){
			players.add(new Player(playersNames.get(i)) );
		}
	}
	public void startNewGame(){
		activePlayer = 0;
		turns = 0;
	}
	
	public void nextTurn(){
		activePlayer++;
		activePlayer %= players.size();
		turns++;
		if(endOfGame()){
			endGame();
		}
		else{
			guiController.showMessage(MessageBuilder.nextTurnMessage(getActivePlayerName()));
		}
	}
	/**
	 * Returns if game should be ended.
	 */
	private boolean endOfGame(){
		return turns >= 10;
	}
	private void endGame(){
		guiController.showMessage(MessageBuilder.endOfGameMessage());
		guiController.closeGame();
	}
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
