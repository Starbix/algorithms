package graph;

public class Edge implements Comparable<Edge> { 

	public int u;   // vertex u of the edge 
	public int v;   // vertex v of the edge
	public int w;   // the weight of the edge  

	public Edge (int u, int v, int w) {
		this.u = u;
		this.v = v;      
		this.w = w;
	}
	public Edge (int u, int v) {
		this.u = u;
		this.v = v;      
	}
	@Override
	public int compareTo(Edge o) {
		return this.w - o.w;
	}

}

