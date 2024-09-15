import java.util.*;

public class Solution {

  class Node {
    long x;
    long y;
    Node(long x, long y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "(" + x + " " + y + ")";
    }
  }

  HashSet<Node> point = new HashSet<>();

  int row = 0;
  int col = 0;

  long left = Long.MAX_VALUE;
  long right = Long.MIN_VALUE;
  long bottom = Long.MAX_VALUE;
  long top = Long.MIN_VALUE;

  public String[] solution(int[][] line) {
    String[] answer = {};

    row = line.length;
    col = line[0].length;

    getPoint(line);
    int arraySize = (int)(top - bottom) + 1;
    int width = (int)(right - left) + 1;

    answer = new String[arraySize];
    StringBuilder sb = new StringBuilder();

    for(int j = 0; j < width; j++) {
      sb.append(".");
    }

    Arrays.fill(answer, sb.toString());

    for(Node node : point) {
      sb.delete(0, sb.length());
      long x = node.x - bottom;
      long y = node.y - left;
      int index = (arraySize-1) - (int)x;
      String prev = answer[index];
      sb.append(prev, 0, (int)y);
      sb.append("*");
      sb.append(prev.substring((int)y+1));
      answer[index] = sb.toString();
    }

    return answer;
  }

  private void getPoint(int[][] line) {

    for(int i = 0; i < row; i++) {
      int[] firstLine = line[i];
      long A = firstLine[0];
      long B = firstLine[1];
      long E = firstLine[2];
      for(int j = i+1; j < row; j++) {
        int[] secondLine = line[j];
        long C = secondLine[0];
        long D = secondLine[1];
        long F = secondLine[2];

        long ADBC = A*D - B*C;
        if(ADBC == 0) continue;

        long BFED = B*F - E*D;
        if(BFED % ADBC != 0) continue;

        long ECAF = E*C - A*F;
        if(ECAF % ADBC != 0) continue;

        long x = BFED / ADBC;
        long y = ECAF / ADBC;

        point.add(new Node(y, x));

        left = Math.min(left, x);
        right = Math.max(right, x);
        bottom = Math.min(bottom, y);
        top = Math.max(top, y);

      }
    }
  }

}