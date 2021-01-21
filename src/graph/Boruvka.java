package graph;

import java.util.HashMap;

import datastructures.UnionFind;

public class Boruvka {

	public Boruvka() {	}

	public static long getMST(Graph G){
		UnionFind MST = new UnionFind(G.V);

		long mst=0;

		HashMap<Integer, Edge> map = new HashMap<Integer, Edge>();

		while (MST.getComponents()>1) {

			for (Edge e : G.edges) {
				if (!MST.same(e.u, e.v)) {
					//get representant of vertices u and v
					int u = MST.find(e.u.getKey());
					int v = MST.find(e.v.getKey());

					//if no cheapest edge has been set or if this edge is cheaper
					if (map.get(u)==null || e.w<map.get(u).w) {
						//put cheaper edge of component with vertex u
						map.put(u, e);
					}
					//we assume the directed edges are actually undirected
					if (map.get(v)==null || e.w<map.get(v).w) {
						//put cheaper edge of component with vertex u
						map.put(v, e);
					}
				}
			}

			for (Edge e : map.values()) {
				//only add to total weight if the two components haven't already been union'ed
				if (!MST.same(e.u, e.v)) mst += e.w;

				MST.union(e.u, e.v);
			}

			//clear hashmap so we don't process edges again
			map.clear();
		}
		return mst;
	}
}
