package mod.tiles.Borgo;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Mutek extends Unit {
	Mutek(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(2);
	}

	public void attack(){
		hit(0+rotation,1+hitBonus);
		hit((5+rotation)%6, 1+hitBonus);
		hit((1+rotation)%6, 1+hitBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Borgo.mutek();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Borgo.mutekSelected();
	}
	
}
