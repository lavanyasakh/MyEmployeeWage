public class EmpWageComputation {
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;

	public static void empWageForCompanyWorkers(String company, int empRatePerHr, int numOfWorkingDays, int maxHrsPerMonth)
	{
		int empHrs = 0;
		int empWage = 0;
		int totalEmpWage = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		//Computation
		while (totalWorkingDays < numOfWorkingDays && totalEmpHrs <=  maxHrsPerMonth) {
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
		totalEmpWage = totalEmpHrs * empRatePerHr;
		System.out.println("Total Monthly Wage  for company: " +company+"  Is " +totalEmpWage);
	}

	public static void main(String[] args)
	{
		empWageForCompanyWorkers("DMart", 20, 20, 100);
		empWageForCompanyWorkers("Reliance", 25, 25, 95);
	}
				
}


