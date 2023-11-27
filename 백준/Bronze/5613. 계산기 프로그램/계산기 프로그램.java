import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int result = Integer.parseInt(br.readLine());

        while(true) {

            String sign = br.readLine();

            if(sign.equals("=")) break;

            int a = Integer.parseInt(br.readLine());

            if (sign.equals("+")) {
                result += a;
            } else if (sign.equals("-")) {
                result -= a;
            } else if (sign.equals("*")) {
                result *= a;
            } else if (sign.equals("/")) {
                result /= a;
            }
        }

        sb.append(result);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}