package Digraph;
/*
 * 有向图的深度优先搜索
 * 解决“是否存在一条从s到达给定顶点的v的有向路径”
 */

public class DirectedDFS {
	private boolean[] marked;
	//在G中找到s可达的所有顶点
	public DirectedDFS(Digraph G,int s){
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	
	//在G中找到从sources中的所有顶点可达的所有顶点
	public DirectedDFS(Digraph G,Iterable<Integer> sources){
		marked = new boolean[G.V()];
		for(int s : sources)
			if(!marked[s]) dfs(G,s);
	}
	
	private void dfs(Digraph G,int v){
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w]) dfs(G,v);
	}
	
	public boolean marked(int v){
		return marked[v];
	}
}
