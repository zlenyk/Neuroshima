package mod.tiles.Moloch;

import java.awt.Image;

import mod.FieldModel;
import mod.Player;
import mod.Unit;
import cont.board.ImageLoader;


public class Juggernaut extends Unit{
	Juggernaut(Player owner, FieldModel board[]){
		super(owner,board);
		hp=2;
		initiative.add(1);

		for(int i=0;i<6;i++){
			if(i%2==1)shield[i] = false;
			else shield[i] = true;
		}
	}
	public void attack(){
		shoot(1+rotation,1+shootBonus);
		hit(0+rotation,2+hitBonus);
	}
	@Override
	public Image getImage() {
		return ImageLoader.Moloch.juggernaut();
	}
	@Override
	public Image getSelectedImage() {
		return ImageLoader.Moloch.juggernautSelected();
	}
	
	
}
