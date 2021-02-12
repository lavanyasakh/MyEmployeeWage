public class EmpWageComputation {
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;
	public static final int WAGE_PER_HR = 20;
	public static final int MAX_WORKING_DAYS = 20;
	public static final int MAX_HRS_IN_MONTH = 100;

	public static void empWageForCompanyWorkers()
	{
		int empHrs = 0;
		int empWage = 0;
		int totalEmpWage = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		//Computation
		while (totalWorkingDays < MAX_WORKING_DAYS && totalEmpHrs <=  MAX_HRS_IN_MONTH) {
			totalWorkingDays++;
			int empCheck = (int)Math.floor(Math.random() *10) %3;
			switch (empCheck) {
				case IS_FULL_TIME:
					empHrs = 8;
					break;
				case IS_PART_TIME:
					empHrs = 4;
					break;
				default:
					empHrs = 0;
			}
			totalEmpHrs += empHrs;
			System.out.println("Day: " + totalWorkingDays + "  Emp Hr: " +empHrs);
		}
		totalEmpWage = totalEmpHrs * WAGE_PER_HR;
		System.out.println("Total Monthly Wage  for company: " + totalEmpWage);
	}

	public static void main(String[] args)
	{
		empWageForCompanyWorkers();
	}
				
}


