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
        
        String S = br.readLine();
        int n = S.length();

        int length = 1;

        for (int i = 0; i < n - 1; i++) {
            int left = i;
            int right = n - 1;

            boolean flag = true;
            while (left <= right) {
                if(S.charAt(left) != S.charAt(right)) {
                    flag = false;
                    break;
                }
                left++;
                right--;
            }

            if (flag) {
                length = n - 1 - i + 1;
                break;
            }
        }

        sb.append(length + (n - length) * 2);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}