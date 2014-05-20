package mod.tiles.Moloch;

import java.awt.Image;

import cont.board.ImageLoader;
import gui.Field;
import mod.FieldModel;
import mod.Modul;
import mod.Player;


public class Oficer extends Modul {
	public Oficer(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		this.board = board;
		hp = 1;
		ifWorks = new boolean[6];
		for(int i=0;i<6;i++){
			if(i%2==1)ifWorks[i] = false;
			else ifWorks[i] = true;
		}
		
	}
	public void work(int direction){
		if(ifWorks[(direction+rotation)%6]==true){
			if(board[position].neighbours[(direction+rotation)%6]!=null && board[position].neighbours[(direction+rotation)%6].tile instanceof mod.Unit){
				((mod.Unit)board[position].neighbours[(direction+rotation)%6].tile).shootBonus++;
			}
		}
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Moloch.oficer();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.oficerSelected();
	}
}
