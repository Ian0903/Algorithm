package MST;

import dataStructure.MinPQ;
import dataStructure.Queue;
/*
 * Prim最小生成树算法的延时实现
 * 
 */

public class LazyPrimMST {
	private boolean[] marked;//最小生成树的顶点
	private Queue<Edge> mst;//最小生成树的边
	private MinPQ<Edge> pq;//横切边（包括失效的边）
	
	public LazyPrimMST(EdgeWeightGraph G){
		marked = new boolean[G.V()];
		pq = new MinPQ<Edge>(G.V());
		mst = new Queue<Edge>();
		
		visit(G,0);
		while(!pq.isEmpty()){
			Edge e = pq.delMin();//从pq中得到权重最小的边
			int v = e.either(),w = e.other(v);//跳过失效的边
			if(marked[v] && marked[w]) continue;
			mst.enqueue(e);//将边添加到树中
			if(!marked[v]) visit(G,v);//将顶点(v或w)连接的边添加到树中
			if(!marked[w]) visit(G,w);
		}
	}
	
	private void visit(EdgeWeightGraph G,int v){
		//标记顶点v并将所有连接v和未标记顶点的边加入pq
		marked[v] = true;
		for(Edge e : G.adj(v))
			if(!marked[e.other(v)])
				pq.insert(e);
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
	public double weight(){
		double sumWeight = 0;
		for(int i = 0;i < mst.size();i++){
			sumWeight+=(mst.dequeue().weight());
		}
		return sumWeight;
	}
}
