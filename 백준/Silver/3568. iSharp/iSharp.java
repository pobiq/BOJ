import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static int[] arr;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), ",; ");
		
		String firstString = st.nextToken();
		
		StringTokenizer firstToken = new StringTokenizer(firstString, "[]&*", true);
		
		String variable = firstToken.nextToken();
		
		List<String> addVariable = new ArrayList<String>();
		
		while(firstToken.hasMoreTokens()) {
			String temp = firstToken.nextToken();
			if(temp.equals("[")) {
				temp += firstToken.nextToken();
			}
			addVariable.add(temp);
		}
		
		while(st.hasMoreTokens()) {
			StringTokenizer subToken = new StringTokenizer(st.nextToken(), "[]&*", true);
			StringBuffer sub = new StringBuffer();
			
			String var = subToken.nextToken();
			
			List<String> subVariable = new ArrayList<String>();
			
			while(subToken.hasMoreTokens()) {
				String temp = subToken.nextToken();
				if(temp.equals("[")) {
					temp += subToken.nextToken();
				}
				subVariable.add(temp);
			}
			
			sub.append(variable);
			for(int i=0; i<addVariable.size(); i++) {
				sub.append(addVariable.get(i));
			}
			
			for(int i=subVariable.size()-1; i>=0; i--) {
				sub.append(subVariable.get(i));
			}
			
			sub.append(" " + var+";").append("\n");
			
			sb.append(sub.toString());
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}