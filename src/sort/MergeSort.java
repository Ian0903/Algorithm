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
		sort(arr,low,mid);
		sort(arr,mid+1,high);
		mergeSort(arr,low,mid,high);
	}
	
	public static void mergeSort(int[] arr,int low,int mid,int high){
		int i = low,j = mid+1;
		//将值复制进辅助数组
		for(int k = low;k<=high;k++){
			aux[k] = arr[k];
		}
		for(int k = low;k<=high;k++){
			if(i>mid) arr[k] = aux[j++];//右半边取尽
			else if(j>high) arr[k] = aux[i++];//左半边取尽
			else if(aux[j]<aux[i]) arr[k] = aux[j++];
			else arr[k] = aux[i++];
		}
	}
	
	
	
	//打印数组
		public static void printArr(int[] arr){
			for(int i=0;i<arr.length;i++){
				System.out.print(arr[i]+" ");
			}
		}

}
