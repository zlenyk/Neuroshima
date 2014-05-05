package mod;

import java.util.List;


public class Unit extends Field {
//	FieldModel position;
	public List<Integer> initiative;
//	int rotation;
//	int hp;
	public void attack(){}
//	boolean shield[];
//	boolean isNetted;
	public int shootBonus;
	public int hitBonus;
	protected int initiativeBonus;
//	final int directions[] = {-5, -2, 2, 5, 3, -3};
	
	protected void shoot(int direction,int power){
		while(position.neibours[direction]!=null){
			if(position.neibours[direction].tile!=null){
				if(position.neibours[direction].tile.shield[(direction+3)%6]==false) 
					position.neibours[direction].tile.hp-=power;
				else position.neibours[direction].tile.hp-=(power-1);
				break;
			}
		}
	}
	protected void hit(int direction, int power){
		if(position.neibours[direction]!=null&&position.neibours[direction].tile!=null){
			position.neibours[direction].tile.hp-=power;
		}
	}
	void put(){
		if(position.neibours[0]!=null&&position.neibours[0].tile!=null) position.neibours[0].tile.work(3);
		if(position.neibours[1]!=null&&position.neibours[1].tile!=null) position.neibours[1].tile.work(4);
		if(position.neibours[2]!=null&&position.neibours[2].tile!=null) position.neibours[2].tile.work(5);
		if(position.neibours[3]!=null&&position.neibours[3].tile!=null) position.neibours[3].tile.work(0);
		if(position.neibours[4]!=null&&position.neibours[4].tile!=null) position.neibours[4].tile.work(1);
		if(position.neibours[5]!=null&&position.neibours[5].tile!=null) position.neibours[5].tile.work(2);
	}
	
	
	
}
