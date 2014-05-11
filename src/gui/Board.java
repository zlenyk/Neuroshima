package gui;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import cont.board.BoardController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Board extends JPanel{

	List<Field> fieldList;
	List<String> armies;
	BoardController controller;
	public Board (List<String> armies) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		controller = new BoardController(this);
		this.armies = armies;
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.mouseAction(e.getX(),e.getY());
			}
		});
		
		controller.generateBoard();
	}

}
