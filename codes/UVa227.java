import java.util.Scanner;

/**
 * @author Adonis
 * @Email 1583801169@qq.com
 * @Date 2019-01-19 11:17:38
 * @Version V1.0
 */

/**
 * 记录 puzzle 中空格的位置
 * x：行
 * y：列
 */
class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int kase = 1;
		
		while (true) {
			char[][] puzzle = new char[5][5];
			Position pos = new Position(0, 0);
			
			for (int i=0; i<5; i++) {	// 输入 puzzle，并做简单判断和处理
				String tmp = in.nextLine();
				if (tmp.equals("Z")) {	// Z 结束输入
					in.close();
					return;
				}
				
				if (tmp.length() == 4) {	// 空格在最后面，需要手动加上空格
					tmp += " ";
				}
				puzzle[i] = tmp.toCharArray();
				for (int j=0; j<5; j++) {	// 找出空格的位置
					if (puzzle[i][j] == ' ') {
						pos.setX(i);
						pos.setY(j);
					}
				}
			}
			
			StringBuilder move = getMove(in);	// 获取指令
			int len = move.length();
			boolean legal = true;	// 标志指令是否合法
			
			for (int i=0; i<len-1; i++) {
				if (!isLegal(move.charAt(i), puzzle, pos)) {	// 指令不合法
					legal = false;
					break;
				}
			}
			
			if (kase > 1) {	// 注意输出格式
				System.out.println();
			}
			System.out.printf("Puzzle #%d:\n", kase++);
			if (legal) {
				printAfter(puzzle);
			} else {
				System.out.println("This puzzle has no final configuration.");
			}
		}
	}
	
	/**
	 * 判断指令是否合法
	 * @param c
	 * @param puzzle
	 * @param pos
	 * @return
	 */
	private static boolean isLegal(char c, char[][] puzzle, Position pos) {
		boolean legal = true;
		int x = pos.getX(), y = pos.getY();
		
		switch (c) {
		case 'A':	// up
			if (x == 0) {
				legal = false;
				break;
			}
			puzzle[x][y] = puzzle[x-1][y];
			puzzle[x-1][y] = ' ';
			pos.setX(x-1);
			break;
		
		case 'B':	// down
			if (x == 4) {
				legal = false;
				break;
			}
			puzzle[x][y] = puzzle[x+1][y];
			puzzle[x+1][y] = ' ';
			pos.setX(x+1);
			break;
			
		case 'L':	// left
			if (y == 0) {
				legal = false;
				break;
			}
			puzzle[x][y] = puzzle[x][y-1];
			puzzle[x][y-1] = ' ';
			pos.setY(y-1);
			break;
			
		case 'R':	// right
			if (y == 4) {
				legal = false;
				break;
			}
			puzzle[x][y] = puzzle[x][y+1];
			puzzle[x][y+1] = ' ';
			pos.setY(y+1);
			break;
		}
		return legal;
	}
	
	/**
	 * 获取指令
	 * 指令存在一种可能：一条指令不完全在一行，可能是两行或者多行输入得来的
	 * @param in
	 * @return
	 */
	private static StringBuilder getMove(Scanner in) {
		// 为什么不用 String
		StringBuilder move = new StringBuilder(in.nextLine());
		StringBuilder tmp = move;
		while (tmp.charAt(tmp.length()-1) != '0') {
			tmp = new StringBuilder(in.nextLine());
			move.append(tmp);
		}
		return move;
	}
	
	/**
	 * 打印执行指令后的 puzzle
	 * @param puzzle
	 */
	private static void printAfter(char[][] puzzle) {
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				System.out.print(puzzle[i][j]);
				if (j != 4) {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}

}
