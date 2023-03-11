import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    public static void main(String[] args) {
        //각 노드가 연결된 정보를 2차원 배열로 표현
        int[][]graph = {{},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}};

        //각 노드가 방문한 정보를 1차원 배열 자료형으로 표현
        boolean[] visited = {false, false, false, false, false, false, false, false, false};

        int start = 1; //시작노드
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        //큐가 빌때까지 반복
        while (!queue.isEmpty()) {
            //큐에서 하나의 원소를 뽑아서 출력
            int v = queue.poll();
            System.out.print(v + " ");

            //인접 노드 중 아직 방문하지 않은 원소들을 큐에 삽입
            for (int i : graph[v]){
                if(visited[i] == false){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
