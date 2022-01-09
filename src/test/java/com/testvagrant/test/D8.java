package com.testvagrant.test;

public class D8 {

	public static void main(String[] args) {
		
		int[] inp = {0,1,1,1,0,0,1};
		int sum = 0;
		
		for(int i = 0; i < inp.length; i++) {
			sum = sum + inp[i];
		}
		
		int zeros = inp.length - sum;
		int[] op = null; 
		for(int j = 0; j < zeros; j++) {
			op[j] = 0;
		}
		
		for (int k = zeros; k < inp.length; k++) {
			op[k] = 1;
		}

		
	}

}
