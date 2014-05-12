package mod;

import java.util.LinkedList;


public class Field {
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
