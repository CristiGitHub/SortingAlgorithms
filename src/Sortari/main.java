package Sortari;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Sortari.Sorti;
public class main {
	private static Scanner sc = new Scanner(System.in);
	 private static int top =0;
	public static void showComm() {
		System.out.println("Available commands");
		for (GenMod comm : GenMod.values()) {
			System.out.println(  comm + " ");
		}
	}
	
	public static String getDataCaseUnsensitive(String msg) {
		return getData(msg, false);
	}
	
	public static String getData(String msg, boolean caseSensitive) {
		System.out.println(msg);
		return caseSensitive ? sc.next() : sc.next().toUpperCase();
	}
	public static void citire(String path)
	{
		int t=0;
		int numar, maxim;
		try {
		      File myObj = new File(path);
		      Scanner myReader = new Scanner(myObj);
		      String data = myReader.nextLine();
		      t=Integer.parseInt(data);
		      for(int i = 1 ; i <= t ; i++)
		      {
		    	   data = myReader.nextLine();
		    	  String token[]=data.split(" ");
		    	  numar = Integer.parseInt(token[0]);
		    	  maxim = Integer.parseInt(token[1]);
		    	  GenMod tr=GenMod.valueOf(token[2].toLowerCase());
		    	  Generare generator = new Generare();
		    	  switch(tr) {
		    	  case sorted:
		    		  { int vector[]= generator.GenSorted(numar, maxim);
		    		  System.out.println("-----Sorted Array ------");
		    		  System.out.println("with "+ numar + " elements with a maximum value of " + maxim);
		    		  ToateSortarile(vector);
		    		  break;}
		    	  case random:
		    		  {int vector[]= generator.GenRandom(numar, maxim);
		    		  System.out.println("-----Random Array ------");
		    		  System.out.println("with "+ numar + " elements with a maximum value of " + maxim);
		    		  ToateSortarile(vector);
		    		  break;}
		    	  case almostsorted:
		    	  {
		    		  int vector[]=generator.AlmostSorted(numar, maxim);
		    				  System.out.println("-----AlmOSorted Array ------");
		    		  System.out.println("with "+ numar + " elements with a maximum value of " + maxim);
		    			ToateSortarile(vector);	
		    			break;  
		    	  }
		    	  case interstinggenalg:
		    	  {
		    		  int vector[]=generator.InterstingGenAlg(numar, maxim);
		    		  	System.out.println("---Perlin Noise Generated Array + Math ----");
		    		  	System.out.println("with "+ numar + " elements with a maximum value of " + maxim);
		    			ToateSortarile(vector);	
		    		  	break;
		    	  } 
		    	  case mountain:
		    	  {
		    		  int vector[]=generator.Mountain(numar, maxim);
		    		  	System.out.println("---Mountain Array ----");
		    		  	System.out.println("with "+ numar + " elements with a maximum value of " + maxim);
		    			ToateSortarile(vector);	
		    		  	break;
		    	  }
		    		  
		      }
		    	  }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public static void ToateSortarile(int vector[])
	{   Sorti sr = new Sorti();
		 int  safe[] = new int[vector.length];
		 for(int i = 0 ; i < vector.length ; ++ i)
			 safe[i]=vector[i];
		sr.InsertionSort(safe);
		 for(int i = 0 ; i < vector.length ; ++ i)
			 safe[i]=vector[i];
		sr.CountSort(safe);
		 for(int i = 0 ; i < vector.length ; ++ i)
			 safe[i]=vector[i];
		sr.RadixSort(safe);
		 for(int i = 0 ; i < vector.length ; ++ i)
			 safe[i]=vector[i];
		sr.MergeSort(safe);
		 for(int i = 0 ; i < vector.length ; ++ i)
			 safe[i]=vector[i];
		sr.QuickSortClassic(safe);
		 for(int i = 0 ; i < vector.length ; ++ i)
			 safe[i]=vector[i];
		sr.QuickSortmm(safe);
		 for(int i = 0 ; i < vector.length ; ++ i)
			 safe[i]=vector[i];
		sr.JavaSort(safe);
		 for(int i = 0 ; i < vector.length ; ++ i)
			 safe[i]=vector[i];
		sr.BubbleSort(safe);
		 for(int i = 0 ; i < vector.length ; ++ i)
			 safe[i]=vector[i];
		sr.HeapSort(safe);
		 for(int i = 0 ; i < vector.length ; ++ i)
			 safe[i]=vector[i];
		sr.SelectionSort(safe);
		
	}

	public static void main(String[] args) {
		
		
		citire("input.txt");
		/*int v[]=Generare.GenSorted(100, 20);
		for(int i = 0 ; i < 100 ;i ++)
			System.out.print(v[i]+ " ");
		
		int vector[]= {1,5,2,3,4,7};
		
		Sorti.QuickSortMiddle(vector,0,vector.length-1);
		for(int i : vector)
			System.out.print(vector[i]+ " ");
		
		*/
		


	}

}
