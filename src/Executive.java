public class Executive extends Employee implements Manager{
    private final int capacity = 10;
    private Employee[] directReporters;
    private int index = 0;

    public Executive() {
        this.directReporters = new Employee[capacity];
    }

    public boolean confirmHiring(Employee e){
        System.out.println("Hiring confirmed!");
        return true;
    }

    public void addDirectReporter(Employee directReporter) {
        this.directReporters[index] = directReporter;
        index++;
    }

    public void confirmFiring(Employee e){
        System.out.println("Firing confirmed!");
    }

    public void confirmCompanyBudget(){
        System.out.println("Budget confirmed!");
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
        return directReporters;
    }

    @Override
    public void getTeam() {
        System.out.println("Getting team");
    }
}
