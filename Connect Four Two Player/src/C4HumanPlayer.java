
public class C4HumanPlayer extends ConnectPlayer {
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

	@Override
	public int generateMove() {
		return 0;
	}

	@Override
	public int smartGenerate() {
		return 0;
	}

}
