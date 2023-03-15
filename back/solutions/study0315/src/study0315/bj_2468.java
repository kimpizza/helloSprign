package study0315;
import java.util.*;
import java.io.*;
public class bj_2468 {
	static int N, result = 0;
	static int[][] arr ;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		// 지형의 최대 높이
		int max = 0;
		int cnt = 0;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				max = max < arr[i][j]? arr[i][j] : max;
				
			}
		}
		for(int k=0; k<max; k++) {
            visit = new boolean[N][N];
            cnt = 0;
            for(int x=0; x<N; x++) {
                for(int y=0; y<N; y++) {
                    if(arr[x][y] > k && !visit[x][y]) {
                        bfs(x,y,k);
                        cnt++;
                    }
                }
            }
            result = result < cnt ? cnt : result;
        }
 
        System.out.println(result);
    }
 
    private static void bfs(int x, int y, int target) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {x, y});
        visit[x][y] = true;
 
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int curX = data[0];
            int curY = data[1];
 
             for(int i=0; i<4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
 
                if(nextX >=0 && nextY >=0 && nextX < N && nextY < N) {
                    if(!visit[nextX][nextY] && arr[nextX][nextY] > target) {
                        visit[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}
 