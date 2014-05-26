package mod.tiles.Borgo;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Nozownik extends Unit {
	Nozownik(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(3);
	}

	public void attack(){
		hit(0+rotation,1+hitBonus);
		hit(5+rotation, 1+hitBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Borgo.nozownik();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Borgo.nozownikSelected();
	}
	
}
