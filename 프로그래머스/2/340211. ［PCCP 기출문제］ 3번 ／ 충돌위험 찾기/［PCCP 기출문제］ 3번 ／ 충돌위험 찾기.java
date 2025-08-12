import java.util.HashMap;

class Solution {
    public class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true; // 같은 객체면 true
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y && time == node.time;
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(x, y, time);
        }
        
    }

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        HashMap<Node, Integer> hm = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            int time = 0;
            for (int j = 1; j < routes[i].length; j++) {
                int start = routes[i][j - 1] - 1;
                int end = routes[i][j] - 1;
                int startX = points[start][0] - 1;
                int startY = points[start][1] - 1;
                int endX = points[end][0] - 1;
                int endY = points[end][1] - 1;

                while (true) {

                    if (startX == endX && startY == endY) {
                        break;
                    }

                    Node now = new Node(startX, startY, time);

                    hm.put(now, hm.getOrDefault(now, 0) + 1);

                    if (startX < endX) {
                        startX++;
                    } else if (startX > endX) {
                        startX--;
                    } else {
                        if (startY < endY) {
                            startY++;
                        } else if (startY > endY) {
                            startY--;
                        }
                    }
                    time++;
                }

                Node now = new Node(startX, startY, time);


                if (j == routes[i].length - 1) {
                    hm.put(now, hm.getOrDefault(now, 0) + 1);
                }
            }
        }

        for (int value : hm.values()) {
            if(value >= 2) {
                answer++;
            }
        }

        return answer;
    }
}