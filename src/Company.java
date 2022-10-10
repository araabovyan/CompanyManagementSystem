public class Company {
    private String name;
    private Executive director;
    private Employee[] employees;
    private int count = 0;

    public Company(String name, int capacity){
        this.name = name;
        employees = new Employee[capacity];
    }

    public Executive getDirector() {
        return director;
    }

    public void setDirector(Executive director) {
        this.director = director;
    }

    public Employee getEmployee(String name, String surname){
        System.out.println("Getting employee!");
        Employee emp = null;
        return emp;
    }

    public Employee[] getEmployees(){
        return employees;
    }

    public Employee[] getTeam(Manager m){
        if(m.getDirectReports().length == 0){
            return null;
        }
        Employee[] team= m.getDirectReports();
        for (int i = 0; i < team.length; i++) {
            if (team[i] instanceof Manager) {
                getTeam((Manager) team[i]);
                continue;
            } else{
                System.out.println(team[i]);
            }
        }
        return null;
    }

    public boolean hireEmployee(String name, String surname, String passport_id, int age, Employee type, Manager m) throws IllegalStateException{
        if (director == null) throw new IllegalStateException("Company director is not specified yet!");
        if(!director.confirmHiring(type)) return false;
        director.confirmHiring(type);
        employees[count] = type;
        count++;
        m.addDirectReporter(type);
        return true;
    }
    public boolean hireEmployee(String name, String surname, String passport_id, int age, Employee type) throws IllegalStateException{
        if (director == null) throw new IllegalStateException("Company director is not specified yet!");
        if(!director.confirmHiring(type)) return false;
        employees[count] = type;
        count++;
        director.addDirectReporter(type);
        return true;
    }

    public static void main() {
        Executive ceo = new Executive();
        FinancialManager fm = new FinancialManager();
        SWManager sm1 = new SWManager("SDK");
        SWManager sm2 = new SWManager("Product");
        SWEngineer se1 = new SWEngineer("junior");
        SWEngineer se2 = new SWEngineer("junior");
        SWEngineer se3 = new SWEngineer("mid");
        SWEngineer se4 = new SWEngineer("min");
        SWEngineer se5 = new SWEngineer("senior");
        SWEngineer se6 = new SWEngineer("senior");
        Accountant ac1 = new Accountant();
        Accountant ac2 = new Accountant();

        Company cmp = new Company("AUAConstruct", 20);
        cmp.setDirector(ceo);
        cmp.hireEmployee("John1", "Snow1", "A123", 23, fm);
        cmp.hireEmployee("Tessa", "Miller", "A124", 24, sm1);
        cmp.hireEmployee("Walter", "White", "A125", 54, sm2);

        cmp.hireEmployee("Jesse1", "Pinkman", "A126", 24, ac1, fm);
        cmp.hireEmployee("Jesse2", "Pinkman", "A127", 34, ac2, fm);
        cmp.hireEmployee("Edward", "Morrison", "A128", 35, se1, sm1);
        cmp.hireEmployee("Evan", "Valet", "A129", 26, se3, sm1);
        cmp.hireEmployee("Walter3", "White", "A130", 26, se5, sm1);
        cmp.hireEmployee("Walter4", "White", "A131", 28, se2, sm2);
        cmp.hireEmployee("Walter5", "White", "A132", 29, se4, sm2);
        cmp.hireEmployee("Walter6", "White", "A134", 38, se6, sm2);

    }


}
