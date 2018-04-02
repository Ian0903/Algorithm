package MST;

import dataStructure.Bag;
import dataStructure.IndexMinPQ;
/*
 * 最小生成树的Prim算法（即时实现）
 */

public class PrimMST {
	private Edge[] edgeTo;//距离树最近的边
	private double[] distTo;//distTo[w] = edgeTo[w].weight();距离树最近的边的权重
	private boolean[] marked;//如果v在树中则为true
	private IndexMinPQ<Double> pq;//有效的横切便
	
	public PrimMST(EdgeWeightGraph G){
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		for(int v = 0;v < G.V();v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[0] = 0.0;
		pq.insert(0, 0.0);//用顶点0和权重0初始化pq
		while(!pq.isEmpty())
			visit(G,pq.delMin());
	}
	
	private void visit(EdgeWeightGraph G,int v){
		//将顶点v添加到树中，更新数据
		marked[v] = true;
		for(Edge e : G.adj(v)){
			int w = e.other(v);
			if(marked[w]) continue;//v-w失效
			if(e.weight()<distTo[w]){//当前边的权重小于距离树最近的边的权重，替换
				distTo[w] = e.weight();
				edgeTo[w] = e;
				if(pq.contains(w))pq.changeKey(w, distTo[w]);
				else pq.insert(w,distTo[w]);
				
			}
		}
	}
	
	public Iterable<Edge> edges(){
		Bag<Edge> mst = new Bag<Edge>();
		for(int v = 1;v<edgeTo.length;v++)
			mst.add(edgeTo[v]);
		return mst;
	}
	
	public double weight(){
		double sum = 0.0;
		for(int v = 1;v<edgeTo.length;v++){
			sum+=edgeTo[v].weight();
		}
		return sum;
	}
}
