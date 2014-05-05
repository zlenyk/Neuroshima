package mod;


public class Modul extends Field {
//	void work(){}
	int hp;
	int rotation;
	int owner;
	boolean ifWorks[];
	void put(){
		for(int i=0;i<6;i++){
			if(ifWorks[i]==true) work(i);
		}
	}
}
