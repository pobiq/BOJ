import java.io.*;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        Deque<Integer> deque = new LinkedList<>();
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(x == deque.peekFirst()) {
                deque.pollFirst();
            } else {
                Deque<Integer> case1 = new LinkedList<>();
                Deque<Integer> case2 = new LinkedList<>();

                while(!deque.isEmpty()) {
                    int y = deque.pollFirst();
                    case1.add(y);
                    case2.add(y);
                }

                int left = 0;
                int right = 0;

                while(case1.peekFirst() != x) {
                    left++;
                    case1.addLast(case1.pollFirst());
                }

                while(case2.peekFirst() != x) {
                    right++;
                    case2.addFirst(case2.pollLast());
                }

                if(left <= right) {
                    result += left;
                    case1.pollFirst();
                    deque = case1;
                } else {
                    result += right;
                    case2.pollFirst();
                    deque = case2;
                }

            }
        }


        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}