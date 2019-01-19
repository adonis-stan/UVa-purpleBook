import java.util.Scanner;

/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-18 20:14:15
 * @Version V1.0
 */

public class Main {

	private static final double C = 12.01;
	private static final double H = 1.008;
	private static final double O = 16.00;
	private static final double N = 14.01;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for (int i=0; i<T; i++) {
			String s = in.next();
			double mol = 0;
			int len = s.length();
			
			for (int j=0; j<len; j++) {
				char c = s.charAt(j);
				
				if (Character.isAlphabetic(c)) {	// 是字符 C H O N
					mol += getMol(c);	// 若是后面出现数字，即该原子个数，mol 少加一个该原子的质量
				} else {	// 是数字
					// 两位数，此处因为题意中明确了最多只有99个，故此处的判断是成立的
					// 如果题意没有要求，或者明确了不止两位数，
					// 此处的判断就不成立
					// 故此处的代码逻辑扩展性非常差
					if (Character.isDigit(s.charAt(j-1))) {	// 两位数
						// 注意这里需要再减去 (s.charAt(j-1) - '1')
						// 因为对于两位数来说，多加了第一个数字减 1 个该原子质量
						mol += getMol(s.charAt(j-2))
								* ((s.charAt(j-1)-'0') * 10 + (s.charAt(j) - '1') - (s.charAt(j-1) - '1'));
					} else {	// 一位数
						mol += getMol(s.charAt(j-1)) * (s.charAt(j) - '1');
					}
				}
			}
			System.out.printf("%.3f\n", mol);
		}
		
		in.close();
	}
	
	private static double getMol(char c) {
		if (c == 'C') {
			return C;
		}
		if (c == 'H') {
			return H;
		}
		if (c == 'O') {
			return O;
		}
		if (c == 'N') {
			return N;
		}
		return 0;
	}

}
