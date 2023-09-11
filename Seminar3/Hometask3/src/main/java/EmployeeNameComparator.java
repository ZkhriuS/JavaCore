import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int result = o1.getSurname().compareTo(o2.getSurname());
        if(result==0)
            return o1.getName().compareTo(o2.getName());
        return result;
    }
}
