package mod.tiles.Moloch;

import java.util.LinkedList;

public class Bomb extends mod.Field {
	Bomb(){}
	
public LinkedList<Integer> pick(){
	LinkedList<Integer> whereCanPut = new LinkedList<Integer>();
	whereCanPut.add(5);
	whereCanPut.add(7);
	whereCanPut.add(8);
	whereCanPut.add(10);
	whereCanPut.add(12);
	whereCanPut.add(13);
	whereCanPut.add(15);
	return whereCanPut;
}
public void put(int position){
	board[position].tile.takeDmg(1);
	for(int i=0;i<6;i++) if(board[position].tile!=null) board[position].tile.takeDmg(1);
}
}
