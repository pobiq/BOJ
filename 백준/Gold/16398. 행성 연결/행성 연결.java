import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[] parent;

  static class Node implements Comparable<Node>{
    int to;
    int from;
    int weight;

    public Node(int to, int from, int weight) {
      this.to = to;
      this.from = from;
      this.weight = weight;
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

    long result = 0;

    N = Integer.parseInt(br.readLine());
    parent = new int[N];

    for(int i = 0; i < N; i++) {
      parent[i] = i;
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();

    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        int w = Integer.parseInt(st.nextToken());
        if(j > i) {
          pq.add(new Node(i, j, w));
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