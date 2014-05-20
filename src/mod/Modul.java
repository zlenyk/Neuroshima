package mod;

import java.awt.Image;


public abstract class Modul extends Tile {
	
	public void put(int position, int rotation){
		this.rotation = rotation;
		board[position].tile = this;
		this.position=position;
		for(int i=0;i<6;i++){
			if(ifWorks[i]==true) work(i);
		}
	}


	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Image getSelectedImage() {
		// TODO Auto-generated method stub
		return null;
	}
}
