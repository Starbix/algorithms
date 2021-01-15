package datastructures;

public class UnionFind {


	int[] rank;
	int[] rep;

	int n;

	//FAST: same and union in O(logN)
	//not FAST: same in O(1) and union in O(n) 
	final boolean FAST;

	public UnionFind(int n) {
		this.FAST = true;
		this.n = n;
		make(n);
	}

	public UnionFind(int n, boolean fast) {
		this.FAST = fast;
		this.n = n;
		make(n);
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

			if (rank[uRoot]<rank[vRoot]) {
				rep[uRoot] = vRoot;
			} else if (rank[uRoot]>rank[vRoot]) {
				rep[vRoot] = uRoot;
			} else {
				rep[vRoot] = uRoot;
				rank[uRoot]++;
			}
		} else {

			int r = rep[u];
			for (int i=0;i<n;i++) {
				if (rep[i]==r) {
					rep[i] = rep[v];
				}
			}
		}
	}



}
