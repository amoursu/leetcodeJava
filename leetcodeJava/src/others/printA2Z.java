package others;

import java.util.*;

public class printA2Z implements Runnable {
	public static final int COUNT=26; //字母的个数
	public static final int TIMES=10; //循环打印的次数
	public static final byte[] LOCK=new byte[0]; //互斥器
	private static volatile int run=0; //每打印一个字母，值会+1
	private List<Printor> printors=new ArrayList<Printor>(); //收集所有线程对象
	
	@Override
	public void run() {
		for(int i=0;i<COUNT;i++){ //初始化26个线程对象
			printors.add(new Printor((char)('A'+i), i));
		}		
		for(int i=printors.size()-1;i>=0;i--){ //逆序：依次运行 
			new Thread(printors.get(i)).start();
		}
	}
	//test in main
	public static void main(String[] args){
		new Thread(new printA2Z()).start();
	}
	
	private static class Printor implements Runnable{
		private char name;
		private int id;
		private int times=0;
		public Printor(char name,int id){
			this.name=name;
			this.id=id;
		}
		@Override
		public void run() {
			synchronized(LOCK){ //把门锁上,别人别想进来
				while(this.times<TIMES)
				if(this.id==run%COUNT){
					System.out.print(this.name);
					if(this.id==COUNT-1) System.out.println(); //换行
					run++;
					this.times++;
					LOCK.notifyAll(); //吼一嗓子：其他的兄弟，你们准备好了吗
				}else {
					try {
						LOCK.wait(); //我K，白来了，我得出去等(释放锁)...
					} catch (InterruptedException e) {
						System.out.println(this.name+"=>exception occurs...");
					}
				}
			} //结束：释放锁
		}
	}
}
