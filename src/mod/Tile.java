package mod;

import gui.Field;

import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;

import mod.tiles.empty.Empty;


public abstract class Tile {
	
	public Field field;
	
	public Field getField(){
		return field;
	}	
	
	public boolean ifWorks[];
	public void stopwork(){}
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
	public void work(int direction){}
	public abstract void put(int position, int rotation);
	public abstract Image getImage();
	public abstract Image getSelectedImage();
	public void die(){
		if(netted<=0) stopwork();
		board[position].tile = new Empty();
	}
	public boolean isNetted(){
		if(netted==0) return false;
		else return true;
	}
	
}
