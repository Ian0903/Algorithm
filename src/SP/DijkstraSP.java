package SP;

import java.util.Stack;

import dataStructure.IndexMinPQ;

/*
 * 最短路径的Dijkstra算法
 * 思想：通过“边”来松弛s顶点到其余各个顶点的路程
 */
public class DijkstraSP {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;
	
	public DijkstraSP(EdgeWeightDigraph G,int s){
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		
		for(int v = 0;v<G.V();v++){
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		pq.insert(s, 0.0);
		while(!pq.isEmpty())
			relax(G,pq.delMin());
	}
	
	private void relax(EdgeWeightDigraph G,int v){
		for(DirectedEdge e : G.adj(v)){
			int w = e.to();
			if(distTo[w] > distTo[v] + e.weight()){
				distTo[w] = distTo[v];
				edgeTo[w] = e;
			}
			if(pq.contains(w))pq.changeKey(w, distTo[w]);
			pq.insert(w, distTo[w]);
		}
	}
	
	public double distTo(int v){
		return distTo[v];
	}
	
	public boolean hasPathTo(int v){
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	
	public Iterable<DirectedEdge> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for(DirectedEdge e = edgeTo[v];e != null;e = edgeTo[e.from()]){
			path.push(e);
		}
		return path;
	}
	
}
