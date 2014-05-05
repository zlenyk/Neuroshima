package mod.tiles.Moloch;

import mod.Modul;


public class Scout extends Modul {
	Scout(int rotation){
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
/*				int size =  ((Unit)position.neibours[(direction+rotation)%6].tile).initiative.size;
				if (size == 1){
					int temp = ((Unit)position.neibours[(direction+rotation)%6].tile).initiative.poll;
					temp++;
					((Unit)position.neibours[(direction+rotation)%6].tile).initiative.add(temp);
				}
				else if (size == 2){
					int temp = ((Unit)position.neibours[(direction+rotation)%6].tile).initiative.poll;
					int temp2 = ((Unit)position.neibours[(direction+rotation)%6].tile).initiative.poll;
					temp2++; temp++;
					((Unit)position.neibours[(direction+rotation)%6].tile).initiative.add(temp2);
					((Unit)position.neibours[(direction+rotation)%6].tile).initiative.add(temp);
*/	// To do something better	
				}
			}
		}
	}
}
