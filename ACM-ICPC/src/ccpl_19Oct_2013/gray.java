package ccpl_19Oct_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gray
{
	private static BufferedReader br;
	private static boolean test=true;

	public static void main(String[] args) throws IOException
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/acm_19Oct/gray.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));

		solucionarProblema();

		br.close();
	}

	private static void solucionarProblema() throws IOException
	{
		String linea=br.readLine();
		while(!linea.equals("0 0"))
		{
			String[] paramGray=linea.split(" ");
			int numDecimal=Integer.parseInt(paramGray[0]);
			String numEnGray=paramGray[1];

			String rta=solucionarCaso(numDecimal,numEnGray.toCharArray());
			System.out.println(rta);
			linea=br.readLine();
		}
	}

	private static String solucionarCaso(int numDecimal, char[] numEnGray) 
	{
		// Pasar el Gray a Binario
		String binario="";
		for (int i = 0; i < numEnGray.length; i++)
		{
			if(i==0)binario+=numEnGray[i];
			else
			{
				if(numEnGray[i]=='0')binario+=binario.charAt(i-1);
				else binario+=(binario.charAt(i-1)=='0')?'1':'0';
			}
		}

		// Pasar el Decimal a Binario
		String binario2=Integer.toBinaryString(numDecimal);

		// Sumar los dos numeros Binarios

		int TamSuma=Math.max(binario.length(), binario2.length());

		int diferencia=binario.length()-binario2.length();
		if(diferencia>0) for (int i = 0; i <diferencia ; i++)binario2='0'+binario2;
		else if(diferencia<0)for (int i = 0; i < -diferencia; i++)binario='0'+binario;

		char[] carry={'0'};
		String suma="";
		for (int i = TamSuma-1; i >=0; i--) suma=sumador1bit(binario.charAt(i),binario2.charAt(i),carry)+suma;
		suma=suma.substring(suma.length()-numEnGray.length);

		// Pasar la suma a Gray
		char[] binar=suma.toCharArray();
		String gray="";
		for (int i = 0; i < binar.length; i++)
		{
			if(i==0)gray+=binar[i];
			else
			{
				if(binar[i-1]!=binar[i]) gray+='1';
				else gray+='0';
			}
		}
		
		return gray;
	}

	private static char sumador1bit(char add1, char add2, char[] carry)
	{
		char carryA=carry[0];
		if((add1=='1'&&add2=='1')||(add2=='1'&&carry[0]=='1')||(add1=='1'&&carry[0]=='1'))carry[0]='1';
		else carry[0]='0';
		if((add1=='0'&&add2=='1'&&carryA=='0')||(add1=='1'&&add2=='1'&&carryA=='1')||(add1=='0'&&add2=='0'&&carryA=='1')||(add1=='1'&&add2=='0'&&carryA=='0')) return '1';
		else return '0';
	}
}