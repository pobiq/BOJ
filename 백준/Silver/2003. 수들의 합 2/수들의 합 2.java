import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] array = new int[n];

        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int start = -1;
        int end = -1;
        int sum = 0;

        while (true) {
            if (sum == m) {
                result++;
                sum -= array[++start];
            } else if (sum < m) {
                if (end == n-1) break;
                sum += array[++end];
            } else {
                sum -= array[++start];
            }
        }

        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}