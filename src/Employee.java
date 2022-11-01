import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return passportID.equals(employee.passportID);
    }

    @Override
    public int hashCode() {
        return passportID.hashCode();
    }
}
