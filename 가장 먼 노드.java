// 문제 설명
// n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 
// 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 
// 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.

// 노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 
// 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.

//  제한사항
// 노드의 개수 n은 2 이상 20,000 이하입니다.
// 간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
// vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.

//                                             입출력 예
//       n	                                    vertex	                             return
//       6	          [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	        3

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];      // 인접 리스트로 그래프 생성
        int[] distances = new int[n + 1];                       // 시작 노드로부터의 최단 경로 저장
        boolean[] visited = new boolean[n + 1];                 // 방문 여부

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 생성
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        // BFS 수행
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 시작 노드는 1번
        visited[1] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distances[neighbor] = distances[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        int maxDistance = Arrays.stream(distances).max().getAsInt();
        int answer = (int) Arrays.stream(distances).filter(d -> d == maxDistance).count();
        return answer;
    }
}
