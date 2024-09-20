import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static boolean[] visited;
  static ArrayList<Node>[] graph;

  static class Node implements Comparable<Node>{
    int from;
    int weight;

    public Node(int from, int weight) {
      this.from = from;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
      return this.weight - o.weight;
    }
  }

  static long result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();



    N = Integer.parseInt(br.readLine());
    graph = new ArrayList[N];
    visited = new boolean[N];

    for(int i = 0; i < N; i++) {
      graph[i] = new ArrayList<>();
    }

    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        int w = Integer.parseInt(st.nextToken());
        if(i == j) continue;
        graph[i].add(new Node(j, w));
      }
    }

    prim(0);

    sb.append(result);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static void prim(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));

    while(!pq.isEmpty()) {
      Node cur = pq.poll();
      if(visited[cur.from]) continue;
      visited[cur.from] = true;
      result += cur.weight;

      for(Node next : graph[cur.from]) {
        if(!visited[next.from]) {
          pq.add(new Node(next.from, next.weight));
        }
      }
    }
  }

}