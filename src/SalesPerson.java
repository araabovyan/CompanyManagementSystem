import java.util.ArrayList;

public class SalesPerson extends Employee{
    private String[] customerAccounts;

    public SalesPerson(String[] customerAccounts) {
        this.customerAccounts = customerAccounts;
    }

    public void prepareProductDemo(){
        System.out.println("Preparing product demo");
    }
}
