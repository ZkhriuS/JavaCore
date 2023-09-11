public class Freelancer extends Employee{
    private double hourlyRate;
    private Freelancer(String name, String surname, double hourlyRate){
        super(name, surname);
        this.hourlyRate = hourlyRate;
        salary = calculateSalary();
    }
    public static Employee getInstance(){
        return new Freelancer(
                names[random.nextInt(names.length)],
                surNames[random.nextInt(surNames.length)],
                random.nextDouble(minSalary, maxSalary)/(8*20.8)
        );
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    protected double calculateSalary() {
        return 20.8*8*hourlyRate;
    }

    @Override
    public String toString() {
        return String.format("Фрилансер %s %s, почасовая ставка %f, зарплата %.2f", getName(), getSurname(), getHourlyRate(), getSalary());
    }
}
