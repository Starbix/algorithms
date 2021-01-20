package graph;

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {

	int key;
	int dist;
	ArrayList<Edge> in;
	ArrayList<Edge> out;

	static boolean compareWithDist = false;

	public Vertex() {
		in = new ArrayList<Edge>();
		out = new ArrayList<Edge>();

	}

	public Vertex(int key) {
		this();
		this.key = key;
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
			
			if (dist>o.dist) return 1;
			if (dist<o.dist) return -1;
			return 0;
		} else {
			return key-o.getKey();
		}
	}
	
	public String toString() {
		return "Vrtx "+key+": "+dist;
	}

}
