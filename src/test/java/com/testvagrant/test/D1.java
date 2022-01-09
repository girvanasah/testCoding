package com.testvagrant.test;

public class D1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {3,3,3,3,4,4};
		
		for (int i = 0; i < a.length-1; i++) {
			if(a[i] != a[i+1]) {
				System.out.println(i);
				break;
			}
		}
		
	}

}
