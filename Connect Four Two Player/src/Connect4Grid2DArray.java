
public class Connect4Grid2DArray implements Connect4Grid {
	public static final int BOARD_WIDTH = 7; // column
	public static final int BOARD_HEIGHT = 6; // row
	public static final int BLANK = '\u2002';

	public static char[][] board = new char[BOARD_HEIGHT][BOARD_WIDTH];
	private char lastPiece;
	private int lastColumn;
	private int lastRow;

	@Override
	public void emptyGrid() {
		for (int count = 0; count < board.length; count++) {
			for (int count2 = 0; count2 < board[count].length; count2++) {
				board[count][count2] = BLANK;
			}
		}
	}

	public String toString() {
		String boardString = "";
		for (int count = 0; count < board.length; count++) {
			for (int count2 = 0; count2 < board[count].length; count2++) {
				if (count2 == BOARD_WIDTH - 1) {
					boardString = boardString + " | " + board[count][count2] + " | " + "\n";
				} else {
					boardString = boardString + " | " + board[count][count2];
				}
			}

		}
		boardString = boardString + "------------------------------" + "\n";
		boardString = boardString + "   1   2   3   4   5   6   7";
		// System.out.print(boardString);
		return boardString;
	}

	@Override
	public boolean isValidColumn(int column) {
		if (column >= 0 && column <= BOARD_WIDTH) {
			if (!isColumnFull(column)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isColumnFull(int column) {
		for (int count = 5; count >= 0; count--) {
			if (board[count][column] == BLANK) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void dropPiece(ConnectPlayer player, int column) {
		if (!isColumnFull(column) && isValidColumn(column)) {
			for (int count = 5; count >= 0; count--) {
				if (board[count][column] == BLANK) {
					board[count][column] = player.getPiece();
					this.lastPiece = player.getPiece();
					this.lastColumn = column;
					this.lastRow = count;
					break;
				}
			}
		}
	}

	@Override
	public boolean didLastPieceConnect4() {
		// // ---------->
		try {
			System.out.println("Last Column: " + this.lastColumn);
			System.out.println("Last Row: " + this.lastRow);
			// check down
			if (this.lastRow < 3) {
				if (board[this.lastRow + 1][this.lastColumn] == this.lastPiece
						&& board[this.lastRow + 2][this.lastColumn] == this.lastPiece
						&& board[this.lastRow + 3][this.lastColumn] == this.lastPiece) {
					return true;
				}
			}
			if (this.lastColumn > 2) {
				if (board[this.lastRow][this.lastColumn - 1] == this.lastPiece
						&& board[this.lastRow][this.lastColumn - 2] == this.lastPiece
						&& board[this.lastRow][this.lastColumn - 3] == this.lastPiece) {
					System.out.println("1st: 3 Back");
					return true;
				}
				if (board[this.lastRow][this.lastColumn - 1] == this.lastPiece
						&& board[this.lastRow][this.lastColumn - 2] == this.lastPiece
						&& board[this.lastRow][this.lastColumn + 1] == this.lastPiece) {
					System.out.println("1st: 1 Forward 2 back");
					return true;
				}
				if (board[this.lastRow][this.lastColumn + 1] == this.lastPiece
						&& board[this.lastRow][this.lastColumn + 2] == this.lastPiece
						&& board[this.lastRow][this.lastColumn - 1] == this.lastPiece) {
					System.out.println("1st: 2 Forward 1 back");
					return true;
				}

			}
			if (this.lastRow < 3 && this.lastColumn > 2) {
				if (board[this.lastRow + 1][this.lastColumn - 1] == this.lastPiece
						&& board[this.lastRow + 2][this.lastColumn - 2] == this.lastPiece
						&& board[this.lastRow + 3][this.lastColumn - 3] == this.lastPiece) {
					System.out.println("Diagonal Downward left");
					return true;
				}
				if (board[this.lastRow + 1][this.lastColumn - 1] == this.lastPiece
						&& board[this.lastRow + 2][this.lastColumn - 2] == this.lastPiece
						&& board[this.lastRow - 1][this.lastColumn + 1] == this.lastPiece) {
					System.out.println("Diagonal Left Downward 2 upward 1");
					return true;
				}
				if (board[this.lastRow - 1][this.lastColumn + 1] == this.lastPiece
						&& board[this.lastRow - 2][this.lastColumn + 2] == this.lastPiece
						&& board[this.lastRow + 1][this.lastColumn - 1] == this.lastPiece) {
					System.out.println("Diagonal Left Downward 1 upward 2");
					return true;
				}
			}
			if (this.lastRow > 2 && this.lastColumn > 2) {
				if (board[this.lastRow - 1][this.lastColumn - 1] == this.lastPiece
						&& board[this.lastRow - 2][this.lastColumn - 2] == this.lastPiece
						&& board[this.lastRow - 3][this.lastColumn - 3] == this.lastPiece) {
					System.out.println("Diagonal Upward left");
					return true;
				}
				if (board[this.lastRow - 1][this.lastColumn - 1] == this.lastPiece
						&& board[this.lastRow - 2][this.lastColumn - 2] == this.lastPiece
						&& board[this.lastRow + 1][this.lastColumn + 1] == this.lastPiece) {
					System.out.println("Diagonal Upward left 2 up 1 down");
					return true;
				}
				if (board[this.lastRow - 1][this.lastColumn - 1] == this.lastPiece
						&& board[this.lastRow + 1][this.lastColumn + 1] == this.lastPiece
						&& board[this.lastRow + 2][this.lastColumn + 2] == this.lastPiece) {
					System.out.println("Diagonal Upward left 1 up 2 down");
					return true;
				}
			}
			// <---------
			if (this.lastColumn < 4) {
				if (board[this.lastRow][this.lastColumn + 1] == this.lastPiece
						&& board[this.lastRow][this.lastColumn + 2] == this.lastPiece
						&& board[this.lastRow][this.lastColumn + 3] == this.lastPiece) {
					System.out.println("2nd: 3 Forward");
					return true;
				}

				if (board[this.lastRow][this.lastColumn + 1] == this.lastPiece
						&& board[this.lastRow][this.lastColumn + 2] == this.lastPiece
						&& board[this.lastRow][this.lastColumn - 1] == this.lastPiece) {
					System.out.println("2nd: 2 Forward 1 back");
					return true;
				}
				if (board[this.lastRow][this.lastColumn - 1] == this.lastPiece
						&& board[this.lastRow][this.lastColumn - 2] == this.lastPiece
						&& board[this.lastRow][this.lastColumn + 1] == this.lastPiece) {
					System.out.println("2nd: 1 Forward 2 back");
					return true;
				}

			}
			if (this.lastRow > 2 && this.lastColumn < 4) {
				if (board[this.lastRow - 1][this.lastColumn + 1] == this.lastPiece
						&& board[this.lastRow - 2][this.lastColumn + 2] == this.lastPiece
						&& board[this.lastRow - 3][this.lastColumn + 3] == this.lastPiece) {
					System.out.println("Diagonal upward right");
					return true;
				}
				if (board[this.lastRow - 1][this.lastColumn + 1] == this.lastPiece
						&& board[this.lastRow - 2][this.lastColumn + 2] == this.lastPiece
						&& board[this.lastRow + 1][this.lastColumn - 1] == this.lastPiece) {
					System.out.println("Diagonal upward right 2 up 1 down");
					return true;
				}
				if (board[this.lastRow - 1][this.lastColumn + 1] == this.lastPiece
						&& board[this.lastRow + 1][this.lastColumn - 1] == this.lastPiece
						&& board[this.lastRow + 2][this.lastColumn - 2] == this.lastPiece) {
					System.out.println("Diagonal upward right 1 up 2 down");
					return true;
				}
			}

			if (this.lastRow < 3 && this.lastColumn < 4) {
				if (board[this.lastRow + 1][this.lastColumn + 1] == this.lastPiece
						&& board[this.lastRow + 2][this.lastColumn + 2] == this.lastPiece
						&& board[this.lastRow + 3][this.lastColumn + 3] == this.lastPiece) {
					System.out.println("Diagonal downward right");
					return true;
				}
				if (board[this.lastRow + 1][this.lastColumn + 1] == this.lastPiece
						&& board[this.lastRow + 2][this.lastColumn + 2] == this.lastPiece
						&& board[this.lastRow - 1][this.lastColumn - 1] == this.lastPiece) {
					System.out.println("Diagonal downward right, 2 down 1 up");
					return true;
				}
				if (board[this.lastRow - 1][this.lastColumn - 1] == this.lastPiece
						&& board[this.lastRow - 2][this.lastColumn - 2] == this.lastPiece
						&& board[this.lastRow + 1][this.lastColumn + 1] == this.lastPiece) {
					System.out.println("Diagonal downward right, 1 down 2 up");
					return true;
				}
			}

		} catch (Exception e) {
			System.out.println("Checking: Out of Bounds!");

			System.out.println("Last Column: " + this.lastColumn + " Last Row: " + this.lastRow);
		}
		return false;
	}

	@Override
	public boolean isGridFull() {
		for (int count = 0; count < board.length; count++) {
			for (int count2 = 0; count2 < board[count].length; count2++) {
				if (board[count][count2] == BLANK) {
					return false;
				}
			}
		}
		return true;
	}

	public char getLastPiece() {
		return this.lastPiece;
	}
}
