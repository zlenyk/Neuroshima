package mod.tiles.Moloch;

import gui.Field;
import mod.FieldModel;
import mod.Modul;
import mod.Player;
import mod.Unit;


public class Mozg extends Modul {
	public Mozg(Player owner, FieldModel board[]){
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
	protected void work(int direction){
		if(ifWorks[(direction+rotation)%6]==true){
			//if(board[position].neibours[(direction+rotation)%6].tile instanceof Unit){
			//	((Unit)board[position].neibours[(direction+rotation)%6].tile).hitBonus++;
			//	((Unit)board[position].neibours[(direction+rotation)%6].tile).shootBonus++;
			//}
		}
	}
	
}
