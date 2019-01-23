import java.util.Scanner;

/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-19 10:28:23
 * @Version V1.0
 */

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for (int i=0; i<n; i++) {
			String s = in.next();
			int len = s.length();
			int T = 0;
			
			// s 的最小周期范围为 1~len
			// 从 1 开始，不断测试，知道找到最小周期 T
			// 第一步，截取子串，即周期串 tmp1
			// 第二步，用空格替换 s 中的所有子串  tmp1，得到新的字符串 tmp2
			// 第三步，判断 tmp2 的长度，若为 0，则说明 s 是一个以 j 为周期，以 tmp1 生成的
			for (int j=1; j<=len; j++) {	// 从 1 开始，找到 s 的最小周期 T
				String tmp1 = s.substring(0, j);
				String tmp2 = s.replaceAll(tmp1, "");	// 若 s 是以 j 为周期，则 tmp2 为空串
				
				if (tmp2.length() == 0) {	// 找到最小周期 T
					T = j;
					break;
				}
			}
			System.out.println(T);
			if (i != n-1) {	// 注意输出格式
				System.out.println();
			}
		}
		
		in.close();
	}

}
