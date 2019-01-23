import java.util.Scanner;

/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-20 14:52:39
 * @Version V1.0
 */

public class Main {

	private static final int MAXN = 3001;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a, b;
		
		while (in.hasNext()) {
			int[] remainders = new int[MAXN];	// 余数
			int[] rst = new int[MAXN];			// 每次除的结果（除第一次外）
			int cnt = 0;	// 循环节的位数
			a = in.nextInt();
			b = in.nextInt();
			
			System.out.printf("%d/%d = %d.", a, b, a/b);
			
			a %= b;
			
			while (remainders[a] == 0) {	// 找到循环节
				rst[++cnt] = (a * 10) / b;	// * 10 是必须的
				remainders[a] = cnt;	// 下标为余数，值为第几个，即小数点后第几位
				a = a * 10 % b;	// * 10 是必须的
			}
			
			for (int i=1; i<=cnt && i<51; i++) {
				if (i == remainders[a]) {	// 找到循环节后，a 为循环节第一个数
					System.out.print("(");
				}
				System.out.print(rst[i]);
				if (i == 50) {
					System.out.print("...");
				}
			}
			System.out.println(")");
			System.out.println("   " + (cnt - remainders[a] + 1) + " = number of digits in repeating cycle\n");
		}
		
		in.close();
	}

}
