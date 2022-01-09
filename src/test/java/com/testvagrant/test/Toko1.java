package com.testvagrant.test;

import java.util.ArrayList;

public class Toko1 {

	static ArrayList<Character> seq = new ArrayList<Character>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inp = "{}{}[]()";
		
		char a[]= inp.toCharArray();
		int len = a.length;
		
		for (int i = 0;i<len;i++) {
//			if()
		}
		
		
	}
	
	public static void push(char ch) {
		seq.add(ch);
	}
	
	public static char pop() {
		int s = seq.size();
		char a = seq.get(s-1);
		seq.remove(s-1);
		return a;
	}
	
	

}
