package ex;


import java.util.*;
import java.io.*;

public class test1260_2 {
	
	static StringBuilder sb = new StringBuilder();
	static int node, line, start;
	static int [][] arr;
	static boolean[] bool;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		node = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		arr = new int[node+1][node+1];
		bool = new boolean[node+1];
		
		for(int i = 1; i<=line; i++) {		
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		} //값 세팅 완료 
		dfs(start);
		sb.append("\n");
		bool = new boolean[node+1];
		bfs(start);
		System.out.println(sb);
		
	}

	private static void bfs(int start2) {
		bool[start] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			start = q.poll();
			sb.append(start+" ");
			
			for(int i = 1; i <= node; i++) {
				if(arr[start][i] ==1 && !bool[i]) {
					q.add(i);
					bool[i] = true;
				}
			}
		}
		
	}

	public static void dfs(int start) {
		bool[start] = true;
		sb.append(start+" ");
		
		for(int i = 1; i<= node; i++) {
			if(arr[start][i]==1 && !bool[i]) {
				dfs(i);
				
			}
		}
		
	}
}
