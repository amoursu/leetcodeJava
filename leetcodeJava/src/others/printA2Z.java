package others;

import java.util.*;

public class printA2Z implements Runnable {
	public static final int COUNT=26; //��ĸ�ĸ���
	public static final int TIMES=10; //ѭ����ӡ�Ĵ���
	public static final byte[] LOCK=new byte[0]; //������
	private static volatile int run=0; //ÿ��ӡһ����ĸ��ֵ��+1
	private List<Printor> printors=new ArrayList<Printor>(); //�ռ������̶߳���
	
	@Override
	public void run() {
		for(int i=0;i<COUNT;i++){ //��ʼ��26���̶߳���
			printors.add(new Printor((char)('A'+i), i));
		}		
		for(int i=printors.size()-1;i>=0;i--){ //������������ 
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
			synchronized(LOCK){ //��������,���˱������
				while(this.times<TIMES)
				if(this.id==run%COUNT){
					System.out.print(this.name);
					if(this.id==COUNT-1) System.out.println(); //����
					run++;
					this.times++;
					LOCK.notifyAll(); //��һɤ�ӣ��������ֵܣ�����׼��������
				}else {
					try {
						LOCK.wait(); //��K�������ˣ��ҵó�ȥ��(�ͷ���)...
					} catch (InterruptedException e) {
						System.out.println(this.name+"=>exception occurs...");
					}
				}
			} //�������ͷ���
		}
	}
}
