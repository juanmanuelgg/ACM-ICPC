package nacionales_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tennis
{
	public static BufferedReader br;
	public static boolean test=false;

	public static void main(String[] args) throws IOException 
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/nacionales_2013/tennisTest.in")));
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
			String[] paramJuego=linea.split(" ");
			int numRondas=Integer.parseInt(paramJuego[0]);
			double jug1=Double.parseDouble(paramJuego[1]);
			double jug2=Double.parseDouble(paramJuego[2]);
			
			int rta=solucionarCaso(numRondas,jug1,jug2);
			//--------------------------
			System.out.println(rta);
			linea=br.readLine();
		}
	}

	private static int solucionarCaso(int numRondas, double jug1, double jug2)
	{
		for (int i = 1; i <= numRondas; i++)
		{
			if(Math.ceil(jug1/(2*i)) == Math.ceil(jug2/(2*i))) return i;
		}
		return 0;
	}
	
}