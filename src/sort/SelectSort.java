package sort;

public class SelectSort {
	/*
	 * 选择排序思想：找到数组中最小的元素，将它放到数组的第一个元素的位置。再从剩下的元素找到最小元素，将它放到数组的第二元素的位置，直到数组排序。
	 * 时间复杂度：O(N^2)
	 * 效率：选择排序需要~N^2/2次比较和~N次比较，它的运行时间与输入无关，这个特点使得他对一个即使已经排序好的数组也需要这么多次的比较和交换。
	 */

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arrTest = {2,-1,0,15,6,1,7,2};
		selectSort(arrTest);
		printArr(arrTest);
	}
	
	public static void selectSort(int[] arr){
		int n = arr.length;
		for(int i = 0;i<n;i++){
			int min = i;
			for(int j = i+1;j<n;j++){
				if(arr[j]<arr[min]) min = j;//寻找最小元素的index
			}
			//交换元素位置
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			
		}
	}
	
	
	//打印数组
	public static void printArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
