package mod.tiles.Moloch;

import gui.Field;

import java.awt.Image;
import java.util.LinkedList;

import mod.FieldModel;
import mod.Player;
import cont.board.ImageLoader;

public class SztabMoloch extends mod.Unit {
	
	public SztabMoloch(Player owner, FieldModel board[]){
		field = new Field(getImage(),getSelectedImage());
		this.owner = owner;
		position = -1;
		this.board = board;
		hp=1;
		shield = new boolean[6];
		for(int i=0;i<6;i++) shield[i] = false;
		isNetted = 0;
		initiative = new LinkedList<Integer>();
		initiative.add(0);
		shootBonus = 0;
		hitBonus = 0;
		initiativeBonus = 0;
	}
	
	
	public void attack(){
		hit(0,1+hitBonus);
		hit(1,1+hitBonus);
		hit(2,1+hitBonus);
		hit(3,1+hitBonus);
		hit(4,1+hitBonus);
		hit(5,1+hitBonus);
	}

	@Override
	public Image getImage() {
		
		return ImageLoader.Moloch.sztab();
	}

	@Override
	public Image getSelectedImage() {
		
		return ImageLoader.Moloch.sztabSelected();
	}
}
