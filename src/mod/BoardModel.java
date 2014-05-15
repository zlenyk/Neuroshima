package mod;

import gui.Field;

import java.util.ArrayList;
import java.util.List;

import cont.game.GameController;




public class BoardModel {
	FieldModel board[];
	GameController gameController;
	
	private void fillBoard(List<String> armies){
		/*
		 * if armies = ... then...
		 * 
		 * 
		 */
	for(int i=0;i<21;i++) board[i]=new FieldModel(new mod.tiles.empty.Empty(),i);
		
	}
	public BoardModel(GameController game,List<String> armies){
		gameController = game;
		board = new FieldModel[21];
		fillBoard(armies);
		fillNeighbours();
		createBoard();
	}
	private void createBoard(){
		List<Field> fieldList = new ArrayList<Field>();
		for(int i = 0; i<21; i++){
			fieldList.add(board[i].getTile().getField());
		}
		gameController.createBoard(fieldList);
	}
	
	private void fillNeighbours(){
				board[0].neibours[0] = null;
				board[0].neibours[1] = null;
				board[0].neibours[2] = board[3];
				board[0].neibours[3] = board[2];
				board[0].neibours[4] = null;
				board[0].neibours[5] = null;
				
				board[2].neibours[0] = null;
				board[2].neibours[1] = board[0];
				board[2].neibours[2] = board[5];
				board[2].neibours[3] = board[7];
				board[2].neibours[4] = board[4];
				board[2].neibours[5] = null;
				
				board[3].neibours[0] = null;
				board[3].neibours[1] = null;
				board[3].neibours[2] = board[6];
				board[3].neibours[3] = board[8];
				board[3].neibours[4] = board[5];
				board[3].neibours[5] = board[0];
				
				board[4].neibours[0] = null;
				board[4].neibours[1] = board[2];
				board[4].neibours[2] = board[7];
				board[4].neibours[3] = board[9];
				board[4].neibours[4] = null;
				board[4].neibours[5] = null;
				
				board[5].neibours[0] = board[0];
				board[5].neibours[1] = board[3];
				board[5].neibours[2] = board[8];
				board[5].neibours[3] = board[10];
				board[5].neibours[4] = board[7];
				board[5].neibours[5] = board[2];
				
				board[6].neibours[0] = null;
				board[6].neibours[1] = null;
				board[6].neibours[2] = null;
				board[6].neibours[3] = board[11];
				board[6].neibours[4] = board[8];
				board[6].neibours[5] = board[3];
				
				board[7].neibours[0] = board[2];
				board[7].neibours[1] = board[5];
				board[7].neibours[2] = board[10];
				board[7].neibours[3] = board[12];
				board[7].neibours[4] = board[9];
				board[7].neibours[5] = board[4];
				
				board[8].neibours[0] = board[3];
				board[8].neibours[1] = board[6];
				board[8].neibours[2] = board[11];
				board[8].neibours[3] = board[13];
				board[8].neibours[4] = board[10];
				board[8].neibours[5] = board[5];
				
				board[9].neibours[0] = board[4];
				board[9].neibours[1] = board[7];
				board[9].neibours[2] = board[12];
				board[9].neibours[3] = board[14];
				board[9].neibours[4] = null;
				board[9].neibours[5] = null;
				
				board[10].neibours[0] = board[5];
				board[10].neibours[1] = board[8];
				board[10].neibours[2] = board[13];
				board[10].neibours[3] = board[15];
				board[10].neibours[4] = board[12];
				board[10].neibours[5] = board[7];
				
				board[11].neibours[0] = board[6];
				board[11].neibours[1] = null;
				board[11].neibours[2] = null;
				board[11].neibours[3] = board[16];
				board[11].neibours[4] = board[13];
				board[11].neibours[5] = board[8];
				
				board[12].neibours[0] = board[7];
				board[12].neibours[1] = board[10];
				board[12].neibours[2] = board[15];
				board[12].neibours[3] = board[17];
				board[12].neibours[4] = board[14];
				board[12].neibours[5] = board[9];
				
				board[13].neibours[0] = board[8];
				board[13].neibours[1] = board[11];
				board[13].neibours[2] = board[16];
				board[13].neibours[3] = board[18];
				board[13].neibours[4] = board[15];
				board[13].neibours[5] = board[10];
				
				board[14].neibours[0] = board[9];
				board[14].neibours[1] = board[12];
				board[14].neibours[2] = board[17];
				board[14].neibours[3] = null;
				board[14].neibours[4] = null;
				board[14].neibours[5] = null;
				
				board[15].neibours[0] = board[10];
				board[15].neibours[1] = board[13];
				board[15].neibours[2] = board[18];
				board[15].neibours[3] = board[20];
				board[15].neibours[4] = board[17];
				board[15].neibours[5] = board[12];
				
				board[16].neibours[0] = board[11];
				board[16].neibours[1] = null;
				board[16].neibours[2] = null;
				board[16].neibours[3] = null;
				board[16].neibours[4] = board[18];
				board[16].neibours[5] = board[13];
				
				board[17].neibours[0] = board[12];
				board[17].neibours[1] = board[15];
				board[17].neibours[2] = board[20];
				board[17].neibours[3] = null;
				board[17].neibours[4] = null;
				board[17].neibours[5] = board[14];
				
				board[18].neibours[0] = board[13];
				board[18].neibours[1] = board[16];
				board[18].neibours[2] = null;
				board[18].neibours[3] = null;
				board[18].neibours[4] = board[20];
				board[18].neibours[5] = board[15];
				
				board[20].neibours[0] = board[15];
				board[20].neibours[1] = board[18];
				board[20].neibours[2] = null;
				board[20].neibours[3] = null;
				board[20].neibours[4] = null;
				board[20].neibours[5] = board[17];
	}
	
}
