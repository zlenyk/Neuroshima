package mod.tiles.Posterunek;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class PancerzWspomagany extends Unit {
	PancerzWspomagany(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(3);
		initiative.add(2);
	}

	public void attack(){
		hit(0+rotation,2+hitBonus);
		shoot(5+rotation,1+shootBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Posterunek.pancerzwspomagany();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Posterunek.pancerzwspomaganySelected();
	}
	
	@Override
	public Image getNettedImage() {
		return ImageLoader.Posterunek.pancerzwspomaganyNetted();
	}
	
}
