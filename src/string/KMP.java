package string;
/*
 * KMP字符串查找算法
 */
public class KMP {
	private static int[] next;
	
	public static int KMP(String t, String p) {

		next = new int[p.length()];
		getNext(p, next);
		int i = 0;
		int j = 0;

		while (i < t.length() && j < p.length()) {
			if (j == -1 || t.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}

		if (j == p.length())
			return i - j;
		else
			return -1;
	}

	public static void getNext(String p, int[] next) {
		next[0] = -1;
		int i = 0, j = -1;
		while (i < p.length()-1) {
			if (j == -1 || p.charAt(i) == p.charAt(j)) {
				++j;
				++i;
				next[i] = j;
			} else {
				j = next[j];
			}

		}
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String a = "ababababca";
		String b = "abababca";
		int index = KMP(a, b);
		System.out.println(index);
	}

}
