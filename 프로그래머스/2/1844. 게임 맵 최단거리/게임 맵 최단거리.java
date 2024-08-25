import java.util.*;

class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[][] vistied;

    static int result = -1;

    static int row,col;

    public class Node {
        int x;
        int y;
        int dist;

        Node(int x, int y, int dist) {
          this.x = x;
          this.y = y;
          this.dist = dist;
        }
    }

    public int solution(int[][] maps) {
        int answer = 0;

        row = maps.length;
        col = maps[0].length;

        vistied = new boolean[row][col];

        bfs(0, 0, maps);

        answer = result;

        return answer;
    }

    public void bfs(int a, int b, int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, b, 1));
        vistied[a][b] = true;

        while(!queue.isEmpty()) {
        Node node = queue.poll();

        if(node.x == maps.length -1 && node.y == maps[0].length - 1) {
            result = node.dist;
        }

            for(int i = 0; i < 4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];
                int nextDist = node.dist + 1;

                if(nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) continue;

                if(maps[nextX][nextY] == 0) continue;

                if(vistied[nextX][nextY]) continue;

                queue.add(new Node(nextX, nextY, nextDist));
                vistied[nextX][nextY] = true;

            }
        }
    }
}