package com.testvagrant.test;

public class D9 {

	public static void main(String[] args) {
		
		
		//Rotate matrix
		//a[i][j] = a[j][i]
		
		//m*n
		
		int [][]a = new int[2][4];
		int num = 1;
		
		for(int i = 0; i <2; i++) {
			for (int j = 0; j < 4; j++) {
				a[i][j] = num;
				System.out.print(a[i][j] + " ");
				num++;
			}
			System.out.println("");
		}
		
		for(int k = 0; k < 4; k++) {
			for (int l = 1; l >= 0; l--) {
				System.out.print(a[l][k] + " ");
			}
			System.out.println("");
		}
	}

}
