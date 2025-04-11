import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static int n = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();

    n = Integer.parseInt(br.readLine());

    dfs(0, 0);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static void dfs(int number, int depth) {
    if(depth == n) {
      System.out.println(number);
      return;
    }

    for(int i = 1; i <= 9; i++) {
      int nextNumber = number * 10 + i;
      if(isPrime(nextNumber)) {
        dfs(nextNumber, depth+1);
      }
    }
  }

  private static boolean isPrime(int nextNumber) {
    if(nextNumber < 2) return false;
    for (int i = 2; i*i <= nextNumber; i++) {
      if(nextNumber % i == 0) {
        return false;
      }
    }
    return true;
  }

}