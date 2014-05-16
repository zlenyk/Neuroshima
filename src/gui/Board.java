package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import mod.FieldModel;
import cont.board.BoardGUIController;


public class Board extends JPanel{

	List<Field> fieldList;
	BoardGUIController controller;
	public BoardGUIController getController(){
		return controller;
	}
	public Board () {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		controller = new BoardGUIController(this);
		fieldList = new ArrayList<Field>();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.select(e.getX(),e.getY());
			}
		});
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
