package mod;

import gui.Field;

import java.util.LinkedList;
import java.util.List;

import mod.tiles.empty.Empty;


public abstract class Unit extends Tile {


	public List<Integer> initiative;
	public void attack(){}
	public int shootBonus;
	public int hitBonus;
	public int initiativeBonus;
		
	protected Unit(Player owner, FieldModel[] board){
		this.owner = owner;
		this.board = board;
		
		field = new Field(getImage(),getSelectedImage());
		shield = new boolean[6];
		ifWorks = new boolean[6];
		initiative = new LinkedList<Integer>();
		
		for(int i=0;i<6;i++) shield[i] = false;
		for(int i=1;i<6;i++) ifWorks[i] = false;

		position = -1;
		netted = 0;
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}
	protected void shoot(int direction,int power){
		direction = direction%6;
		int tmpPos = position;
		while(board[tmpPos].neighbours[direction]!=null){
			if(!(board[tmpPos].neighbours[direction].getTile() instanceof Empty) && board[tmpPos].neighbours[direction].getTile().owner!=this.owner){
				if(board[tmpPos].neighbours[direction].getTile().shield[(direction+3)%6]==false) 
					board[tmpPos].neighbours[direction].getTile().takeDmg(power);
				else board[tmpPos].neighbours[direction].getTile().takeDmg(power-1);
				break;
			}
			tmpPos = board[tmpPos].neighbours[direction].getPosition();
		}
	}
	
	protected void hit(int direction, int power){
		direction = direction%6;
		if(isGoodNeighbour(direction) 
				&& board[position].neighbours[direction].getTile().owner!=this.owner){
			
			board[position].neighbours[direction].getTile().takeDmg(power);
		}
	}
	@Override
	public void put(int position, int rotation){
		this.rotation = rotation;
		this.position=position;
		for(int i = 0; i < 6; i++){
			if(isGoodNeighbour(i)){
				board[position].neighbours[i].getTile().work((i+3)%6);
			}
		}
		System.out.println("iamputed");
	}
	
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
	public int getBiggestInitiative(){
		if(initiative.isEmpty()) return -1;
		return initiative.get(0)+initiativeBonus;
	}
	@Override
	public boolean isInstant(){
		return false;
	}
	
	
}
