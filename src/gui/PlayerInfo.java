package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import mod.Player;
import mod.Tile;
import java.awt.Font;

/**
 * @author zygmunt
 *	Panel, which shows information about Player.
 */
public class PlayerInfo extends JPanel{
	private JLabel nameLabel;
	private JLabel hpLabel;
	private JLabel tilesLeftLabel;
	private List<Tile> tileList;
	Player player;
	
	public String getName(){
		return nameLabel.getText();
	}
	public String getHp(){
		return hpLabel.getText();
	}
	public String getTilesLeft(){
		return tilesLeftLabel.getText();
	}
	

	public PlayerInfo(Player p){
		super();
		player = p;
		tileList = new ArrayList<Tile>();
		
		setBackground(Color.GRAY);
		if (player.getArmy().equals("Moloch"))		setBackground(Color.RED);
		if (player.getArmy().equals("Borgo"))		setBackground(new Color(51, 153, 255));
		if (player.getArmy().equals("Posterunek"))	setBackground(new Color(0, 128, 0));
		if (player.getArmy().equals("Hegemonia"))	setBackground(Color.ORANGE);
		setLayout(null);
		
		nameLabel = new JLabel("");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		if (player.getArmy().equals("Borgo") || player.getArmy().equals("Posterunek"))	nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(10, 6, 219, 15);
		nameLabel.setText("Player: "+player.getName());
		add(nameLabel);
		
		hpLabel = new JLabel("");
		hpLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		if (player.getArmy().equals("Borgo") || player.getArmy().equals("Posterunek"))	hpLabel.setForeground(Color.WHITE);
		hpLabel.setBounds(292, 6, 70, 15);
		hpLabel.setText("HP: "+player.getSztab().getHp());
		add(hpLabel);
		
		tilesLeftLabel = new JLabel("");
		tilesLeftLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		if (player.getArmy().equals("Borgo") || player.getArmy().equals("Posterunek"))	tilesLeftLabel.setForeground(Color.WHITE);
		tilesLeftLabel.setBounds(10, 129, 126, 15);
		tilesLeftLabel.setText("Tiles left: "+player.getArmySet().getSize());
		add(tilesLeftLabel);
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
	public void refreshText(){
		hpLabel.setText("HP: "+player.getSztab().getHp());
		tilesLeftLabel.setText("Tiles left: "+player.getArmySet().getSize());
	}
}
