/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-15 19:33:30
 * @Version V1.0
 */

import java.util.Scanner;

public class Main {

	private static final String MSG[] = {" -- is not a palindrome.",
			" -- is a regular palindrome.", " -- is a mirrored string.",
			" -- is a mirrored palindrome."};
	private static final char REV[] = "A   3  HIL JM O   2TUVWXY51SE Z  8 ".toCharArray();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNextLine()) {
			String s = in.nextLine();
			int len = s.length();
			int p = 1, m = 1;
			
			for (int i=0; i<(len+1)/2; i++) {
				if (s.charAt(i) != s.charAt(len-1-i)) {	// 判断回文
					p = 0;
				}
				if (rev(s.charAt(i)) != s.charAt(len-1-i)) {	// 判断镜像
					m = 0;
				}
			}
			System.out.println(s + MSG[m*2+p]+"\n");
		}
		
		in.close();
	}
	
	/**
	 * find the reverse of character and return it
	 * @param c
	 * @return
	 */
	private static char rev(char c) {
		if (Character.isAlphabetic(c)) {
			return REV[c-'A'];
		}
		return REV[c-'0'+25];
	}

}
