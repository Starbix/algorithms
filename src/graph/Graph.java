package graph;

public class Graph{

	public int V;       // number of vertices in the graph
	public int E;      // number of edges  in the graph
	public Edge[] edges;  // each edge in the graph  

	public Graph(int V, int E) {
		this.V     = V;
		this.E     = E;
		this.edges   = new Edge[E];
	}

}
