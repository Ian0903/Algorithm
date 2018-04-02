package dataStructure;
/*
 * union-find算法
 * 用于解决动态连通性问题，能动态连接两个点，并且判断两个点是否连通。
 */
public class UF {
	private int[] id;//分量id
	private int count;//分量数量
	public UF(int N){
		//初始化分量id数组
		count = N;
		id = new int[N];
		for(int i = 0;i<N;i++)
			id[i] = i;
	}
	
	public int count(){
		return count;
	}
	
	public boolean connected(int p,int q){
		return find(p) == find(q);
	}
	
	public int find(int p){
		return id[p];
	}
	
	public void union(int p,int q){
		//将p和q归并到相同的分量中
		int pID = find(p);
		int qID = find(q);
		
		//如果p和q已经在相同的分量中则不采取任何行动
		if(pID == qID) return;
		//将p的分量重命名位q的名称
		for(int i = 0;i<id.length;i++){
			if(id[i] == pID) 
				id[i] = qID;
		count--;
		}
	}
}
