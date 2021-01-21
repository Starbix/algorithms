package graph;

import java.util.Arrays;

public class GraphApp {

	public GraphApp() {	}

	public static void main(String[] args) {

		Graph G = new Graph(7, 9);

		

		//add vertices and edges		
		int[] u = {1,1,3,3,2,4,4,4,0};
		int[] v = {3,2,2,4,5,5,0,6,6};
		int[] w = {1,2,5,2,2,1,7,3,6};
//		int[] u = {0,1,1,3,0};
//		int[] v = {1,2,3,2,3};
//		int[] w = {5,7,-1,1,4};

		for (int i=0;i<G.E;i++) {
			G.edges[i] = new Edge(G.vertices[u[i]], G.vertices[v[i]], w[i]);
		}


		System.out.println(Boruvka.getMST(G));

		int[] d = BellmanFord.shortestPath(G, G.vertices[1]);

		System.out.println("Distance matrix:");
		//for (int[] a : d) {
			System.out.println(Arrays.toString(d));
		//}


	}

}
