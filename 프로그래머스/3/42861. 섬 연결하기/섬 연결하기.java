import java.util.*;

class Solution {
  static int V, E;
  static int[] parent;

  static class Node implements Comparable<Node>{
    int to;
    int from;
    int weight;

    Node(int to, int from, int weight) {
      this.to = to;
      this.from = from;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
      return this.weight - o.weight;
    }
  }

  public int solution(int n, int[][] costs) {
    int answer = 0;

    parent = new int[n];

    for(int i = 0; i < n; i++) {
      parent[i] = i;
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();

    for(int[] cost : costs) {
      pq.add(new Node(cost[0], cost[1], cost[2]));
    }

    while(!pq.isEmpty()) {
      Node node = pq.poll();

      if(!isSameParent(node.to, node.from)) {
        answer += node.weight;
        union(node.to, node.from);
      }
    }

    return answer;
  }

  private static boolean isSameParent(int to, int from) {
    int x = find(to);
    int y = find(from);
    return x == y;
  }

  private static int find(int number) {
    if(parent[number] == number) return number;
    return parent[number] = find(parent[number]);
  }

  private static void union(int to, int from) {
    int x = find(to);
    int y = find(from);
    if(x != y) {
      parent[y] = x;
    }
  }
}