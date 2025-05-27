import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    double score = 0.0;
    double totalScore = 0;

    for (int i = 0; i < 20; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String lecture = st.nextToken();
      double s = Double.parseDouble(st.nextToken());
      String grade = st.nextToken();

      switch (grade) {
        case "A+":
          score += s * 4.5;
          totalScore += s;
          break;
        case "A0":
          score += s * 4.0;
          totalScore += s;
          break;
        case "B+":
          score += s * 3.5;
          totalScore += s;
          break;
        case "B0":
          score += s * 3.0;
          totalScore += s;
          break;
        case "C+":
          score += s * 2.5;
          totalScore += s;
          break;
        case "C0":
          score += s * 2.0;
          totalScore += s;
          break;
        case "D+":
          score += s * 1.5;
          totalScore += s;
          break;
        case "D0":
          score += s * 1.0;
          totalScore += s;
          break;
        case "F":
          score += s * 0.0;
          totalScore += s;
          break;
        case "P":
          break;
      }
    }

    sb.append(score / totalScore);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}