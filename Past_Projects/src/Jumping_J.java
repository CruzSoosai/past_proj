
/**
 * 2D Board with Js(J) placed in spaces(_) and contains barriers(X)
 * Only move is to: Jump (vertical or horizontal only) a J over another and into a hole, to eliminate the second J
 * Return minimum number of moves ato get minimum number of Js on Board
 */
public class Jumping_J {

	public static int[] jumping_j_game(String[][] board) {
		int rows = board.length;
		int cols = board[0].length;
		int nJ = getJs(board,rows,cols);
		int nMoves = Integer.MAX_VALUE;
		int [] startingAns = {nJ, nMoves};
		int [] final_ans = solve(board, startingAns, 0, nJ);
		System.out.println("Min Js: "+final_ans [0] + "\nOptimal number of moves: " +final_ans[1]);
		return final_ans;
	}

	static int getJs(String board[][], int rows, int cols) 
	{ 
		int nJ = 0;
		for (int i = 0; i < rows; i++) 
		{ 
			for (int j = 0; j < cols; j++) 
				if((board [i][j]).equals("J")) {
					nJ++;
				}
		}
		return nJ;
	}


	static int []  solve(String  [] [] board, int [] ans, int moves, int nJ) {
		int rows = board.length;
		int cols = board[0].length;
		if (nJ<=1) {
			if(nJ<=ans[0] && moves<=ans[1]) {
				ans [0] = nJ;
				ans [1] = moves;
			}
			else if(nJ < ans[0]) {
				ans [0] = nJ;
				ans [1] = moves;
			}
			return ans;
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j].equals("J")) {
					if(canJumpRight(board, i, j)) {
						board [i] [j] = "_";
						board [i] [j+1] = "_";
						nJ--;moves++;
						board [i] [j+2] = "J";
						solve(board, ans, moves, nJ);
						//reset
						board [i] [j] = "J";
						board [i] [j+1] = "J";
						nJ++;moves--;
						board [i] [j+2] = "_";

					}
					if(canJumpLeft(board, i, j)) {
						board [i] [j] = "_";
						board [i] [j-1] = "_";
						nJ--;moves++;
						board [i] [j-2] = "J";
						solve(board, ans, moves, nJ);
						//reset
						board [i] [j] = "J";
						board [i] [j-1] = "J";
						nJ++;moves--;
						board [i] [j-2] = "_";

					}
					if(canJumpUp(board, i, j)) {
						board [i] [j] = "_";
						board [i-1] [j] = "_";
						nJ--;moves++;
						board [i-2] [j] = "J";
						solve(board, ans, moves, nJ);
						//reset
						board [i] [j] = "J";
						board [i-1] [j] = "J";
						nJ++;moves--;
						board [i-2] [j] = "_";

					}
					if(canJumpDown(board, i, j)) {
						board [i] [j] = "_";
						board [i+1] [j] = "_";
						nJ--;moves++;
						board [i+2] [j] = "J";
						solve(board, ans, moves, nJ);
						//reset
						board [i] [j] = "J";
						board [i+1] [j] = "J";
						nJ++;moves--;
						board [i+2] [j] = "_";
					}
				}
			}
		}
		if(nJ<=ans[0] && moves<=ans[1]) {
			ans [0] = nJ;
			ans [1] = moves;
		}
		else if(nJ < ans[0]) {
			ans [0] = nJ;
			ans [1] = moves;
		}

		return ans;
	}

	private static boolean canJumpRight(String[][] board, int row, int col) {
		if (col>board[0].length-3) {
			return false;
		}
		if((board[row][col+1].equals("J"))&&((board [row] [col+2]).equals("_"))) {
			return true;
		}
		return false;
	}
	private static boolean canJumpLeft(String[][] board, int row, int col) {
		if (col<2) {
			return false;
		}
		if((board[row][col-1].equals("J"))&&((board [row] [col-2]).equals("_"))) {
			return true;
		}
		return false;
	}
	private static boolean canJumpUp(String[][] board, int row, int col) {
		if (row<2) {
			return false;
		}
		if((board[row-1][col].equals("J"))&&((board [row-2] [col]).equals("_"))) {
			return true;
		}
		return false;
	}
	private static boolean canJumpDown(String[][] board, int row, int col) {
		if (row>board.length-3) {
			return false;
		}
		if((board[row+1][col].equals("J"))&&((board [row+2] [col]).equals("_"))) {
			return true;
		}
		return false;
	}

}
