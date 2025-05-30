import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  static class Node implements Comparable<Node> {
    int P;
    int L;
    int G;

    public Node(int P, int L, int G) {
      this.P = P;
      this.L = L;
      this.G = G;
    }

    @Override
    public int compareTo(Node o) {
      if(this.L == o.L) {
        return this.P - o.P;
      }
      return this.L - o.L;
    }
    
    @Override
    public boolean equals(Object o) {
      if(o instanceof Node) {
        Node node = (Node) o;
        return this.P == node.P && this.L == node.L && this.G == node.G;
      }
      return false;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    TreeSet<Node> treeSet = new TreeSet<>();
    Map<Integer, TreeSet<Node>> treeSetMap = new HashMap<>();
    Map<Integer, int[]> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int P = Integer.parseInt(st.nextToken());
      int L = Integer.parseInt(st.nextToken());
      int G = Integer.parseInt(st.nextToken());

      treeSet.add(new Node(P, L, G));
      if(treeSetMap.containsKey(G)) {
        TreeSet<Node> temp = treeSetMap.get(G);
        temp.add(new Node(P, L, G));
        treeSetMap.replace(G, temp);
      } else {
        TreeSet<Node> temp = new TreeSet<>();
        temp.add(new Node(P, L, G));
        treeSetMap.put(G, temp);
      }
      map.put(P, new int[] {L, G});
    }

    int M = Integer.parseInt(br.readLine());

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      switch(command) {
        case "recommend":
          int G = Integer.parseInt(st.nextToken());
          int x = Integer.parseInt(st.nextToken());
          if(x > 0) {
            sb.append(treeSetMap.get(G).last().P).append("\n");
          } else {
            sb.append(treeSetMap.get(G).first().P).append("\n");
          }
          break;
        case "recommend2":
          int x2 = Integer.parseInt(st.nextToken());
          if(x2 > 0) {
            sb.append(treeSet.last().P).append("\n");
          } else {
            sb.append(treeSet.first().P).append("\n");
          }
        break;
        case "recommend3":
          int x3 = Integer.parseInt(st.nextToken());
          int L = Integer.parseInt(st.nextToken());
          if(x3 > 0) {
            if(treeSet.ceiling(new Node(0, L, 0)) == null) {
              sb.append("-1").append("\n");
            } else {
              sb.append(treeSet.ceiling(new Node(0, L, 0)).P).append("\n");
            }
          } else {
            if(treeSet.floor(new Node(0, L, 0)) == null) {
              sb.append("-1").append("\n");
            } else {
              sb.append(treeSet.floor(new Node(0, L, 0)).P).append("\n");
            }
          }
        break;
        case "add":
          int P2 = Integer.parseInt(st.nextToken());
          int L2 = Integer.parseInt(st.nextToken());
          int G2 = Integer.parseInt(st.nextToken());

          treeSet.add(new Node(P2, L2, G2));
          if(treeSetMap.containsKey(G2)) {
            TreeSet<Node> temp = treeSetMap.get(G2);
            temp.add(new Node(P2, L2, G2));
            treeSetMap.replace(G2, temp);
          } else {
            TreeSet<Node> temp = new TreeSet<>();
            temp.add(new Node(P2, L2, G2));
            treeSetMap.put(G2, temp);
          }
          map.put(P2, new int[] {L2, G2});
        break;
        case "solved":
          int P3 = Integer.parseInt(st.nextToken());
          int[] cur = map.get(P3);
          int L3 = cur[0];
          int G3 = cur[1];
          treeSet.remove(new Node(P3, L3, G3));
          treeSetMap.get(G3).remove(new Node(P3, L3, G3));
          map.remove(P3);
        break;
      }
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

}