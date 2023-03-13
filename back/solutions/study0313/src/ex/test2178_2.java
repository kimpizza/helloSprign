package ex;


import java.util.*;
import java.io.*;

public class test2178_2 {
	static StringBuilder sb = new StringBuilder();
	static int [] moveX = {-1,1,0,0};
	static int [] moveY = {0,0,-1,1};
	static int N, M;
	static int [][] arr;
	static boolean [][] bool;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		bool = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			char[] c = str.toCharArray();
			
			for(int j = 0; j < c.length; j++) {
				arr[i][j] = Character.getNumericValue(c[j]);
			}
		}
		bool[0][0] = true;
		start(0,0);
		System.out.println(arr[N-1][M-1]);
	}


	private static void start(int x, int y) {
		Queue<spot2> q = new LinkedList<>();
		q.add(new spot2(x,y));
		
		while(!q.isEmpty()) {
			spot2 s = q.poll();
			
			for(int i = 0 ;i<4; i++) {
				int nextX = s.x + moveX[i];
				int nextY = s.y + moveY[i];
				
				if(nextX < 0||nextY<0 || nextX>=N|| nextY>=M) {
					continue;
				}
				if(arr[nextX][nextY] == 0 || bool[nextX][nextY]) {
					continue;
				}
				q.add(new spot2(nextX, nextY));
				bool[nextX][nextY] = true;
				arr[nextX][nextY] = arr[s.x][s.y] + 1;
				
			}
		}
	}

}
class spot2{ //다음 이동할 좌표값 기억 
	int x;
	int y;
	
	spot2(int x, int y){
		this.x = x;
		this.y = y;
	}
}
