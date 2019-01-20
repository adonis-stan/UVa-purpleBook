import java.util.Scanner;

/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-20 15:35:49
 * @Version V1.0
 */

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			int w = 0, h = 0;
			int[] widths = new int[6];	// 宽
			int[] lengths = new int[6];	// 长
			boolean flag = true;
			
			for (int i=0; i<6; i++) {
				w = in.nextInt();
				h = in.nextInt();
				if (w > h) {	// 大的放lengths中，小的放widths中
					lengths[i] = w;
					widths[i] = h;
				} else {
					lengths[i] = h;
					widths[i] = w;
				}
			}
			
			for (int i=0; i<6; i++) {	// 将长宽按从小到大排序，先比较长，若相等则比较宽
				for (int j=0; j<5-i; j++) {
					if (lengths[j] > lengths[j+1]) {
						swap(j, j+1, lengths);
						swap(j, j+1, widths);
					} else if (lengths[j] == lengths[j+1] && widths[j] > widths[j+1]) {
						swap(j, j+1, widths);
					}
				}
			}
			
			// 长方体由三组长方形组成，每两个相对长方形应该是一样的，即长宽相等
			// 故排序后的lengths和widths的每两个数值应该相等
			for (int i=0; i<6; i+=2) {
				if (lengths[i] != lengths[i+1] || widths[i] != widths[i+1]) {
					flag = false;
					break;
				}
			}
			
			// 长方体共12条棱，三组，即长、宽、高
			if (lengths[5] != lengths[3] || lengths[1] != widths[5] || widths[3] != widths[1]) {
				flag = false;
			}
			
			if (flag) {
				System.out.println("POSSIBLE");
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
		
		in.close();
	}
	
	private static void swap(int m, int n, int[] arr) {
		int tmp = arr[m];
		arr[m] = arr[n];
		arr[n] = tmp;
	}

}
