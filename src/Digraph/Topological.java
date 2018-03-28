package Digraph;
/*
 * 拓扑排序
 * 1.当且仅当一副有向图是无环图时它才能进行拓扑排序
 * 2.一副有向无环图的的所有顶点的逆后序排列即为拓扑排序
 */
public class Topological {

	private Iterable<Integer> order;//顶点的拓扑排序
	
	public Topological(Digraph G){
		DirectedCycle cycleFinder = new DirectedCycle(G);
		if(!cycleFinder.hasCycle()){
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}
	
	public Iterable<Integer> order(){
		return order;
	}
	
	public boolean isDAG(){
		return order!=null;
	}
}
