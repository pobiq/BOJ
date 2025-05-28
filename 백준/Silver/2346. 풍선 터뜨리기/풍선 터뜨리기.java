import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  static class Node {
    int value;
    int index;

    public Node(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    Deque<Node> deque = new ArrayDeque<>();

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      deque.add(new Node(Integer.parseInt(st.nextToken()), i + 1));
    }

    while(deque.size() > 1) {
      Node node = deque.pollFirst();
      sb.append(node.index).append(" ");
      int value = node.value;

      if(value > 0) {
        for (int i = 0; i < value - 1; i++) {
          deque.addLast(deque.pollFirst());
        }
      } else {
        for (int i = 0; i < Math.abs(value); i++) {
          deque.addFirst(deque.pollLast());
        }
      }
    }

    sb.append(deque.pollFirst().index);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}