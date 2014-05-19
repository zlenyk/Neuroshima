package cont.board;

import gui.Board;

/**
 * @author zygmunt
 *	Class with methods to display game-board.
 */
public class BoardGenerator {
	/**
	 * Generates fields for a given board and places them on it.
	 */
	public static void generateBoard(Board board,BoardController bc){
		board.resetBoard();
		int move = 93;
		int[] hexX = {31,0,31,31+62,62*2,31+62};
		int[] hexY = {0,54,108,108,54,0};
		int[] Y = {108,216,324};
		int X = 0;
		int[] ind1 = {4,9,14};
		int[] ind2 = {2,7,12,17};
		int[] ind3 = {0,5,10,15,20};
		int[] ind4 = {3,8,13,18};
		int[] ind5 = {6,11,16};
		
		for(int i = 0; i<3; i++){
			int[] _hexX = new int[6];
			int[] _hexY = new int[6];
			for(int j = 0;j<6;j++){
				_hexX[j] = hexX[j]+X;
				_hexY[j] = hexY[j]+Y[i];

			}
			bc.getBoardModel().getFieldModelAt(ind1[i]).setShape(_hexX, _hexY);
			bc.getBoardModel().getFieldModelAt(ind1[i]).setLocation(X, Y[i]);

			board.addField(bc.getBoardModel().getFieldModelAt(ind1[i]));
		}
		int[] Y1 = {54,162,270,378};
		X = move;
		for(int i = 0; i<4; i++){
			int[] _hexX = new int[6];
			int[] _hexY = new int[6];
			for(int j = 0;j<6;j++){
				_hexX[j] = hexX[j]+X;
				_hexY[j] = hexY[j]+Y1[i];

			}
			bc.getBoardModel().getFieldModelAt(ind2[i]).setShape(_hexX, _hexY);
			bc.getBoardModel().getFieldModelAt(ind2[i]).setLocation(X, Y1[i]);
			
			board.addField(bc.getBoardModel().getFieldModelAt(ind2[i]));

		}
		int[] Y2 = {0,108,216,324,432};
		X = 2*move;
		for(int i = 0; i<5; i++){
			int[] _hexX = new int[6];
			int[] _hexY = new int[6];
			for(int j = 0;j<6;j++){
				_hexX[j] = hexX[j]+X;
				_hexY[j] = hexY[j]+Y2[i];

			}
			bc.getBoardModel().getFieldModelAt(ind3[i]).setShape(_hexX, _hexY);
			bc.getBoardModel().getFieldModelAt(ind3[i]).setLocation(X, Y2[i]);

			board.addField(bc.getBoardModel().getFieldModelAt(ind3[i]));

		}
		X = 3*move;
		for(int i = 0; i<4; i++){
			int[] _hexX = new int[6];
			int[] _hexY = new int[6];
			for(int j = 0;j<6;j++){
				_hexX[j] = hexX[j]+X;
				_hexY[j] = hexY[j]+Y1[i];

			}
			bc.getBoardModel().getFieldModelAt(ind4[i]).setShape(_hexX, _hexY);
			bc.getBoardModel().getFieldModelAt(ind4[i]).setLocation(X, Y1[i]);

			board.addField(bc.getBoardModel().getFieldModelAt(ind4[i]));

		}
		X = 4*move;
		for(int i = 0; i<3; i++){
			int[] _hexX = new int[6];
			int[] _hexY = new int[6];
			for(int j = 0;j<6;j++){
				_hexX[j] = hexX[j]+X;
				_hexY[j] = hexY[j]+Y[i];

			}
			bc.getBoardModel().getFieldModelAt(ind5[i]).setShape(_hexX, _hexY);
			bc.getBoardModel().getFieldModelAt(ind5[i]).setLocation(X, Y[i]);

			board.addField(bc.getBoardModel().getFieldModelAt(ind5[i]));

		}
	}
}
