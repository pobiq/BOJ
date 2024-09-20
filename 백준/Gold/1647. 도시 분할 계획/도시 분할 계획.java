import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int V, E;

  static long result = 0;

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
    public String toString() {
      return "(" + this.to + ", " + this.from + ", " + this.weight + ")";
    }

    @Override
    public int compareTo(Node o) {
      return this.weight - o.weight;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();

    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    parent = new int[V + 1];

    for(int i = 1; i <= V; i++) {
      parent[i] = i;
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();

    for(int i = 1; i <= E; i++) {
      st = new StringTokenizer(br.readLine());
      int to = Integer.parseInt(st.nextToken());
      int from = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      pq.offer(new Node(to, from, weight));
    }

    int maxWeight = 0;

    while(!pq.isEmpty()) {
      Node cur = pq.poll();

      if(!isSameParent(cur.to, cur.from)) {
        result += cur.weight;
        maxWeight = cur.weight;
        union(cur.to, cur.from);
      }
    }

    result -= maxWeight;

    sb.append(result);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
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
      if(x < y) {
        parent[y] = x;
      } else {
        parent[x] = y;
      }
    }
  }
}