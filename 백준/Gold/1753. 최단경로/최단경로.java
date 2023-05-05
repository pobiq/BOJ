import java.io.*;
import java.util.*;

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
			return this.weight - o.weight;
		}
		
	}
	
	static int v, e;
	static int k;
	static List<Edge>[] graph;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		graph = new List[v+1];
		dist = new int[v+1];
		
		int result = 0;
		
		for(int i=1; i<=v; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		k = Integer.parseInt(br.readLine());
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[now].add(new Edge(to, weight));
		}
		
		dijkstra(k);
		
		for(int i=1; i<=v; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				sb.append("INF");
			} else {
				sb.append(dist[i]);
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void dijkstra(int k) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(k, 0));
        dist[k] = 0;
        
        while(!pq.isEmpty()) {
        	Edge e = pq.poll();
        	int now = e.to;
        	int weight = e.weight;
        	
        	if(dist[now] < weight) continue;
        	
        	for(Edge edge : graph[now]) {
        		int cost = weight + edge.weight;
        		if(cost < dist[edge.to]) {
        			dist[edge.to] = cost;
        			pq.add(new Edge(edge.to, cost));
        		}
        	}
        	
        }
	}
	
}