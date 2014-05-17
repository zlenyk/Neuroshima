package cont.game;

import java.util.ArrayList;
import java.util.List;

import mod.Player;
import mod.Tile;
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
			players.add(new Player(playersNames.get(i),armies.get(i)));
		}
	}
	public void startNewGame(){
		activePlayer = 0;
		turns = 0;
		for(Player active : players){
			guiController.showMessage(MessageBuilder.playerPutSztabMessage(getActivePlayerName()));
			List<Integer> whereCanPut = active.getSztab().pick();
			active.getSztab().put(choosePosition(whereCanPut),0);
			 
			activePlayer++;
			if(activePlayer==0) break;
		}
	}
	
	public void nextTurn(){
		List<Tile> tiles = new ArrayList<Tile>();
		tiles.add(players.get(activePlayer).getTile());
		tiles.add(players.get(activePlayer).getTile());
		tiles.add(players.get(activePlayer).getTile());
		
		/*
		 * here should be:
		 * function printing list tiles,
		 * guiController.showMessage(MessageBuilder.throwTileMessage());
		 * player choose one of 3 tiles to throw it
		 * tiles.remove(index); //remove choosen tile from tiles
		 * guiController.showMessage(MessageBuilder.putTilesMessage());
		 * again player click one tile than:
		 * List<Integeer> whereCanPut = tiles.get(choosentile).pick();
		 * tiles.get(choosentile).put(choosePosition(whereCanPut),0);
		 * than same with last tile
		 * 
		 */
		
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
	public static Integer choosePosition(List<Integer> wherceCanPut){
		return null;
	}
	
	
}
