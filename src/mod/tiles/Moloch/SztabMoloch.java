package mod.tiles.Moloch;

import java.awt.Image;
import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import mod.tiles.empty.Empty;
import cont.board.ImageLoader;

public class SztabMoloch extends mod.Unit {
	
	public SztabMoloch(Player owner, FieldModel board[]){
		super(owner,board);
		hp=20;
		initiative.add(0);
		
		for(int i=0;i<6;i++) ifWorks[i] = true;
	}
	
	
	public void attack(){
		for(int i = 0; i<6; i++){
			if(isGoodNeighbour(i) 
					&& !board[position].neighbours[i].getTile().isSztab()){
				
				hit(i,1+hitBonus);
			}
		}
	}
	
	public void work(int direction){
		if(board[position].neighbours[direction]!=null && board[position].neighbours[direction].getTile() instanceof Unit && board[position].neighbours[direction].getTile().getOwner()==this.owner ) 
			((Unit)board[position].neighbours[direction].getTile()).shootBonus++;
	}
	
	public void stopWork(){
		for(int i=0;i<6;i++){
			if(board[position].neighbours[i]!=null && board[position].neighbours[i].getTile() instanceof Unit && board[position].neighbours[i].getTile().getOwner()==this.owner ) 
				((Unit)board[position].neighbours[i].getTile()).shootBonus--;
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
		
		for(int i =0; i<6; i++){
			if(isGoodNeighbour(i)) work(i); 
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
				if(isEmptyNeighbour(i)) whereCanPut.add(board[position].neighbours[i].getPosition());
			}
			
		}
		
		return whereCanPut;
	}

	@Override
	public Image getImage() {
		
		return ImageLoader.Moloch.sztab();
	}

	@Override
	public Image getSelectedImage() {
		
		return ImageLoader.Moloch.sztabSelected();
	}
}
