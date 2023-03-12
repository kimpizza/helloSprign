import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13460 {

    static int N, M; //크기
    static char[][] map;
    static boolean[][][][] visited;
    static int holeX, holeY;
    static Marble blue, red;

    static int[] dx = {-1, 0, 1, 0}; //위 오른쪽 아래 왼쪽
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        //구출 map 구성
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                } else if (map[i][j] == 'B') {
                    blue = new Marble(0, 0, i, j, 0);
                } else if (map[i][j] == 'R') {
                    red = new Marble(i, j, 0, 0, 0);
                }
            }
        }

        System.out.println(bfs());
        br.close();
    }

    public static int bfs() {
        Queue<Marble> queue = new LinkedList<>();
        queue.add(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
        visited[red.rx][red.ry][blue.bx][blue.by] = true;

        while (!queue.isEmpty()) {
            Marble marble = queue.poll();

            int curRx = marble.rx;
            int curRy = marble.ry;
            int curBx = marble.bx;
            int curBy = marble.by;
            int curCnt = marble.cnt;

            if (curCnt > 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int newRx = curRx;
            }
        }
        return 0;
    }
}


class Marble {
    int rx;
    int ry;
    int bx;
    int by;
    int cnt;

    Marble(int rx, int ry, int bx, int by, int cnt) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}
