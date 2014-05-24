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
		if(ifWorks[direction]==true && board[position].neighbours[direction]!=null && !(board[position].neighbours[direction].tile instanceof Empty) && board[position].neighbours[direction].tile.getOwner()!=this.owner ) board[position].neighbours[direction].tile.netted++; 
	}
	public void stopWork(){
		if(ifWorks[(rotation+1)%6]==true && board[position].neighbours[(rotation+1)%6]!=null && !(board[position].neighbours[(rotation+1)%6].tile instanceof Empty) && board[position].neighbours[(rotation+1)%6].tile.getOwner()!=this.owner ) board[position].neighbours[(rotation+1)%6].tile.netted--; 
		if(ifWorks[(rotation+5)%6]==true && board[position].neighbours[(rotation+5)%6]!=null && !(board[position].neighbours[(rotation+5)%6].tile instanceof Empty) && board[position].neighbours[(rotation+5)%6].tile.getOwner()!=this.owner ) board[position].neighbours[(rotation+5)%6].tile.netted--; 
	}
	@Override
	public void put(int position, int rotation){
		this.rotation = rotation;
		board[position].tile = this;
		this.position=position;
		if(board[position].neighbours[0]!=null&& !(board[position].neighbours[0].tile instanceof Empty)) board[position].neighbours[0].tile.work(3);
		if(board[position].neighbours[1]!=null&&!(board[position].neighbours[0].tile instanceof Empty)) board[position].neighbours[1].tile.work(4);
		if(board[position].neighbours[2]!=null&&!(board[position].neighbours[0].tile instanceof Empty)) board[position].neighbours[2].tile.work(5);
		if(board[position].neighbours[3]!=null&&!(board[position].neighbours[0].tile instanceof Empty)) board[position].neighbours[3].tile.work(0);
		if(board[position].neighbours[4]!=null&&!(board[position].neighbours[0].tile instanceof Empty)) board[position].neighbours[4].tile.work(1);
		if(board[position].neighbours[5]!=null&&!(board[position].neighbours[0].tile instanceof Empty)) board[position].neighbours[5].tile.work(2);
		
		if(board[position].neighbours[(rotation+1)%6]!=null&& !(board[position].neighbours[(rotation+1)%6].tile instanceof Empty)) work((rotation+1)%6); 
		if(board[position].neighbours[(rotation+5)%6]!=null&& !(board[position].neighbours[(rotation+5)%6].tile instanceof Empty)) work((rotation+5)%6); 
		
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
			shootBonus = 0;
			initiativeBonus = 0;
			hitBonus = 0;
			for(int i=0;i<6;i++){
				if(board[position].neighbours[i]!=null && board[position].neighbours[i].tile instanceof Empty) whereCanPut.add(board[position].neighbours[i].position);
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
