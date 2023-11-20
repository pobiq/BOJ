import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] count = new int[20];

        long result = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            int index = 0;
            while(number > 0) {
                if (number % 2 == 1) {
                    count[index]++;
                }
                number /= 2;
                index++;
            }
        }

        for (int i = 0; i < 20; i++) {
            result += (1L << i) * count[i] * (n - count[i]);
        }

        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}