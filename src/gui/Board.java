package gui;

import java.util.List;
import javax.swing.JTextField;


public class Board extends Hexagon{

	List<Field> fieldList;
	List<String> armies;
	private JTextField textField;
	public Board(int side,List<String> armies) {
		super(side);
		this.armies = armies;
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(20);
		textField.setText(armies.get(0) +" "+ armies.get(1));
	}

}
