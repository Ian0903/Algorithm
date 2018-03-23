package search;

/*
 * 红黑树性质：1.红链接都为左结点	2.完美黑色平衡，即任意空链接到根节点的路径上的黑链接数量相同
 * 红黑树插入算法：
 * 	1.如果右子节点是红色的而左子点是红色的，则进行左旋转
 * 	2.如果左字节是红色的且它的左子节点也是红色的，则进行右旋转
 * 	3.如果左右节点均为红色，则进行颜色转换
 */
public class RedBlackBST<Key extends Comparable,Value> {
	private Node root;
	
	private static final boolean RED = true;
	
	private static final boolean BLACK = false;
	private class Node{
		Key key;
		Value val;
		Node left,right;
		int N;
		boolean color;//由其父节点指向它的链接颜色
		
		Node(Key key,Value val,int N,boolean color){
			this.key = key;
			this.N = N;
			this.color = color;
		}
	}
	
	private boolean isRed(Node x){
		if(x == null) return false;
		return x.color == RED;
	}
	
	private Node rotateLeft(Node h){
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	private Node rotateRight(Node h){
		Node x= h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1+size(h.left) + size(h.right);
		return x;
	}
	
	private int size(Node h){
		if(h == null) return 0;
		return h.N;
	}
	
	private void flipColor(Node h){
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	public void put(Key key,Value val){
		root = put(root,key,val);
		root.color = BLACK;
	}
	
	private Node put(Node h,Key key,Value val){
		if(h == null)//标准的插入操作，和父节点用红链接相连
			return new Node(key,val,1,RED);
		int cmp = key.compareTo(h.val);
		if(cmp < 0) put(h.left,key,val);
		else if(cmp > 0) put(h.right,key,val);
		else h.val = val;
		
		if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
		if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
		if(isRed(h.left) && isRed(h.right)) flipColor(h);
		
		h.N = size(h.left)+size(h.right)+1;
		return h;
	}
}
