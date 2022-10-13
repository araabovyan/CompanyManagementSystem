import java.util.Comparator;

public class Company {
    private String name;
    private Executive director;
    private Employee[] employees;
    ArrayDeque<Employee> top10performers;
    private int count = 0;

    public Company(String name, int capacity) {
        this.name = name;
        employees = new Employee[capacity];
    }

    public Executive getDirector() {
        return director;
    }

    public void setDirector(Executive director) {
        this.director = director;
    }

    public Employee getEmployee(String name, String surname) {
        System.out.println("Getting employee!");
        Employee emp = null;
        return emp;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public Employee[] getTeam(Manager m) {
        if (m.getDirectReports().length == 0) {
            return null;
        }
        Employee[] team = m.getDirectReports();
        for (int i = 0; i < team.length; i++) {
            if (team[i] instanceof Manager) {
                getTeam((Manager) team[i]);
                continue;
            } else {
                System.out.println(team[i]);
            }
        }
        return null;
    }

    public boolean hireEmployee(String name, String surname, String passport_id, int age, Employee type, Manager m) throws IllegalStateException {
        if (director == null) throw new IllegalStateException("Company director is not specified yet!");
        if (!director.confirmHiring(type)) return false;
        director.confirmHiring(type);
        employees[count] = type;
        count++;
        m.addDirectReporter(type);
        return true;
    }

    public boolean hireEmployee(String name, String surname, String passport_id, int age, Employee type) throws IllegalStateException {
        if (director == null) throw new IllegalStateException("Company director is not specified yet!");
        if (!director.confirmHiring(type)) return false;
        employees[count] = type;
        count++;
        director.addDirectReporter(type);
        return true;
    }

    public void addTopPerformer(Employee e){
        if(top10performers.size() >= 10){
            top10performers.popFront();
        }
        top10performers.pushBack(e);
    }

    public void addTopPerformer(Employee e, Comparator<Employee> comp){
        if(top10performers.size() >= 10){
            Employee smallest = top10performers.front();
            if(comp.compare(e, smallest) == -1) return;
            top10performers.popFront();
        }
        top10performers.pushFront(e);
        Employee walk = e;
        for(Employee topEmployee : top10performers){
            if (comp.compare(walk, topEmployee) == 1){
                top10performers.swapObjects(walk, topEmployee);
            }
        }
    }
}
