public class EmpWageComputation {
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;

	private final String company;
	private final int empRatePerHr;
	private final int numOfWorkingDays;
	private final int maxHrsPerMonth;

	public EmpWageComputation(String company, int empRatePerHr, int numOfWorkingDays, int maxHrsPerMonth) 
	{
		this.company = company;
		this.empRatePerHr = empRatePerHr;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrsPerMonth = maxHrsPerMonth;
	} 

	public void empWageForCompanyWorkers()
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
		int[] empTotalWage = new int[1];
		empTotalWage[0] = totalEmpWage;
		System.out.println("Total Monthly Wage  for company: " +company+"  Is " +empTotalWage[0]);
	}


	public static void main(String[] args)
	{
		EmpWageComputation dMart = new EmpWageComputation("DMart", 20, 20, 100);
		EmpWageComputation reliance = new EmpWageComputation("Reliance", 25, 25, 90);	
		dMart.empWageForCompanyWorkers();
		reliance.empWageForCompanyWorkers();
	}
				
}


