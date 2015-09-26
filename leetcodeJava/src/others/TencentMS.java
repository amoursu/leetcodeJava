package others;

public class TencentMS {

	public static void print(int max){
		int[] sLine = new int[max];
		
		boolean isOk = false;
		while(!isOk){
			isOk = true;
			for(int i = 0;i < max;i++){
                int f = getFrequency(sLine, i);				
				if(sLine[i] != f){
					sLine[i] = f;
					isOk = false;
				}
			}
		}
		for(int i = 0;i < max;i++)
			System.out.print(i+" ");
		System.out.println();
        for(int s : sLine)
        	System.out.print(s+" ");
	}
	
	private static int getFrequency(int[] array, int i){
		int count = 0;
		for(int a : array){
			if(a == i)
				count ++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        print(10);
	}

}
