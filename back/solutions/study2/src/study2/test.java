package study2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			int num = Integer.parseInt(br.readLine());
			int [] arr = new int[num+1];
			boolean [] visit = new boolean[num+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			// 값 세팅 완료
			// 1 2 3 4 5 6 7 8 
			// 3 2 7 8 1 4 5 6 
			int cnt = 0;
			for(int i = 1; i<arr.length; i++) {
				if(!visit[i]) {
					visit[i] = true;
					int go = arr[i];
					while(true) {
						if(visit[go]) {
							visit[go]=true;
							cnt++;
							break;
						} //방문한적이 없다면 
						visit[go] = true;
						go = arr[go];
					}
				}
			}
			System.out.println(cnt);
		}br.close();
	}
}
