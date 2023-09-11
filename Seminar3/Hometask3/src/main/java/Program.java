import java.util.List;

public class Program {
    public static void main(String[] args) {
        Company company = new Company(15);
        company.printCompany();
        System.out.println();
        company.sortSurname();
        company.printCompany();
        System.out.println();
        company.sortSalary();
        company.printCompany();
    }
}
