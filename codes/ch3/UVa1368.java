import java.util.Scanner;

/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-20 12:16:55
 * @Version V1.0
 */

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for (int t=0; t<T; t++) {
			int m = in.nextInt();
			int n = in.nextInt();
			char[][] dna = new char[m][n];	// DNA序列数组
			
			for (int i=0; i<m; i++) {
				dna[i] = in.next().toCharArray();
			}
			
			StringBuilder s = new StringBuilder();	// 所求DNA序列
			int sum = 0;	// 总距离
			for (int j=0; j<n; j++) {	// 求出每列最多的那个字符
				int[] cnt = new int[4];	// 每列 A C G T 的个数
				getCnt(m, j, dna, cnt);
				
				int max = cnt[0];	// 该列中 A C G T 最多的个数
				int index = 0;		// 0:A 1:C 2:G 3:T
				for (int ii = 1; ii < 4; ii++) {
					if (max < cnt[ii]) {
						max = cnt[ii];
						index = ii;
					}
				}
				sum += m - max;	// 总距离为行数减去每列最多字符的个数之和
				switch (index) {
				case 0:
					s.append('A');
					break;

				case 1:
					s.append('C');
					break;

				case 2:
					s.append('G');
					break;

				case 3:
					s.append('T');
					break;
				}
			}
			System.out.println(s);
			System.out.println(sum);
		}
		
		in.close();
	}
	
	private static void getCnt(int m, int j, char[][] dna, int[] cnt) {
		for (int i=0; i<m; i++) {
			switch (dna[i][j]) {
			case 'A':
				cnt[0]++;
				break;

			case 'C':
				cnt[1]++;
				break;
			
			case 'G':
				cnt[2]++;
				break;
				
			case 'T':
				cnt[3]++;
				break;
			}
		}
	}

}
