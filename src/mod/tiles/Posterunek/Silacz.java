package mod.tiles.Posterunek;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Silacz extends Unit {
	Silacz(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(3);
	}

	public void attack(){
		hit(0+rotation,2+hitBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Posterunek.silacz();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Posterunek.silaczSelected();
	}
	
}
