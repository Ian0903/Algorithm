package Digraph;
/*
 * 计算强连通分量的Kosaraju算法
 * 1.在给定的一幅图中，使用DepthFirstOrder来计算它的反向图G^R的逆后序排序
 * 2.在G中进行深度优先搜索，但要按照刚才的计算得到顺序来访问所有未标记的顶点
 */

public class KosarajuSCC {
	private boolean[] marked;//已访问过的顶点
	private int[] id;//强连通分量的标识符
	private int count;//强连通分量的数量
	
	public KosarajuSCC(Digraph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		for(int s : order.reversePost()){
			if(!marked[s]){
				dfs(G,s);
				count++;
			}
		}
			
	}
	
	public void dfs(Digraph G,int v){
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v)){
			if(!marked[w])
				dfs(G,w);
		}
	}
	
	public boolean stronglyConnected(int v,int w){
		return id[v] == id[w];
	}
	
	public int id(int v){
		return id[v];
	}
	
	public int count(){
		return count;
	}

}
