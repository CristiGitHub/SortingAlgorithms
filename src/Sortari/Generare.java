package Sortari;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Generare {
	
	public static int[] GenSorted(int numar , int maxim)
	{
		List<Integer> data = new ArrayList<>(numar);
		for(int i = 0 ; i < numar ;i++)
		data.add((int) (Math.random()*maxim));
		Collections.sort(data);
		return data.parallelStream().mapToInt(i->i).toArray();
	}
	public static int[] GenRandom(int numar , int maxim)
	{
		int result[]= new int[numar];
		for(int i = 0 ; i < numar ; i++)
			result[i]=ThreadLocalRandom.current().nextInt(0, maxim + 1);
		return result;
	}
	public static int[] AlmostSorted(int numar , int maxim)
	{
		int result[]= new int[numar];
		result= GenSorted(numar,maxim);
		int aux;
		int rnd,brn;
		for(int i = 0 ; i< numar/20 ; ++i)
		{
			rnd= ThreadLocalRandom.current().nextInt(0, numar);
			brn =ThreadLocalRandom.current().nextInt(0, numar);
			aux=result[rnd];
			result[rnd]=result[brn];
			result[brn]=aux;
		}
		return result;
		
	}
	public static int[] InterstingGenAlg(int numar , int maxim)
	{int result[]= new int[numar];
	float x;
		PerlinNoise pr = new PerlinNoise();
		for(int i = 0 ; i < numar ; ++i) {
			float val = pr.perlin((float) Math.random(), i);
			x=(float) Math.pow(1/(Math.pow(Math.E, -val)+1),2); // (1 / 1+e^-val)^2*maxim ---Math power
			x=x*maxim;
		result[i]=(int) x;
		}
		return result;
		
	}
	public static int[] Mountain(int numar , int maxim)
	{
		int result[]= new int[numar];
		int varst[]= GenSorted(numar/2,maxim-maxim%30);
		int vardr[] = GenSorted(numar/2,maxim-maxim%30);
		for(int i = 0 ; i<numar/2 ; ++i)
			result[i]=varst[i];
		for(int i = numar/2 ; i>=1 ; --i)
			result[numar-i]=vardr[i-1];
		return result;
	}
	// - --- IntroSort & TeamSort in future version :D -------
	
}
