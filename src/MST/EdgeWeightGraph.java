package MST;

import dataStructure.Bag;

/*
 * 加权有向图的数据类型
 */
public class EdgeWeightGraph {
	private final int V;//顶点数目
	private int E;//边数目
	private Bag<Edge>[] adj;
	public EdgeWeightGraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<Edge>[])new Bag[V];//创建邻接表
		for(int i = 0;i<V;i++)
			adj[i] = new Bag<Edge>();
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	public void addEdge(Edge e){
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
	
	public Iterable<Edge> edges(){
		Bag<Edge> b = new Bag<Edge>();
		for(int v = 0;v<V;v++){
			for(Edge e : adj[v]){
				if(e.other(v) > v) b.add(e);//按权重排序
			}
		}
		return b;
	}
}
