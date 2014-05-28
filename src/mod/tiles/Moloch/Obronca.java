package mod.tiles.Moloch;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Obronca extends Unit {
	Obronca(Player owner, FieldModel board[]){
		super(owner,board);
		hp=2;
		initiative.add(1);
	}
	
	public void attack(){
		shoot(0+rotation, 1+shootBonus);
		shoot((1+rotation)%6, 1+shootBonus);
		shoot((5+rotation)%6, 1+shootBonus);
	}

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.obronca();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.obroncaSelected();
	}
}
