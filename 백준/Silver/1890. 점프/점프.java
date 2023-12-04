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

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (map[i][j] == 0) continue;

                int jump = map[i][j];
                if (i + jump < n) {
                    dp[i + jump][j] += dp[i][j];
                }

                if (j + jump < n) {
                    dp[i][j + jump] += dp[i][j];
                }
            }
        }

        sb.append(dp[n-1][n-1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}