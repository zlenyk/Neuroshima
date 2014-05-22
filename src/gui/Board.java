package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import mod.FieldModel;
import cont.GUIController;
import cont.board.BoardController;
import cont.game.GameController;


public class Board extends JPanel{

	List<Field> fieldList;
	BoardController controller;
	public BoardController getController(){
		return controller;
	}
	public Board (GUIController gui,GameController game) {
		setBorder(null);
		setLayout(null);
		controller = new BoardController(game,gui,this);
		fieldList = new ArrayList<Field>();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.select(e.getPoint());
			}
		});
	}
	public void resetBoard(){
		removeAll();
		fieldList.clear();
	}
	public void addField(FieldModel f){
		f.getTile().getField().setLocation(f.getLocation());
		this.add(f.getTile().getField());			//adds to JPanel
		fieldList.add(f.getTile().getField());
	}
	public List<Field> getFields(){
		return fieldList;
	}

}
