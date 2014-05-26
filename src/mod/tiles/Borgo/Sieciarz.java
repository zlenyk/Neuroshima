package mod.tiles.Borgo;

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
		initiative.add(1);
	}
	public void work(int direction){
		if(ifWorks[direction]==true
				&& isGoodNeighbour(direction)
				&& board[position].neighbours[direction].getTile().getOwner()!=this.owner ){
			
			board[position].neighbours[direction].getTile().netted++;
		}
	}
	public void stopWork(){
		if(ifWorks[rotation]==true 
				&& isGoodNeighbour(rotation) 
				&& board[position].neighbours[rotation].getTile().getOwner()!=this.owner ){
			
			board[position].neighbours[rotation].getTile().netted--; 
		}
	}
	@Override
	public void put(int position, int rotation){
		this.rotation = rotation;
		this.position=position;
		for(int i = 0; i < 6; i++){
			if(isGoodNeighbour(i)){
				board[position].neighbours[i].getTile().work((i+3)%6);
			}
		}		
		if(isGoodNeighbour(rotation)){
			work(rotation); 
		}
	}
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
				if(isGoodNeighbour(i)){
					whereCanPut.add(board[position].neighbours[i].getPosition());
				}
			}
			
		}
		
		return whereCanPut;
	}

	public void attack(){
		hit(0+rotation,3+hitBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Borgo.sieciarz();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Borgo.sieciarzSelected();
	}
	
}
