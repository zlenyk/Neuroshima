package gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerInfo extends JPanel{
	private JLabel nameLabel;

	public String getName(){
		return nameLabel.getText();
	}

	public PlayerInfo(String name){
		super();
		setBackground(Color.GRAY);
		setLayout(null);
		
		nameLabel = new JLabel("");
		nameLabel.setBounds(12, 12, 70, 15);
		nameLabel.setText(name);
		add(nameLabel);
	}
}
