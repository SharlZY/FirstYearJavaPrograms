import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class ClimbingClubHarnessRecordSystem {
/*Assuming that the inputstream is a txt file, with the number of harnesses in the first line, followed by comma-separated 
 * characteristics of each harness in a line  */
	public static void main(String[] args) {
		boolean onLoan2 = false;
		boolean toLoop = true;

		String borrower2;
		HarnessRecords records;
		try {
			String fileName = JOptionPane
					.showInputDialog("Please enter the name of the file containing the harnesses' details: ");
			In inputFile = new In(fileName);
			records = new HarnessRecords(inputFile);
			while (toLoop) {
				for (int i = 0; i < records.getHarnessValues().size(); i++) {
					Harness h = (Harness) records.getHarnessValues().get(i);
					System.out.println(h.toString());
				}
				System.out.println(
						"--------------------------------------------------------------------------------------------------");
				int response4 = JOptionPane
						.showOptionDialog(null,
								"Welcome to the Climbing Club Harness Record System." + "\n"
										+ "Please select an operation: ",
								"Climbing Club Harness Record System", JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "Add a New Harness to the Records", "Remove a Harness from the Records",
										"Record Safety Check", "Loan a Harness", "Return a Harness", "Cancel" },
								"default");

				// begin the 6 options
				if (response4 == 0) {
					String make2 = JOptionPane.showInputDialog("Please enter the make of the harness:  ");
					String modelNumber2 = JOptionPane.showInputDialog("Please enter the modelNumber of the harness:  ");
					int modNumber2 = Integer.parseInt(modelNumber2);
					String used2 = JOptionPane
							.showInputDialog("Please enter the number of times the harness has been used: ");
					int usedTimes2 = Integer.parseInt(used2);
					String climbInstructor2 = JOptionPane.showInputDialog(
							"Please enter the name of the last climb instructor that checked the harness: ");
					int responseAdd = JOptionPane.showOptionDialog(null, "Is the Harness on loan? ",
							"Climbing Club Harness Record System", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Yes", "No" }, "default");
					if (responseAdd == 0) {
						onLoan2 = true;
						borrower2 = JOptionPane
								.showInputDialog("Please enter the name of the borrower that borrowed the harness: ");
					} else {
						onLoan2 = false;
						borrower2 = "";
					}
					Harness newHarnessValue = new Harness(make2, modNumber2, usedTimes2, climbInstructor2, onLoan2,
							borrower2);
					records.addHarness(newHarnessValue);

				} else if (response4 == 1) {
					String make1 = JOptionPane.showInputDialog("Please enter the make of the harness: ");
					String modelNumberStr = JOptionPane
							.showInputDialog("Please enter the model number of the harness: ");
					int modelNumber = Integer.parseInt(modelNumberStr);
					records.removeHarness(make1, modelNumber);
					JOptionPane.showMessageDialog(null, "You have removed this harness from the records. ",
							"ACCESS GRANTED", JOptionPane.INFORMATION_MESSAGE);

				} else if (response4 == 2) {
					String instructor = JOptionPane.showInputDialog(
							"Please enter the name of the climb instructor that has checked the safety of the harness: ");
					String make3 = JOptionPane.showInputDialog("Please enter the make of the harness: ");
					String modelNumberStr2 = JOptionPane
							.showInputDialog("Please enter the model number of the harness: ");
					int modelNumber3 = Integer.parseInt(modelNumberStr2);
					Harness check = records.checkHarness(instructor, make3, modelNumber3);
					if (check == null) {
						JOptionPane.showMessageDialog(null, "This Harness make and model does not exist. ", "WARNING",
								JOptionPane.ERROR_MESSAGE);
					}

				} else if (response4 == 3) {
					String borrower3 = JOptionPane.showInputDialog(
							"Please enter the name of the borrower who wished to be loaned a harness: ");
					Harness loaned = records.loanHarness(borrower3);
					if (loaned == null) {
						JOptionPane.showMessageDialog(null, "There are no available Harnesses. ", "WARNING",
								JOptionPane.ERROR_MESSAGE);
					}

				} else if (response4 == 4) {
					String make5 = JOptionPane.showInputDialog("Please enter the make of the harness: ");
					String number = JOptionPane.showInputDialog("Please enter the model number of the harness: ");
					int actualNumber = Integer.parseInt(number);
					Harness returnH = records.returnHarness(make5, actualNumber);
					if (returnH == null) {
						JOptionPane.showMessageDialog(null, "This Harness make and model does not exist. ", "WARNING",
								JOptionPane.ERROR_MESSAGE);
					}

				} else if (response4 == 5 || response4 == JOptionPane.CLOSED_OPTION) {
					toLoop = false;
				} // response == 0 end
			}
		} catch (HeadlessException cancel) {
			JOptionPane.showMessageDialog(null, "Thank you for using the program. ");
			toLoop = false;
		} catch (NumberFormatException invalidInput) {
			JOptionPane.showMessageDialog(null, "You have entered an invalid input. ", "ERROR",
					JOptionPane.WARNING_MESSAGE);
			toLoop = false;
		}
	}
}