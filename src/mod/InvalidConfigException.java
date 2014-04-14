package mod;

public class InvalidConfigException extends Exception{
	String message;
	InvalidConfigException(String m){
		message = m;
	}
	public String toString(){
		return message;
	}
}
