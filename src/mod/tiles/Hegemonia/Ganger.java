package mod.tiles.Hegemonia;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Ganger extends Unit {
	Ganger(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(3);

	}

	public void attack(){
		hit(0+rotation,1+hitBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Hegemonia.ganger();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Hegemonia.gangerSelected();
	}
	
}
