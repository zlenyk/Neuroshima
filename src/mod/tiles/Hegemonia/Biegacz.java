package mod.tiles.Hegemonia;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Biegacz extends Unit {
	Biegacz(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(2);

	}

	public void attack(){
		hit(0+rotation,1+hitBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Hegemonia.biegacz();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Hegemonia.biegaczSelected();
	}
	
	@Override
	public Image getNettedImage() {
		return ImageLoader.Hegemonia.biegaczNetted();
	}
	
}
