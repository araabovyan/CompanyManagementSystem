public class SWEngineer extends Employee{
    protected String title;

    public SWEngineer(String title) {
        this.title = title;
    }

    public void doCoding(){
        System.out.println("I am coding!");
    }
}
