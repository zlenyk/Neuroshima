package mod.tiles.Posterunek;

import java.awt.Image;
import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import mod.tiles.empty.Empty;
import cont.board.ImageLoader;

public class SztabPosterunek extends mod.Unit {
	
	public SztabPosterunek(Player owner, FieldModel board[]){
		super(owner,board);
		hp=20;
		initiative.add(0);
		
		for(int i=0;i<6;i++) ifWorks[i] = true;
	}
	
	
	public void attack(){
		if(board[position].neighbours[0]!=null && !board[position].neighbours[0].getTile().isSztab())hit(0,1+hitBonus);
		if(board[position].neighbours[1]!=null && !board[position].neighbours[0].getTile().isSztab())hit(1,1+hitBonus);
		if(board[position].neighbours[2]!=null && !board[position].neighbours[0].getTile().isSztab())hit(2,1+hitBonus);
		if(board[position].neighbours[3]!=null && !board[position].neighbours[0].getTile().isSztab())hit(3,1+hitBonus);
		if(board[position].neighbours[4]!=null && !board[position].neighbours[0].getTile().isSztab())hit(4,1+hitBonus);
		if(board[position].neighbours[5]!=null && !board[position].neighbours[0].getTile().isSztab())hit(5,1+hitBonus);
	}
	
	public void work(int direction){
		if(board[position].neighbours[direction]!=null && board[position].neighbours[direction].getTile() instanceof Unit && board[position].neighbours[direction].getTile().getOwner()==this.owner ) 
			((Unit)board[position].neighbours[direction].getTile()).initiative.add(((Unit)board[position].neighbours[direction].getTile()).initiative.get(((Unit)board[position].neighbours[direction].getTile()).initiative.size()-1)-1); 
	}
	public void stopWork(){
		for(int i=0; i<6; i++){
			if(board[position].neighbours[i]!=null && board[position].neighbours[i].getTile() instanceof Unit && board[position].neighbours[i].getTile().getOwner()==this.owner ) 
				((Unit)board[position].neighbours[i].getTile()).initiative.add(((Unit)board[position].neighbours[i].getTile()).initiative.get(((Unit)board[position].neighbours[i].getTile()).initiative.size()-1)-1); 
		}
	}
	
	
	@Override
	public void put(int position, int rotation){
		this.rotation = rotation;
		this.position=position;
		if(board[position].neighbours[0]!=null&& !(board[position].neighbours[0].getTile() instanceof Empty)) board[position].neighbours[0].getTile().work(3);
		if(board[position].neighbours[1]!=null&&!(board[position].neighbours[0].getTile() instanceof Empty)) board[position].neighbours[1].getTile().work(4);
		if(board[position].neighbours[2]!=null&&!(board[position].neighbours[0].getTile() instanceof Empty)) board[position].neighbours[2].getTile().work(5);
		if(board[position].neighbours[3]!=null&&!(board[position].neighbours[0].getTile() instanceof Empty)) board[position].neighbours[3].getTile().work(0);
		if(board[position].neighbours[4]!=null&&!(board[position].neighbours[0].getTile() instanceof Empty)) board[position].neighbours[4].getTile().work(1);
		if(board[position].neighbours[5]!=null&&!(board[position].neighbours[0].getTile() instanceof Empty)) board[position].neighbours[5].getTile().work(2);
		
		for(int i =0; i<6; i++){
			if(board[position].neighbours[i]!=null && !(board[position].neighbours[i].getTile() instanceof Empty)) work(i); 
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
		
		return ImageLoader.Posterunek.sztab();
	}

	@Override
	public Image getSelectedImage() {
		
		return ImageLoader.Posterunek.sztabSelected();
	}
}
