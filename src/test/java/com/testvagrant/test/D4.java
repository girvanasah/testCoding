package com.testvagrant.test;

public class D4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inp = "a";
		
		boolean flag = true;
		
		int len = inp.length()-1;
		
		int max = len / 2 + 1;
		for(int i = 0; i < max; i++) {
			if(inp.charAt(i) != inp.charAt(len)) {
				flag = false;
				break;
			}
			len--;
		}
		if(flag) {
			System.out.println("Palindrome");
		}else {
			System.out.println("Not Palindrome");
		}
	}

}
