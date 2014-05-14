package cont.board;

import gui.Board;
import gui.Field;

/**
 * @author zygmunt
 *	Class with methods to display game-board.
 */
public class BoardGenerator {
	public BoardGenerator(){}
	/**
	 * Methods generates fields for a given board and places them on it.
	 */
	public static void generateBoard(Board board){

		int move = 93;
		int[] hexX = {31,0,31,31+62,62*2,31+62};
		int[] hexY = {0,54,108,108,54,0};
		int[] Y = {108,216,324};
		int X = 0;
		for(int i = 0; i<3; i++){
			int[] _hexX = new int[6];
			int[] _hexY = new int[6];
			for(int j = 0;j<6;j++){
				_hexX[j] = hexX[j]+X;
				_hexY[j] = hexY[j]+Y[i];

			}
			Field field = new Field(ImageLoader.Borgo.bitwa(),ImageLoader.Borgo.bitwaSelected(),_hexX,_hexY);
			board.addField(field);
			field.setLocation(X, Y[i]);
			board.add(field);
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
			Field field = new Field(ImageLoader.Borgo.bitwa(),ImageLoader.Borgo.bitwaSelected(),_hexX,_hexY);
			board.addField(field);
			field.setLocation(X, Y1[i]);
			board.add(field);
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
			Field field = new Field(ImageLoader.Borgo.bitwa(),ImageLoader.Borgo.bitwaSelected(),_hexX,_hexY);
			board.addField(field);
			field.setLocation(X, Y2[i]);
			board.add(field);
		}
		X = 3*move;
		for(int i = 0; i<4; i++){
			int[] _hexX = new int[6];
			int[] _hexY = new int[6];
			for(int j = 0;j<6;j++){
				_hexX[j] = hexX[j]+X;
				_hexY[j] = hexY[j]+Y1[i];

			}
			Field field = new Field(ImageLoader.Borgo.bitwa(),ImageLoader.Borgo.bitwaSelected(),_hexX,_hexY);
			board.addField(field);
			field.setLocation(X, Y1[i]);
			board.add(field);
		}
		X = 4*move;
		for(int i = 0; i<3; i++){
			int[] _hexX = new int[6];
			int[] _hexY = new int[6];
			for(int j = 0;j<6;j++){
				_hexX[j] = hexX[j]+X;
				_hexY[j] = hexY[j]+Y[i];

			}
			Field field = new Field(ImageLoader.Borgo.bitwa(),ImageLoader.Borgo.bitwaSelected(),_hexX,_hexY);
			board.addField(field);
			field.setLocation(X, Y[i]);
			board.add(field);
		}
	}
}
