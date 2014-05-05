package mod;


public class Modul extends Field {
//	void work(){}
	protected int hp;
	protected int rotation;
	int owner;
	protected boolean ifWorks[];
	void put(){
		for(int i=0;i<6;i++){
			if(ifWorks[i]==true) work(i);
		}
	}
}
