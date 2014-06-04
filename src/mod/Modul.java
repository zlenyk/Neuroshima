package mod;

import java.awt.Image;
import java.util.LinkedList;

import mod.tiles.empty.Empty;


public abstract class Modul extends Tile {
	
	
	@Override
	public void put(int position, int rotation){
		this.rotation = rotation;
		this.position=position;
		for(int i=0;i<6;i++){
			if(ifWorks[i]==true) work(i);
		}
	}
	
	
	@Override
	public LinkedList<Integer> pick(){
		LinkedList<Integer> whereCanPut = new LinkedList<Integer>();
		if(position == -1){
			for(int i=0;i<21;i++){
				if(i!=1&&i!=19){
					if(board[i].getTile() instanceof Empty) whereCanPut.add(i);
				}
				
			}
		}
		else{
			if(isWorking())stopWork();
			working = false;
			netted = 0;
			for(int i=0;i<6;i++){
				if(isEmptyNeighbour(i)) whereCanPut.add(board[position].neighbours[i].getPosition());
			}
			
		}
		
		return whereCanPut;
	}

	@Override
	public Image getImage() {
		return null;
	}


	@Override
	public Image getSelectedImage() {
		return null;
	}
	
	@Override
	public boolean isInstant(){
		return false;
	}
	
}

