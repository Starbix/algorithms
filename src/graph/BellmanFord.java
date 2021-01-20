package graph;

public class BellmanFord {

	public BellmanFord() {
		// TODO Auto-generated constructor stub
	}

	public static void shortestPath(Graph G, Vertex s) {
		Vertex[] parent = new Vertex[G.V];


		for (Vertex v : G.vertices) {
			parent[v.getKey()]=null;
			v.dist = Integer.MAX_VALUE;
		}
		s.setDist(0);

		for (int i=1;i<G.V;i++) {
			for (Edge e :  G.edges) {
				if (e.u.dist!=Integer.MAX_VALUE&&e.u.dist+e.w<e.v.dist) {
					e.v.dist = e.u.dist+e.w;
					parent[e.v.getKey()]=e.u;
				}
			}
		}

		for (Edge e :  G.edges) {
			if (e.u.dist+e.w<e.v.dist) {
				throw new IllegalArgumentException("Negative Cycle detected");
			}
		}
		
	}

}
