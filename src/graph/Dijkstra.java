package graph;

import java.util.PriorityQueue;

public class Dijkstra {

	//treat edges as directed
	public static boolean directed = true;

	public Dijkstra() {	}

	public static int[] shortestPath(Graph G, Vertex s) {
		Vertex.compareWithDist=true;
		//reset edge weights
		G.resetVertexDists();

		int[] d =  new int[G.V];
		Vertex[] parent = new Vertex[G.V];

		for (Vertex v : G.vertices) {
			parent[v.getKey()]=null;
			v.dist = Integer.MAX_VALUE;
			d[v.getKey()] = v.dist;
		}

		d[s.key] = 0;
		s.setDist(0);

		//TODO: use own prioQueue
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();

		queue.add(s);

		while (!queue.isEmpty()) {
			Vertex u = queue.remove();

			for (Edge e : u.out) {
				Vertex v = e.v;

				if (u.getDist()!=Integer.MAX_VALUE&&u.getDist()+e.w<v.getDist()) {
					v.dist=u.getDist()+e.w;
					parent[v.getKey()] = u;
					queue.add(v);
					d[v.key] = v.dist;
				}
			}
			if (!directed) {
				for (Edge e : u.in) {
					Vertex v = e.u;
					if (u.getDist()!=Integer.MAX_VALUE&&u.getDist()+e.w<v.getDist()) {
						v.dist=u.getDist()+e.w;
						parent[v.getKey()] = u;
						queue.add(v);
						d[v.key] = v.dist;
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
