package MST;

import dataStructure.MinPQ;
import dataStructure.Queue;
/*
 * Kruscal算法计算最小生成树
 */
import dataStructure.UF;

public class KruscalMST {
	private Queue<Edge> mst;
	
	public KruscalMST(EdgeWeightGraph G){
		mst = new Queue<Edge>();
		MinPQ<Edge> pq = new MinPQ<Edge>(G.V());
		UF uf = new UF(G.V());
		
		while(!pq.isEmpty() && mst.size() < G.V()-1){
			Edge e = pq.delMin();//从pq得到权重最小的边和它的顶点
			int v = e.either(),w = e.other(v);
			if(uf.connected(v, w)) continue;//形成环，忽略
			uf.union(v,w);//合并分量
			mst.enqueue(e);//添加边到最小生成树
		}
		
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
	public double weight(){
		double sum = 0.0;
		for(int v = 1;!mst.isEmpty();v++){
			sum+=mst.dequeue().weight();
		}
		return sum;
	}
}
