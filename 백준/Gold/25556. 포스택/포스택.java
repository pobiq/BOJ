import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static boolean isStackAdd(Stack<Integer> stack, int number) {

        if(stack.isEmpty()) {
            return true;
        } else {
            if(stack.peek() < number) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        boolean isSort = true;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());

            if(isStackAdd(stack1, number)) {
                stack1.add(number);
                continue;
            } else if(isStackAdd(stack2, number)) {
                stack2.add(number);
                continue;
            } else if(isStackAdd(stack3, number)) {
                stack3.add(number);
                continue;
            } else if(isStackAdd(stack4, number)) {
                stack4.add(number);
                continue;
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