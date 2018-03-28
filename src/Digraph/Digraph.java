package Digraph;

import dataStructure.Bag;

/*
 * 有向图的数据类型
 */
public class Digraph {
	private final int V;//顶点数
	private int E;//边数
	private Bag<Integer>[] adj;//邻接表
	
	public Digraph(int V){
		this.V = V;
		this.E = 0;
		//初始化邻接表
		adj = (Bag<Integer>[])new Bag[V];
		for(int i = 0;i<V;i++){
			adj[i] = new Bag<Integer>();
		}
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	public void addEdge(int v,int w){
		adj[v].add(w);
		E++;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public Digraph reverse(){
		Digraph R = new Digraph(V);
		for(int v = 0;v<V;v++)
			for(int w : adj(v))
				addEdge(w,v);
		return R;
	}
}
