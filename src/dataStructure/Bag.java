package dataStructure;

import java.util.Iterator;

/*
 * 背包是一种不支持从中删除元素的数据类型——它目的就是帮助用例收集元素并迭代遍历所有收集到的元素。
 */
public class Bag<Item> implements Iterable<Item> {
	private Node first;//链表的首节点
	private class Node{
		Item item;
		Node next;
	}
	public void add(Item item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		
		private Node current = first;
		@Override
		public boolean hasNext() {
			
			return current!=null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
}
