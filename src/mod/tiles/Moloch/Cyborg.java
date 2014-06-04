package mod.tiles.Moloch;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Cyborg extends Unit{
	Cyborg(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(3);
	}
	
	public void attack(){
		shoot(rotation,1+shootBonus);
	}

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.cyborg();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.cyborgSelected();
	}
	
	@Override
	public Image getNettedImage() {
		return ImageLoader.Moloch.cyborgNetted();
	}
		
}
