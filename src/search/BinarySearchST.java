package search;
/*
 * 二分查找（基于有序数组）
 * 思想：在查找时，先将被查找的值和中间的值比较，若被查找的值小于中间值，则查找范围缩小为low到mid-1；若被查找的值大于中间值，则查找的范围缩小为mid+1到high；否则中间值就是要查找的值。
 * 优点：最优的查找效率和空间需求，能够进行有序性相关的操作。
 * 缺点：插入操作很慢
 */

public class BinarySearchST <Key extends Comparable<Key>,Value> {
	
	private Key[] keys;
	private Value[] vals;
	private int N;
	//调整数组大小
	public BinarySearchST(int capacity){
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	
	public int size(){
		return N;
	}
	
	public Value get(Key key){
		int i = rank(key);//对key进行二分查找
		if(i < N && keys[i].compareTo(key) == 0) return vals[i];
		else return null;
	}

	//二分查找实现算法
	public int rank(Key key){
		int lo = 0,hi = N-1;
		int mid = lo + (hi - lo)/2;
		while(lo<=hi){
			int cmp = key.compareTo(keys[mid]);
			if(cmp < 0) hi = mid-1;
			else if(cmp > 0) lo = mid+1;
			else return mid;
		}
		return lo;
	}
	
	/*
	 * 二分查找的递归实现
	public int rank(Key key,int lo,int hi){
		if(lo>hi) return lo;
		int mid = lo+(hi - lo)/2;
		int cmp = key.compareTo(keys[mid]);
		if(cmp<0) 
			return rank(key,lo,mid-1);
		else if(cmp>0)
			return rank(key,mid+1,hi);
		else return mid;
	}
	**/
	
	public void put(Key key,Value val){
		//查找键，找到则更新值，否则创建新元素
		int i = rank(key);
		if(i<N && keys[i].compareTo(key) == 0){
			vals[i] = val;
			return ;
		}
		for(int j = N;j>i;j--){
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
}
