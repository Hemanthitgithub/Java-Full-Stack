package day13programs;

import java.util.ArrayList;
import java.util.List;

public class GraphEdge {
	
	private int v;
	private List<List<Integer>> adj;
	
	public GraphEdge(int v) {
		this.v = v;
		adj = new ArrayList<>(v);
		for(int i=0;i<v;i++) {
			adj.add(new ArrayList<>());
		}
	}
	public void adEdge(int u,int v) {
		adj.get(u).add(v);
		if(isCyclic(u)) {
			adj.get(u).remove(adj.get(u).size()-1);
			System.out.println("Edge("+u+","+v+")cannot be added as it creates a cycle.");
		}
	}
	public boolean isCyclic(int v) {
		boolean[] visited = new boolean[v];
		boolean[] recStack = new boolean[v];
		return isCyclicutil(v,visited,recStack);
	}
	private boolean isCyclicutil(int v,boolean[] visited,boolean[] recStack) {
		if(!visited[v]) {
			visited[v] = true;
			recStack[v] = true;
			
			for(Integer neigbor : adj.get(v)) {
				if(!visited[neigbor]&& isCyclicutil(neigbor,visited,recStack)) {
					return true;
				}else if
					(recStack[neigbor]) {
					
				}
				}
				}
			
			recStack[v]=false;
			return false;
		}
		
		public static void main(String[] args) {
			GraphEdge graph = new GraphEdge(4);
			graph.adEdge(0,1);
			graph.adEdge(0,2);
			graph.adEdge(1,2);
			graph.adEdge(2,0);
			graph.adEdge(2,3);
			graph.adEdge(3,3);
			System.out.println("Graph has cycle:"+graph.isCyclic(0));
			graph.adEdge(3,0);
			System.out.println("Graph has cycle:"+graph.isCyclic(0));
		}
	}

			