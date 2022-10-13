public abstract class Employee{
    private String name;
    private String surname;
    private String passportID;
    private int performanceScore;
    private int id;

    public int getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(int performanceScore) {
        this.performanceScore = performanceScore;
    }

    public void doWork() {
        System.out.println("Working");
    }

    public void takeVacation() {
        System.out.println("Taking is on vacation...");
    }
}
