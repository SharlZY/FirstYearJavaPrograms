import javax.swing.JOptionPane;

public class Connect4Game {
	public static final char PIECE1 = 'x';
	public static final char PIECE2 = 'o';

	public static void main(String[] args) {
		boolean keepPlaying = true;
		boolean anotherPlayer = false;
		int turn = 1;
		Connect4Grid grid = new Connect4Grid2DArray();
		grid.emptyGrid();
		ConnectPlayer player = new C4HumanPlayer();
		ConnectPlayer player2 = new C4HumanPlayer();

		ConnectPlayer computer1 = new C4RandomAIPlayer();

		ConnectPlayer computer = new C4RandomAIPlayer();
		int aiColumn;
		int prevAiColumn;
		int welcomeSelection = JOptionPane.showOptionDialog(null, "Welcome to the Connect4 Game!", "Connect4 Game",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Let's Play!" },
				"default");
		if (welcomeSelection == -1) {
			JOptionPane.showMessageDialog(null, "You have exit the game!", "Now leaving . . .",
					JOptionPane.WARNING_MESSAGE);
			keepPlaying = false;
		} else {

			int response = JOptionPane.showOptionDialog(null,
					"Would you like to play against another player or computer?", "Connect4 Game",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					new String[] { "2 Players", "Computer Player", "Computer Vs Computer" }, "default");
			if (response == -1) {
				JOptionPane.showMessageDialog(null, "You have exit the game!", "Now leaving . . .",
						JOptionPane.WARNING_MESSAGE);
				keepPlaying = false;
			} else if (response == 0 || response == 1) {
				if (response == 0) {
					anotherPlayer = true;
				} else if (response == 1) {
					anotherPlayer = false;
				}
				int responseSelection = JOptionPane.showOptionDialog(null,
						"Player 1: Please select the piece you would like to play as: ", "Connect4 Game",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "o", "x" },
						"default");
				if (responseSelection == -1) {
					JOptionPane.showMessageDialog(null, "You have exit the game!", "Now leaving . . .",
							JOptionPane.WARNING_MESSAGE);
					keepPlaying = false;
				} else {
					if (anotherPlayer == false) {
						if (responseSelection == 0) {
							player.setPiece(PIECE2);
							computer.setPiece(PIECE1);
						} else if (responseSelection == 1) {
							player.setPiece(PIECE1);
							computer.setPiece(PIECE2);
						}
					} else if (anotherPlayer == true) {
						if (responseSelection == 0) {
							player.setPiece(PIECE2);
							player2.setPiece(PIECE1);
						} else if (responseSelection == 1) {
							player.setPiece(PIECE1);
							player2.setPiece(PIECE2);
						}
					}
					while (keepPlaying) {
						int columnSelection = JOptionPane.showOptionDialog(null,
								"Connect4 Board:\n" + grid.toString()
										+ ((turn % 2 == 0) ? "\n Other Player's turn " : "\n Player 1's turn")
										+ "\n Please select a column: ",
								"Connect4 Game", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
								new String[] { "1", "2", "3", "4", "5", "6", "7" }, "default");
						if (grid.isGridFull()) {
							JOptionPane.showMessageDialog(null, "This game has end in a draw!", "Connect4 Game",
									JOptionPane.INFORMATION_MESSAGE);
							int select = JOptionPane.showOptionDialog(null, "Would you like to restart the game?",
									"Connect4 Game", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
									null, new String[] { "Yes", "No" }, "default");
							if (select == -1 || select == 1) {
								JOptionPane.showMessageDialog(null, "You have exit the game!", "Now leaving . . .",
										JOptionPane.WARNING_MESSAGE);
								keepPlaying = false;
							} else if (select == 0) {
								turn = 1;
								grid.emptyGrid();
								continue;
							}
						} else {
							if (columnSelection == -1) {
								int columnSelection2 = JOptionPane.showOptionDialog(null,
										"Are you sure you would like to leave?", "Connect4 Game",
										JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
										new String[] { "Yes", "No", "Restart" }, "default");
								if (columnSelection2 == -1 || columnSelection2 == 0) {
									JOptionPane.showMessageDialog(null, "You have exit the game!", "Now leaving . . .",
											JOptionPane.WARNING_MESSAGE);
									keepPlaying = false;
								} else if (columnSelection2 == 1) {
									continue;
								} else if (columnSelection2 == 2) {
									turn = 1;
									grid.emptyGrid();
									continue;
								}
							} else if (columnSelection == 0) {
								if (grid.isColumnFull(columnSelection)) {
									JOptionPane.showMessageDialog(null, "This column is full!", "Warning!",
											JOptionPane.WARNING_MESSAGE);
									continue;
								} else {
									if (turn % 2 == 0) {
										grid.dropPiece(player2, columnSelection);
										turn++;
									} else {
										grid.dropPiece(player, columnSelection);
										turn++;
									}
								}
							} else if (columnSelection == 1) {
								if (grid.isColumnFull(columnSelection)) {
									JOptionPane.showMessageDialog(null, "This column is full!", "Warning!",
											JOptionPane.WARNING_MESSAGE);
									continue;
								} else {
									if (turn % 2 == 0) {
										grid.dropPiece(player2, columnSelection);
										turn++;
									} else {
										grid.dropPiece(player, columnSelection);
										turn++;
									}

								}
							} else if (columnSelection == 2) {
								if (grid.isColumnFull(columnSelection)) {
									JOptionPane.showMessageDialog(null, "This column is full!", "Warning!",
											JOptionPane.WARNING_MESSAGE);
									continue;
								} else {
									if (turn % 2 == 0) {
										grid.dropPiece(player2, columnSelection);
										turn++;
									} else {
										grid.dropPiece(player, columnSelection);
										turn++;
									}

								}
							} else if (columnSelection == 3) {
								if (grid.isColumnFull(columnSelection)) {
									JOptionPane.showMessageDialog(null, "This column is full!", "Warning!",
											JOptionPane.WARNING_MESSAGE);
									continue;
								} else {
									if (turn % 2 == 0) {
										grid.dropPiece(player2, columnSelection);
										turn++;
									} else {
										grid.dropPiece(player, columnSelection);
										turn++;
									}

								}
							} else if (columnSelection == 4) {
								if (grid.isColumnFull(columnSelection)) {
									JOptionPane.showMessageDialog(null, "This column is full!", "Warning!",
											JOptionPane.WARNING_MESSAGE);
									continue;
								} else {
									if (turn % 2 == 0) {
										grid.dropPiece(player2, columnSelection);
										turn++;
									} else {
										grid.dropPiece(player, columnSelection);
										turn++;
									}

								}
							} else if (columnSelection == 5) {
								if (grid.isColumnFull(columnSelection)) {
									JOptionPane.showMessageDialog(null, "This column is full!", "Warning!",
											JOptionPane.WARNING_MESSAGE);
									continue;
								} else {
									if (turn % 2 == 0) {
										grid.dropPiece(player2, columnSelection);
										turn++;
									} else {
										grid.dropPiece(player, columnSelection);
										turn++;
									}

								}
							} else if (columnSelection == 6) {
								if (grid.isColumnFull(columnSelection)) {
									JOptionPane.showMessageDialog(null, "This column is full!", "Warning!",
											JOptionPane.WARNING_MESSAGE);
									continue;
								} else {
									if (turn % 2 == 0) {
										grid.dropPiece(player2, columnSelection);
										turn++;
									} else {
										grid.dropPiece(player, columnSelection);
										turn++;
									}
								}
							}
							if (player.isWinner(grid)) {
								System.out.println("Player has won!");
								JOptionPane.showMessageDialog(null, "Congratulations! Player 1 has won!", "VICTORY",
										JOptionPane.INFORMATION_MESSAGE);
								int select = JOptionPane.showOptionDialog(null, "Would you like to play again?",
										"Connect4 Game", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
										null, new String[] { "Yes", "No" }, "default");
								if (select == -1 || select == 1) {
									JOptionPane.showMessageDialog(null, "You have exit the game!", "Now leaving . . .",
											JOptionPane.WARNING_MESSAGE);
									keepPlaying = false;
								} else if (select == 0) {
									int response2 = JOptionPane.showOptionDialog(null,
											"Would you like to play against another player or computer?",
											"Connect4 Game", JOptionPane.YES_NO_CANCEL_OPTION,
											JOptionPane.QUESTION_MESSAGE, null,
											new String[] { "2 Players", "Computer Player" }, "default");
									System.out.println("R2: " + response2);
									if (response2 == -1) {
										JOptionPane.showMessageDialog(null, "You have exit the game!",
												"Now leaving . . .", JOptionPane.WARNING_MESSAGE);
										keepPlaying = false;
									} else if (response2 == 0) {
										if (anotherPlayer == false) {
											player2.setPiece(computer.getPiece());
											anotherPlayer = true;
										} else if (anotherPlayer == true) {
											player2.setPiece(player2.getPiece());
										}
									} else if (response2 == 1) {
										if (anotherPlayer == true) {
											computer.setPiece(player2.getPiece());
											anotherPlayer = false;
										} else if (anotherPlayer == false) {
											computer.setPiece(computer.getPiece());
										}
									}
									turn = 1;
									grid.emptyGrid();
									continue;
								}
							}
							if (anotherPlayer == true) {
								if (player2.isWinner(grid)) {
									System.out.println("Player 2 has won!");
									JOptionPane.showMessageDialog(null, "Congratulations! Player 2 has won!", "VICTORY",
											JOptionPane.INFORMATION_MESSAGE);
									int select = JOptionPane.showOptionDialog(null, "Would you like to play again?",
											"Connect4 Game", JOptionPane.YES_NO_CANCEL_OPTION,
											JOptionPane.QUESTION_MESSAGE, null, new String[] { "Yes", "No" },
											"default");
									if (select == -1 || select == 1) {
										JOptionPane.showMessageDialog(null, "You have exit the game!",
												"Now leaving . . .", JOptionPane.WARNING_MESSAGE);
										keepPlaying = false;
									} else if (select == 0) {
										int response2 = JOptionPane.showOptionDialog(null,
												"Would you like to play against another player or computer?",
												"Connect4 Game", JOptionPane.YES_NO_CANCEL_OPTION,
												JOptionPane.QUESTION_MESSAGE, null,
												new String[] { "2 Players", "Computer Player" }, "default");
										if (response2 == -1) {
											JOptionPane.showMessageDialog(null, "You have exit the game!",
													"Now leaving . . .", JOptionPane.WARNING_MESSAGE);
											keepPlaying = false;
										} else if (response2 == 0) {
										} else if (response2 == 1) {
											anotherPlayer = false;
											computer.setPiece(player2.getPiece());
										}
										turn = 1;
										grid.emptyGrid();
										continue;
									}
								}
							} else if (anotherPlayer == false) {
								// aiColumn = computer.generateMove();
								aiColumn = computer.smartGenerate();
								prevAiColumn = aiColumn;
								if (grid.isColumnFull(aiColumn)) {
									while (aiColumn == prevAiColumn && !grid.isColumnFull(aiColumn)) {
										// aiColumn =
										// computer.generateMove();
										aiColumn = computer.smartGenerate();
									}
									grid.dropPiece(computer, aiColumn);
									turn++;
								} else {
									grid.dropPiece(computer, aiColumn);
									turn++;
								}
								if (computer.isWinner(grid)) {
									System.out.println("Computer has won!");
									JOptionPane.showMessageDialog(null, "You lose!", "DEFEAT",
											JOptionPane.ERROR_MESSAGE);
									int select = JOptionPane.showOptionDialog(null, "Would you like to play again?",
											"Connect4", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
											null, new String[] { "Yes", "No" }, "default");
									if (select == -1 || select == 1) {
										JOptionPane.showMessageDialog(null, "You have exit the game!",
												"Now leaving . . .", JOptionPane.WARNING_MESSAGE);
										keepPlaying = false;
									} else if (select == 0) {
										int response2 = JOptionPane.showOptionDialog(null,
												"Would you like to play against another player or computer?",
												"Connect4 Game", JOptionPane.YES_NO_CANCEL_OPTION,
												JOptionPane.QUESTION_MESSAGE, null,
												new String[] { "2 Players", "Computer Player" }, "default");
										if (response2 == -1) {
											JOptionPane.showMessageDialog(null, "You have exit the game!",
													"Now leaving . . .", JOptionPane.WARNING_MESSAGE);
											keepPlaying = false;
										} else if (response2 == 0) {
											anotherPlayer = true;
											player2.setPiece(computer.getPiece());
										} else if (response2 == 1) {
										}
										turn = 1;
										grid.emptyGrid();
										continue;
									}
								}
							}
						}
					}
				}
			} else {
				computer.setPiece(PIECE1);
				computer1.setPiece(PIECE2);
				while (keepPlaying) {
					int select = JOptionPane.showOptionDialog(null, "Connect4 Board:\n" + grid.toString(),
							"Connect4 Game", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
							new String[] { "Next Move" }, "default");
					if (select == 0) {
						int columnC2 = computer.smartGenerate();
						grid.dropPiece(computer, columnC2);
						if (computer.isWinner(grid)) {
							JOptionPane.showMessageDialog(null, "Computer 1 has won!", "VICTORY",
									JOptionPane.INFORMATION_MESSAGE);
							keepPlaying = false;
						} else {
							int columnC1 = computer1.smartGenerate();
							grid.dropPiece(computer1, columnC1);
							if (computer1.isWinner(grid)) {
								JOptionPane.showMessageDialog(null, "Computer 2 has won!", "VICTORY",
										JOptionPane.INFORMATION_MESSAGE);
								keepPlaying = false;
							}
						}
					} else if (select == -1) {
						JOptionPane.showMessageDialog(null, "You have exit the game!", "Now leaving . . .",
								JOptionPane.WARNING_MESSAGE);
						keepPlaying = false;
					}
				}
			}
		}
	}
}
