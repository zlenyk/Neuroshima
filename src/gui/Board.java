package gui;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import cont.board.BoardGenerator;


public class Board extends JPanel{

	List<Field> fieldList;
	List<String> armies;
	public Board (List<String> armies) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.armies = armies;
		setLayout(null);
		BoardGenerator bg = new BoardGenerator(this);
		bg.generateBoard();
	}

}
