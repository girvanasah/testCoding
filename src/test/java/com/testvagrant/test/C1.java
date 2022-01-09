package com.testvagrant.test;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C1 {

	/*
	 * find the unique pair of integers from an array whose sum is equal to a given number
	 */
	
	public static void main(String[] args) {
		
		int a[] =  {1, 5, 2, 9, 7, 4, 6, 4, 0, 3};
		
		int sum = 5;
		
		ArrayList<String> ans = new ArrayList<String>();
		
		for(int i = 0; i < a.length; i++) {
//			if(a[i] <= sum)
			{
				for(int j = 1; j < a.length-1; j++) {
					
					if(a[i] + a[j] == sum) {
						if(!ans.contains("{"+a[i] + "," +a[j] + "}")) {
							if(!ans.contains("{" +a[j] + "," +a[i] + "}")) {
								ans.add("{"+a[i]+","+a[j]+"}");
							}
						}
					}
				}
			}
		}
		
		System.out.println(ans);
		
	}
}
