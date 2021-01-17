package graph;

public class GraphApp {

	public GraphApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph G = new Graph(7, 9);
		
		Vertex[] vertices = new Vertex[7];
		for (int i=0;i<vertices.length;i++) {
			vertices[i] = new Vertex(i);
		}
		
		//add vertices and edges		
		int[] u = {1,1,3,3,2,4,4,4,0};
		int[] v = {3,2,2,4,5,5,0,6,6};
		int[] w = {1,2,5,2,2,1,7,3,6};
		
		for (int i=0;i<9;i++) {
			G.edges[i] = new Edge(G.vertices[u[i]], G.vertices[v[i]], w[i]);
		}
		
		
		System.out.println(Kruskal.getMST(G));
		
		Dijkstra.shortestPath(G, G.vertices[1]);
		
		System.out.println("Distance from 1:");
		for (Vertex ver : G.vertices) {
			System.out.println(ver.key+": "+ver.getDist());
		}
		
		
	}

}
