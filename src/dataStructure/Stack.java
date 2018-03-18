package dataStructure;

import java.util.Iterator;
/*
 * 分别使用数组、链表实现下压栈。
 */

//数组实现下压栈
class ResizingArrayStack<Item> implements Iterable<Item>{
	
	private Item[] a = (Item[]) new Object[1];//栈元素
	private int N = 0;
	public boolean isEmpty(){return N == 0;}
	public int size(){return N;}
	private void resize(int max){
		//将栈移动到一个大小位MAX的新数组
		Item[] temp = (Item[]) new Object[max];
		for(int i = 0;i<N;i++)
			temp[i] = a[i];
		a = temp;
	}
	
	public void push(Item item){
		//将元素添加到栈顶
		if(N==a.length) resize(2*a.length);//动态增加数组大小
		a[N++] = item;
	}
	
	public Item pop(){
		//从栈顶删除元素
		Item item = a[--N];
		a[N] = null;//避免对象游离
		if(N>0 && N == a.length/4) resize(a.length/2);//删除多余空间
		return item;
	}
	
	public Iterator<Item> iterator(){ 
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		//支持后进先出的迭代
		private int i = N;
		public boolean hasNext(){ return i>0;}
		public Item next(){return a[--i];}
	}
}

//链表实现下压栈
class LinkListStack<Item> implements Iterable<Item>{
	private Node first;//栈顶元素
	private int N;//元素数量
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void push(Item item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
	//单链表结构
	private class Node{
		Item item;
		Node next;
	}
}

public class Stack {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ResizingArrayStack<Integer> ras = new ResizingArrayStack<Integer>();
		LinkListStack<Integer> lls = new LinkListStack<Integer>();
		for(int i = 0;i<10;i++){
			ras.push(i);
			lls.push(i);
		}
		System.out.print("ResizingArrayStack:");
		for(int i = 0;i<10;i++){
			System.out.print(ras.pop()+" ");
			
		}
		
		System.out.print("LinkListStack:");
		for(int i = 0;i<10;i++){
			System.out.print(lls.pop()+" ");
		}
		
	}

}
