package others;

/**
 * Something must be wrong
 * @author zhouyan
 *
 */
public class printABC {

	private final Object lock = new Object();
	private static boolean isA, isB, isC;
	
	class A implements Runnable{

		@Override
		public void run() {
	        synchronized(lock){
	        	while(!isA){
	        		try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	        	}
	        	System.out.println("A");
	        	isA = false;
	        	isB = true;
	        	isC = false;
	        	lock.notifyAll();
	        }
		}
	}
	
	class B implements Runnable{

		@Override
		public void run() {
	        synchronized(lock){
	        	while(!isB){
	        		try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	        	}
	        	System.out.println("B");
	        	isA = false;
	        	isB = false;
	        	isC = true;
	        	lock.notifyAll();
	        }
		
			
		}
	}
	
	class C implements Runnable{

		@Override
		public void run() {
	        synchronized(lock){
	        	while(!isC){
	        		try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	        	}
	        	System.out.println("C");
	        	isA = true;
	        	isB = false;
	        	isC = false;
	        	lock.notifyAll();
	        }
		}
	}
	
	public static void main(String[] args) {
		isA = true;
		isB = false;
		isC = false;
        for(int i = 0; i < 10; i++){
        	new Thread(new printABC().new A()).start();
        	new Thread(new printABC().new B()).start();
        	new Thread(new printABC().new C()).start();
        }
	}

}
