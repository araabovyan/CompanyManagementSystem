import java.util.Comparator;

public class PerformanceComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.getPerformanceScore() == o2.getPerformanceScore()){
            return 0;
        }else if(o1.getPerformanceScore() >= o2.getPerformanceScore()){
            return 1;
        }else{
            return -1;
        }
    }
}
