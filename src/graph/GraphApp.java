package graph;

public class GraphApp {

	public GraphApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph G = new Graph(7, 9);
		
		//add vertices and edges		
		int[] u = {1,1,3,3,2,4,4,4,0};
		int[] v = {3,2,2,4,5,5,0,6,6};
		int[] w = {1,2,5,2,2,1,7,3,6};
		
		for (int i=0;i<9;i++) {
			G.edges[i] = new Edge(u[i], v[i], w[i]);
		}
		
		
		System.out.println(Kruskal.getMST(G));
		
	}

}
