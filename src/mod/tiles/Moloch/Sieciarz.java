package mod.tiles.Moloch;

import java.awt.Image;
import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import mod.tiles.empty.Empty;
import cont.board.ImageLoader;

public class Sieciarz extends Unit {
	Sieciarz(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		ifWorks[0] = true;
		ifWorks[5] = true;
	}
	public void work(int direction){
		if(ifWorks[(6+direction-rotation)%6]==true 
				&& isGoodNeighbour(direction) 
				&& board[position].neighbours[direction].getTile().getOwner()!=this.owner ) {
			
			board[position].neighbours[direction].getTile().netted++; 
			if(board[position].neighbours[direction].getTile().netted==1) board[position].neighbours[direction].getTile().stopWork();
		}
			

	}
	public void stopWork(){
		if(isGoodNeighbour(rotation) && board[position].neighbours[rotation].getTile().getOwner()!=this.owner ){
			board[position].neighbours[rotation].getTile().netted--; 
			if(board[position].neighbours[rotation].getTile().netted==0){
				for(int i=0; i<6;i++) board[position].neighbours[rotation].getTile().work(i);
			}
		}
		if(isGoodNeighbour((rotation+5)%6) && board[position].neighbours[(rotation+5)%6].getTile().getOwner()!=this.owner ){
			board[position].neighbours[(rotation+5)%6].getTile().netted--;
			if(board[position].neighbours[(rotation+5)%6].getTile().netted==0){
				for(int i=0; i<6;i++) board[position].neighbours[(rotation+5)%6].getTile().work(i);
			}
		}
	}
	@Override
	public void put(int position, int rotation){
		this.rotation = rotation;
		this.position=position;
		for(int i = 0; i<6; i++){
			if(isGoodNeighbour(i)){
				board[position].neighbours[i].getTile().work((i+3)%6);
			}
		}
		for(int i = 0; i<6; i+=5){
			if(isGoodNeighbour(i+rotation)){
				work((i+rotation)%6); 
			}
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
			stopWork();
			netted = 0;
			shootBonus = 0;
			initiativeBonus = 0;
			hitBonus = 0;
			for(int i=0;i<6;i++){
				if(board[position].neighbours[i]!=null && board[position].neighbours[i].getTile() instanceof Empty) whereCanPut.add(board[position].neighbours[i].getPosition());
			}
			
		}
		
		return whereCanPut;
	}

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.sieciarz();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.sieciarzSelected();
	}
	
	// Ma siec w kierunkach 0 i 5
}
