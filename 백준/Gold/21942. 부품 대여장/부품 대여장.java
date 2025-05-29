import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

  static class Node {
    String M;
    long fee;

    public Node(String M, long fee) {
      this.M = M;
      this.fee = fee;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    String L = st.nextToken();
    int F = Integer.parseInt(st.nextToken());
    Map<String, LocalDateTime> map = new HashMap<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    String[] LArr1 = L.split("[/:]");

    long rentalPeriod = Integer.parseInt(LArr1[0]) * 60 * 24 + Integer.parseInt(LArr1[1]) * 60 + Integer.parseInt(LArr1[2]);

    TreeMap<String, Long> answer = new TreeMap<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String date = st.nextToken();
      String time = st.nextToken();
      String P = st.nextToken();
      String M = st.nextToken();

      String key = P + " " + M;

      if (map.containsKey(key)) {
        LocalDateTime prevTime = map.get(key);
        long diff = ChronoUnit.MINUTES.between(prevTime, LocalDateTime.parse(date + " " + time, formatter));
        if (diff > rentalPeriod) {
          if(answer.containsKey(M)) {
            answer.put(M, answer.get(M) + ((diff - rentalPeriod) * F));
          } else {
            answer.put(M, ((diff - rentalPeriod) * F));
          }
        }
        map.remove(key);
      } else {
        map.put(key, LocalDateTime.parse(date + " " + time, formatter));
      }
    }

    
    if(answer.isEmpty()) {
      sb.append("-1");
    } else {
      for (Map.Entry<String, Long> entry : answer.entrySet()) {
        sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
      }
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

}