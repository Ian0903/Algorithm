package Graph;

import java.util.Stack;

import dataStructure.Queue;


/*
 * 广度优先搜索：寻找起点到指定顶点的最短路径
 * 1.将起点加入队列
 * 2.取队列中的所有未标记过顶点v并标记它
 * 3.将与v相邻的所有未标记过的顶点加入队列
 */

public class BreadthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	public BreadthFirstPaths(Graph G,int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G,s);
	}
	
	private void bfs(Graph G,int v){
		marked[v] = true;//标记起点
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(v);//将它加入队列
		while(!queue.isEmpty()){
			queue.dequeue();//从队列中删除下一个顶点
			for(int w : G.adj(v)){
				if(!marked[w]){
					edgeTo[w] = v;
					marked[w] = true;
					queue.enqueue(w);
				}
			}
		}
 	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v;x!=s;x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
}
