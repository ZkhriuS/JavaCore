import java.util.Comparator;
import java.util.Random;

public abstract class Employee implements Comparable<Employee> {
    protected static String[] names = new String[]{"Даниил", "Алексей", "Константин", "Егор", "Никита", "Евгений", "Михаил", "Владислав"};
    protected static String[] surNames = new String[]{"Барцевич", "Василевич", "Гончаров", "Климченя", "Круталевич", "Лемешевский", "Сидоров", "Скуратов", "Юревич"};
    protected static Random random = new Random();
    protected static final double minSalary = 30000;
    protected static final double maxSalary = 500000;
    private static int counter = 1000;
    protected int id;
    protected String name;
    protected String surname;
    protected double salary;
    {
        id = ++counter;
    }
    protected Employee(){
        this("#Name#", "#Surname#", minSalary);
    }
    protected Employee(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    protected Employee(String name, String surname, double salary){
        this(name, surname);
        if(salary<minSalary)
            throw new RuntimeException("Ошибка! Зарплата меньше минимальной зарплаты "+ minSalary);
        this.salary=salary;
    }

    protected abstract double calculateSalary();

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary<minSalary)
            throw new RuntimeException("Ошибка! Зарплата меньше минимальной зарплаты "+ minSalary);
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.getSalary(), o.getSalary());
    }
}
