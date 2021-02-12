public class EmpWageComputation
{
	public static final int IS_PRESENT = 1;
	public static final int WAGE_PER_HR = 20;

	public static void main(String[] args)
	{
		//Variables
		int empHrs = 0;
		int empWage = 0;
		//Computation
		double empCheck = Math.floor(Math.random() *10) %2;
		if (empCheck == IS_PRESENT)
			empHrs = 8;
		else
			empHrs = 0;
			empWage = empHrs * WAGE_PER_HR;
			System.out.println("Employee Wage is =" +empWage);
	}	
}


