import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer {
	private char piece;

	@Override
	public boolean isWinner(Connect4Grid grid) {
		if (grid.didLastPieceConnect4() && grid.getLastPiece() == this.piece) {
			return true;
		}
		return false;
	}

	@Override
	public void setPiece(char piece) {
		this.piece = piece;
	}

	@Override
	public char getPiece() {
		return this.piece;
	}

	public int generateMove() {
		Random randomGenerator = new Random();
		int column = randomGenerator.nextInt(6);
		return column;
	}

	@Override
	public int smartGenerate() {
		try {
			for (int row = 5; row >= 0; row--) {
				for (int column = 0; column < Connect4Grid2DArray.BOARD_WIDTH; column++) {
					if (Connect4Grid2DArray.board[row][column] == this.piece
							&& Connect4Grid2DArray.board[row][column + 1] == Connect4Grid2DArray.BLANK) {
						return column + 1;
					} else if (Connect4Grid2DArray.board[row][column] == this.piece
							&& Connect4Grid2DArray.board[row][column - 1] == Connect4Grid2DArray.BLANK) {
						return column - 1;
					} else if (Connect4Grid2DArray.board[row][column] == this.piece
							&& Connect4Grid2DArray.board[row - 1][column] == Connect4Grid2DArray.BLANK) {
						return column;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Out of Bounds!");
		}
		return generateMove();
	}
}
