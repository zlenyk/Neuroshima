package mod;

import gui.Field;

import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;


public abstract class Tile {
	
	public Field field;
	
	public Field getField(){
		return field;
	}	

	protected FieldModel board[];
	protected int rotation;
	protected Player owner;
	public int position;
	public boolean shield[];
	public int hp;
	protected int isNetted;
	public LinkedList<Integer> pick(){return null;}
	public void takeDmg(int power){
		
		hp-=power;
		if(hp<=0) board[position].tile = new mod.tiles.empty.Empty();
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
	protected void work(int direction){}
	public abstract void put(int position, int rotation);
	public abstract Image getImage();
	public abstract Image getSelectedImage();

	
}
