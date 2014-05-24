package mod;

import java.util.LinkedList;
import java.util.List;

import mod.tiles.empty.Empty;


public abstract class Unit extends Tile {


	public List<Integer> initiative;
	public void attack(){}
	public int shootBonus;
	public int hitBonus;
	public int initiativeBonus;
		
	protected void shoot(int direction,int power){
		while(board[position].neighbours[direction]!=null){
			if(!(board[position].neighbours[direction].tile instanceof Empty) && board[position].neighbours[direction].tile.owner!=this.owner){
				if(board[position].neighbours[direction].tile.shield[(direction+3)%6]==false) 
					board[position].neighbours[direction].tile.takeDmg(power);
				else board[position].neighbours[direction].tile.takeDmg(power-1);
				break;
			}
		}
	}
	
	protected void hit(int direction, int power){
		if(board[position].neighbours[direction]!=null && !(board[position].neighbours[direction].tile instanceof Empty) && board[position].neighbours[direction].tile.owner!=this.owner){
			board[position].neighbours[direction].tile.takeDmg(power);
		}
	}
	
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
	}
	
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
			shootBonus = 0;
			initiativeBonus = 0;
			hitBonus = 0;
			for(int i=0;i<6;i++){
				if(board[position].neighbours[i]!=null && board[position].neighbours[i].tile instanceof Empty) whereCanPut.add(board[position].neighbours[i].position);
			}
			
		}
		
		return whereCanPut;
	}
	public int getBiggestInitiative(){
		if(initiative.isEmpty()) return -1;
		else return initiative.get(0)+initiativeBonus;
	}
	
	
}
