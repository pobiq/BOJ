import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int V;
  static int[] parent;

  static int result = 0;

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

    @Override
    public String toString() {
      return "(" + this.to + ", " + this.from + ", " + this.weight + ")";
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();

    V = Integer.parseInt(br.readLine());
    parent = new int[V + 1];

    PriorityQueue<Node> pq = new PriorityQueue<>();

    for(int i = 1; i <= V; i++) {
      parent[i] = i;
    }

    for(int i = 1; i <= V; i++) {
      int expense = Integer.parseInt(br.readLine());
      pq.add(new Node(0, i, expense));
    }

    for(int i = 1; i <= V; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 1; j <= V; j++) {
        int expense = Integer.parseInt(st.nextToken());
        if(j > i) {
          pq.add(new Node(i, j, expense));
        }
      }
    }

    while(!pq.isEmpty()) {
      Node cur = pq.poll();

      if(!isSameParent(cur.to, cur.from)) {
        result += cur.weight;
        union(cur.to, cur.from);
      }
    }

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
      parent[y] = x;
    }
  }

}