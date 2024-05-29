package day18;

import java.util.Arrays;

public class UniqueElements {

	public static int[] findUniqueElements(int[]  nums) {
		int XorResult = 0;
		for(int num : nums) {
			XorResult ^= num;
		}
		int setBit = XorResult & ~(XorResult - 1);
		
		int unique1 = 0;
		int unique2 = 0;
		for(int num : nums) {
			if((num & setBit) !=0) {
				unique1 ^= num;
			}else {
				unique2 ^= num;
			}
		}
		
		return new int[] { unique1,unique2};
	}
	public static void main(String[] args) {
		int[] nums = {12,24,36,48,60,72,84};
				int[] result = findUniqueElements(nums);
		System.out.println("The two unique elements are:" + Arrays.toString(result));
	}
}

		