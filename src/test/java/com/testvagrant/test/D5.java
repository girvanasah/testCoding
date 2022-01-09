package com.testvagrant.test;

public class D5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String inp = "Hari reads in a class 11";
		
		String mid[] = inp.split(" ");
		
		String output = "";
		
		for(int i = mid.length-1; i >=0; i--) {
			output = output + " "  + mid[i];
		}
		
		System.out.println(output.trim());
	}

}
