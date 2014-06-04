package mod.tiles.Moloch;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;


public class Szturmowiec extends Unit {
	Szturmowiec(Player owner, FieldModel board[]){
		super(owner,board);
		hp=2;
		initiative.add(2);
		initiative.add(1);
	}
	
	public void attack(){
		shoot(rotation,1+shootBonus);
	}

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.szturmowiec();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.szturmowiecSelected();
	}
	
	@Override
	public Image getNettedImage() {
		return ImageLoader.Moloch.szturmowiecNetted();
	}
}
