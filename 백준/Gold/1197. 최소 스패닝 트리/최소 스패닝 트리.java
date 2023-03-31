import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge> {
        int to;
        int weight;
        
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
        
        public String toString() {
        	return this.to + " " + this.weight;
        }
    }
	
	static int V, E;
    static ArrayList<ArrayList<Edge>> graph;
    static PriorityQueue<Edge> pq;
    static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		visited = new boolean[V+1];
		pq = new PriorityQueue<>();
		graph = new ArrayList<>();
		
		long result = 0;
		
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Edge(v, w));
			graph.get(v).add(new Edge(u, w));
		}
		
		pq.add(new Edge(1, 0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int to = edge.to;
			int weight = edge.weight;
			
			if(visited[to]) {
				continue;
			}
			
			visited[to] = true;
			result += weight;
			
			for(Edge e : graph.get(to)) {
				if(!visited[e.to]) {
					pq.offer(e);
				}
			}
		}

		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}