package mod.tiles.Moloch;

import mod.Modul;

import cont.board.ImageLoader;


public class Oficer extends Modul {
	Oficer(int rotation){
		hp = 1;
		this.rotation = rotation;
		ifWorks = new boolean[6];
		for(int i=0;i<6;i++){
			if(i%2==1)ifWorks[i] = false;
			else ifWorks[i] = true;
		}
		
	}
	protected void work(int direction){
		if(ifWorks[(direction+rotation)%6]==true){
			if(board[position].neibours[(direction+rotation)%6].tile instanceof mod.Unit){
				((mod.Unit)board[position].neibours[(direction+rotation)%6].tile).shootBonus++;
			}
		}
	}
}
