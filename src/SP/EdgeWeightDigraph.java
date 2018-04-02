package SP;

import MST.Edge;
import dataStructure.Bag;

/*
 * 加权有向图的数据类型
 */
public class EdgeWeightDigraph {
	private final int V;//顶点数目
	private int E;//边数目
	private Bag<DirectedEdge>[] adj;
	public EdgeWeightDigraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<DirectedEdge>[])new Bag[V];//创建邻接表
		for(int i = 0;i<V;i++)
			adj[i] = new Bag<DirectedEdge>();
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	public void addEdge(DirectedEdge e){
		adj[e.from()].add(e);
		E++;
	}
	public Iterable<DirectedEdge> adj(int v){
		return adj[v];
	}
	
	public Iterable<DirectedEdge> edges(){
		Bag<DirectedEdge> b = new Bag<DirectedEdge>();
		for(int v = 0;v<V;v++){
			for(DirectedEdge e : adj[v]){
				b.add(e);
			}
		}
		return b;
	}
}
