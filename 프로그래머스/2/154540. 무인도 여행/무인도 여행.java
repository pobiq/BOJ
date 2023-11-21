import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] matrix;
    static ArrayList<Integer> list = new ArrayList<>();
    static int row = 0;
    static int col = 0;
    
    public static class Node {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
    
    static public void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        
        int value = 0;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            value += Character.getNumericValue(matrix[node.x][node.y]);
            
            for (int i = 0; i < 4; i++) {
                int xx = node.x + dx[i];
                int yy = node.y + dy[i];
                
                if (xx < 0 || xx >= row || yy < 0 || yy >= col || matrix[xx][yy] == 'X') {
                    continue;
                }
                
                if(visited[xx][yy]) continue;
                
                visited[xx][yy] = true;
                queue.add(new Node(xx, yy));
                
            }
            
        }
        
        list.add(value);
        
    }
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        row = maps.length;
        col = maps[0].length();
        visited = new boolean[row][col];
        
        matrix = new char[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = maps[i].charAt(j);
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && matrix[i][j] != 'X') {
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }
        
        if (list.size() == 0) {
            answer = new int[]{-1};
        } else {
            answer = list.stream().sorted().mapToInt(Integer::intValue).toArray();
        }
        
        return answer;
    }
}