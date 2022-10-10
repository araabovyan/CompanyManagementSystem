public abstract class Employee {
    private String name;
    private String surname;
    private String passportID;
    private int id;

    public void doWork() {
        System.out.println("Working");
    }

    public void takeVacation() {
        System.out.println("Taking is on vacation...");
    }
}
