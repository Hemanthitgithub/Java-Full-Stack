package day18;

public class BitManipulation {

	public static int countSetBits(int num) {
		
		int count = 0;
		while(num > 0){
			count += (num & 1);
			num >>= 1;
		}
		return count;
	}
	
	public static int totalSetBits(int n) {
		int total = 0;
		for(int i = 1;i<=n;i++) {
			total += countSetBits(i);
		}
		return total;
	}
	public static void main(String[] args) {
		int num = 15;
		System.out.println("Number of set bits in "+ num +":" + countSetBits(num));
		int n= 25;
		System.out.println("Total number of set bits from 1 to " + n + ":"+totalSetBits(n));
	}
}