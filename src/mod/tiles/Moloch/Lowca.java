package mod.tiles.Moloch;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Lowca extends Unit {
	public Lowca(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(3);
	}
	
	public void attack(){
		hit(0+rotation, 1+hitBonus);
		hit(1+rotation, 1+hitBonus);
		hit(3+rotation, 1+hitBonus);
		hit(5+rotation, 1+hitBonus);
	}

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.lowca();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.lowcaSelected();
	}
}
