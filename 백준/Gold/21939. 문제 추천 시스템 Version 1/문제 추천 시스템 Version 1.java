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

        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        HashMap<Integer, Integer> recommendList = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            TreeSet<Integer> set = map.getOrDefault(l, new TreeSet<>());
            set.add(p);
            map.put(l, set);
            recommendList.put(p, l);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            switch(command) {
                case "recommend":
                    int x = Integer.parseInt(st.nextToken());
                    if(x == 1) {
                        int level = map.lastKey();
                        TreeSet<Integer> set = map.get(level);
                        sb.append(set.last()).append("\n");
                    } else {
                        int level = map.firstKey();
                        TreeSet<Integer> set = map.get(level);
                        sb.append(set.first()).append("\n");
                    }
                    break;
                case "add":
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    TreeSet<Integer> set = map.getOrDefault(l, new TreeSet<>());
                    set.add(p);
                    map.put(l, set);
                    recommendList.put(p, l);
                    break;
                case "solved":
                    int number1 = Integer.parseInt(st.nextToken());
                    int level1 = recommendList.get(number1);
                    recommendList.remove(number1);
                    TreeSet<Integer> temp = map.get(level1);
                    temp.remove(Integer.valueOf(number1));
                    if(temp.isEmpty()) {
                        map.remove(level1);
                    } else {
                        map.put(level1, temp);
                    }
                    break;
            }
        }
        
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}