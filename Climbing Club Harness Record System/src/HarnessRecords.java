import java.util.ArrayList;

public class HarnessRecords {
	private ArrayList<Harness> harnessValues;

	HarnessRecords() {
		this.harnessValues = new ArrayList<Harness>();
	}

	HarnessRecords(In theFile) {
		String make;
		int modelNumber;
		int used;
		String instructor;
		boolean onLoan;
		String borrower;
		this.harnessValues = new ArrayList<Harness>();
		String longString = theFile.readAll();
		String[] theRecords = longString.split("\n");
		System.out.print("\"" + theRecords[0].trim() + "\"");
		int number = Integer.parseInt(theRecords[0].trim());
		for (int count = 1; count <= number; count++) {
			String[] details = theRecords[count].split("\\s*,\\s*");
			if (details.length == 5) {
				make = details[0].trim();
				modelNumber = Integer.parseInt(details[1]);
				used = Integer.parseInt(details[2]);
				instructor = details[3].trim();
				onLoan = Boolean.parseBoolean(details[4]);
				borrower = "";

			} else {
				make = details[0].trim();
				modelNumber = Integer.parseInt(details[1]);
				used = Integer.parseInt(details[2]);
				instructor = details[3].trim();
				onLoan = Boolean.parseBoolean(details[4]);
				borrower = details[5].trim();
			}
			Harness aHarness = new Harness(make, modelNumber, used, instructor, onLoan, borrower);
			this.harnessValues.add(aHarness);
		}
	}

	public boolean isEmpty() {
		for (int count = 0; count < this.harnessValues.size(); count++) {
			if ((Harness) harnessValues.get(count) == null) {
				return true;
			}
		}
		return false;
	}

	public void addHarness(Harness harnessVal) {
		this.harnessValues.add(harnessVal);
	}

	public Harness findHarness(String make, int modelNumber) {
		for (int count = 0; count < this.harnessValues.size(); count++) {
			Harness harness1 = (Harness) this.harnessValues.get(count);
			if (harness1.getMake().equals(make) && harness1.getModelNumber() == modelNumber) {
				return harness1;
			}
		}
		System.out.println("Cannot find harness: Does not exist");
		return null;
	}

	public Harness checkHarness(String name, String make, int number) {
		Harness theHarness = findHarness(make, number);
		if (theHarness != null && !theHarness.getOnLoan()) {
			theHarness.checkHarness(name);
			return theHarness;
		} else {
			System.out.println("Cannot check Harness: Does not exist - On Loan");
			return null;
		}
	}

	public Harness loanHarness(String borrower) {
		for (int count = 0; count < harnessValues.size(); count++) {
			Harness harness = (Harness) this.harnessValues.get(count);
			if (harness.canHarnessBeLoaned()) {
				harness.loanHarness(borrower);
				return harness;
			}

		}
		System.out.println("Cannot loan: Does not exist");
		return null;
	}

	public Harness returnHarness(String make, int modNumber) {
		Harness theHarness = findHarness(make, modNumber);
		if (theHarness != null && theHarness.isHarnessOnLoan()) {
			theHarness.returnHarness();
			return theHarness;
		}
		System.out.println("Cannot return harness: Does not exist");
		return null;
	}

	public Harness removeHarness(String make, int modNumber) {
		for (int count = 0; count < this.harnessValues.size(); count++) {
			Harness harness = (Harness) this.harnessValues.get(count);
			if (harness != null && harness.getMake().equals(make) && harness.getModelNumber() == modNumber) {
				this.harnessValues.remove(count);
				return harness;
			}
		}
		return null;
	}

	public ArrayList<Harness> getHarnessValues() {
		return this.harnessValues;
	}
}