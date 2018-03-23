package search;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


public class BST <Key extends Comparable,Value> {
	private Node root;//二叉查找树根节点
	
	private class Node{
		private Key key;
		private Value val;
		private Node left,right;
		private int N;
		
		public Node(Key key,Value val,int N){
			this.key = key;
			this.val = val;
			this.N = N;
		}
		
		public int size(){
			return N;
		}
		
		public int size(Node node){
			if(node == null) return 0;
			return node.N;
		}
		
		public Value get(Key key){
			return get(root,key);
		}
		
		private  Value get(Node x,Key key){
			//在以x为根节点的子树中查找并返回key对应Value
			//若查找不到则返回null
			if(x == null) return null;
			int cmp = key.compareTo(x.key);
			if(cmp <0) return get(x.left,key);
			else if(cmp>0) return get(x.right,key);
			return x.val;
		}
		
		public void put(Key key,Value val){
			root = put(root,key,val);
		}
		
		private Node put(Node x,Key key,Value val){
			//如果key存在于x为根节点的子树中，则更新它的值
			//否则将以key和val为键值的新结点插入到该子树中
			if(x == null) return new Node(key,val,1);
			int cmp = key.compareTo(x.val);
			if(cmp<0) x.left = put(x.left,key,val);
			else if(cmp>0) x.right = put(x.right,key,val);
			else x.val = val;
			x.N = size(x.left)+size(x.right)+1;
			return x;
		}
		
		public Key min(){
			return min(root).key;
		}
		
		//最小键
		private Node min(Node x){
			if(x.left == null) return x;
			return min(x.left);
		}
		
		public Key floor(Key key){
			Node x = floor(root,key);
			if(x == null)return null;
			return x.key;
		}
		
		//向上取整
		//如果 key 小于根节点的 key，那么小于等于 key 的最大键节点一定在左子树中；如果 key 大于根节点的 key，只有当根节点右子树中存在小于等于 key 的节点，小于等于 key 的最大键节点才在右子树中，否则根节点就是小于等于 key 的最大键节点。
		private Node floor(Node x,Key key){
			if(x == null) return null;
			int cmp = key.compareTo(x.val);
			if(cmp == 0) return x;
			if(cmp<0) return floor(x.left,key);
			Node t = floor(x.right,key);
			if(t!=null) return t;
			else return x;
		}
		
		public int rank(Key key){
			return rank(root,key);
		}
		
		//排名
		//如果给定的键和根节点相等，则返回左子树中的节点总数t；若小于根节点，则返回该键在左子树中的排名（利用递归）；若大于根节点，返回t+1（根节点）加上它在右子树中的排名（递归计算）
		private int rank(Node x,Key key){
			if(x == null) return 0;
			int cmp = key.compareTo(x.val);
			if(cmp <0) return rank(x.left,key);
			else if(cmp>0) return rank(x.right,key);
			else return x.size(x.left);
		}
		
		//删除操作
		//如果待删除节点只有一个子树，则直接让待删除的节点链接指向子树；若有两个子树，则让右子树的最小节点指向该节点。
		public void deleteMin(){
			root = deleteMin(root);
		}
		
		private Node deleteMin(Node x){
			if(x.left == null) return x.right;
			x.left = deleteMin(x.left);
			x.N = size(x.left)+size(x.right)+1;
			return x;
		}
		
		public void delete(Key key){
			root = delete(root,key);
		}
		
		private Node delete(Node x,Key key){
			if(x==null) return null;
			int cmp = key.compareTo(x.val);
			if(cmp<0) x.left = delete(x.left,key);
			else if(cmp>0) x.right = delete(x.right,key);
			else{
				//待删除的节点只有一个子树
				if(x.right == null) return x.left;
				else if(x.left == null) return x.right;
				//待删除的节点有两个子树
				Node t = x;
				x = min(t.right);
				x.right = deleteMin(t.right);
				x.left = t.left;
				
			}
			x.N = size(x.left)+size(x.right)+1;
			return x;
		}
		
		//范围查找
		//利用二叉查找树中序遍历的结果为有序序列的特点
		public Iterable<Key> keys(Key lo,Key hi){
			Queue<Key> queue = new LinkedBlockingQueue<Key>();
			keys(root,queue,lo,hi);
			return queue;
		}
		
		private void keys(Node x,Queue<Key> queue,Key lo,Key hi){
			if(x == null) return;
			int cmplo = lo.compareTo(x.key);
			int cmphi = hi.compareTo(x.key);
			if(cmplo < 0) keys(x.left,queue,lo,hi);
			if(cmplo<=0 && cmphi<=0) queue.add(x.key);
			if(cmphi >0) keys(x.right,queue,lo,hi);
		}
	}
}
