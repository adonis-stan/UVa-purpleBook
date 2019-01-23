/**
 * @author Adonis
 * @E-mail 1583801169@qq.com
 * @Creation Time 2019年1月15日 上午11:21:23
 * @Version V1.0
 */

import java.util.Scanner;

public class UVa272 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean flag = true;	// 区分左右双引号
		String s = "";
		
		while (in.hasNextLine()) {
			s = in.nextLine();
			
			for (int i=0; i < s.length(); i++) {
				char c = s.charAt(i);
				
				if (c == '"') {
					System.out.print(flag ? "``" : "''");
					flag = !flag;
				} else {
					System.out.print(c);
				}
			}
			System.out.print("\n");	// nextLine()读取一行，但是不读取换行符
		}
		in.close();
	}

}
