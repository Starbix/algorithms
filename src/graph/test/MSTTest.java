package graph.test;
import static org.junit.Assert.*;

import org.junit.rules.Timeout;

import graph.Boruvka;
import graph.Edge;
import graph.Graph;
import graph.Kruskal;
import graph.Prim;

import org.junit.Rule;
import org.junit.Test;

public class MSTTest {

	@Rule
	public Timeout globalTimeout= Timeout.seconds(5);



	@Test
	public void easyTest() {
		Graph G = new Graph(7, 9);

		int[] u = {1,1,3,3,2,4,4,4,0};
		int[] v = {3,2,2,4,5,5,0,6,6};
		int[] w = {1,2,5,2,2,1,7,3,6};

		for (int i=0;i<G.E;i++) {
			G.edges[i] = new Edge(G.vertices[u[i]], G.vertices[v[i]], w[i]);
		}
		int weight = 15;

		assertEquals(weight, Prim.getMST(G, G.vertices[1]));
		assertEquals(weight, Kruskal.getMST(G));
		assertEquals(weight, Boruvka.getMST(G));


	}


	@Test
	public void easyTestNegative() {
		Graph G = new Graph(7, 9);

		int[] u = {1,1,3,3,2,4,4,4,0};
		int[] v = {3,2,2,4,5,5,0,6,6};
		int[] w = {1,2,-5,2,2,1,-7,3,6};

		for (int i=0;i<G.E;i++) {
			G.edges[i] = new Edge(G.vertices[u[i]], G.vertices[v[i]], w[i]);
		}

		int weight = -5;

		assertEquals(weight, Prim.getMST(G, G.vertices[1]));
		assertEquals(weight, Kruskal.getMST(G));
		assertEquals(weight, Boruvka.getMST(G));
	}

	@Test
	public void onlyNegative() {
		Graph G = new Graph(7, 9);

		int[] u = {1,1,3,3,2,4,4,4,0};
		int[] v = {3,2,2,4,5,5,0,6,6};
		int[] w = {-1,-2,-5,-2,-2,-1,-7,-3,-6};

		for (int i=0;i<G.E;i++) {
			G.edges[i] = new Edge(G.vertices[u[i]], G.vertices[v[i]], w[i]);
		}

		int weight = -24;

		assertEquals(weight, Prim.getMST(G, G.vertices[1]));
		assertEquals(weight, Kruskal.getMST(G));
		assertEquals(weight, Boruvka.getMST(G));
	}

	@Test
	public void sameEdgeWeights() {
		Graph G = new Graph(7, 9);

		int[] u = {1,1,3,3,2,4,4,4,0};
		int[] v = {3,2,2,4,5,5,0,6,6};
		int[] w = {1,1,1,1,1,1,1,1,1};

		for (int i=0;i<G.E;i++) {
			G.edges[i] = new Edge(G.vertices[u[i]], G.vertices[v[i]], w[i]);
		}

		int weight = 6;

		assertEquals(weight, Prim.getMST(G, G.vertices[1]));
		assertEquals(weight, Kruskal.getMST(G));
		assertEquals(weight, Boruvka.getMST(G));
	}

	@Test
	public void singleVertex() {
		Graph G = new Graph(1,0);

		int[] u = {1,1,3,3,2,4,4,4,0};
		int[] v = {3,2,2,4,5,5,0,6,6};
		int[] w = {1,1,1,1,1,1,1,1,1};

		for (int i=0;i<G.E;i++) {
			G.edges[i] = new Edge(G.vertices[u[i]], G.vertices[v[i]], w[i]);
		}

		int weight = 0;

		assertEquals(weight, Prim.getMST(G, G.vertices[0]));
		assertEquals(weight, Kruskal.getMST(G));
		assertEquals(weight, Boruvka.getMST(G));
	}
	
	@Test
	public void emptyGraph() {
		Graph G = new Graph(0,0);

		assertEquals(0, Prim.getMST(G, null));
		assertEquals(0, Kruskal.getMST(G));
		assertEquals(0, Boruvka.getMST(G));


	}
}
