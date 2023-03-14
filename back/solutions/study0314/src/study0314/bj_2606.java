package study0314;


import java.util.*;
import java.io.*;

public class bj_2606 {
	static boolean []visit;
	static int [][] arr;
	static int node, line, cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		node = Integer.parseInt(br.readLine());
		line = Integer.parseInt(br.readLine());
		
		arr = new int[node+1][node+1];
		visit = new boolean[node+1];
		
		for(int i = 0; i<line; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		}
		
		dfs(1);
		
		System.out.println(cnt-1);
	}

	private static void dfs(int i) {
		visit[i] = true;
		cnt++;
		for(int k = 1; k<=node; k++) {
			if(arr[i][k] ==1 && !visit[k]) {
				dfs(k);
			}
		}
		
	}

}
