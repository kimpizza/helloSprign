package ex;

import java.io.*;
import java.util.*;

public class bj10451 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<T; i++) {
			int cnt = 0;
			int in = Integer.parseInt(br.readLine());
			int [] arr = new int[in+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int j = 1; j<arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			boolean[] visit = new boolean[arr.length];
			
			for(int j = 1; j<arr.length;j++) {
				if(!visit[j]) { //방문하지 않았다면 
					visit[j] = true;
					int go = arr[j]; //연결 된 노드가 있는지 확인 
					while(true) {
						if(visit[go]) {
							cnt++;
							break;
						} //이전에 방문한적이 없다면 
						visit[go] = true; 
						go = arr[go];
					}
				}
			}
			System.out.println(cnt);
		}
		br.close();
		
	}

}
