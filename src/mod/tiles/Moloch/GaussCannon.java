package mod.tiles.Moloch;

import java.awt.Image;
import java.util.LinkedList;

import mod.Unit;

public class GaussCannon extends Unit {
	GaussCannon(mod.FieldModel board[]){
		this.board = board;
		position = -1;
		//this.rotation = rotation;
		hp = 2;
		shield = new boolean[6];
		for(int i=0; i<6; i++)	shield[i] = false;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
		initiative.add(1);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}
	
	public void attack(){
		//shoot(rotation,1+shootBonus);
		int direction = rotation, power = 1;
		while(board[position].neibours[direction]!=null){
			if(board[position].neibours[direction].tile!=null){
				if(board[position].neibours[direction].tile.shield[(direction+3)%6]==false) 
					board[position].neibours[direction].tile.hp-=power;
				else board[position].neibours[direction].tile.hp-=(power-1);
				
			}
		}
	}
	// Dzialo Gaussa strzela do wszystkich celow na swojej linii

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getSelectedImage() {
		// TODO Auto-generated method stub
		return null;
	}
}
