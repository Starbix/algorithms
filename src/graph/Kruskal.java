package graph;

import java.util.Arrays;
import java.util.Comparator;

import datastructures.UnionFind;

public class Kruskal {

	static boolean DEBUG = false;

	public Kruskal() {	}

	public static long getMST(Graph G){
		UnionFind MST = new UnionFind(G.V);

		long mst=0;

		//TODO: use own sorting algorithm
		Arrays.sort(G.edges, new Comparator<Edge>() {
			public int compare(Edge o1, Edge o2) {
				return o1.w - o2.w;
			}
		});


		for (Edge e : G.edges ) {
			if (!MST.same(e.u.getKey(), e.v.getKey())) {
				MST.union(e.u.getKey(), e.v.getKey());
				if(DEBUG) System.out.println(e.u+" and "+e.v+" : "+e.w);
				mst += e.w;
			}
		}	
		return mst;
	}

}
