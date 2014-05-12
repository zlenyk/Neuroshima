package mod.tiles.Moloch;

import java.util.LinkedList;

public class Move extends mod.Field {
	
	
	public LinkedList<Integer> pick(){
		LinkedList<Integer> whereCanPut = new LinkedList<Integer>();
		for(int i=0;i<21;i++) if(board[i]!=null&&board[i].tile!=null&&board[i].tile.owner==this.owner) whereCanPut.add(board[position].neibours[i].position);
		
		return whereCanPut;
	}
	public void put(int position, int rotation){
		mod.Field tileToMove = board[position].tile;
		board[position].tile.pick();
		
		//choosePosition();
		
		tileToMove.put(position,rotation);
		
	}
}
