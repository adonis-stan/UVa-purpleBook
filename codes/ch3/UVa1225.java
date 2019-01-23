import java.util.Scanner;

/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-18 21:42:32
 * @Version V1.0
 */

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for (int i=0; i<T; i++) {
			int n = in.nextInt();
			//String s = "";
			StringBuilder s = new StringBuilder();
			int[] ans = new int[10];
			
			// 会产生许多垃圾内存，详细请了解Java字符串的相关知识
			/*for (int j=1; j<=n; j++) {
				s += j;
			}*/
			for (int j=1; j<=n; j++) {
				s.append(j);
			}
			
			int len = s.length();
			
			for (int j=0; j<len; j++) {
				ans[s.charAt(j)-'0']++;
			}
			
			for (int j=0; j<10; j++) {
				System.out.print(ans[j]);
				if (j != 9) {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
		
		in.close();
	}

}
