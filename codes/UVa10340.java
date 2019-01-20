import java.util.Scanner;

/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-20 15:35:01
 * @Version V1.0
 */

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			String s = in.next();
			String t = in.next();
			int len = t.length();
			int cnt = 0;
			
			for (int i=0; i<len; i++) {
				if (t.charAt(i) == s.charAt(cnt)) {
					cnt++;
				}
				// 此处一旦找到了，就必须得跳出循环
				// 如果不跳出循环，会报异常：java.lang.StringIndexOutOfBoundsException
				// 因为在 cnt == s.length() ，字符串 t 还没有遍历完时，此时 cnt 已经越界了
				if (cnt == s.length()) {
					System.out.println("Yes");
					break;
				}
			}
			if (cnt != s.length()) {
				System.out.println("No");
			}
		}
		
		in.close();
	}

}
