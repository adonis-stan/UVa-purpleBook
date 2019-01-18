/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-15 20:49:26
 * @Version V1.0
 */
import java.util.Scanner;

public class Main {

	private static final int MAXN = 1010;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] a = new int[MAXN];	// 答案序列
		int[] b = new int[MAXN];	// 猜测序列
		
		for (int kase=1; ; kase++) {
			int n = in.nextInt();
			if (n == 0) {	// 输入0结束
				break;
			}
			System.out.printf("Game %d:\n", kase);
			
			for (int i=0; i<n; i++) {
				a[i] = in.nextInt();
			}
			
			for ( ; ; ) {
				int A = 0, B = 0;	// A位置正确的个数，B出现但位置不对的个数
				
				for (int i=0; i<n; i++) {
					b[i] = in.nextInt();
					if (a[i] == b[i]) {
						A++;
					}
				}
				
				if (b[0] == 0) {	// 正常的猜测序列不会有0，所以判断第一个是否为0即可
					break;
				}
				
				for (int i=1; i<=9; i++) {
					int c1 = 0, c2 = 0;	// 数字i在a和b中出现的次数
					
					for (int j=0; j<n; j++) {
						if (a[j] == i) {
							c1++;
						}
						if (b[j] == i) {
							c2++;
						}
					}
					
					B += Math.min(c1, c2);
				}
				System.out.printf("    (%d,%d)\n", A, B-A);
			}
		}
		
		in.close();
	}

}
