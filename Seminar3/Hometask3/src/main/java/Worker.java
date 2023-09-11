public class Worker extends Employee{

    private Worker(String name, String surname, double salary){
        super(name, surname, salary);
    }
    public static Employee getInstance(){
        return new Worker(
                names[random.nextInt(names.length)],
                surNames[random.nextInt(surNames.length)],
                random.nextDouble(minSalary, maxSalary)
        );
    }

    @Override
    protected double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Рабочий %s %s, зарплата %.2f", getName(), getSurname(), getSalary());
    }
}
