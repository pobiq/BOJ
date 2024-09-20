import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  static int V, E;
  static int start;
  static ArrayList<Node>[] graph;
  static int[] dist;

  static class Node {
    int index;
    int cost;

    Node(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }

    @Override
    public String toString() {
      return "(" + this.index + ", " + this.cost + ")";
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();

    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(br.readLine());
    graph = new ArrayList[V + 1];
    dist = new int[V + 1];

    // graph 초기화
    for(int i = 0; i <= V; i++) {
      graph[i] = new ArrayList<>();
    }

    // dist 초기화
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    for(int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph[u].add(new Node(v, w));
    }

    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    pq.offer(new Node(start, 0));

    while(!pq.isEmpty()) {
      Node cur = pq.poll();
      int curIndex = cur.index;
      int curCost = cur.cost;

      if(dist[curIndex] < curCost) continue;

      for(int i = 0; i < graph[curIndex].size(); i++) {
        Node next = graph[curIndex].get(i);
        int nextIndex = next.index;
        int nextCost = next.cost;

        if(dist[nextIndex] > curCost + nextCost) {
          dist[nextIndex] = curCost + nextCost;
          pq.offer(new Node(nextIndex, dist[nextIndex]));
        }
      }
    }

    for(int i = 1; i <= V; i++) {
      if(dist[i] == Integer.MAX_VALUE) {
        System.out.println("INF");
      } else {
        System.out.println(dist[i]);
      }
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}