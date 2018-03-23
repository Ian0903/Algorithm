package search;
/*
 * 基于拉链法的散列表
 * 思想：使用一个链表对象的数组出列相同键的散列值情况。
 */
public class SeparateChainingHashST<Key ,Value>  {
	private int M;//散列表的大小
	private int N;//键值对的总数
	private SequentialSearchST<Key,Value>[] st;//存放链表对象的数组
	
	public SeparateChainingHashST(){
		this(997);//默认构造997条链表
	}
	
	public SeparateChainingHashST(int M){
		//创建M条链表
		this.M = M;
		st = (SequentialSearchST<Key,Value>[]) new SequentialSearchST[M];//JAVA不允许泛型的数组，需要强转
		for(int i = 0;i<M;i++){
			st[0] = new SequentialSearchST();
		}
		
	}
	
	public int hash(Key key){
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public Value get(Key key){
		return (Value) st[hash(key)].get(key);
	}
	
	public void put(Key key,Value val){
		 st[hash(key)].put(key,val);
	}
	
	
}
