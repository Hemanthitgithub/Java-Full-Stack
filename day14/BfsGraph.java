package day14;

import java.util.LinkedList;

public class BfsGraph {
	private int v;
	private LinkedList<Integer>[] adjList;
	
	public BfsGraph(int v) {
		this.v = v;
		adjList = new LinkedList[v];
		for(int i=0;i<v;++i) {
			adjList[i] = new LinkedList();
	}
	}
	
	public void addEdge(int v, int w) {
		adjList[v].add(w);
		adjList[w].add(v);
	}
	public void BfsGraph(int s){
		boolean[] visited = new boolean[v];
		LinkedList<Integer>queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			
			for(int neigbor : adjList[current]) {
				if(!visited[neigbor]) {
					visited[neigbor]= true;
					queue.add(neigbor);
				}
			}
		}
	}
				
					
	public static void main(String args[]) {
		BfsGraph graph = new BfsGraph(4);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		System.out.println("Bfs traversal starting from vertex 2:");
		graph.BfsGraph(2);;
	}
	
}
