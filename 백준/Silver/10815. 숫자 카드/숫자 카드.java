import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = n-1;
            boolean flag = false;

            while (left <= right) {
                int mid = (left + right) / 2;

                if(array[mid] == number) {
                    flag = true;
                    break;
                } else if(array[mid] > number) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if(flag) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append(" ");
        }



        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}