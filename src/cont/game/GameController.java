package cont.game;

import java.util.ArrayList;
import java.util.List;

import mod.FieldModel;
import mod.Player;
import mod.Tile;
import mod.Unit;
import cont.GUIController;
import cont.MessageBuilder;
import cont.board.BoardController;

/**
 * Class controls game-flow.
 */
public class GameController {
	private GUIController guiController;
	private BoardController boardController;
	private List<Player> players;
	private int activePlayer;
	private int turns;
	private boolean sztabTurn;
	private int endingTurn;
	public GameController(GUIController gui,List<String>playersNames,List<String> armies){
		guiController = gui;
		boardController = BoardController.createNewBoard(gui, this);
		players = new ArrayList<Player>();
		for(int i = 0; i<playersNames.size(); i++){
			players.add(new Player(playersNames.get(i),armies.get(i),boardController.getBoardModel().getBoard()));
		}
		turns = 0;
	}
	/**
	 * Starts new game. Is called once during game.
	 */
	public void startNewGame(){
		activePlayer = 0;
		turns = 0;
		endingTurn = 0;
		sztabTurn = true;
		beginTurn();
	}
	/**
	 * @return true if in this turn, players put their Sztab tiles at board.
	 */
	public boolean isSztabTurn(){
		return sztabTurn;
	}
	/**
	 * Is called every time, "Next turn" button is clicked. Ends previous turn and starts next one.
	 * 
	 */
	public void nextTurn(){
		if(isSztabTurn() && getActivePlayer().getSztabPosition() < 0){
			guiController.showMessage(MessageBuilder.mustPutSztabMessage());
			return;
		}
		endTurn();
		boardController.clearSelections();
		beginTurn();
	}

	private void beginTurn(){
		if(isSztabTurn()){
			guiController.showMessage(MessageBuilder.playerPutSztabMessage(getActivePlayer().getName()));
		}
		else if(isBattle()){
			battle();
		}
		else{
			guiController.showMessage(MessageBuilder.nextTurnMessage(getActivePlayer().getName()));
			normalTurn();
		}
	}
	private void endTurn(){
		guiController.refreshPlayerInfo();
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
		if(players.get(activePlayer).getArmySet().getSize()!=0)tiles.add(players.get(activePlayer).getTile());
		if(players.get(activePlayer).getArmySet().getSize()!=0)tiles.add(players.get(activePlayer).getTile());
		if(players.get(activePlayer).getArmySet().getSize()!=0)tiles.add(players.get(activePlayer).getTile());
		else endingTurn++;
		
		guiController.giveTiles(getActivePlayer(), tiles);
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
	private void battle(){
		guiController.showMessage(MessageBuilder.battle());
		FieldModel[] board = boardController.getBoardModel().getBoard();
		int initiative = 0;
		for(int i = 0; i<21; i++){
			if(i!=1 && i!=19 && board[i].tile instanceof Unit && ((Unit)board[i].tile).getBiggestInitiative()>initiative) initiative = ((Unit)board[i].tile).getBiggestInitiative();
		}
		while(initiative>=0){
			guiController.showMessage(MessageBuilder.actuallyInitiative(initiative));
			for(int i = 0; i<21; i++){
				if(i!=1 && i!=19 && board[i].tile instanceof Unit && ((Unit)board[i].tile).initiative.contains(initiative-((Unit)board[i].tile).initiativeBonus)){
					if(board[i].tile.isNetted())((Unit)board[i].tile).attack();
				}
			}
			for(int i = 0; i<21; i++){
				if(i!=1 && i!=19 && board[i].tile instanceof mod.tiles.empty.Empty && board[i].tile.getHp() <= 0) board[i].tile.die();
			}
			
		}
		
		
	}
	private boolean isBattle(){
		FieldModel[] board = boardController.getBoardModel().getBoard();
		for(int i = 0; i<21; i++){
			if(i!=1 && i!=19 && board[i].tile instanceof mod.tiles.empty.Empty) return false;
		}
		return true;
	}
	/**
	 * Returns if game should be ended.
	 */
	private boolean endOfGame(){
		return endingTurn == players.size();
	}
	private void endGame(){
		
		guiController.showMessage(MessageBuilder.endOfGameMessage(winner()));
		guiController.closeGame();
	}
	private String winner(){
		if(players.get(0).getSztab().getHp()>players.get(1).getSztab().getHp()) return players.get(0).getName();
		else if(players.get(1).getSztab().getHp()>players.get(0).getSztab().getHp()) return players.get(1).getName();
		return "-";
	}
	public void endGameManually(){
		guiController.showMessage(MessageBuilder.gameInterrupted());
		guiController.closeGame();
	}
	
	public int getTurnNumber(){
		return turns;
	}
	/**
	 * @return active player
	 */
	public Player getActivePlayer(){
		return players.get(activePlayer);
	}
	/**
	 * @return list of players in the game.
	 */
	public List<Player> getPlayers(){
		return players;
	}
	
}
