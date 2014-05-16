package mod;

import gui.Field;

import java.util.ArrayList;
import java.util.List;

import cont.board.BoardController;


public class BoardModel {
	FieldModel board[];
	BoardController boardController;
	
	private void fillBoard(){
		for(int i=0;i<19;i++) board[i]=new FieldModel(i);
		for(int i=0;i<19;i++) board[i].changeTile(new mod.tiles.empty.Empty());
	}
	public BoardModel(BoardController boardC){
		boardController = boardC;
		board = new FieldModel[19];
		fillBoard();
		fillNeighbours();
	}
	
	public List<Field> getFields(){
		List<Field> fieldList = new ArrayList<Field>();
		for(int i = 0; i<19; i++){
			fieldList.add(board[i].getTile().getField());
		}
		return fieldList;
	}
	
	private void fillNeighbours(){
				board[0].neibours[0] = null;
				board[0].neibours[1] = board[3];
				board[0].neibours[2] = board[4];
				board[0].neibours[3] = board[1];
				board[0].neibours[4] = null;
				board[0].neibours[5] = null;
				
				board[1].neibours[0] = board[0];
				board[1].neibours[1] = board[4];
				board[1].neibours[2] = board[5];
				board[1].neibours[3] = board[2];
				board[1].neibours[4] = null;
				board[1].neibours[5] = null;
				
				board[2].neibours[0] = board[1];
				board[2].neibours[1] = board[5];
				board[2].neibours[2] = board[6];
				board[2].neibours[3] = null;
				board[2].neibours[4] = null;
				board[2].neibours[5] = null;
				
				board[3].neibours[0] = null;
				board[3].neibours[1] = board[7];
				board[3].neibours[2] = board[8];
				board[3].neibours[3] = board[4];
				board[3].neibours[4] = board[0];
				board[3].neibours[5] = null;
				
				board[4].neibours[0] = board[3];
				board[4].neibours[1] = board[8];
				board[4].neibours[2] = board[9];
				board[4].neibours[3] = board[5];
				board[4].neibours[4] = board[1];
				board[4].neibours[5] = board[0];
				
				board[5].neibours[0] = board[4];
				board[5].neibours[1] = board[9];
				board[5].neibours[2] = board[10];
				board[5].neibours[3] = board[6];
				board[5].neibours[4] = board[2];
				board[5].neibours[5] = board[1];
				
				board[6].neibours[0] = board[5];
				board[6].neibours[1] = board[10];
				board[6].neibours[2] = board[11];
				board[6].neibours[3] = null;
				board[6].neibours[4] = null;
				board[6].neibours[5] = board[2];
				
				board[7].neibours[0] = null;
				board[7].neibours[1] = null;
				board[7].neibours[2] = null;
				board[7].neibours[3] = board[12];
				board[7].neibours[4] = board[8];
				board[7].neibours[5] = board[3];
				
				board[8].neibours[0] = board[7];
				board[8].neibours[1] = board[12];
				board[8].neibours[2] = board[13];
				board[8].neibours[3] = board[9];
				board[8].neibours[4] = board[4];
				board[8].neibours[5] = board[3];
				
				board[9].neibours[0] = board[8];
				board[9].neibours[1] = board[13];
				board[9].neibours[2] = board[14];
				board[9].neibours[3] = board[10];
				board[9].neibours[4] = board[5];
				board[9].neibours[5] = board[4];
				
				board[10].neibours[0] = board[9];
				board[10].neibours[1] = board[14];
				board[10].neibours[2] = board[15];
				board[10].neibours[3] = board[11];
				board[10].neibours[4] = board[6];
				board[10].neibours[5] = board[5];
				
				board[11].neibours[0] = board[10];
				board[11].neibours[1] = board[15];
				board[11].neibours[2] = null;
				board[11].neibours[3] = null;
				board[11].neibours[4] = null;
				board[11].neibours[5] = board[6];
				
				board[12].neibours[0] = null;
				board[12].neibours[1] = null;
				board[12].neibours[2] = board[16];
				board[12].neibours[3] = board[13];
				board[12].neibours[4] = board[8];
				board[12].neibours[5] = board[7];
				
				board[13].neibours[0] = board[12];
				board[13].neibours[1] = board[16];
				board[13].neibours[2] = board[17];
				board[13].neibours[3] = board[14];
				board[13].neibours[4] = board[9];
				board[13].neibours[5] = board[8];
				
				board[14].neibours[0] = board[13];
				board[14].neibours[1] = board[17];
				board[14].neibours[2] = board[18];
				board[14].neibours[3] = board[15];
				board[14].neibours[4] = board[10];
				board[14].neibours[5] = board[9];
				
				board[15].neibours[0] = board[14];
				board[15].neibours[1] = board[18];
				board[15].neibours[2] = null;
				board[15].neibours[3] = null;
				board[15].neibours[4] = board[11];
				board[15].neibours[5] = board[10];
				
				board[16].neibours[0] = null;
				board[16].neibours[1] = null;
				board[16].neibours[2] = null;
				board[16].neibours[3] = board[17];
				board[16].neibours[4] = board[13];
				board[16].neibours[5] = board[12];
				
				board[17].neibours[0] = board[16];
				board[17].neibours[1] = null;
				board[17].neibours[2] = null;
				board[17].neibours[3] = board[18];
				board[17].neibours[4] = board[14];
				board[17].neibours[5] = board[13];
				
				board[18].neibours[0] = board[17];
				board[18].neibours[1] = null;
				board[18].neibours[2] = null;
				board[18].neibours[3] = null;
				board[18].neibours[4] = board[15];
				board[18].neibours[5] = board[14];
				
	}
	
}
