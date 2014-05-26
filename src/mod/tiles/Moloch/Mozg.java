package mod.tiles.Moloch;

import java.awt.Image;

import cont.board.ImageLoader;
import gui.Field;
import mod.FieldModel;
import mod.Modul;
import mod.Player;
import mod.Unit;
import mod.tiles.empty.Empty;


public class Mozg extends Modul {
	public Mozg(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		this.board = board;
		hp = 1;
		position = -1;
		ifWorks = new boolean[6];
		for(int i=0;i<6;i++){
			if(i%2==1)ifWorks[i] = false;
			else ifWorks[i] = true;
		}
		
	}
	
	
	
	public void work(int direction){
		if(ifWorks[(direction+rotation)%6]==true){
			if(board[position].neighbours[(direction+rotation)%6].getTile() instanceof Unit){
				((Unit)board[position].neighbours[(direction+rotation)%6].getTile()).hitBonus++;
				((Unit)board[position].neighbours[(direction+rotation)%6].getTile()).shootBonus++;
			}
		}
	}
	
	public void stopWork(){
		if(board[position].neighbours[(0+rotation)%6].getTile() instanceof Unit){
			((Unit)board[position].neighbours[(0+rotation)%6].getTile()).hitBonus--;
			((Unit)board[position].neighbours[(0+rotation)%6].getTile()).shootBonus--;
		}
		if(board[position].neighbours[(2+rotation)%6].getTile() instanceof Unit){
			((Unit)board[position].neighbours[(2+rotation)%6].getTile()).hitBonus--;
			((Unit)board[position].neighbours[(2+rotation)%6].getTile()).shootBonus--;
		}
		if(board[position].neighbours[(4+rotation)%6].getTile() instanceof Unit){
			((Unit)board[position].neighbours[(4+rotation)%6].getTile()).hitBonus--;
			((Unit)board[position].neighbours[(4+rotation)%6].getTile()).shootBonus--;
		}
	}
	
	@Override
	public void put(int position, int rotation){
		this.rotation = rotation;
		this.position=position;
		if(board[position].neighbours[0]!=null&& !(board[position].neighbours[0].getTile() instanceof Empty)) board[position].neighbours[0].getTile().work(3);
		if(board[position].neighbours[1]!=null&&!(board[position].neighbours[1].getTile() instanceof Empty)) board[position].neighbours[1].getTile().work(4);
		if(board[position].neighbours[2]!=null&&!(board[position].neighbours[2].getTile() instanceof Empty)) board[position].neighbours[2].getTile().work(5);
		if(board[position].neighbours[3]!=null&&!(board[position].neighbours[3].getTile() instanceof Empty)) board[position].neighbours[3].getTile().work(0);
		if(board[position].neighbours[4]!=null&&!(board[position].neighbours[4].getTile() instanceof Empty)) board[position].neighbours[4].getTile().work(1);
		if(board[position].neighbours[5]!=null&&!(board[position].neighbours[5].getTile() instanceof Empty)) board[position].neighbours[5].getTile().work(2);
		
		if(board[position].neighbours[rotation]!=null && !(board[position].neighbours[rotation].getTile() instanceof Empty)) work(rotation); 
		if(board[position].neighbours[(2+rotation)%6]!=null && !(board[position].neighbours[(2+rotation)%6].getTile() instanceof Empty)) work((2+rotation)%6); 
		if(board[position].neighbours[(4+rotation)%6]!=null && !(board[position].neighbours[(4+rotation)%6].getTile() instanceof Empty)) work((4+rotation)%6); 
	}
	
	
	@Override
	public Image getImage() {
		return ImageLoader.Moloch.mozg();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.mozgSelected();
	}
	
}
