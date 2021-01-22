package graph.test;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.rules.Timeout;

import graph.BreadthFirstSearch;
import graph.Dijkstra;
import graph.Edge;
import graph.Graph;

import org.junit.Rule;
import org.junit.Test;

public class ShortestPathTest {

	@Rule
	public Timeout globalTimeout= Timeout.seconds(5);



	@Test
	public void easyTestDirected() {
		Graph G = new Graph(7, 9);

		int[] u = {1,1,3,3,2,4,4,4,0};
		int[] v = {3,2,2,4,5,5,0,6,6};
		int[] w = {1,2,5,2,2,1,7,3,6};

		for (int i=0;i<G.E;i++) {
			G.edges[i] = new Edge(G.vertices[u[i]], G.vertices[v[i]], w[i]);
		}
		int[] distanceW = {10, 0, 2, 1, 3, 4, 6};
		int[] distance = {3,0,1,1,2,2,3};
		
		Dijkstra.directed = true;
		BreadthFirstSearch.directed = true;
		
		assertTrue(Arrays.equals(distanceW, Dijkstra.shortestPath(G, G.vertices[1])));
		assertTrue(Arrays.equals(distance, BreadthFirstSearch.shortestPath(G, G.vertices[1])));

	}

	@Test
	public void easyTestUndirected() {
		Graph G = new Graph(7, 9);

		int[] u = {1,1,3,3,2,4,4,4,0};
		int[] v = {3,2,2,4,5,5,0,6,6};
		int[] w = {1,2,5,2,2,1,7,3,6};

		for (int i=0;i<G.E;i++) {
			G.edges[i] = new Edge(G.vertices[u[i]], G.vertices[v[i]], w[i]);
		}
		int[] distanceW = {10, 0, 2, 1, 3, 4, 6};
		int[] distance = {3,0,1,1,2,2,3};
		
		Dijkstra.directed = false;
		BreadthFirstSearch.directed = false;
		
		assertTrue(Arrays.equals(distanceW, Dijkstra.shortestPath(G, G.vertices[1])));
		assertTrue(Arrays.equals(distance, BreadthFirstSearch.shortestPath(G, G.vertices[1])));

	}
}
