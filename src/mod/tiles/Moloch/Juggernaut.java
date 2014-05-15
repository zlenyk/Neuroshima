package mod.tiles.Moloch;

import java.awt.Image;

import cont.board.ImageLoader;

import java.util.LinkedList;

import mod.Unit;


public class Juggernaut extends Unit{
	Juggernaut(mod.FieldModel[] board){
		this.board = board;
		position = -1;
		//this.rotation = rotation;
		hp=2;
		shield = new boolean[6];
		for(int i=0;i<6;i++){
			if(i%2==1)shield[i] = false;
			else shield[i] = true;
		}
		isNetted = 0;
		initiative = new LinkedList<Integer>();
		initiative.add(1);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}
	public void attack(){
		shoot(1+rotation,1+shootBonus);
		hit(0+rotation,2+hitBonus);
	}
	@Override
	public Image getImage() {
		return ImageLoader.Moloch.juggernaut();
	}
	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.juggernautSelected();
	}
	
	
}
