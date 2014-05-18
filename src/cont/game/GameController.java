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
	private boolean sztabTurn;
	public GameController(GUIController gui,List<String>playersNames,List<String> armies){
		guiController = gui;
		boardController = BoardController.createNewBoard(gui, this);
		players = new ArrayList<Player>();
		for(int i = 0; i<playersNames.size(); i++){
			players.add(new Player(playersNames.get(i),armies.get(i),boardController.getBoardModel().getBoard()));
		}
		turns = 0;
	}
	public void startNewGame(){
		activePlayer = 0;
		turns = 0;
		sztabTurn = true;
		beginTurn();
	}
	public boolean isSztabTurn(){
		return sztabTurn;
	}
	public void nextTurn(){
		endTurn();
		beginTurn();
	}
	private void beginTurn(){
		if(isSztabTurn()){
			guiController.showMessage(MessageBuilder.playerPutSztabMessage(getActivePlayerName()));
		}
		else{
			guiController.showMessage(MessageBuilder.nextTurnMessage(getActivePlayerName()));
			normalTurn();
		}
	}
	private void endTurn(){
		activePlayer++;
		activePlayer %= players.size();
		if(activePlayer == 0) {
			sztabTurn = false;
			turns++;
		}
		if(endOfGame()){
			endGame();
		}
	}
	private void normalTurn(){
		List<Tile> tiles = new ArrayList<Tile>();
		tiles.add(players.get(activePlayer).getTile());
		tiles.add(players.get(activePlayer).getTile());
		tiles.add(players.get(activePlayer).getTile());
		
		/*
		 * here should be:
		 * function printing list<tile> tiles, with 3 tiles from armyset,
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
	
	public int getTurnNumber(){
		return turns;
	}
	public Player getActivePlayer(){
		return players.get(activePlayer);
	}
	public String getActivePlayerName(){
		return getActivePlayer().getName();
	}
	public List<Player> getPlayers(){
		return players;
	}
}
