class Solution {
    public int solution(String[] board) {
    int answer = 0;

    answer = isExist(board);

    return answer;
  }

  private int isExist(String[] board) {
    int oCount = 0;
    int xCount = 0;

    char[][] graph = new char[3][3];

    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        if(board[i].charAt(j) == 'O') {
          oCount++;
        } else if(board[i].charAt(j) == 'X') {
          xCount++;
        }
        graph[i][j] = board[i].charAt(j);
      }
    }

    if(bingo(graph, 'O') && bingo(graph, 'X')) return 0;

    if(bingo(graph, 'O')) {
      if(oCount - xCount == 1) {
        return 1;
      } else {
        return 0;
      }
    }

    if(bingo(graph, 'X')) {
      if(oCount == xCount) {
        return 1;
      } else {
        return 0;
      }
    }

    if(oCount > xCount) {
      if(oCount - xCount == 1) {
        return 1;
      } else {
        return 0;
      }
    } else if(oCount == xCount) {
      return 1;
    } else {
      return 0;
    }

  }

  private boolean bingo(char[][] graph, char text) {

    for(int i = 0; i < 3; i++) {
      if(graph[i][0] == text && graph[i][1] == text && graph[i][2] == text) {
        return true;
      }
    }

    for(int j = 0; j < 3; j++) {
      if(graph[0][j] == text && graph[1][j] == text && graph[2][j] == text) {
        return true;
      }
    }

    if(graph[0][0] == text && graph[1][1] == text && graph[2][2] == text) {
      return true;
    }

    if(graph[2][0] == text && graph[1][1] == text && graph[0][2] == text) {
      return true;
    }

    return false;
  }
}