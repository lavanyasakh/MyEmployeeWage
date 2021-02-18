import java.util.HashMap;
import java.util.LinkedList;
interface ComputeEmpWage {
	public void addCompanyEmpWage(String company, int empRatePerHr, int maxHrs, int workingDays);
	public void calculateEmpWageComp();
	public int getTotalWage(String company);
}
class CompanyEmpWage {
	public final String company;
	public final int empRatePerHr;
	public final int workingDays;
	public final int maxHrs;
	public int totalEmpWage;

	public CompanyEmpWage( String company, int empRatePerHr, int maxHrs, int workingDays ) {
		this.company = company;
                this.empRatePerHr = empRatePerHr;
                this.maxHrs = maxHrs;
                this.workingDays = workingDays;
		totalEmpWage = 0;
	}

	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}
	public String toString() {
                return "Total Emp Wage for Company: " +company+ " is "+ totalEmpWage;
	}
}
public class EmpWageComputation implements ComputeEmpWage{
	public static final int IS_FULL_TIME = 1;
        public static final int IS_PART_TIME = 2;

	private int numOfCompany = 0;
	private LinkedList<CompanyEmpWage> companyEmpWageList;
	private HashMap<String,CompanyEmpWage> companyEmpWageMap;
	public EmpWageComputation() {
		companyEmpWageList = new LinkedList<>();
		companyEmpWageMap = new HashMap<>();
	}

	public void addCompanyEmpWage(String company, int empRatePerHr, int maxHrs, int workingDays) {
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHr, maxHrs, workingDays);
		companyEmpWageList.add(companyEmpWage);
		companyEmpWageMap.put(company, companyEmpWage);
	}

	public void calculateEmpWageComp() {
		for (int i = 0; i < companyEmpWageList.size() ; i++) {
			CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
			companyEmpWage.setTotalEmpWage(this.calculateEmpWageComp(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}

	public int calculateEmpWageComp(CompanyEmpWage companyEmpWage) {
		//Constraints
                int empHrs;
                int Hrs = 0;
                int day = 1;
                int wagePerDay = 0, totalSalary = 0;

                //Computation
                while ( (day <= companyEmpWage.workingDays) && (Hrs <= companyEmpWage.maxHrs) ) {
                        int empCheck = (int)Math.floor(Math.random() * 10) % 3;
			switch(empCheck) {
                        case IS_FULL_TIME:
                                System.out.println("DAY"+day+"# "+"Employee is Present_Full_Time");
                                empHrs = 8;
                                break;
                        case IS_PART_TIME:
                                System.out.println("DAY"+day+"# "+"Employee is Present_Part_Time");
                                empHrs = 4;
                                break;
                        default:
                                System.out.println("DAY"+day+"# "+"Employee is Absent");
                                empHrs = 0;
                        }

			// Wage Per Day
                        wagePerDay = companyEmpWage.empRatePerHr * empHrs;
			System.out.println("Wage for Day"+day+"#: "+wagePerDay);
                        day += 1;
                        Hrs += empHrs;
                        totalSalary = totalSalary + wagePerDay;
                }
		return totalSalary;
	}

	public int getTotalWage(String company) {
		return companyEmpWageMap.get(company).totalEmpWage;
	}

	public static void main(String[] args) {
		ComputeEmpWage empWage = new EmpWageComputation();
		empWage.addCompanyEmpWage("HCL", 20,100,20);
		empWage.calculateEmpWageComp();
		System.out.println("Total Wage for HCL:"+empWage.getTotalWage("HCL"));
	}
}



