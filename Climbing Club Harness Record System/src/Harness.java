
public class Harness {
	private String make;
	private int modelNumber;
	private int used;
	private String climbInstructor;
	private boolean onLoan;
	private String borrower;
	private final int maxTimes = 25;

	Harness(String make, int modelNumber, int used, String climbInstructor, boolean onLoan, String borrower) {
		this.make = make;
		this.modelNumber = modelNumber;
		this.used = used;
		this.climbInstructor = climbInstructor;
		this.onLoan = onLoan;
		this.borrower = borrower;
	}

	Harness(String make, int modelNumber, String climbInstructor) {
		this.make = make;
		this.modelNumber = modelNumber;
		this.climbInstructor = climbInstructor;
		this.onLoan = false;
		this.borrower = "";
	}

	public Harness checkHarness(String climbInstructor) {
		if (this.onLoan == false) {
			this.used = 0;
			this.climbInstructor = climbInstructor;
			return this;
		}
		return null;
	}

	public boolean isHarnessOnLoan() {
		if (this.onLoan == true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean canHarnessBeLoaned() {
		if (isHarnessOnLoan() == false && this.used < maxTimes) {
			return true;
		} else {
			return false;
		}
	}

	public Harness loanHarness(String borrower) {
		if (canHarnessBeLoaned()) {
			this.borrower = borrower;
			this.used = this.used + 1;
			this.onLoan = true;
			return this;
		}
		return null;
	}

	public Harness returnHarness() {
		if (this.onLoan == true) {
			this.onLoan = false;
			this.used = this.used + 1;
			this.borrower = "";
			return this;
		}
		return null;
	}

	public String toString() {
		String harnessDescription = "Make: " + this.make + " | " + "Model Number: " + this.modelNumber + " | " + "Times used: "
				+ this.used + " | " + "Climb Instructor: " + this.climbInstructor + " | " + "On Loan: " + this.onLoan + " | "
				+ "Borrower: " + this.borrower;
		return harnessDescription;
	}
	public String getMake(){
		return this.make;
	}
	public int getModelNumber(){
		return this.modelNumber;
	}
	public int getUsed(){
		return this.used;
	}
	public String getClimbInstructor(){
		return this.climbInstructor;
	}
	public boolean getOnLoan(){
		return this.onLoan;
	}
	public String getBorrower(){
		return this.borrower;
	}
}
