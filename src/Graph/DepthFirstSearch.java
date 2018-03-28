package Graph;
/*
 * 深度优先搜索
 * 遍历其中一个顶点时：1.将它标记为已访问	2.递归地访问它的所有没有被标注过的邻居顶点
 */
public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	public DepthFirstSearch(Graph G,int s){
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	private void dfs(Graph G,int v){
		marked[v] = true;
		count++;
		for(int w : G.adj(v))//获取v顶点的邻居顶点
			if(!marked[w]) dfs(G,w);//若没有标记过则进行dfs
	}
	
	public boolean marked(int w){
		return marked[w];
	}
	public int count(){
		return count;
	}
}
