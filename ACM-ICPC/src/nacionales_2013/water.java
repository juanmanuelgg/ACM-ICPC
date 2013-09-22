package nacionales_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class water
{
	public static BufferedReader br;
	public static boolean test=true;

	public static void main(String[] args) throws IOException 
	{
		if(test)br=new BufferedReader(new FileReader(new File("./data/nacionales_2013/waterTest.in")));
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
			String[] auxGrafo=linea.split(" ");
			int numVertices=Integer.parseInt(auxGrafo[0])+1;
			int numArcos=Integer.parseInt(auxGrafo[1]);
			
			@SuppressWarnings("unchecked")
			ArrayList<Integer>[] adj=new ArrayList[numVertices];
			for (int i = 0; i < adj.length; i++) adj[i]=new ArrayList<Integer>();
			
			for (int i = 0; i < numArcos; i++)
			{
				String[] auxArco=br.readLine().split(" ");
				int from=Integer.parseInt(auxArco[0]);
				int to=Integer.parseInt(auxArco[1]);
				adj[from].add(to);
			}
			
			int rta=solucionarCaso(adj);
			//--------------------------
			System.out.println(rta);
			linea=br.readLine();
		}
	}

	private static int solucionarCaso(ArrayList<Integer>[] adj)
	{
		int[] coloresV=new int[adj.length];
		Arrays.fill(coloresV, -1);
		
		for (int i = 0; i < adj.length; i++) if(coloresV[i]==-1) bfs(i, coloresV, i, adj);
		
		Set<Integer> lol=new HashSet<Integer>();
		for (int color : coloresV) if(color!=0) lol.add(color);
		
		return lol.size();
	}
	
	private static void bfs(int s, int[]coloresV, int color, ArrayList<Integer>[] adj)
	{
		coloresV[s]=color;
		Queue<Integer> pq= new PriorityQueue<Integer>();
		pq.add(s);
		
		while (!pq.isEmpty())
		{
			int u=pq.poll();
			for (int v : adj[u])
			{
				if(coloresV[v]!=color)
				{
					coloresV[v]=color;
					pq.add(v);
				}
			}
		}
	}
	
}