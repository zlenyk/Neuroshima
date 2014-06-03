package mod;

import gui.Field;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import cont.board.BoardController;


public class BoardModel {
	FieldModel board[];
	BoardController boardController;
	
	private void fillBoard(){

		for(int i=0;i<21;i++) board[i]=new FieldModel(i);
		for(int i=0;i<21;i++) board[i].changeTile(new mod.tiles.empty.Empty());
	}
	public BoardModel(BoardController boardC){
		boardController = boardC;
		board = new FieldModel[21];
		fillBoard();
		fillNeighbours();
	}
	
	public FieldModel[] getBoard(){
		return board;
	}
	public int getPosition(Point p){
		for(int i = 0; i<21; i++){
			if(i != 1 && i != 19){
				if(getFieldModelAt(i).contains(p)){
					return i;
				}
			}
		}
		return -1;
	}
	public FieldModel getFieldModelThatContains(Point p){
		for(int i = 0; i<21; i++){
			if(i != 1 && i != 19){
				if(getFieldModelAt(i).contains(p)){
					return getFieldModelAt(i);
				}
			}
		}
		return null;
	}
	public FieldModel getFieldModelAt(int position){
		return board[position];
	}
	public FieldModel getSelectedFieldModel(){
		for(int i = 0; i<21; i++){
			if(i != 1 && i != 19){
				if(getFieldModelAt(i).getTile().getField().isSelected()){
					return getFieldModelAt(i);
				}
			}
		}
		return null;
	}
	public List<Field> getFields(){
		List<Field> fieldList = new ArrayList<Field>();
		for(int i = 0; i<21; i++){
			fieldList.add(board[i].getTile().getField());
		}
		return fieldList;
	}
	private void fillNeighbours(){

		board[0].neighbours[0] = null;
		board[0].neighbours[1] = null;
		board[0].neighbours[2] = board[3];
		board[0].neighbours[3] = board[5];
		board[0].neighbours[4] = board[2];
		board[0].neighbours[5] = null;

		board[2].neighbours[0] = null;
		board[2].neighbours[1] = board[0];
		board[2].neighbours[2] = board[5];
		board[2].neighbours[3] = board[7];
		board[2].neighbours[4] = board[4];
		board[2].neighbours[5] = null;

		board[3].neighbours[0] = null;
		board[3].neighbours[1] = null;
		board[3].neighbours[2] = board[6];
		board[3].neighbours[3] = board[8];
		board[3].neighbours[4] = board[5];
		board[3].neighbours[5] = board[0];

		board[4].neighbours[0] = null;
		board[4].neighbours[1] = board[2];
		board[4].neighbours[2] = board[7];
		board[4].neighbours[3] = board[9];
		board[4].neighbours[4] = null;
		board[4].neighbours[5] = null;

		board[5].neighbours[0] = board[0];
		board[5].neighbours[1] = board[3];
		board[5].neighbours[2] = board[8];
		board[5].neighbours[3] = board[10];
		board[5].neighbours[4] = board[7];
		board[5].neighbours[5] = board[2];

		board[6].neighbours[0] = null;
		board[6].neighbours[1] = null;
		board[6].neighbours[2] = null;
		board[6].neighbours[3] = board[11];
		board[6].neighbours[4] = board[8];
		board[6].neighbours[5] = board[3];

		board[7].neighbours[0] = board[2];
		board[7].neighbours[1] = board[5];
		board[7].neighbours[2] = board[10];
		board[7].neighbours[3] = board[12];
		board[7].neighbours[4] = board[9];
		board[7].neighbours[5] = board[4];

		board[8].neighbours[0] = board[3];
		board[8].neighbours[1] = board[6];
		board[8].neighbours[2] = board[11];
		board[8].neighbours[3] = board[13];
		board[8].neighbours[4] = board[10];
		board[8].neighbours[5] = board[5];

		board[9].neighbours[0] = board[4];
		board[9].neighbours[1] = board[7];
		board[9].neighbours[2] = board[12];
		board[9].neighbours[3] = board[14];
		board[9].neighbours[4] = null;
		board[9].neighbours[5] = null;

		board[10].neighbours[0] = board[5];
		board[10].neighbours[1] = board[8];
		board[10].neighbours[2] = board[13];
		board[10].neighbours[3] = board[15];
		board[10].neighbours[4] = board[12];
		board[10].neighbours[5] = board[7];

		board[11].neighbours[0] = board[6];
		board[11].neighbours[1] = null;
		board[11].neighbours[2] = null;
		board[11].neighbours[3] = board[16];
		board[11].neighbours[4] = board[13];
		board[11].neighbours[5] = board[8];

		board[12].neighbours[0] = board[7];
		board[12].neighbours[1] = board[10];
		board[12].neighbours[2] = board[15];
		board[12].neighbours[3] = board[17];
		board[12].neighbours[4] = board[14];
		board[12].neighbours[5] = board[9];

		board[13].neighbours[0] = board[8];
		board[13].neighbours[1] = board[11];
		board[13].neighbours[2] = board[16];
		board[13].neighbours[3] = board[18];
		board[13].neighbours[4] = board[15];
		board[13].neighbours[5] = board[10];

		board[14].neighbours[0] = board[9];
		board[14].neighbours[1] = board[12];
		board[14].neighbours[2] = board[17];
		board[14].neighbours[3] = null;
		board[14].neighbours[4] = null;
		board[14].neighbours[5] = null;

		board[15].neighbours[0] = board[10];
		board[15].neighbours[1] = board[13];
		board[15].neighbours[2] = board[18];
		board[15].neighbours[3] = board[20];
		board[15].neighbours[4] = board[17];
		board[15].neighbours[5] = board[12];

		board[16].neighbours[0] = board[11];
		board[16].neighbours[1] = null;
		board[16].neighbours[2] = null;
		board[16].neighbours[3] = null;
		board[16].neighbours[4] = board[18];
		board[16].neighbours[5] = board[13];

		board[17].neighbours[0] = board[12];
		board[17].neighbours[1] = board[15];
		board[17].neighbours[2] = board[20];
		board[17].neighbours[3] = null;
		board[17].neighbours[4] = null;
		board[17].neighbours[5] = board[14];

		board[18].neighbours[0] = board[13];
		board[18].neighbours[1] = board[16];
		board[18].neighbours[2] = null;
		board[18].neighbours[3] = null;
		board[18].neighbours[4] = board[20];
		board[18].neighbours[5] = board[15];

		board[20].neighbours[0] = board[15];
		board[20].neighbours[1] = board[18];
		board[20].neighbours[2] = null;
		board[20].neighbours[3] = null;
		board[20].neighbours[4] = null;
		board[20].neighbours[5] = board[17];
	}
	
}




