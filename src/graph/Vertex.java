package graph;

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {

	int key;
	int dist;
	ArrayList<Edge> out;

	static boolean compareWithDist = false;

	public Vertex() {
		out = new ArrayList<Edge>();

	}

	public Vertex(int key) {

		this.key = key;
		out = new ArrayList<Edge>();
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getDist() {
		return dist;
	}

	public void setDist(int dist) {
		this.dist = dist;
	}

	public boolean equals(Vertex v) {
		return this.key==v.getKey();
	}

	@Override
	public int compareTo(Vertex o) {
		if (compareWithDist) {
			return dist-o.getDist();
		} else {
			return key-o.getKey();
		}
	}

}
