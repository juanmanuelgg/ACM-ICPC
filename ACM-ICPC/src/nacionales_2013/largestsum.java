package nacionales_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class largestsum
{
	public static BufferedReader br;
	public static boolean test=false;

	public static void main(String[] args) throws IOException 
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/nacionales_2013/largestsumTest.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));

		solucionarProblema();

		br.close();
	}

	private static void solucionarProblema() throws IOException
	{
		String linea=br.readLine();
		while (linea!=null)
		{
			//--------------------------
			String[] secuencia=linea.split(" ");
			
			int rta=solucionarCaso(secuencia);
			//--------------------------
			System.out.println(rta);
			linea=br.readLine();
		}
	}

	private static int solucionarCaso(String[] secuencia) 
	{
		int[] numeros=new int[secuencia.length];
		ArrayList<Integer> ix=new ArrayList<Integer>();
		ix.add(0);
		
		boolean flag=false;
		for (int i = 0; i < numeros.length; i++) 
		{
			numeros[i]=Integer.parseInt(secuencia[i]);
			if(numeros[i]<0)flag=true;
			else if (numeros[i]>0 && flag)
			{
				ix.add(i);
				flag=false;
			}
		}
		
		int mayor=0;
		for (Integer i : ix)
		{
			int aux=0;
			cilco:for (int j = i; j < numeros.length; j++)
			{
				aux+=numeros[j];
				if(aux>mayor) mayor=aux;
				else if(aux<0) break cilco;
			}
		}
		
		return mayor;
	}
	
}