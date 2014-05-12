package mod;

public class InvalidConfigException extends Exception{
	String message;
	public InvalidConfigException(String m){
		message = m;
	}
	public String toString(){
		return message;
	}
}
