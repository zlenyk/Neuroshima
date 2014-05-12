package mod;


public class Modul extends Field {
	protected int hp;
	protected int rotation;
	protected boolean ifWorks[];
	
	
	public void put(int position, int rotation){
		this.rotation = rotation;
		board[position].tile = this;
		this.position=position;
		for(int i=0;i<6;i++){
			if(ifWorks[i]==true) work(i);
		}
	}
}
