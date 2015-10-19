package designPatterns;

public class LockSingleton {
 
	private static LockSingleton singleton;
	public static LockSingleton getInstance(){
		if(singleton==null){
			synchronized(LockSingleton.class){
				if(singleton==null)
					singleton = new LockSingleton();
			}
		}
		return singleton;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
