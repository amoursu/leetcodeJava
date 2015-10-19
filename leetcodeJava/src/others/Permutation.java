package others;

public class Permutation {
    static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        permutation("221");
	}

	static void permutation(String str){
		permutation(str.toCharArray(),0,str.length());
	}
	
	static void permutation(char[] array, int begin, int len){
		if(begin == len-1){
			print(array);
			count ++;
		}else{
			for(int i = begin;i < len;i++){
				if(isSwap(array, begin, i)){
				    swap(array,begin,i);
				    permutation(array,begin+1,len);
				    swap(array,begin,i);
				}
			}
		}
	}
	
	static boolean isSwap(char[] array, int begin, int end){
		for(int i = begin;i < end;i++){
			if(array[i] == array[end])
				return false;
		}
		return true;
	}
	
	static void print(char[] array){
		for(char c : array)
			System.out.print(c);
		System.out.println();
	}
	
	static void swap(char[]array,int i,int j){
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
