package datastructures;

import graph.Vertex;

public class UnionFind {

	int[] rank;
	int[] rep;

	int n;

	int components;

	//FAST: same and union in O(logN)
	//not FAST: same in O(1) and union in O(n) 
	final boolean FAST;

	public UnionFind(int n) {
		this(n, true);
	}

	public UnionFind(int n, boolean fast) {
		this.FAST = fast;
		this.n = n;
		this.components = n;
		make(n);
	}

	public int getComponents() {
		return components;
	}

	void make(int n) {
		rep = new int[n];

		for (int i=0;i<n;i++) {
			rep[i]=i;
		}

		if (FAST) {
			rank = new int[n];
		}

	}

	public boolean same(int x, int y) {
		if (FAST) return find(x)==find(y);

		return rep[x]==rep[y];
	}

	public boolean same(Vertex u, Vertex v) {
		return same(u.getKey(), v.getKey());
	}

	public int find(int x) {
		if (!FAST) return rep[x];
		if (rep[x]!=x) {
			rep[x] = find(rep[x]);
		}
		return rep[x];
	}

	public void union(int u, int v) {
		if (FAST) {
			int uRoot = find(u);
			int vRoot = find(v);

			if (uRoot!=vRoot) components--;

			if (rank[uRoot]<rank[vRoot]) {
				rep[uRoot] = vRoot;
			} else if (rank[uRoot]>rank[vRoot]) {
				rep[vRoot] = uRoot;
			} else {
				rep[vRoot] = uRoot;
				rank[uRoot]++;
			}
		} else {

			if (rep[u]!=rep[v]) components--;

			int r = rep[u];
			for (int i=0;i<n;i++) {
				if (rep[i]==r) {
					rep[i] = rep[v];
				}
			}
		}
	}

	public void union(Vertex u, Vertex v) {
		union(u.getKey(), v.getKey());
	}	
}
