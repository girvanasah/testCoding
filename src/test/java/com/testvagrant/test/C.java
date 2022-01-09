package com.testvagrant.test;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class C {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here

        Scanner s = new Scanner(System.in);
        String name = s.nextLine(); 
        int testCases = Integer.parseInt(name);
        ArrayList<String> len = new ArrayList<String>();
        ArrayList<String> str = new ArrayList<String>();

        for (int i = testCases;i>0;i--){
            String len1 = s.nextLine();
            len.add(len1);
            String str1 = s.nextLine();
            str.add(str1);
        }

        for(int j = 0; j < testCases; j++){
            System.out.println(maxMismatch(Integer.parseInt(len.get(j)), str.get(j)));
        }

    }

    public static int maxMismatch(int length, String query){
        int count = 0;
        int temp = length-1;
        char ans[] = query.toCharArray();
        for(int i = 0; i<length ;i++){
            if(ans[0] != ans[temp]){
                count++;
            }
            temp--;
        }
        return count;
    }
}
