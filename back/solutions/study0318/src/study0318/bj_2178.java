package study0318;
import java.util.*;
import java.io.*;
public class bj_2178 {
	static int [][]arr;
	static boolean [][]visit;
	static int []X = {-1,1,0,0};
	static int []Y = {0,0,-1,1};
	static int N, M;
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int [N][M];
		visit = new boolean [N][M];
		
		for(int i = 0 ; i<N; i++) {
			String s = br.readLine();
			char []c = s.toCharArray();
			
			for(int j = 0; j<c.length; j++) {
				arr[i][j] = Character.getNumericValue(c[j]);
			}
		}
		
		
		bfs(0,0);
		System.out.println(arr[N-1][M-1]);
	}
	private static void bfs(int i, int j) {
		Queue<posi> q = new LinkedList<>();
		visit[0][0] = true;

		q.add(new posi(i,j));
		
		while(!q.isEmpty()) {
			posi p = q.poll();
			for(int k = 0 ; k<4 ;k++) {
				int nextX = p.x + X[k];
				int nextY = p.y + Y[k];
				
				if(nextX<0||nextY<0|| nextX>=N || nextY>=M) {
					continue;
				}
				if(visit[nextX][nextY] || arr[nextX][nextY] == 0) {
					continue;
				}
				
				
				visit[nextX][nextY] = true;
				arr[nextX][nextY] = arr[p.x][p.y] + 1;
				q.add(new posi(nextX, nextY));
			}
			
		}
	}
	
}
class posi{
	int x;
	int y;
	
		posi(int x, int y){
			this.x = x;
			this.y = y;
		}
}
