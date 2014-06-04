package mod.tiles.Posterunek;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Komandos extends Unit {
	Komandos(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(3);
	}

	public void attack(){
		shoot(0+rotation,1+shootBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Posterunek.komandos();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Posterunek.komandosSelected();
	}
	
	@Override
	public Image getNettedImage() {
		return ImageLoader.Posterunek.komandosNetted();
	}
	
}
