package mod;

import java.util.LinkedList;
import java.util.List;


public abstract class Unit extends Tile {


	public List<Integer> initiative;
	public void attack(){}
	public int shootBonus;
	public int hitBonus;
	protected int initiativeBonus;
		
	protected void shoot(int direction,int power){
		/*while(board[position].neibours[direction]!=null){
			if(board[position].neibours[direction].tile!=null){
				if(board[position].neibours[direction].tile.shield[(direction+3)%6]==false) 
					board[position].neibours[direction].tile.takeDmg(power);
				else board[position].neibours[direction].tile.takeDmg(power-1);
				break;
			}
		}*/
	}
	
	protected void hit(int direction, int power){
		/*if(board[position].neibours[direction]!=null&&board[position].neibours[direction].tile!=null){
			board[position].neibours[direction].tile.takeDmg(power);
		}*/
	}
	
	public void put(int position, int rotation){
		this.rotation = rotation;
		board[position].tile = this;
		/*this.position=position;
		if(board[position].neibours[0]!=null&&board[position].neibours[0].tile!=null) board[position].neibours[0].tile.work(3);
		if(board[position].neibours[1]!=null&&board[position].neibours[1].tile!=null) board[position].neibours[1].tile.work(4);
		if(board[position].neibours[2]!=null&&board[position].neibours[2].tile!=null) board[position].neibours[2].tile.work(5);
		if(board[position].neibours[3]!=null&&board[position].neibours[3].tile!=null) board[position].neibours[3].tile.work(0);
		if(board[position].neibours[4]!=null&&board[position].neibours[4].tile!=null) board[position].neibours[4].tile.work(1);
		if(board[position].neibours[5]!=null&&board[position].neibours[5].tile!=null) board[position].neibours[5].tile.work(2);
	*/}
	
	public LinkedList<Integer> pick(){
		LinkedList<Integer> whereCanPut = new LinkedList<Integer>();
		if(position == -1){
			for(int i=0;i<19;i++){
				if(board[i]!=null&&board[i].tile==null) whereCanPut.add(i);
			}
		}
		else{
			/*shootBonus = 0;
			initiativeBonus = 0;
			hitBonus = 0;
			for(int i=0;i<6;i++){
				if(board[position].neibours[i]==null) whereCanPut.add(board[position].neibours[i].position);
			}
			*/
		}
		
		return whereCanPut;
	}
	
	
}
