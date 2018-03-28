package Graph;

import java.io.InputStream;

import dataStructure.Bag;

/*
 * 无向图的数据类型
 */
public class Graph {
	private final int V;//顶点数目
	private int E;//边数目
	private Bag<Integer>[] adj;
	public Graph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V];//创建邻接表
		for(int i = 0;i<V;i++)
			adj[i] = new Bag<Integer>();
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	public void addEdge(int v,int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
}
