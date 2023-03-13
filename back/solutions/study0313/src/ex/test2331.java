package ex;

import java.util.*;
import java.io.*;

public class test2331 {
    static StringBuilder sb = new StringBuilder();
	static int node, line, start;
	static boolean [] visit;
	static int [][] arr;
	
	
	public static void main(String [] args ) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        
        arr = new int[node+1][node+1];
        visit = new boolean[node+1];
        
        for(int i = 0 ; i < line; i++) {
        	StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            arr[a][b] = arr[b][a] = 1;        
        }
        
        dfs(start);
        sb.append("\n");
        visit = new boolean[node+1];
        bfs(start);
	}
	
	public static void dfs(int start) {
		visit[start] = true;
		sb.append(start+" ");
		
		for(int i = 1; i<=node; i++) {
			if(!visit[i]&& arr[start][i] == 1) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int start) {
		visit[start] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			start = q.poll();
			sb.append(start+" ");
			for(int i = 1; i<=node; i++) {
				if(arr[start][i]==1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
		
		
		
	}

}
