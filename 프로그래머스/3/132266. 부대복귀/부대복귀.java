import java.util.*;

class Solution {
  static ArrayList<Node>[] graph;

  static int W, E;

  static int[] dist;

  static class Node implements Comparable<Node>{
    int from;
    int dist;

    Node(int from, int dist) {
      this.from = from;
      this.dist = dist;
    }

    public String toString() {
      return "(" + from + ", " + dist + ")";
    }

    @Override
    public int compareTo(Node o) {
      return this.dist - o.dist;
    }
  }

  public int[] solution(int n, int[][] roads, int[] sources, int destination) {
    int[] answer = {};

    graph = new ArrayList[n];
    dist = new int[n];

    for(int i = 0; i < n; i++) {
      dist[i] = Integer.MAX_VALUE;
    }

    for(int i = 0; i < n; i++) {
      graph[i] = new ArrayList<Node>();
    }

    for(int[] road : roads) {
      int x = road[0] - 1;
      int y = road[1] - 1;
      graph[x].add(new Node(y, 1));
      graph[y].add(new Node(x, 1));
    }

    dijkstra(destination - 1);

    answer = new int[sources.length];

    for(int i = 0; i < sources.length; i++) {
      answer[i] = dist[sources[i]-1] == Integer.MAX_VALUE ? -1 : dist[sources[i]-1];
    }

    return answer;
  }

  private void dijkstra(int destination) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(destination, 0));
    dist[destination] = 0;

    while(!pq.isEmpty()) {
      Node cur = pq.poll();

      if(dist[cur.from] < cur.dist) continue;

      for(Node next : graph[cur.from]) {
        if(dist[next.from] > cur.dist + next.dist) {
          dist[next.from] = cur.dist + next.dist;
          pq.add(new Node(next.from, dist[next.from]));
        }
      }
    }
  }
}