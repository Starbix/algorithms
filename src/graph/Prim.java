package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

import datastructures.UnionFind;

public class Prim {

	public Prim() {	}

	public static long getMST(Graph G, Vertex s){
		Vertex.compareWithDist=true;

		UnionFind MST = new UnionFind(G.V);
		long mst=0;

		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();

		for (Vertex v : G.vertices) {
			v.dist = Integer.MAX_VALUE;
			queue.add(v);
		}

		s.dist = 0;
		queue.remove(s);
		queue.add(s);

		while (!queue.isEmpty()) {
			Vertex v = queue.remove();
			MST.union(s.getKey(), v.getKey());

			System.out.println("Adding: "+v.key+" w: "+v.dist);
			mst += v.dist;

			for (Edge e : v.out) {
				if (!MST.same(s.key, e.v.getKey())) {
					if (e.v.dist>e.w) {
						e.v.dist = e.w;
						queue.remove(e.v);
						queue.add(e.v);
					}


				}
			}

			for (Edge e : v.in) {
				if (!MST.same(s.key, e.u.getKey())) {
					if (e.u.dist>e.w) {
						e.u.dist = e.w;
						queue.remove(e.u);
						queue.add(e.u);
					}


				}
			}

			System.out.println(Arrays.toString(queue.toArray()));
		}
		return mst;
	}
}
