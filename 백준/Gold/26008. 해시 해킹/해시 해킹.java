import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        int h = Integer.parseInt(br.readLine());
        long result = 1;


        for (int i = 0; i < n-1; i++) {
            result = (result * m) % 1000000007;
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}