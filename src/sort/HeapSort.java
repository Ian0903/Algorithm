package sort;
/*
 * 思想：由于堆可以很容易得到最大元素并删除它，不断进行这种操作可以得到递减序列。
 * 		如果把最大元素和最后一个元素交换位置，并且不删除它，可以得到一个递增序列。
 * 		堆排序分为两个阶段，第一个阶段是把无序数组建立成一个堆；第二个阶段是交换最大元素并进行下沉操作恢复堆秩序。
 * 时间复杂度：O(NlogN)
 */
public class HeapSort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arrTest = {2,-1,0,15,6,1,7,2};
		heapSort(arrTest);
		printArr(arrTest);
	}
	
	public static void heapSort(int[] arr){
		int N = arr.length;
		for(int k = N/2;k>=1;k--)//堆构建
			sink(arr,k,N);
		
		while(N>1){
			int temp = arr[1];
			arr[1] = arr[N];
			arr[N--] = arr[1];
			//每交换一次首尾节点后进行下沉排序
			sink(arr,1,N);
		}
		
	}
	
	//堆元素下沉操作
	public static void sink(int[] a,int k,int N){
		while(2*k<=N){
			int j = 2*k;
			if(j<N && a[j]<a[j+1]) j++;
			if(a[k]>a[j]) break;
			int temp = a[k];
			a[k] = a[j];
			a[j] = temp;
			k = j;
		}
	}
	
	//打印数组
	public static void printArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

}
