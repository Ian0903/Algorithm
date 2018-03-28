package Digraph;

import java.util.Stack;

import dataStructure.Queue;

/*
 * 有向图中基于深度优先搜索的顶点排序
 * 1.前序：在递归调用前将顶点加入队列
 * 2.后序：在递归调用后将顶点加入队列
 * 3.逆后序：在递归调用后将顶点压入栈
 */
public class DepthFirstOrder {

	private boolean marked[];
	private Queue<Integer> pre;//前序排列
	private Queue<Integer> post;//后序排列
	private Stack<Integer> reversePost;//逆后序排列
	
	public DepthFirstOrder(Digraph G){
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		marked = new boolean[G.V()];
		for(int i = 0;i<G.V();i++){
			if(!marked[i])
				dfs(G,i);
		}
	}
	
	private void dfs(Digraph G,int v){
		pre.enqueue(v);
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w])
				dfs(G,w);
		}
		post.enqueue(v);
		reversePost.push(v);
	}
	
	public Iterable<Integer> pre(){
		return pre;
	}
	public Iterable<Integer> post(){
		return post;
	}
	public Iterable<Integer> reversePost(){
		return reversePost;
	}
	
	
}


