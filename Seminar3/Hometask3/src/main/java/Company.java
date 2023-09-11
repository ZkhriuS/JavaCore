import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Company {
    private static final Random random = new Random();
    private List<Employee> employees;
    private int count;
    private Company(){
        employees = new ArrayList<>();
    }
    public Company(int count){
        this();
        if(count<1){
            throw new RuntimeException("Ошибка! Попытка создать пустую компанию");
        }
        this.count = count;
        setEmployees();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees() {
        for(int i=0; i<count; i++){
            float seed = random.nextFloat();
            if(seed<0.5f)
                employees.add(Worker.getInstance());
            else
                employees.add(Freelancer.getInstance());
        }
    }

    public List<Employee> sortSurname(){
        Collections.sort(employees, new EmployeeNameComparator());
        return employees;
    }

    public List<Employee> sortSalary(){
        Collections.sort(employees);
        return employees;
    }

    public void printCompany(){
        for (Employee e: employees) {
            System.out.println(e);
        }
    }
}
