package sort;

public class InsertSort {

	/*
	 * 插入排序思想：入排序从左到右开始，将符合条件的当前元素插入到左边已经排序的数组中，使得插入后的数组仍有序。
	 * 时间复杂度：O(N^2)
	 * 效率：插入排序的效率取决与原始数组的排序状态，如果数组已经部分有序了，则插入排序会很快。对于部分有序数组和小规模数组特别高效。
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arrTest = {2,-1,0,15,6,1,7,2};
		insertSort(arrTest);
		printArr(arrTest);
	}

	public static void insertSort(int[] arr){
		for(int i = 1;i<arr.length;i++){
			for(int j = i;j>0;j--){
				if(arr[j-1]>arr[j]){
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
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
