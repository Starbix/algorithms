package graph;

public class FloydWarshall {

	//treat edges as directed
	public static boolean directed = true;
	
	public FloydWarshall() {	}

	public static int[][] allPairShortestPath(Graph G) {
		int[][] d = new int[G.V][G.V];

		//initialization: d(i,i)=0 and infinity otherwise
		for (int i=0;i<G.V;i++) {
			for (int j=0;j<G.V;j++) {
				if(j==i) {
					d[i][j] = 0;
				} else {
					d[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		//base cases: adjacent vertices have a non-infinity distance
		for (Edge e: G.edges) {
			if (e.u.key!=e.v.key) {
				d[e.u.key][e.v.key] = e.w;
				if (!directed) d[e.v.key][e.u.key] = e.w;
			}
		}

		//allowed to use vertices
		for (int i=0;i<G.V;i++) {
			for (int u=0;u<G.V;u++) {
				for (int v=0;v<G.V;v++) {
					if (d[u][i]!=Integer.MAX_VALUE&&d[i][v]!=Integer.MAX_VALUE) {
						d[u][v] = Math.min(d[u][v], d[u][i] + d[i][v]);
					}
				}
			}
		}
		return d;
	}
}
