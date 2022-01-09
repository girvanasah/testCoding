package com.testvagrant.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Str {

	public static void main(String[] args) {
		
		
		String inp = "asasashjahdjsahddvdsferA";
		
		int max = 1;
		
		String low = inp.toLowerCase();
		
		HashMap<Character, Integer> occurence = new HashMap<Character, Integer>();
		
		for (int i = 0; i < low.length(); i++) {
			if(!occurence.containsKey(low.charAt(i))) {
				occurence.put(low.charAt(i), 1);
			}
			else {
				int count = occurence.get(low.charAt(i));
				count++;
				occurence.put(low.charAt(i), count);
			}		
		}
		
		for (Entry<Character, Integer> a : occurence.entrySet()) {
			System.out.println(a.getKey() + " > " + a.getValue());
		}
		
		ArrayList<Integer> li = new ArrayList<Integer>();
		
		for(Entry<Character, Integer> a : occurence.entrySet()) {
			if(!li.contains(a.getValue())) {
				li.add(a.getValue());
			}
		}
		
		
		li.sort(null);
		
		int size = li.size();
		
		int index = size - max;
		
		if (index >= 0 ) {
			
			int value = li.get(index);
			
			for (Entry<Character, Integer> a : occurence.entrySet()) {
				if(a.getValue() == value) {
					System.out.println(a.getKey());
				}
			}
			
		}
		

	}

}

