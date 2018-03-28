package dataStructure;

import java.util.Iterator;
/*
 * 使用链表实现队列
 */

public class Queue<Item> implements Iterable<Item>{
	
	private Node first;
	private Node last;
	private int N;
	
	public boolean isEmpty(){
		return N == 0;
	}
	public int size(){
		return N;
	}
	
	public void enqueue(Item item){
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else oldlast.next = last;
		N++;
	}
	
	public Item dequeue(){
		Item item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		N--;
		return item;
	}
	
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext(){
			return current!=null;
		}
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	private class Node {
		Item item;
		Node next;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Queue<Integer> llq = new Queue<Integer>();
		for(int i = 0;i<10;i++){
			llq.enqueue(i);
		}
		for(int i = 0;i<10;i++){
			System.out.print(llq.dequeue()+" ");
		}
	}
}

