package search;
/*
 * 顺序查询（基于无序链表）
 * 优点：适用于小型问题
 * 缺点：对大型符号表很慢
 */

public class SequentialSearchST<Key,Value>{
	private Node first;//链表首节点
	
	private class Node{
		//链表节点的定义
		Key key;
		Value val;
		Node next;
		
		public Node(Key key,Value val,Node next){
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public Value get(Key key){
		for(Node x = first;x!=null;x=x.next){
			if(key.equals(x.key))
				return x.val;//命中
		}
		return null;//未命中
	}
	
	public void put(Key key,Value val){
		for(Node x = first;x!=null;x = x.next){
			if(key.equals(x.key))
				x.val = val;//命中，更新
		}
		first = new Node(key,val,first);//未命中，新建节点
		
	}
}

