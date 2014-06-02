package mod;

import gui.Field;

import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;

import mod.tiles.Borgo.SztabBorgo;
import mod.tiles.Hegemonia.SztabHegemonia;
import mod.tiles.Moloch.SztabMoloch;
import mod.tiles.Posterunek.SztabPosterunek;
import mod.tiles.empty.Empty;


public abstract class Tile {
	
	public Field field;
	
	public Field getField(){
		return field;
	}	
	
	public boolean ifWorks[];
	public void stopWork(){}
	protected FieldModel board[];
	protected int rotation;
	protected Player owner;
	public int position;
	public boolean shield[];
	public int hp;
	public int netted;
	public LinkedList<Integer> pick(){return null;}
	public void takeDmg(int power){
		
		hp-=power;
	}
	public boolean contains(Point p){
		return field.contains(p);
	}
	public void changeSelect(){
		field.changeSelect();
	}
	public Player getOwner(){
		return owner;
	}
	public int getHp(){
		return hp;
	}
	public int getRotation(){
		return rotation;
	}
	public void work(int direction){}
	public abstract void put(int position, int rotation);
	public abstract Image getImage();
	public abstract Image getSelectedImage();
	public void die(){
		if(netted<=0) stopWork();
		board[position].changeTile(new Empty());
	}
	public boolean isNetted(){
		if(netted==0) return false;
		return true;
	}
	public boolean isSztab(){
		if(this instanceof SztabBorgo || this instanceof SztabHegemonia || this instanceof SztabMoloch || this instanceof SztabPosterunek) return true;
		return false;
	}
	public boolean isInstant(){
		return true;
	}
	
	protected boolean isGoodNeighbour(int index){
		index = index%6;
		return board[position].neighbours[index]!=null 
				&& !(board[position].neighbours[index].getTile() instanceof Empty);
	}
	protected boolean isEmptyNeighbour(int index){
		index = index%6;
		return board[position].neighbours[index]!=null 
				&& (board[position].neighbours[index].getTile() instanceof Empty);
	}
	public LinkedList<Integer> whoCanPush(){
		LinkedList<Integer> canPush = new LinkedList<Integer>();
		for(int i=0;i<6;i++){
			if(isGoodNeighbour(i) && board[position].neighbours[i].getTile().getOwner()!=owner){
				if(board[position].neighbours[i].neighbours[i]!=null && board[position].neighbours[i].neighbours[i].getTile() instanceof Empty) 
					canPush.add(board[position].neighbours[i].neighbours[i].getPosition());
				if(board[position].neighbours[i].neighbours[(i+1)%6]!=null && board[position].neighbours[i].neighbours[(i+1)%6].getTile() instanceof Empty) 
					canPush.add(board[position].neighbours[i].neighbours[(i+1)%6].getPosition());
				if(board[position].neighbours[i].neighbours[(i+5)%6]!=null && board[position].neighbours[i].neighbours[(i+5)%6].getTile() instanceof Empty) 
					canPush.add(board[position].neighbours[i].neighbours[(i+5)%6].getPosition());
				
			}
		}
		return canPush;
	}
	public LinkedList<Integer> whereCanBePushed(int direction){
		LinkedList<Integer> canBePushed = new LinkedList<Integer>();
		for(int i=5;i!=2;i=(i+1)%6){
			if(board[position].neighbours[(i+direction)%6]!=null && board[position].neighbours[(i+direction)%6].getTile() instanceof Empty)
				canBePushed.add(board[position].neighbours[(i+direction)%6].getPosition());
		}
		return canBePushed;
	}
	public boolean isNetter(){
		return false;
	}
	public boolean isBattle(){
		return false;
	}
	
}
