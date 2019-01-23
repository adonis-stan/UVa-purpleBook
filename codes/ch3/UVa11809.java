import java.util.Scanner;

/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-20 21:31:23
 * @Version V1.0
 */

public class Main {

	private static final double ZERO = 1e-6;	// 浮点数运算有精度问题，判 0 不是 == 0
	private static final double LG2 = Math.log10(2);
	
	// C * 2^D = A * 10^B
	// C = 1 - (1/2)^M
	// D = 2^E - 1
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double A = 0.0;
		int B = 0;
		
		while (in.hasNext()) {
			String s = in.next();
			if (s.equals("0e0")) {	// 结束
				break;
			}
			String[] numbers = s.split("[e]");
			A = Double.parseDouble(numbers[0]);
			B = Integer.parseInt(numbers[1]);
			double lgsum = Math.log10(A) + B;
			
			for (int M=1; M<=10; M++) {
				double tmp = Math.log10(1-Math.pow(0.5, M));	// 1>>M 不行，等于 0
				long E = Math.round(Math.log10((lgsum - tmp) / LG2 + 1) / LG2);	// 阶码的位数
				if (Math.abs(lgsum - tmp - LG2 * ((1<<E) - 1)) <= ZERO) {
					System.out.printf("%d %d\n", M-1, E);	// M-1: 小数点后第一位必须是 1
					break;
				}
			}
		}
		
//		while (in.hasNext()) {
//			String s = in.next();
//			if (s.equals("0e0")) {	// 结束
//				break;
//			}
//			String[] numbers = s.split("[e]");
//			A = Double.parseDouble(numbers[0]);
//			B = Integer.parseInt(numbers[1]);
//			double lgsum = A * Math.pow(10, B);
//			
//			for (int M=1; M<=10; M++) {
//				double tmp = 1 - Math.pow(0.5, M);
//				long E = Math.round(Math.log10(Math.log10(lgsum / tmp) / LG2 + 1) / LG2);
//				double tmp1 = tmp * Math.pow(2, (1<<E)-1);
//				double tmp2 = Math.abs(lgsum - tmp * Math.pow(2, (1<<E)-1));
//				if (Math.abs(lgsum - tmp * Math.pow(2, (1<<E)-1)) == 0) {
//					System.out.printf("%d %d\n", M-1, E);
//					break;
//				}
//			}
//		}
		
		in.close();
	}

}
