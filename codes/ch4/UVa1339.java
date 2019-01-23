import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-21 21:15:41
 * @Version V1.0
 */

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			String s1 = in.next();
			String s2 = in.next();
			int[] a1 = new int[26];
			int[] a2 = new int[26];
			int len = s1.length();
			boolean flag = true;
			
			for (int i=0; i<len; i++) {
				a1[s1.charAt(i) - 'A']++;
				a2[s2.charAt(i) - 'A']++;
			}
			
			Arrays.sort(a1);
			Arrays.sort(a2);
			
			for (int i=0; i<26; i++) {
				if (a1[i] != a2[i]) {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		in.close();
	}

}
