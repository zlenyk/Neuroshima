package mod.tiles.Hegemonia;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class UniwersalnyZolnierz extends Unit {
	UniwersalnyZolnierz(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(3);
	}

	public void attack(){
		hit(0+rotation,1+hitBonus);
		shoot(0+rotation,1+shootBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Hegemonia.uniwersalnyzolnierz();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Hegemonia.uniwersalnyzolnierzSelected();
	}
	
}
