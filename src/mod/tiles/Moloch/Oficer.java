package mod.tiles.Moloch;

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
	protected void work(int direction){
		if(ifWorks[(direction+rotation)%6]==true){
			//if(board[position].neibours[(direction+rotation)%6].tile instanceof mod.Unit){
			//	((mod.Unit)board[position].neibours[(direction+rotation)%6].tile).shootBonus++;
			//}
		}
	}
}
