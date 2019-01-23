import java.util.Scanner;

/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-19 18:33:48
 * @Version V1.0
 */

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int kase = 1;
		
		while (true) {
			int r = in.nextInt();
			if (r == 0) {
				in.close();
				break;
			}
			if (kase > 1) {	// 注意输出格式
				System.out.println();
			}
			int c = in.nextInt();
			char[][] grid = new char[r][c];	// 字谜
			int[][] number = new int[r][c];	// 起始标记，0 表示非起始，-1表示*
			
			for (int i=0; i<r; i++) {
				grid[i] = in.next().toCharArray();
			}
			
			int cnt = 1;	// 起始点编号
			for (int i=0; i<r; i++) {	// 标记起始，填充 number
				for (int j=0; j<c; j++) {
					if (grid[i][j] == '*') {	// *
						number[i][j] = -1;
					} else if (i == 0 || j == 0) {	// 网格左边界和上边界处理
						if (grid[i][j] != '*') {
							number[i][j] = cnt++;
						}
					} else {
						if (grid[i-1][j] != '*' && grid[i][j-1] != '*') {	// 非起始格
							number[i][j] = 0;
						} else {	// 起始格
							number[i][j] = cnt++;
						}
					}
				}
			}
			
			System.out.printf("puzzle #%d:\n", kase++);
			System.out.println("Across");
			for (int i=0; i<r; i++) {	// Across
				for (int j=0; j<c; j++) {
					if (number[i][j] == -1 || number[i][j] == 0) {
						continue;
					}
					if (j == 0 || (j != 0 && number[i][j-1] == -1)) {
						System.out.printf("%3d.", number[i][j]);
						for (int m = j; m < c && number[i][m] != -1; m++) {
							System.out.print(grid[i][m]);
						}
						System.out.println();
					}
				}
			}
			
			System.out.println("Down");
			for (int i=0; i<r; i++) {	// Down
				for (int j=0; j<c; j++) {
					if (number[i][j] == -1 || number[i][j] == 0) {
						continue;
					}
					if (i == 0 || (i != 0 && number[i-1][j] == -1)) {
						System.out.printf("%3d.", number[i][j]);
						for (int m = i; m < r && number[m][j] != -1; m++) {
							System.out.print(grid[m][j]);
						}
						System.out.println();
					}
				}
			}
		}
	}

}
