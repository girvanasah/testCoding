package com.testvagrant.test;

public class D11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// abaccdaba > aba, cc, aba
		//aabaa
		
	
		
		String a = "abaccd";
		
		String b,c,d,e;
		int len = a.length();
		Character in,in1;
		
		for(int i = 0; i < len-1; i++) {
			b="";
			c="";
			in = a.charAt(i);
			b = in.toString();
			c = in.toString();
			for(int j = 1; j< len; j++) {
				in1 = a.charAt(j);
				b = b + in1.toString();
				c = in1.toString() + c;
				if(b.equals(c)) {
					System.out.println(b);
				}
				
			}
		}
		
		
		
	}

}
