package mod.tiles.Borgo;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Silacz extends Unit {
	Silacz(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(2);
	}

	public void attack(){
		hit(0+rotation,2+hitBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Borgo.silacz();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Borgo.silaczSelected();
	}
	
	@Override
	public Image getNettedImage() {
		return ImageLoader.Borgo.silaczNetted();
	}
	
}
