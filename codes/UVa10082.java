/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-15 18:43:15
 * @Version V1.0
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		char cArr[] = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./ ".toCharArray();	// 最后包括一个空格
		int clen = cArr.length;
		Scanner in = new Scanner(System.in);
		
		while (in.hasNextLine()) {
			String s = in.nextLine();
			int slen = s.length();
			
			for (int i=0; i<slen; i++) {
				int j = 1;
				char c = s.charAt(i);
				
				for ( ; j<clen && c!=cArr[j]; j++);	// 找到输入字符串当前遍历的字符在字符数组中的位置
				
				if (cArr[j] != ' ') {
					System.out.print(cArr[j-1]);
				} else {
					System.out.print(c);
				}
			}
			System.out.println();	// nextLine()只能读取一行，无法读取换行符
		}
		
		in.close();
	}

}
