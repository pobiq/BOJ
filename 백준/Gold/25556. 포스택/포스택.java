import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        boolean isSort = true;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(stack1.isEmpty()) {
                stack1.add(number);
                continue;
            } else {
                if(stack1.peek() < number) {
                    stack1.add(number);
                    continue;
                }
            }

            if(stack2.isEmpty()) {
                stack2.add(number);
                continue;
            } else {
                if(stack2.peek() < number) {
                    stack2.add(number);
                    continue;
                }
            }

            if(stack3.isEmpty()) {
                stack3.add(number);
                continue;
            } else {
                if(stack3.peek() < number) {
                    stack3.add(number);
                    continue;
                }
            }

            if(stack4.isEmpty()) {
                stack4.add(number);
                continue;
            } else {
                if(stack4.peek() < number) {
                    stack4.add(number);
                    continue;
                }
            }

            isSort = false;

        }

        if(isSort) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}