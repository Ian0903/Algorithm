package sort;

/*
 * 归并排序思想：要将一个数组排序时，可先将它分为（递归）两半分别排序，然后再将结果归并起来。
 * 时间复杂度：O(NlgN)
 * 效率：若为小数组的话递归操作会过于频繁，不适合选择归并排序。
 */

public class MergeSort {
	private static int[] aux;//归并所需的辅助数组

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arrTest = {2,-1,0,15,6,1,7,2};
		aux = new int[arrTest.length];
		sort(arrTest,0,arrTest.length-1);
		printArr(arrTest);
	}
	
	public static void sort(int[] arr,int low,int high){
		if(low>=high) return;
		int mid = low + (high - low)/2;
		sort(arr,low,mid);//左半边排序
		sort(arr,mid+1,high);//右半边排序
		mergeSort(arr,low,mid,high);//归并左右排序
	}
	
	public static void mergeSort(int[] arr,int low,int mid,int high){
		int i = low;//左序列指针
		int j = mid+1;//右序列指针
		int t = 0;//临时数组指针
		//比较左右序列指针，取值小的放入临时数组中
		while(i <= mid && j <= high){
			if(arr[i] < arr[j]){
				aux[t++] = arr[i++];
			}else{
				aux[t++] = arr[j++];
			}
		}
		
		//将左边剩余的值存入临时数组中
		while(i <= mid){
			aux[t++] = arr[i++];
		}
		//将右边剩余的值存入临时数组中
		while(j <= high){
			aux[t++] = arr[j++];
		}
		
		//把临时数组的值复制回原数组
		t=0;
		while(low <= high){
			arr[low++] = aux[t++]; 
		}
	}
	
	
	
	//打印数组
		public static void printArr(int[] arr){
			for(int i=0;i<arr.length;i++){
				System.out.print(arr[i]+" ");
			}
		}

}
