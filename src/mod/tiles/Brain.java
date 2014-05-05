package mod.tiles;


public class Brain extends Modul {
	Brain(int rotation){
		hp = 1;
		this.rotation = rotation;
		ifWorks = new boolean[6];
		for(int i=0;i<6;i++){
			if(i%2==1)ifWorks[i] = false;
			else ifWorks[i] = true;
		}
		
	}
	void work(int direction){
		if(ifWorks[(direction+rotation)%6]==true){
			if(position.neibours[(direction+rotation)%6].tile instanceof Unit){
				((Unit)position.neibours[(direction+rotation)%6].tile).hitBonus++;
				((Unit)position.neibours[(direction+rotation)%6].tile).shootBonus++;
			}
		}
	}
}
