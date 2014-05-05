


public class BoardModel {
	FieldModel board[];
	BoardModel(){
		board = new FieldModel[21];
		for(int i=0;i<21;i++) board[i]=new FieldModel();
		//----------------------------//
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
		
		//itd dokonczyc--------------//
	}
	
}
