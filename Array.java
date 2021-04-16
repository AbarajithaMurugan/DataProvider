package org.array;

public class Array {
	public static void main(String[] args) {
		
		int a[]=new int[10];
		
		a[1]=1;
		a[2]=2;
		a[3]=3;
		a[4]=4;
		a[5]=5;
		a[6]=6;
		a[7]=7;
		a[0]=8;
		a[8]=9;
		a[9]=10;
		
		int sum=0;
		
		for (int i = 0; i < a.length; i++) {
			
			sum=sum+a[i];
						
		}
		int s=sum/9;
		System.out.println(s);
		
		
	}

}
