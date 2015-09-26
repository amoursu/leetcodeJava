package easy;

public class P190_ReverseBits {

	// you need treat n as an unsigned value
	// Integer.MAX_VALUE = 2^31-1;
    public static int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        for(int i = 32-binary.length();i>0;i--){
        	binary = '0' + binary;
        }
        int result = 0;
        for(int i = 0;i < binary.length();i++){
        	if(binary.charAt(i)=='1'){
        		result += Math.pow(2, i);
        	}
        }
    	return result;
    }
	
	public static void main(String[] args) {
        System.out.println(reverseBits(1));
        System.out.println(Integer.MAX_VALUE);
//        int i = 2147483648;//wrong
	}
}
