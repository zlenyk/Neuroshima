package mod.tiles.Hegemonia;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class Gladiator extends Unit {
	Gladiator(Player owner, FieldModel board[]){
		super(owner,board);
		hp=2;
		initiative.add(1);

		shield[0]=true;
		shield[1]=true;
		shield[5]=true;
	}

	public void attack(){
		hit(0+rotation,2+hitBonus);
		hit(1+rotation,2+hitBonus);
		hit(5+rotation,2+hitBonus);
	}
	
	@Override
	public Image getImage() {
		return ImageLoader.Hegemonia.gladiator();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Hegemonia.gladiatorSelected();
	}
	
}
