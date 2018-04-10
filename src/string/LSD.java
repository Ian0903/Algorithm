package string;

/*
 * 低位优先的字符串排序
 * 适用于长度特定的字符串
 */
public class LSD {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String[] testStr = {"2IYE230","3CI0722","1ICK751","10HV845","4JZY524"};
		sort(testStr,7);
		printStr(testStr);
	}


	public static void sort(String[] a,int W){
		//通过前W个字符将a[]排序
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];//临时字符串数组

		for(int d = W-1;d>=0;d--){
			//根据第d个字符用键索引计数法排序
			int[] count = new int[R+1];//计算出现频率
			for(int i = 0;i<N;i++)
				count[a[i].charAt(d) + 1]++;
			for(int r = 0;r<R;r++)//将频率转化为索引
				count[r+1]+=count[r];
			for(int i = 0;i<N;i++)//将元素分类
				aux[count[a[i].charAt(d)]++] = a[i];
			for(int i = 0;i<N;i++)//回写
				a[i] = aux[i];
		}
	}
	
	public static void printStr(String[] arr){
		for(int i = 0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}

