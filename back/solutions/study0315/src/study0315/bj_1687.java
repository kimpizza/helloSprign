package study0315;

import java.io.*;
import java.util.*;
public class bj_1687 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		if(n == k) {
			System.out.println(0);
			return;
		}
		
		boolean [] visit = new boolean[100001];
		visit[n] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		
		int size = q.size();
		int cnt = 0;
		
		while(true) {
			cnt++;
			size = q.size();
			
			for(int i =0; i<size; i++) {
				int x = q.remove();
				visit[x] = true;
				if(x-1 == k || x +1 == k || x*2 == k) {
					System.out.println(cnt);
					return;
				}
				
				if(x-1>=0 && !visit[x-1]) {
					visit[x-1] = true;
					q.add(x-1);
				}
				
				if(x+1<=100000 && !visit[x+1]) {
					visit[x+1] = true;
					q.add(x+1);
				}
				
				if(x*2 <=100000 && !visit[x*2]) {
					visit[x*2] = true;
					q.add(x*2);
				}
			}
		}
	}
}
