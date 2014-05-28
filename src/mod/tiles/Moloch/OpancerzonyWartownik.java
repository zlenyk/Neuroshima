package mod.tiles.Moloch;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;


public class OpancerzonyWartownik extends Unit{
	OpancerzonyWartownik(Player owner, FieldModel board[]){
		super(owner,board);
		hp=1;
		initiative.add(2);
		
		shield[0] = true;
	}
	public void attack(){
		shoot((1+rotation)%6,1+shootBonus);
		shoot((5+rotation)%6,1+shootBonus);
	}
	@Override
	public Image getImage() {
		return ImageLoader.Moloch.opancerzonywartownik();
	}
	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.opancerzonywartownikSelected();
	}
	
	
}
