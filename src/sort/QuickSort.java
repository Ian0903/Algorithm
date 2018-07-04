package sort;
/*
 * 快速排序思想：快速排序通过一个切分元素将数组分为两个子数组，左子数组小于等于切分元素，右子数组大于等于切分元素，将这两个子数组排序也就将整个数组排序了。
 * 时间复杂度:O(NlogN)
 * 效率：快速排序是原地排序，不需要辅助数组，但递归需要辅助栈，为了防止数组一开始是有序的，需要在排序前将数组打乱。
 */

public class QuickSort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arrTest = {2,-1,0,15,6,1,7,2};
		quickSort(arrTest,0,arrTest.length-1);
		printArr(arrTest);
	}
	
	public static void quickSort(int[] arr,int low,int high){
		if(low >= high) return;
		int partition = partition(arr,low,high);
		quickSort(arr,low,partition-1);
		quickSort(arr,partition+1,high);
	}
	
	public static int partition(int[] arr,int low,int high){
		int i = low;
		int j = high+1;//由于基准值选为1，因此j+1
		int key = arr[low];//基准值
		while(true){
			while(arr[++i] < key && i != high);
			while(arr[--j] > key && j != low);
			if(i>=j) break;
			//交换左右指针的值
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		//左右指针相遇，将基准值放到正确位置
		int temp = arr[low];
		arr[low] = arr[j];
		arr[j] = temp;
		
		return j;
	}
	
	public static void printArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
