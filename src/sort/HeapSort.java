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
		int[] arrTest = {4,-1,0,15,6,1,7,2};
		heapSort(arrTest);
		printArr(arrTest);
	}
	
	public static void heapSort(int[] arr){
		int N = arr.length;
		for(int i = N/2-1;i>=0;i--)//堆构建
			sink(arr,i,N);
		//交换顶点和最后一个节点，重新下沉调整堆结构
		for(int j = arr.length - 1;j>0;j--){
			int temp = arr[0];
			arr[0] = arr[j];
			arr[j] = temp;
			sink(arr,0,j);
		}
		
	}
	
	//堆元素下沉操作
	public static void sink(int[] arr,int i,int N){
		for(int k = 2*i+1;k<N;k = 2*k+1){//从i节点的左子节点开始
			if(k+1<N && arr[k]<arr[k+1]){//若左子节点小于右子节点则k指向右子节点
				k++;
			}
			if(arr[k]>arr[i]){//若子节点大于父节点，则交换值
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
			}else{
				break;
			}
		}
	}
	
	//打印数组
	public static void printArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

}
