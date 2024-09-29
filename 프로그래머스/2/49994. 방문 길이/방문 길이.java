import java.util.*;

class Solution {
  public class Node {
    int startX;
    int startY;
    int endX;
    int endY;

    Node(int startX, int startY, int endX, int endY) {
      this.startX = startX;
      this.startY = startY;
      this.endX = endX;
      this.endY = endY;
    }

    public String toString() {
      return "(" + startX + ", " + startY + ", " + endX + ", " + endY + ")";
    }

    @Override
    public boolean equals(Object obj) {
      if(this == obj) {
        return true;
      }
      if(obj == null) {
        return false;
      }
      if(getClass() != obj.getClass()) {
        return false;
      }
      Node node = (Node) obj;
      return this.startX == node.startX &&
          this.startY == node.startY &&
          this.endX == node.endX &&
          this.endY == node.endY;
    }

    @Override
    public int hashCode() {
      return Objects.hash(startX, startY, endX, endY);
    }
  }

  public int solution(String dirs) {
    HashSet<Node> hs = new HashSet<>();
    int x = 0;
    int y = 0;

    for(int i = 0; i < dirs.length(); i++) {
      char c = dirs.charAt(i);

      switch (c) {
        case 'U':
          if(x == -5) continue;
          hs.add(new Node(x-1, y, x, y));
          x -= 1;
          break;
        case 'D':
          if(x == 5) continue;
          hs.add(new Node(x, y, x+1, y));
          x += 1;
          break;
        case 'R':
          if(y == 5) continue;
          hs.add(new Node(x, y, x, y+1));
          y += 1;
          break;
        case 'L':
          if(y == -5) continue;
          hs.add(new Node(x, y-1, x, y));
          y -= 1;
          break;
      }
    }

    return hs.size();
  }
}