package com.testvagrant.test;

public class D2 {
	
	/*
	 * i/p as an array shift it by three places
	 */
	
	public static void main (String []args) {
		
		int a[]= {1,2,3,4,5,6,7};
		
		//{7,1,2,3,4,5,6}
		
		//{4,5,6,7,1,2,3}
		int shift = 4;
		for(int i = shift; i > 0; i--) {
			int temp;
			for (int j = 0; j < a.length-1; j++) {
				
				a[j+1] = a[j];
			}
		}
		
	}

}
