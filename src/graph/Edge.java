package graph;

public class Edge implements Comparable<Edge> { 

	public Vertex u;   // vertex u of the edge 
	public Vertex v;   // vertex v of the edge
	public int w;   // the weight of the edge  
	
	boolean directed=true;

	public Edge (Vertex u, Vertex v, int w) {
		this(u,v);     
		this.w = w;
			}
	public Edge (Vertex u, Vertex v) {
		this.u = u;
		this.v = v;    
		u.out.add(this);
		v.in.add(this);
	}
	@Override
	public int compareTo(Edge o) {
		return this.w - o.w;
	}

}

