package graph;

import datastructures.Queue;

public class BreadthFirstSearch {

	//treat edges as directed
	public static boolean directed = true;

	public BreadthFirstSearch() {	}

	public static int[] shortestPath(Graph G, Vertex s) {
		//reset edge weights
		G.resetVertexDists();

		int[] d =  new int[G.V];
		for (int i=0;i<G.V;i++) {
			d[i]=Integer.MAX_VALUE;
		}

		Queue<Vertex> queue = new Queue<Vertex>();
		Vertex[] parent = new Vertex[G.V];

		queue.enqueue(s);
		d[s.getKey()]=0;

		while (!queue.isEmpty()) {
			Vertex u = queue.dequeue();
			if (parent[u.getKey()]!=null) u.dist = d[parent[u.getKey()].getKey()]+1;
			d[u.getKey()] = u.dist;


			for (Edge e : u.out) {
				if (parent[e.v.getKey()]==null&&e.v!=s) {
					queue.enqueue(e.v);
					parent[e.v.getKey()] = e.u;
				}
			}

			if (!directed) {
				for (Edge e : u.in) {
					if (parent[e.u.getKey()]==null&&e.u!=s) {
						queue.enqueue(e.u);
						parent[e.u.getKey()] = e.v;
					}
				}
			}
		}
		return d;
	}

	public static int[][] allPairShortestPath(Graph G) {
		int[][] d = new int[G.V][G.V];

		for (Vertex v : G.vertices) {
			d[v.getKey()] = shortestPath(G, v);
		}

		return d;
	}
}
