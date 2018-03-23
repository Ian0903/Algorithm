package search;
/*
 * 基于线性探测法的散列表
 * 思想：线性探测法使用空位来解决冲突，当冲突发生时，向前探测一个空位来存储冲突的键。使用线程探测法，数组的大小 M 应当大于键的个数 N（M>N)。
 */

public class LinearProbingHashST<Key,Value> {
	private int N;//键值对总数、
	private int M;//线性探测表大小
	private Key[] keys;
	private Value[] vals;
	
	public LinearProbingHashST(){
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	
	public LinearProbingHashST(int cap){
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
		resize(cap);
	}
	private int hash(Key key){
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	//为了保证散列表的性能，应当调整数组的大小，使得N/M在 [1/4, 1/2] 之间。
	private void resize(){
		if(N >= M/2) resize(2 * M);
		else if(N <= M/8) resize(M / 2);
	}
	
	private void resize(int cap){
		LinearProbingHashST<Key,Value> t;
		t = new LinearProbingHashST<Key,Value>(cap);
		for(int i = 0;i<M;i++)
			if(keys[i] != null)
				t.put(keys[i],vals[i]);
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}
	
	public void put(Key key,Value val){
		if(N >= M/2) resize(2*M);
		
		int i;
		for(i = hash(key);keys[i] !=null;i = (i+1)%M)
			if(keys[i].equals(key)){
				vals[i] = val;
				return;	
			}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	public Value get(Key key){
		for(int i = hash(key);keys[i]!=null;i=(i+1)% M)
				if(keys[i].equals(key))
					return vals[i];
		return null;
	}
	
	//删除操作：将删除键的右侧所有相邻的键值重新插入散列表中
	public void delete(Key key){
		int i = hash(key);
		while(!key.equals(keys[i]))
				i = (i+1) % M;
		keys[i] = null;
		vals[i] = null;
		i = (i+1) % M;
		while(keys[i] != null){
			Key keyToRedo = keys[i];
			Value valToRedo = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--;
			put(keyToRedo,valToRedo);
			i = (i+1) % M;
		}
		N--;
		if(N>0 && N == M/8) resize(M/2);
	}
}
