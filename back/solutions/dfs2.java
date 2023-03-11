import java.util.Deque;
import java.util.LinkedList;

public class dfs2 {
    public static void main(String[] args) {
        int [][]graph = {{},
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

        //정의된 DFS함수 호출
        dfs2 dfs = new dfs2();
        dfs.dfsTest(graph, 1, visited);
    }

    private void dfsTest(int[][] graph, int start, boolean[] visited) {
        //시작노드 방문처리
        visited[start] = true;
        System.out.print(start + " "); //방문한 노드 출력

        Deque<Integer> stack = new LinkedList<>();

        stack.push(start); //시작 노드 스택에 입력

        while (!stack.isEmpty()) {
            int now = stack.peek();

            boolean hasNearNode = false;//방문하지 않은 인접 노드가 있는지 확인
            //인접 노드를 방문하지 않았을 경우 스택에 넣고 방문처리함
            for(int i : graph[now]){
                if(!visited[i]){
                    hasNearNode = true;
                    stack.push(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                    break;
                }
            }

            if (hasNearNode == false) {
                stack.pop();
            }
        }
    }
}
