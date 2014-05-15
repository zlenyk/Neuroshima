package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import cont.board.BoardController;


public class Board extends JPanel{

	List<Field> fieldList;
	BoardController controller;
	public BoardController getController(){
		return controller;
	}
	public Board () {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		controller = new BoardController(this);
		fieldList = new ArrayList<Field>();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.mouseAction(e.getX(),e.getY());
			}
		});
	}
	public void addField(Field field){
		add(field);			//adds to JPanel
		fieldList.add(field);
	}
	public List<Field> getFields(){
		return fieldList;
	}

}
