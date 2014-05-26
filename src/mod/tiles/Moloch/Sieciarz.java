package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;

import cont.board.ImageLoader;

import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import mod.tiles.empty.Empty;

public class Sieciarz extends Unit {
	Sieciarz(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		position = -1;
		this.board = board;
		hp = 1;
		shield = new boolean[6];
		for(int i=0; i<6; i++)	shield[i] = false;
		ifWorks = new boolean[6];
		ifWorks[0] = true;
		for(int i=1;i<6;i++) ifWorks[i] = false;
		ifWorks[5] = true;
		netted = 0;
		initiative = new LinkedList<Integer>();
	}
	public void work(int direction){
		if(ifWorks[direction]==true && board[position].neighbours[direction]!=null && !(board[position].neighbours[direction].getTile() instanceof Empty) && board[position].neighbours[direction].getTile().getOwner()!=this.owner ) board[position].neighbours[direction].getTile().netted++; 
	}
	public void stopWork(){
		if(ifWorks[rotation]==true && board[position].neighbours[rotation]!=null && !(board[position].neighbours[rotation].getTile() instanceof Empty) && board[position].neighbours[rotation].getTile().getOwner()!=this.owner ) board[position].neighbours[rotation].getTile().netted--; 
		if(ifWorks[(rotation+5)%6]==true && board[position].neighbours[(rotation+5)%6]!=null && !(board[position].neighbours[(rotation+5)%6].getTile() instanceof Empty) && board[position].neighbours[(rotation+5)%6].getTile().getOwner()!=this.owner ) board[position].neighbours[(rotation+5)%6].getTile().netted--; 
	}
	@Override
	public void put(int position, int rotation){
		this.rotation = rotation;
		this.position=position;
		if(board[position].neighbours[0]!=null&& !(board[position].neighbours[0].getTile() instanceof Empty)) board[position].neighbours[0].getTile().work(3);
		if(board[position].neighbours[1]!=null&&!(board[position].neighbours[1].getTile() instanceof Empty)) board[position].neighbours[1].getTile().work(4);
		if(board[position].neighbours[2]!=null&&!(board[position].neighbours[2].getTile() instanceof Empty)) board[position].neighbours[2].getTile().work(5);
		if(board[position].neighbours[3]!=null&&!(board[position].neighbours[3].getTile() instanceof Empty)) board[position].neighbours[3].getTile().work(0);
		if(board[position].neighbours[4]!=null&&!(board[position].neighbours[4].getTile() instanceof Empty)) board[position].neighbours[4].getTile().work(1);
		if(board[position].neighbours[5]!=null&&!(board[position].neighbours[5].getTile() instanceof Empty)) board[position].neighbours[5].getTile().work(2);
		
		if(board[position].neighbours[rotation]!=null&& !(board[position].neighbours[rotation].getTile() instanceof Empty)) work(rotation); 
		if(board[position].neighbours[(rotation+5)%6]!=null&& !(board[position].neighbours[(rotation+5)%6].getTile() instanceof Empty)) work((rotation+5)%6); 
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
