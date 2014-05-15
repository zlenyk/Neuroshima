package mod;

import gui.Field;

import java.awt.Image;
import java.util.LinkedList;


public abstract class Tile {
	
	public Field field;
	
	public Field getField(){
		return field;
	}
	public abstract Image getImage();
	public abstract Image getSelectedImage();
	
	
	public FieldModel board[];
	public int rotation;
	public int owner;
	protected int position;
	public boolean shield[];
	public int hp;
	protected int isNetted;
	protected void work(int direction){}
	public void put(int position, int rotation){}
	public LinkedList<Integer> pick(){return null;}
	public void takeDmg(int power){
		
		hp-=power;
	}
	
}
