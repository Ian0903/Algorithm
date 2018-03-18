package sort;

public class ShellSort {
	/*
	 * 希尔排序思想：希尔排序通过插入排序对间隔h的序列进行排序，通过不断减小h，最后令h=1，就可以是整个序列有序。
	 * 时间复杂度:O(N)
	 * 效率:希尔排序的运行时间达不到平方级别，已知最坏的时间复杂度为O(N^3/2)。能够解决一些初级排序算法无能为力的问题。
	 */

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arrTest = {2,-1,0,15,6,1,7,2};
		shellSort(arrTest);
		printArr(arrTest);
	}
	
	public static void shellSort(int[] arr){
		//增量gap，并逐步减小增量gap
		for(int gap = arr.length/2;gap>0;gap/=2){
			for(int i = gap;i<arr.length;i++){
				int j=i;
				while(j-gap>=0 && arr[j]<arr[j-gap]){
					int temp = arr[j];
					arr[j] = arr[j-gap];
					arr[j-gap] = temp;
					j-=gap;
				}
			}
		}
	}
	
	public static void printArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
}
