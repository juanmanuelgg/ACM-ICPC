package nacionales_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class reorder
{
	public static BufferedReader br;
	public static boolean test=false;

	public static void main(String[] args) throws IOException 
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/nacionales_2013/reorderTest.in")));
		else br=new BufferedReader(new InputStreamReader(System.in));

		solucionarProblema();

		br.close();
	}

	private static void solucionarProblema() throws IOException
	{
		int casos=Integer.parseInt(br.readLine());
		for (int i = 0; i < casos; i++) 
		{
			//--------------------------
			String[] dicc=br.readLine().split(" ");
			String[] text=br.readLine().split(" ");

			String rta=solucionarCaso(dicc,text);
			//--------------------------
			System.out.println(rta);
		}
	}

	private static String solucionarCaso(String[] dicc, String[] text)
	{
		for (int i = 0; i < text.length; i++) 
		{
			Map<Character, Integer> textoEni=new HashMap<Character, Integer>();
			char[] letrasEnTxti=text[i].toCharArray();
			for (char c : letrasEnTxti)
			{
				Integer reps=textoEni.get(c);
				if(reps==null) textoEni.put(c, 1);
				else textoEni.put(c, reps+1);
			}
			
			ciclo: for (int j = 0; j < dicc.length; j++) 
			{
				Map<Character, Integer> diccEnj=new HashMap<Character, Integer>();
				char[] letrasEnDicj=dicc[j].toCharArray();
				for (char c : letrasEnDicj)
				{
					Integer reps=diccEnj.get(c);
					if(reps==null) diccEnj.put(c, 1);
					else diccEnj.put(c, reps+1);
				}
				
				if(text[i].length()==dicc[j].length() && text[i].startsWith(dicc[j].charAt(0)+"") && text[i].endsWith(dicc[j].charAt(dicc[j].length()-1)+""))
				{
					text[i]=dicc[j];
					break ciclo;
				}
			}
		}
		String ntxt="";
		for (String texti : text) ntxt+=texti+" ";
		return ntxt.trim();
	}
	
}