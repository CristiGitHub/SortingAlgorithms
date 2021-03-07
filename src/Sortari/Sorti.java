package Sortari;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorti {
	
	public static boolean isSorted(int vector[]) {
		for(int i=1;i<vector.length;i++)
			if(vector[i-1]>vector[i])
				return false;
		return true;
	}

	public static void BubbleSort(int vector[])
	{
		
		int aux;
		int len=vector.length;
		long inceput = System.nanoTime();
		for(int i = 0 ;i<len-1;i++)
			for(int j = 0 ; j <len-i-1;j++)
					if(vector[j]>vector[j+1])
					{
						aux=vector[j];
						vector[j]=vector[j+1];
						vector[j+1]=aux;
					}
		long sfarsit   = System.nanoTime();
		long total = sfarsit - inceput;
		System.out.println("BubbleSort time: " + total + " isSorted: " + isSorted(vector));			
	}
	public static void CountSort(int vector[])
	{
		int maxi = 0;
		for(int i = 0 ; i < vector.length ; i++)
			if(vector[i]>maxi)
				maxi=vector[i];
		int count[] = new int[maxi+1];
		
		int x,maxim=0,nr=0,i,j,n;
		n=vector.length;
		int sorti[] = new int[n];
		long inceput = System.nanoTime();
		for(i=0;i<n;i++)
			{count[vector[i]]++;
			if(vector[i]>maxim)
				maxim=vector[i];
			}
		for(i=0;i<=maxim;i++)
			for(j=1;j<=count[i];j++)
				sorti[nr++]=i;
		long sfarsit = System.nanoTime();
		long total = sfarsit- inceput;
		System.out.println("CountSort time: " + total + " isSorted: " + isSorted(sorti));
	
		
	}
	public static void RadixSort(int vector[])
	{
		int maxim=0;
		int n = vector.length;
	
		for(int i = 0 ; i <n; i++)
			if(vector[i]>maxim)
				maxim=vector[i];
		
		long inceput = System.nanoTime();
		for(int i =1 ; maxim/i>0; i *= 10)
		{
			int sorti[] =new int[n];
			Arrays.fill(sorti, 0);
			int count[] =new int[10];	
			int j; 
			Arrays.fill(count, 0);
			
			for( j = 0 ; j < n ; j ++)
				count[(vector[j]/i)%10]++;
			for( j = 1 ; j <= 9 ; j ++)
				count[j]= count[j] + count[j-1];
			for(j = n-1 ; j >=0; j--) {
				
				sorti[count[(vector[j]/i)%10]-1]=vector[j];
				count[(vector[j]/i)%10]--;
				}

			for(j = 0 ; j < n ; ++j)
				vector[j]=sorti[j];
			
		}
		long sfarsit = System.nanoTime();
		long total = sfarsit- inceput;
		System.out.println("RadixSort time: " + total + " isSorted: " + isSorted(vector));
		
	}
	public static void MergeSort(int vector[])
	{	long inceput = System.nanoTime();
		RecSort(vector,0,vector.length-1);
		long sfarsit = System.nanoTime();
		long total = sfarsit - inceput;
		System.out.println("MergSort time: " + total + " isSorted: " + isSorted(vector));
	}
	public static void RecSort(int vector[], int inceput , int sfarsit)
	{
		
		if(inceput < sfarsit) {
			int m = inceput+(sfarsit-inceput)/2;
			RecSort(vector, inceput , m);
			RecSort(vector, m+1 , sfarsit);
			merge(vector , inceput , m , sfarsit);
		}
		
			
			
	}
	public static void merge(int vector[],int inceput , int mijloc , int sfarsit)
	{
		int n1 = mijloc-inceput+1;
		int n2= sfarsit-mijloc;
		int n=vector.length;
		int stanga[] = new int[n1];
		int dreapta[]= new int[n2];
		for(int i = 0 ; i < n1 ; i++)
			stanga[i]= vector[inceput+i];
		for(int i =0 ; i < n2 ; i++)
			dreapta[i]=vector[mijloc+1+i];
		int i =0 , j =0;
		int k=inceput;
		while(i<n1 && j<n2)
		{
			if(stanga[i]<dreapta[j])
			{
				vector[k]= stanga[i];
				i++;
			}
			else
			{
				vector[k]=dreapta[j];
				j++;
			}
			k++;
		}
		while(i<n1)
		{
			vector[k]=stanga[i];
			i++;
			k++;
		}
		while(j<n2)
		{
			vector[k]=dreapta[j];
			j++;
			k++;
					
		}}
	public static void QuickSortClassic(int vector[])
	{
		long inceput = System.nanoTime();
		quickSortClassic(vector,0, vector.length-1);
		long sfarsit = System.nanoTime();
		long total = sfarsit - inceput;
		System.out.println("QuickSort with last elemnet as Pivot time: " + total + " isSorted: " + isSorted(vector));
	}
	public static void quickSortClassic(int vector[], int inceput, int sfarsit) {
	    if (inceput < sfarsit)
	     {
	        int indexPart = partClassic(vector, inceput, sfarsit );
	        quickSortClassic(vector, inceput, indexPart-1);
	        quickSortClassic(vector, indexPart+1, sfarsit);
	    }
	}
	private static int partClassic(int vector[], int inceput, int sfarsit ) {
		
		int pivot=vector[sfarsit];
	    int i,aux;
	    i=inceput-1;
	    for (int j = inceput; j < sfarsit; j++) {
	        if (vector[j] <= pivot) {
	            i++;

	            aux= vector[i];
	            vector[i] = vector[j];
	            vector[j] = aux;
	        }
	    }

	    aux = vector[i+1];
	    vector[i+1] =vector[sfarsit];
	    vector[sfarsit] = aux;

	    return i+1;
	}
	static void QuickSortmm(int vector[])
	{
		long inceput =System.nanoTime();
		QuickSortM(vector, 0 , vector.length-1);
		long sfarsit = System.nanoTime();
		long total = sfarsit-inceput;
		System.out.println("QuickSort with the Middle element as Pivot time: " + total + " isSorted: " + isSorted(vector));
	}
	static void QuickSortM(int vector[] , int inceput , int sfarsit)
	{
		int i = QuickSortMiddleParti(vector,inceput,sfarsit);
		if(inceput< i-1)
		QuickSortM(vector,inceput , i-1);
		if(i<sfarsit)
		QuickSortM(vector,i,sfarsit);
		
		
	}
	static int QuickSortMiddleParti(int vector[] , int inceput , int sfarsit)
	{
		int i = inceput ; 
		int j = sfarsit;
		int pivot = vector[(i+j)/2];
		int aux;
		while(i<=j)
		{
			while(vector[i]<pivot)
				i++;
			while(vector[j]>pivot)
				j--;
			if(i<=j)
			{
				aux=vector[i];
				vector[i]=vector[j];
				vector[j]=aux;
				i++;
				j--;
			}
		}
		return i;
		
		
	}
	public static void JavaSort(int vector[])
	{
		List<Integer> vr = new ArrayList<Integer>(vector.length+1);
		for(int i = 0 ; i < vector.length ; ++i)
			vr.add(vector[i]);
		long inceput =System.nanoTime();
		Collections.sort(vr);
		long sfarsit = System.nanoTime();
		long total = sfarsit-inceput;
		System.out.println("Java Array.sort dual-pivot Quicksort time: " + total + " isSorted: " + isSorted(vr.parallelStream().mapToInt(i->i).toArray()));

	}
	public static void InsertionSort(int vector[])
	{
		long inceput =System.nanoTime();
		for (int i = 1 ; i < vector.length ;++i)
		{
			int pivot = vector[i];
			int j = i -1;
			while(j >= 0 && vector[j] > pivot)
			{
				vector[j+1]=vector[j];
				--j;
			}
			vector[j+1]=pivot;
		}
		
		long sfarsit = System.nanoTime();
		long total = sfarsit-inceput;
		System.out.println("InsertionSort time: " + total + " isSorted: " + isSorted(vector));

	}
	public static void HeapSort(int vector[])
	{
		int n = vector.length;
		int aux;
		long inceput =System.nanoTime();
		for(int i =  n/2 -1 ; i >= 0 ; --i)
			hipi(vector ,n, i);
		for(int i = n -1 ; i > 0 ; --i)
		{
			aux=vector[0];
			vector[0]=vector[i];
			vector[i]=aux;
			hipi(vector,i  ,0);
		}
		long sfarsit = System.nanoTime();
		long total = sfarsit-inceput;
		System.out.println("HeapSort time: " + total + " isSorted: " + isSorted(vector));
		
	}
	public static void hipi(int vector[], int n , int i)
	{
		int nr = i;
		int aux;
		int x = 2*i +1;
		int y =x+1;
		if(x <  n && vector[x] >  vector[nr])
			nr = x;
		if(y < n && vector[y] > vector[nr])
			nr = y;
		if(nr != i)
		{
			aux=vector[nr];
			vector[nr]=vector[i];
			vector[i]=aux;
			hipi(vector,n , nr);
		}
	} 
	public static void SelectionSort(int vector[])
	{
		int n = vector.length;
		long inceput =System.nanoTime();
		for(int i = 0 ; i < n - 1 ; ++i )
		{
			int minim=i;
			for(int j = i+1 ; j < n ; ++j)
				if(vector[j]<vector[minim])
					minim=j;
			int aux;
			aux=vector[minim];
			vector[minim]=vector[i];
			vector[i]=aux;
		}
		long sfarsit = System.nanoTime();
		long total = sfarsit-inceput;
		System.out.println("SelectionSort time: " + total + " isSorted: " + isSorted(vector));
	}
	
		
		
	
}
