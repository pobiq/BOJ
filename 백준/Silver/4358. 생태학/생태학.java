import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    TreeMap<String, Integer> map = new TreeMap<>();
    String s;

    int total = 0;
    while((s = br.readLine()) != null) {
      total++;
      map.put(s, map.getOrDefault(s, 0) + 1);
    }

    for(Map.Entry<String, Integer> entry : map.entrySet()) {
      sb.append(entry.getKey() + " " + String.format("%.4f", (double) entry.getValue() / total * 100) + "\n");
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}