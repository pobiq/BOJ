import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {

    static class Node {
        int left;
        int right;
        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return this.left + " " + this.right;
        }
    }

    static List<Node> nodes = new ArrayList<>();
    static List<String> results = new ArrayList<>();
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        s = br.readLine();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.add(i);
            } else if(c == ')') {
                int left = stack.pop();
                int right = i;
                nodes.add(new Node(left, right));
            }
        }

        for(int i = 1; i <= nodes.size(); i++) {
            combination(new int[i], 0, 0, i);
        }

        results.sort(Comparator.naturalOrder());

        for(String result : results) {
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void combination(int[] arr, int start, int count, int r) {
        if(count == r) {
            print(arr);
            return;
        }

        for(int i = start; i < nodes.size(); i++) {
            arr[count] = i;
            combination(arr, i + 1, count + 1, r);
        }
    }

    static void print(int[] arr) {
        PriorityQueue<Integer> blankList = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++) {
            Node node = nodes.get(arr[i]);
            blankList.add(node.left);
            blankList.add(node.right);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            
            if(blankList.isEmpty()) {
                sb.append(s.charAt(i));
            } else {
                if(blankList.peek() == i) {
                    blankList.poll();
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }

        if(!results.contains(sb.toString())) {
            results.add(sb.toString());
        }
    }
}