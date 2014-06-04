package mod.tiles.Hegemonia;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Bydlak extends Unit {
	Bydlak(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(2);
	}

	public void attack(){
		hit(0+rotation,2+hitBonus);
		hit(1+rotation,1+hitBonus);
		hit(5+rotation,1+hitBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Hegemonia.bydlak();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Hegemonia.bydlakSelected();
	}
	
	@Override
	public Image getNettedImage() {
		return ImageLoader.Hegemonia.bydlakNetted();
	}
	
}
