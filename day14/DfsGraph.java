package day14;

import java.util.LinkedList;

public class DfsGraph {
	
	
		private int v;
		private LinkedList<Integer>[] adjList;
		
		public DfsGraph(int v) {
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
		public void DfsGraph(int s){
			boolean[] visited = new boolean[v];
			dfsUtil(s, visited);
			
		}
		
			private void dfsUtil(int s, boolean[] visited) {
				visited[s] = true;
				System.out.print(s + " ");
				
				for(int neighbor : adjList[s]) {
					if(!visited[neighbor]) {
						dfsUtil(neighbor,visited);
						
					}
				}
			}
						
		public static void main(String args[]) {
			DfsGraph graph = new DfsGraph(4);
			
			graph.addEdge(0, 1);
			graph.addEdge(0, 2);
			graph.addEdge(1, 2);
			graph.addEdge(2, 3);
			
			
			System.out.println("Dfs Traversal:");
			graph.DfsGraph(2);;
		}
		
	}


