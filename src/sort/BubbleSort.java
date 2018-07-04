/*
 * 冒泡排序
 * 思想：通过相邻的两位比较，将值大的数移向右端。
 * 复杂度：O(n^2)
 */
package sort;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {6,3,2,7,1,0};
		bubbleSort(arr);
		printArr(arr);
	}
	
	public static void bubbleSort(int[] arr){
		for(int i = 0;i<arr.length-1;i++){
			for(int j = 0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void printArr(int[] arr){
		for(int i = 0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
