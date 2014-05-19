package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import mod.Player;
import mod.Tile;

/**
 * @author zygmunt
 *	Panel, which shows information about Player.
 */
public class PlayerInfo extends JPanel{
	private JLabel nameLabel;
	private List<Tile> tileList;
	Player player;
	
	public String getName(){
		return nameLabel.getText();
	}

	public PlayerInfo(Player p){
		super();
		player = p;
		tileList = new ArrayList<Tile>();
		
		setBackground(Color.GRAY);
		setLayout(null);
		
		nameLabel = new JLabel("");
		nameLabel.setBounds(12, 12, 70, 15);
		nameLabel.setText(player.getName());
		add(nameLabel);
	}
	public void giveTiles(List<Tile> tl){
		tileList.clear();
		tileList = new ArrayList<Tile>(tl);
		showTiles();
	}
	public Player getPlayer(){
		return player;
	}
	private void showTiles(){
		int move = 120;
		for(int i = 0; i<tileList.size(); i++){
			tileList.get(i).getField().setLocation(i*move, 20);
			this.add(tileList.get(i).getField());
		}
	}
}
