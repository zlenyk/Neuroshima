package gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import mod.Player;

/**
 * @author zygmunt
 *	Panel, which shows information about Player.
 */
public class PlayerInfo extends JPanel{
	private JLabel nameLabel;
	Player player;
	
	public String getName(){
		return nameLabel.getText();
	}

	public PlayerInfo(Player player){
		super();
		setBackground(Color.GRAY);
		setLayout(null);
		
		nameLabel = new JLabel("");
		nameLabel.setBounds(12, 12, 70, 15);
		nameLabel.setText(player.getName());
		add(nameLabel);
	}
}
