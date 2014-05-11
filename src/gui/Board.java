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
	List<String> armies;
	BoardController controller;
	public Board (List<String> armies) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		controller = new BoardController(this);
		this.armies = armies;
		fieldList = new ArrayList<Field>();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.mouseAction(e.getX(),e.getY());
			}
		});
		
		controller.generateBoard();
	}
	public void addField(Field field){
		fieldList.add(field);
	}
	public List<Field> getFields(){
		return fieldList;
	}

}
