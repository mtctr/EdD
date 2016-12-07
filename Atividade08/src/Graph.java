import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.*;

/**
 * An implementation of a general (undirected) graph, using an adjacency list
 * representation
 *
 * @author Luca Castelli Aleardi (INF421 2011)
 */
public class Graph {

	LinkedList<Edge>[] vertices;
	Point_2[] points; // geometric coordinates for drawing the graph

	public Graph(int n) {
		this.vertices = new LinkedList[n];
		for (int i = 0; i < n; i++)
			this.vertices[i] = new LinkedList<Edge>();
	}

	public Graph(Point_2[] points) {
		this.points = points;
		this.vertices = new LinkedList[this.points.length];
		for (int i = 0; i < points.length; i++)
			this.vertices[i] = new LinkedList<Edge>();
	}

	/**
	 * return the number of vertices of the graph
	 */
	public int sizeVertices() {
		return vertices.length;
	}

	public LinkedList<Edge> getEdges(int u) {
		if (u < 0 || u >= this.vertices.length)
			throw new Error("degree: vertex index error");
		return this.vertices[u];
	}

	/**
	 * return the degree of a vertex
	 */
	public int degree(int u) {
		if (u < 0 || u >= this.vertices.length)
			throw new Error("degree: vertex index error");
		return this.vertices[u].size();
	}

	/**
	 * add an edge between vertices u and v
	 */
	public void addEdge(int u, int v) {
		Edge e = new Edge(u, v);
		
		if ((u != v) && (u >= 0 && v >= 0 && u <= this.sizeVertices() - 1 && v <= this.sizeVertices() - 1)&&
				(!this.vertices[u].equals(e) && !this.vertices[v].equals(e))) {
			this.vertices[u].add(e);
			this.vertices[v].add(e);
		}

	}

	/**
	 * returns the position (geometric coordinates) of a vertex
	 */
	public Point_2 getPoint(int i) {
		if (i < 0 || i >= this.points.length)
			throw new Error("getPoint: vertex index error");
		return this.points[i];
	}

	/**
	 * return incident relations and vertex coordinates
	 */
	public String toString() {
		String str = new String();		
		
		for(int i = 0; i <vertices.length; i++){
			str += i + ": " + vertices[i].toString() + "\n";			
		}
		
		for (int i = 0; i<this.points.length; i++){
			str += "point " + i + ": " + points[i].toString() + "\n";
		}
		
		return str;
	}

	/**
	 * draw the graph in a 2D frame
	 */
	public void drawGraph() {
		Fenetre f = new Fenetre();
		for (int i = 0; i < vertices.length; i++) {
			for (Edge e : getEdges(i)) {
				f.addSegment(this.getPoint(e.getU()), this.getPoint(e.getV()));
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Testing class Graph");
		Graph g=graphFromFile("cube.txt");
		System.out.println(g.toString());
		g.drawGraph();
	}

	// The methods below are design to deal with input/output operations

	public static Graph graphFromFile(String filename) {
		Graph result = null;
		double x, y;
		File file;
		FileReader readfic;
		BufferedReader input;
		String line;
		System.out.println("Creating an Adjacency List Representation of a graph from a file");
		try {
			System.out.println("Opening OFF file... " + filename);
			file = new File(filename);
			readfic = new FileReader(file);
			input = new BufferedReader(readfic);

			line = input.readLine();
			StringTokenizer tok = new StringTokenizer(line);
			int nVertices = Integer.parseInt(tok.nextToken());
			int nEdges = Integer.parseInt(tok.nextToken());

			Point_2[] points = new Point_2[nVertices];
			result = new Graph(points);

			int i = 0;
			Point_2 p;
			System.out.print("Reading vertices...");
			while (i < nVertices) {
				line = input.readLine();
				tok = new StringTokenizer(line);
				// System.out.println("line "+i+" :"+line);
				x = (new Double(tok.nextToken())).doubleValue();
				y = (new Double(tok.nextToken())).doubleValue();

				p = new Point_2(x, y);
				points[i] = p;
				i++;
			}
			System.out.println("done " + nVertices + " vertices");

			// System.out.println(result);
			// line = input.readLine();
			System.out.print("Reading edges...");
			i = 0;
			while (i < nEdges) {
				if ((line = input.readLine()) == null)
					break;
				tok = new StringTokenizer(line);

				int u = Integer.parseInt(tok.nextToken());
				int v = Integer.parseInt(tok.nextToken());
				result.addEdge(u, v);
			}
			System.out.println("done " + nEdges + " edges");
			input.close();
		} catch (FileNotFoundException e) {
			// Efichier.erreur(e);
		} catch (IOException e) {
			// Efichier.erreur(e);
		}
		System.out.println("Graph representation created");
		return result;

	}

}
