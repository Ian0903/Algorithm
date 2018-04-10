package string;
/*
 * 三向字符串快速排序
 * 适用于含有较长公共前缀的字符串
 */
public class Quick3string{
    private static int charAt(String s,int d){
        if(d<s.length())
            return s.charAt(d);
        else
            return -1;
    }
    private static void exch(String[] a,int i,int j){
        String t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void sort(String[] a){
        sort(a,0,a.length-1,0);
    }
    private static void sort(String[] a,int lo,int hi,int d){
        if(hi<=lo)
            return;
        int lt = lo,gt = hi;
        int v = charAt(a[lo],d);
        int i = lo + 1;
        while(i<=gt){ //三向，分成大于，等于，小于v 三种
            //a[lo..lt-1] < v=a[lt..gt] < a[gt+1..hi]
            int t = charAt(a[i],d);
            if(t<v)
                exch(a,lt++,i++);//换到最开头
            else if(t>v)
                exch(a,i,gt--);//换到最末尾
            else
                i++;//不换
        }
        //a[lo..lt-1] < v=a[lt..gt] < a[gt+1..hi]
        sort(a,lo,lt-1,d);//因为这时a[lo..lt-1]都是小于v的，但是不一定有序，因此要针对当前字符再进行递归排序
        if(v>=0) //说明不是字符串末尾（将会返回-1）   
            sort(a,lt,gt,d+1);//既然不是字符串末尾，那么就可以进行下一个位置字符的处理
        sort(a,gt+1,hi,d);
    }

    public static void main(String[] args){
        String[] a ={"12","3122","231","31","2134","1243","1244","1245","1246"};
        sort(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}