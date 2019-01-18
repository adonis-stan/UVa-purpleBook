import java.util.Scanner;

/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-18 11:11:09
 * @Version V1.0
 */

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		
		for (int i=0; i<c; i++) {
			String s = in.next();
			char[] cs = s.toCharArray();
			int len = cs.length;
			int ans = 0;	// the beginning of the lexicographically smallest sequence for the test case 
			
			for (int j=1; j<len; j++) {	// find the ans
				if (less(cs, j, ans)) {
					ans = j;
				}
			}
			
			for (int j=0; j<len; j++) {
				System.out.print(cs[(ans+j)%len]);
			}
			System.out.println();
		}
		in.close();
	}
	
	/**
	 * compare p and q to find
	 * the lexicographically smallest sequence starting with p or q
	 * @param cs 测试字符串的数组形式 
	 * @param p  以p为开始的字符串cs
	 * @param q  以q为开始的字符串cs
	 * @return
	 */
	private static boolean less(char[] cs, int p, int q) {
		int len = cs.length;
		for (int i=0; i<len; i++) {	// 循环进行两个字符串同一个位置比较
			if (cs[(p+i)%len] != cs[(q+i)%len]) {	// 不相同
				return cs[(p+i)%len] < cs[(q+i)%len];
			}
		}
		return false;	// 相同无需比较，直接返回
	}

}
