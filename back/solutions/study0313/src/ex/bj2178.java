package ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2178 {

	static int N, M, cnt;	
	static boolean[][] visited;
	static int[][] arr;
	
	//이동좌표 우 왼 하 상
	static int[] moveX = {0, 0, 1, -1};
	static int[] moveY = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			char[] ch = str.toCharArray(); // 문자열 받아서 문자배열로 반환
			for (int j = 0; j < ch.length; j++) {
				arr[i][j] = Character.getNumericValue(ch[j]); //받은 문자를 char타입으로 변환
			}
		}
		visited[0][0] = true; // 출발지 항상 0,0임
		bfs(0, 0); //시작
		
		System.out.println(arr[N-1][M-1]);

	}

	public static void bfs(int x, int y) {
		Queue<spot> q = new LinkedList<>();
		q.add(new spot(x, y));
		while(!q.isEmpty()) {
			spot s = q.poll();
			for(int i = 0; i<4; i++) {
				int nextX = s.x + moveX[i];
				int nextY = s.y + moveY[i];
				// 이동할 칸이 0으로 막혀있거나 범위에서 벗어나는 경
				if(nextX < 0 || nextY <0 || nextX>= N || nextY >=M) {
					continue;
				}
				
				//방문한적이 있거나, 0으로 막혀있는 경
				if(visited[nextX][nextY]||arr[nextX][nextY] == 0) {
					continue;
				}
				q.add(new spot(nextX, nextY));
				arr[nextX][nextY] = arr[s.x][s.y] + 1; //0부터 시작했으니 +1 해주기 
				visited[nextX][nextY] = true;
				
				
			}
		}
	}
}

class spot {
	int x;
	int y;
	
	spot(int x, int y){
		this.x = x;
		this.y = y;
	}
}
