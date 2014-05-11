package cont.board;

import gui.Board;
import gui.Field;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;

public class BoardGenerator {
	Board board;
	List<Field> fieldList;
	public BoardGenerator(Board b){
		fieldList = new ArrayList<Field>();
		board = b;
	}
	public void generateBoard(){
        File imageFile = new File("graphics/borgo/borgo01-sztab.png");
        Image image = null;
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int move = 93;
		int[] Y = {108,216,324};
		int X = 0;
		for(int i = 0; i<3; i++){
			Field field = new Field(image);
			fieldList.add(field);
			field.setLocation(X, Y[i]);
			board.add(field);
		}
		int[] Y1 = {54,162,270,378};
		X = move;
		for(int i = 0; i<4; i++){
			Field field = new Field(image);
			fieldList.add(field);
			field.setLocation(X, Y1[i]);
			board.add(field);
		}
		int[] Y2 = {0,108,216,324,432};
		X = 2*move;
		for(int i = 0; i<5; i++){
			Field field = new Field(image);
			fieldList.add(field);
			field.setLocation(X, Y2[i]);
			board.add(field);
		}
		X = 3*move;
		for(int i = 0; i<4; i++){
			Field field = new Field(image);
			fieldList.add(field);
			field.setLocation(X, Y1[i]);
			board.add(field);
		}
		X = 4*move;
		for(int i = 0; i<3; i++){
			Field field = new Field(image);
			fieldList.add(field);
			field.setLocation(X, Y[i]);
			board.add(field);
		}
	}
}
