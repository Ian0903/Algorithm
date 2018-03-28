package MST;
/*
 * 带权重的边的数据类型
 */

public class Edge implements Comparable<Edge> {
	
	private final int v;//顶点之一
	private final int w;//另一个顶点
	private double weight;//边的权重
	
	public Edge(int v,int w,int weight){
		this.v =v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight(){
		return weight;
	}
	
	public int either(){//其中一个顶点
		return v;
	}
	
	public int other(int vertex){//另外一个顶点
		if(vertex == v) return w;
		else if(vertex == w) return v;
		else throw new RuntimeException("Inconsistent edge");
	}
	
	@Override
	public int compareTo(Edge that){
		if(this.weight()<that.weight()) return -1;
		else if(this.weight() == that.weight()) return 0;
		else return 1;
	}


}
