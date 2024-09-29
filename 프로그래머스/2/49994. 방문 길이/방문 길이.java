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
    int startX = 0;
    int startY = 0;
    int endX = 0;
    int endY = 0;

    for(int i = 0; i < dirs.length(); i++) {
      startX = endX;
      startY = endY;
      char c = dirs.charAt(i);

      switch (c) {
        case 'U':
          if(startX == -5) continue;
          endX -= 1;
          break;
        case 'D':
          if(startX == 5) continue;
          endX += 1;
          break;
        case 'R':
          if(startY == 5) continue;
          endY += 1;
          break;
        case 'L':
          if(startY == -5) continue;
          endY -= 1;
          break;
      }

      Node temp = new Node(endX, endY, startX, startY);
      if(hs.contains(temp)) continue;

      hs.add(new Node(startX, startY, endX, endY));
    }

    return hs.size();
  }
}