class Solution {
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        int[][][] map = new int[20000][100][100];

        int n = points.length;
        int m = routes.length;

        for(int i = 0; i < m; i++) {
          int time = 0;
          for(int j = 1; j < routes[i].length; j++) {
            int start = routes[i][j-1] - 1;
            int end = routes[i][j] - 1;
            int startX = points[start][0] - 1;
            int startY = points[start][1] - 1;
            int endX = points[end][0] - 1;
            int endY = points[end][1] - 1;

            while(true) {

              if(startX == endX && startY == endY) {
                break;
              }

              map[time][startX][startY]++;
              if(map[time][startX][startY] == 2) {
                answer++;
              }

              if(startX < endX) {
                startX++;
              } else if(startX > endX) {
                startX--;
              } else {
                if(startY < endY) {
                  startY++;
                } else if(startY > endY) {
                  startY--;
                }
              }
              time++;
            }

            if(j == routes[i].length - 1) {
              map[time][startX][startY]++;
              if(map[time][startX][startY] == 2) {
                answer++;
              }
            }
          }
        }
        
        return answer;
    }
}