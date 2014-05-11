package cont.board;

import gui.Board;
import gui.Field;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class BoardGenerator {
	Board board;
	List<Field> fieldList;
	public BoardGenerator(Board b){
		fieldList = new ArrayList<Field>();
		board = b;
	}
	public void generateBoard(){
        File imageFile = new File("graphics/borgo/borgo01-sztab.png");
        File selImageFile = new File("graphics/borgo/selected/borgo01-sztab.png");

        Image image = null;
        Image selImage = null;
		try {
			image = ImageIO.read(imageFile);
			selImage = ImageIO.read(selImageFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
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
			Field field = new Field(image,selImage,_hexX,_hexY);
			fieldList.add(field);
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
			Field field = new Field(image,selImage,_hexX,_hexY);
			fieldList.add(field);
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
			Field field = new Field(image,selImage,_hexX,_hexY);
			fieldList.add(field);
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
			Field field = new Field(image,selImage,_hexX,_hexY);
			fieldList.add(field);
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
			Field field = new Field(image,selImage,_hexX,_hexY);
			fieldList.add(field);
			field.setLocation(X, Y[i]);
			board.add(field);
		}
	}
}
