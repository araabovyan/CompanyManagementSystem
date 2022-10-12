public class SWManager extends SWEngineer implements Manager{
    private final int capacity = 10;
    private Employee[] directReporters;
    private int index = 0;

    public SWManager(String title) {
        super(title);
        directReporters = new Employee[capacity];
    }
    public Employee[] getDirectReporters() {
        return directReporters;
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
        return directReporters;
    }

    @Override
    public void getTeam() {
        System.out.println("Getting team");
    }

    public void mentorEmployee(){
        System.out.println("Mentoring employee");
    }

    public void distributeTasks(){
        System.out.println("Distributing tasks!");
    }
}
