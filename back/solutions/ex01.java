import java.util.*;
import java.io.*;

public class ex01 {
    static int N, M; //크기
    static char[][] map;
    static boolean[][][][] visited;
    static int holeX, holeB;
    static Marble blue, red;

    static int[] dx = {-1, }; //위 오른쪽 아래 왼쪽
    public static void main(String[] args) {


    }

}
class Marble{
  int rx;
  int ry;
  int bx;
  int by;
  int cnt;

  Marble(int rx, int ry, int bx, int by, int cnt){
      this.rx = rx;
      this.ry = ry;
      this.bx = bx;
      this.by = by;
      this.cnt = cnt;
  }
}