public abstract class ConnectPlayer {
	public abstract boolean isWinner(Connect4Grid grid);
	public abstract void setPiece(char piece);
	public abstract char getPiece();
	public abstract int generateMove();
	public abstract int smartGenerate();
	public boolean canMakeMove(Connect4Grid grid, int column){
		if(grid.isGridFull() || !grid.isValidColumn(column) || grid.isColumnFull(column)){
			return false;
		}
		return true;
	}
}

