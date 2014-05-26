package mod.tiles.Hegemonia;

import gui.Field;

import java.awt.Image;
import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import mod.tiles.empty.Empty;
import cont.board.ImageLoader;

public class SuperSieciarz extends Unit {
	SuperSieciarz(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		position = -1;
		this.board = board;
		hp=1;
		shield = new boolean[6];
		for(int i=0;i<6;i++) shield[i] = false;
		ifWorks = new boolean[6];
		for(int i=0;i<6;i++) ifWorks[i] = false;
		ifWorks[1] = true;
		ifWorks[5] = true;
		netted = 0;
		initiative = new LinkedList<Integer>();
		initiative.add(2);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}
	
	public void work(int direction){
		if(ifWorks[direction]==true 
				&& isGoodNeighbour(direction)
				&& board[position].neighbours[direction].getTile().getOwner()!=this.owner ){
			
			board[position].neighbours[direction].getTile().netted++; 
		}
	}
	public void stopWork(){
		if(ifWorks[(rotation+1)%6]==true 
				&& isGoodNeighbour((rotation+1)%6)
				&& board[position].neighbours[(rotation+1)%6].getTile().getOwner()!=this.owner ){
			
			board[position].neighbours[(rotation+1)%6].getTile().netted--; 
		}
		if(ifWorks[(rotation+5)%6]==true 
				&& isGoodNeighbour((rotation+5)%6)
				&& board[position].neighbours[(rotation+5)%6].getTile().getOwner()!=this.owner ){
			
			board[position].neighbours[(rotation+5)%6].getTile().netted--; 
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
		if(isGoodNeighbour((rotation+1)%6)){
			work((rotation+1)%6); 
		}
		if(isGoodNeighbour((rotation+5)%6)){
			work((rotation+5)%6); 
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
				if(isGoodNeighbour(i)){
					whereCanPut.add(board[position].neighbours[i].getPosition());
				}
			}
			
		}
		
		return whereCanPut;
	}
	

	public void attack(){
		hit(0+rotation,1+hitBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Hegemonia.supersieciarz();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Hegemonia.supersieciarzSelected();
	}
	
}
