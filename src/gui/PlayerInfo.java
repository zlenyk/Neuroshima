package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import mod.FieldModel;
import mod.Player;
import mod.Tile;
import cont.MainWindowController;

/**
 * @author zygmunt
 *	Panel, which shows information about Player.
 */
public class PlayerInfo extends JPanel{
	private JLabel nameLabel;
	private JLabel hpLabel;
	private JLabel tilesLeftLabel;
	private List<FieldModel> fieldModelList;
	Player player;
	private MainWindowController mainWindowController;
	
	public String getName(){
		return nameLabel.getText();
	}
	public String getHp(){
		return hpLabel.getText();
	}
	public String getTilesLeft(){
		return tilesLeftLabel.getText();
	}
	

	public PlayerInfo(Player p,MainWindowController controller){
		super();
		mainWindowController = controller;
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(FieldModel f : fieldModelList){
					if(player != mainWindowController.getGameController().getActivePlayer()){
						return;
					}
					if(f.contains(e.getPoint())){
						if(getSelectedTile() != null){
							getSelectedTile().changeSelect();
						}
						if(f.getTile() != null){
							f.getTile().changeSelect();
							mainWindowController.setDiscardButtonEnabled(true);
						}
						mainWindowController.getGameController().enablePutButtonOrNot();
						return;
					}
				}
			}
		});
		player = p;
		fieldModelList = new ArrayList<FieldModel>();
		setBackground(Color.GRAY);
		
		setFieldModelLocation();
		
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
	public Tile getSelectedTile(){
		for(FieldModel f : fieldModelList){
			if(f.getTile() != null){
				if(f.getTile().getField().isSelected()){
					return f.getTile();
				}
			}
		}
		return null;
	}
	public Tile getAndDeleteSelectedTile(){
		Tile t = null;
		for(FieldModel f : fieldModelList){
			if(f.getTile() != null){
				if(f.getTile().getField().isSelected()){
					t = f.getTile();
					this.remove(t.getField());
					f.changeTile(null);
					break;
				}
			}
		}
		clearTiles();
		showTiles();
		return t;
	}
	private void setFieldModelLocation(){
		for(int i = 0; i<3; i++){
			fieldModelList.add(new FieldModel());
		}
		int move = 120;
		int[] hexX = {31,0,31,31+62,62*2,31+62};
		int[] hexY = {0,54,108,108,54,0};

		for(int i = 0; i<3; i++){
			
			int[] _hexX = new int[6];
			int[] _hexY = new int[6];

			for(int j = 0;j<6;j++){
				_hexX[j] = hexX[j]+i*move;
				_hexY[j] = hexY[j]+20;
			}
			for(int k = 0; k<6; k++)
			
			fieldModelList.get(i).setShape(_hexX, _hexY);
			fieldModelList.get(i).setLocation(i*move, 20);
		}
	}
	public int getTilesCount(){
		int count = 0;
		for(FieldModel f : fieldModelList){
			if(f.getTile() != null){
				count++;
			}
		}
		return count;
	}
	public void giveTiles(List<Tile> tl){
		clearTiles();

		int index = 0;
		for(int i = 0; i<3; i++){
			if(fieldModelList.get(i).getTile() == null){
				fieldModelList.get(i).changeTile(tl.get(index++));
			}
		}
		showTiles();
	}
	private void clearTiles(){
		for(FieldModel f : fieldModelList){
			if(f.getTile() != null){
				this.remove(f.getTile().getField());
			}
		}
		this.repaint();
	}
	private void showTiles(){
		for(FieldModel f : fieldModelList){
			if(f.getTile() != null){
				f.getTile().getField().setLocation(f.getLocation());
				this.add(f.getTile().getField());
			}
		}
		this.repaint();
	}
	public Player getPlayer(){
		return player;
	}

	public void refreshText(){
		hpLabel.setText("HP: "+player.getSztab().getHp());
		tilesLeftLabel.setText("Tiles left: "+player.getArmySet().getSize());
		this.repaint();
	}
}
