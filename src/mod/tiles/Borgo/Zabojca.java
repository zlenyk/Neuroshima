package mod.tiles.Borgo;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Zabojca extends Unit {
	Zabojca(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(3);
	}

	public void attack(){
		shoot(0+rotation,1+shootBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Borgo.zabojca();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Borgo.zabojcaSelected();
	}
	
	@Override
	public Image getNettedImage() {
		return ImageLoader.Borgo.zabojcaNetted();
	}
	
}
