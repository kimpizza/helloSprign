package study0314;


import java.util.*;
import java.io.*;

public class bj_11724 {
	static int node, line;
	static boolean [] visit;
	static int [][] arr;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());

		node = Integer.parseInt(str.nextToken());
		line = Integer.parseInt(str.nextToken());
		
		arr = new int[node+1][node+1];
		visit = new boolean[node+1];
		
		for(int i = 1; i<=line; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		}
		for(int i = 1; i<=node; i++) {
			if(!visit[i]) {
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	
	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visit[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			start = q.poll();
			
			for(int i = 1; i<=node; i++) {
				if(arr[start][i] ==1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}

}
