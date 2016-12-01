/**
 * @author Luca Castelli Aleardi (INF421, 2011)
 *
 * A class for representing the edge of an undirected graph
 *
 */
public class Edge {
	
	private int u, v;
		
	public Edge(int u, int v) {
		this.u=u;
		this.v=v;
	}
	
	/**
	 * Test whether two edges are equals (when the two incident vertices do coincide)
	 */
	public boolean equals(Object a) {
		Edge e=(Edge)a;
		if(this.u==e.u && this.v==e.v) return true;
		if(this.u==e.v && this.v==e.u) return true;
		return false;
	}
	
	/**
	 * Return the index of the first incident vertex
	 */
	public int getU() {
		return this.u;
	}
	
	/**
	 * Return the index of the second incident vertex
	 */
	public int getV() {
		return this.v;
	}
	
	/**
	 * Given an edge e={u,v} and a vertex u, it returns vertex v (the other extremity of the edge)
	 */
	public int getOtherExtremity(int i) {
		if(this.u==i) 
			return this.v;
		else if(this.v==i)
			return this.u;
		else
			throw new Error("Error: non incident vertex");
	}

	
	public String toString() {
		return "("+u+","+v+")";
	}
	
}
