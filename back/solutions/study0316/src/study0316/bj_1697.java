package study0316;

import java.util.*;
import java.io.*;

public class bj_1697 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N==K) {
			System.out.println(0);
		}
		boolean[] visit = new boolean[100001];
		visit[N] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		
		int size = q.size();
		int cnt = 0;
		
		while(N!=K) {
			cnt++;
			size = q.size();
			

			for(int i =0; i<size; i++) {
				int x = q.poll();
				visit[x] = true;
				if(x-1 == K || x +1 == K || x*2 == K) {
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
