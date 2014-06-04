package mod.tiles.Posterunek;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Likwidator extends Unit {
	Likwidator(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(2);
	}

	public void attack(){
		shoot(0+rotation,2+hitBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Posterunek.likwidator();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Posterunek.likwidatorSelected();
	}
	
	@Override
	public Image getNettedImage() {
		return ImageLoader.Posterunek.likwidatorNetted();
	}
	
}
