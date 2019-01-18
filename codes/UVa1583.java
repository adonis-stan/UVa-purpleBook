import java.util.Scanner;

/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-18 10:24:57
 * @Version V1.0
 */

public class Main {

	private static final int MAXN = 100005;
	
	public static void main(String[] args) {
		int[] ans = new int[MAXN];	// automatically initialized to 0
		int n = 0, c = 0;
		Scanner in = new Scanner(System.in);
		
		for (int i=1; i<MAXN; i++) {
			int x = i, y = i;
			
			while (x > 0) {	// get the sum of the numbers of x and x
				y += x % 10;
				x /= 10;
			}
			if (y < MAXN && (ans[y] == 0 || i < ans[y])) {	// y<MAXN: avoid exceeding the length of array ans
				ans[y] = i;
			}
		}
		
		c = in.nextInt();
		for (int i=0; i<c; i++) {
			n = in.nextInt();
			System.out.println(ans[n]);
		}
		in.close();
	}

}
