// https://school.programmers.co.kr/learn/courses/30/lessons/1844

// 난 BFS를 언제쯤 잘할까 ?
import java.util.*;

class Solution {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {-1, 1, 0, 0};
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visit = new int[maps.length][maps[0].length];
        visit[0][0] = 1;
        
        bfs(maps, visit);
        answer = visit[maps.length - 1][maps[0].length - 1];
        
        if (answer == 0) {
            answer = -1;
        }
        
        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visit) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length 
                    && visit[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visit[nx][ny] = visit[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
