package com.testvagrant.test;

import java.util.ArrayList;

public class D10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String inp = "My name Name is is abc is name";
		
		// op : name is
		
		ArrayList<String> uni = new ArrayList<>();
		ArrayList<String> op = new ArrayList<>();
		
		String words[] = inp.split(" ");
		
		//wrd[0] = "is"
		//wrd[1] = ""
		
		for(String wrd : words) {
			if (uni.contains(wrd)) {
				if(!op.contains(wrd))
				op.add(wrd);
			}
			else {
				uni.add(wrd);
			}
		}
		System.out.println(op);
		
	}

}
