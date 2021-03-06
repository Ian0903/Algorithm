package dataStructure;
/*
 * 基于堆的优先队列（删除最小值）
 */

public class MinPQ<Key extends Comparable<Key>>{
	private Key[] pq;//基于堆的完全二叉树
	private int N = 0;//储存与pq[1..N],pq[0]没有使用
	
	public MinPQ(int maxN){
		pq = (Key[])new Comparable[maxN+1]; //初始化堆大小
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public void insert(Key v){
		pq[++N] = v;//尾节点添加元素
		swim(N);//由下至上有序化
	}
	
	public Key delMin(){
		Key min = pq[1];//从根节点获取最大元素
		//交换根节点和尾节点的元素值
		Key temp = pq[1];
		pq[1] = pq[N];
		pq[N] = temp;
		N--;
		
		pq[N+1] = null;//防止角标越界
		sink(1);//由上至下有序化
		return min;
	}
	
	//由下至上有序化，恢复堆秩序
	private void swim(int k){
		while(k>1 && pq[k/2].compareTo(pq[k])>0){
			Key temp = pq[k/2];
			pq[k/2] = pq[k];
			pq[k] = temp;
			k = k/2;
		}
	}
	
	//由下至上有序化，恢复堆秩序
	private void sink(int k){
		while(2*k <= N){
			int j = 2*k;
			if(j<N && pq[j].compareTo(pq[j+1])>0) j++;
			if(pq[k].compareTo(pq[j])>0) break;
			Key temp = pq[k];
			pq[k] = pq[j];
			pq[j] = temp;
			k = j;
		}
	}
}