public class EmpWageComputation {
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;
	public static final int WAGE_PER_HR = 20;
	public static final int MAX_WORKING_DAYS = 20;
	public static final int MAX_HRS_IN_MONTH = 100;

	public static void main(String[] args)
	{
		int empHrs = 0;
		int empWage = 0;
		int totalEmpWage = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		//Computation
		while (totalWorkingDays <= MAX_WORKING_DAYS && totalEmpHrs <=  MAX_HRS_IN_MONTH) {
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
			empWage = empHrs * WAGE_PER_HR;
			totalEmpHrs += empHrs;
			totalEmpWage += empWage;
			System.out.println("Employee Wage is =" +empWage);
		}
		System.out.println("Total Employee Hrs =" + totalEmpHrs);
		System.out.println("Total Working Days =" + totalWorkingDays);
		System.out.println("Total Monthly Wage =" + totalEmpWage);
	}	
}


