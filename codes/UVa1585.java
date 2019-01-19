import java.util.Scanner;

/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-18 19:12:54
 * @Version V1.0
 */

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for (int i=0; i<T; i++) {
			int sum = 0, count = 1;
			String s = in.next();
			int len = s.length();
			
			for (int j=0; j<len; j++) {
				if (s.charAt(j) == 'O') {
					sum += count++;
				} else {
					count = 1;
				}
			}
			System.out.println(sum);
		}
		
		in.close();
	}

}
