import java.util.Scanner;

/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-20 21:30:47
 * @Version V1.0
 */

public class Main {

	private static final int MAXN = 101;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			String s1 = in.next();
			String s2 = in.next();
			int[] height = new int[MAXN*3];	// 左、中、右，每个长条的长度 <= 100
			int len1 = s1.length();
			int len2 = s2.length();
			int ans = len1 + len2;	// 最大的解为二者之和
			
			for (int i=0; i<len1; i++) {	// 将其中一个串放在中间，并做相关处理
				height[MAXN+i] = s1.charAt(i) - '0';
			}
			
			// 另外一个串从左往右跑，而且是尾和上一个串的头相接
			//-----------------------
			// ****
			//     ********
			//-----------------------
			//     ********
			//             ****
			//-----------------------
			for (int i=MAXN-len2; i<=MAXN+len1; i++) {
				boolean flag = true;
				for (int j=0;j<len2; j++) {
					if (s2.charAt(j) - '0' + height[i+j] > 3) {	// 高度为 3
						flag = false;
						break;
					}
				}
				if (flag) {
					ans = Math.min(ans, Math.max(i+len2, MAXN+len1)-Math.min(i, MAXN));
				}
			}
			System.out.println(ans);
		}
		
		in.close();
	}

}
