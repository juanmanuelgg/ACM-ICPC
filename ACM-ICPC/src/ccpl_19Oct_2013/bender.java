package ccpl_19Oct_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bender
{
	private static boolean test=true;
	private static BufferedReader br;
	private static int map [][]={{-1,-1,2,3,4,5},{-1,-1,3,2,5,4},{-1,-1,1,0,2,2},{-1,-1,0,1,3,3},{-1,-1,4,4,1,0},{-1,-1,5,5,0,1}}; 
	
	public static void main(String[] args) throws IOException
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/acm_19Oct/bender.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));
		solucionarProblema();
		br.close();
	}

	private static void solucionarProblema() throws IOException
	{
		String linea=br.readLine();
		while(!linea.equals("0"))
		{
			String[] instrucciones=br.readLine().split(" ");
			
			String rta=solucionarCaso(instrucciones);
			System.out.println(rta);
			linea=br.readLine();
		}
	}

	private static String solucionarCaso(String[] instrucciones)
	{
		int pos=0;
		for (int i = 0; i < instrucciones.length; i++)
		{
			if(!instrucciones[i].equals("No")) pos=map[pos][map_l_n(instrucciones[i])];
		}
		return map_n_l(pos);
	}
	
	private static int map_l_n(String l)
	{
		if(l.equals("+x"))return 0;
		else if(l.equals("-x"))return 1;
		else if(l.equals("+y"))return 2;
		else if(l.equals("-y"))return 3;
		else if(l.equals("+z"))return 4;
		else return 5;
	}
	
	private static String map_n_l(int n)
	{
		if(n==0)return "+x";
		else if(n==1)return "-x";
		else if(n==2)return "+y";
		else if(n==3)return "-y";
		else if(n==4)return "+z";
		else return "-z";
	}

}