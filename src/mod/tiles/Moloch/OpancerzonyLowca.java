package mod.tiles.Moloch;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;

public class OpancerzonyLowca extends Unit {
	OpancerzonyLowca(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(2);

		shield[0] = true;
		shield[5] = true;
	}
	
	public void attack(){
		hit(0, 1+hitBonus);
		hit(1, 1+hitBonus);
		hit(2, 1+hitBonus);
		hit(3, 1+hitBonus);
		hit(4, 1+hitBonus);
		hit(5, 1+hitBonus);
	}

	@Override
	public Image getImage() {
		return ImageLoader.Moloch.opancerzonylowca();
	}

	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.opancerzonylowcaSelected();
	}
	
	@Override
	public Image getNettedImage() {
		return ImageLoader.Moloch.opancerzonylowcaNetted();
	}
}
