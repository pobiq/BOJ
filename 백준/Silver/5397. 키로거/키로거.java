import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int l = str.length();
            List<Character> list = new LinkedList<>();
            ListIterator<Character> iterator = list.listIterator();
            for (int j = 0; j < l; j++) {
                char c = str.charAt(j);
                if (c == '<') { // 왼쪽 커서 화살표
                    if (!iterator.hasPrevious()) continue;
                    iterator.previous();

                } else if (c == '>') { // 오른쪽 커서 화살표
                    if (!iterator.hasNext()) continue;
                    iterator.next();

                } else if (c == '-') { // 백스페이스
                    if (!iterator.hasPrevious()) continue;
                    iterator.previous();
                    iterator.remove();
                } else { // 일반 문자
                    iterator.add(c);
                }
            }
            
            for(char c : list) {
            	sb.append(c);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}