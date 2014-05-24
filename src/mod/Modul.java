package mod;

import java.awt.Image;
import java.util.LinkedList;

import mod.tiles.empty.Empty;


public abstract class Modul extends Tile {
	
	
	@Override
	public void put(int position, int rotation){
		this.rotation = rotation;
		board[position].tile = this;
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
					if(board[i].tile instanceof Empty) whereCanPut.add(i);
				}
				
			}
		}
		else{
			stopWork();
			netted = 0;
			for(int i=0;i<6;i++){
				if(board[position].neighbours[i]!=null && board[position].neighbours[i].tile instanceof Empty) whereCanPut.add(board[position].neighbours[i].position);
			}
			
		}
		
		return whereCanPut;
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
