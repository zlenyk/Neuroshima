package mod.tiles.Moloch;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Rozpruwacz extends Unit {
	Rozpruwacz(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(2);
	}
	
	public void attack(){
		hit(0+rotation, 2+hitBonus);
	}

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.rozpruwacz();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.rozpruwaczSelected();
	}
	
	@Override
	public Image getNettedImage() {
		return ImageLoader.Moloch.rozpruwaczNetted();
	}
}
