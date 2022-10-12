public class FinancialManager extends Accountant implements Manager{
    private final int capacity = 10;
    protected Employee[] directReporters;
    private int index = 0;

    public FinancialManager() {
        super();
        directReporters = new Employee[capacity];
    }

    public void addDirectReporter(Employee directReporter) {
        this.directReporters[index] = directReporter;
        index++;
    }

    @Override
    public void evaluateEmployee() {
        System.out.println("Evaluating employee");
    }

    @Override
    public void reviewSalary() {
        System.out.println("Reviewing salary");
    }

    @Override
    public Employee[] getDirectReports() {
        System.out.println("Getting direct report");
        return directReporters;
    }

    @Override
    public void getTeam() {
        System.out.println("Getting team");
    }

    public void createCompanyBudget(){
        System.out.println("Creating company budget!");
    }
}
