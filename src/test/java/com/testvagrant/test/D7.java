package com.testvagrant.test;

import java.util.HashMap;

public class D7 {

	public static void main(String[] args) {
		String print = "AZGB";
		
		HashMap<Character, Integer> inp = new HashMap<Character, Integer>();
		int index = 1;
		for(char ch = 'A'; ch <= 'Z'; ++ch) {
			inp.put(ch, index);
			index++;
		}
		
		int l = 1;
		long time = 0;
		
		for(int j = 0; j< print.length(); j++) {
			int n = inp.get(print.charAt(j));
			int diff = Math.abs(n-l);
			l = n;
			if(diff > 13) {
				diff = 26-diff;
			}
			
			time = time + diff;
		}
		
		System.out.println(time);
	}

	
}
