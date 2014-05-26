package mod.tiles.Posterunek;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Ckm extends Unit {
	Ckm(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(2);
		initiative.add(1);
	}

	public void attack(){
		shoot(0+rotation,1+shootBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Posterunek.ckm();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Posterunek.ckmSelected();
	}
	
}
