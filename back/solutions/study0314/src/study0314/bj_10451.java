package study0314;

import java.util.*;
import java.io.*;

public class bj_10451 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());
		for(int test = 0; test<T; test++) {
			int num = Integer.parseInt(br.readLine());
			
			int [] arr = new int[num+1];
			boolean [] visit = new boolean[num+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i<arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			for(int i = 1; i<arr.length; i++) {
				// 1 2 3 4 5 6 7 8 
				// 3 2 7 8 1 4 5 6
				if(!visit[i]) {
					visit[i] = true;
					int go = arr[i];
					while(true) {
						if(visit[go]) {
							cnt++;
							break;
						}
						visit[go] = true;
						go = arr[go];
					}
				}
				
			}
				
			System.out.println(cnt);
		}
		
	}
}
