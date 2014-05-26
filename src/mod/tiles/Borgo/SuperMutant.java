package mod.tiles.Borgo;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class SuperMutant extends Unit {
	SuperMutant(Player owner, FieldModel board[]){
		super(owner,board);
		hp=2;
		initiative.add(2);
	}

	public void attack(){
		hit(0+rotation, 2+hitBonus);
		hit(5+rotation, 1+hitBonus);
		hit(1+rotation, 1+hitBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Borgo.supermutant();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Borgo.supermutantSelected();
	}
	
}
