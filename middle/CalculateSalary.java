package middle;

public class CalculateSalary {

    public static void main(String[] args) {
        Employee employee = new Employee("John", Type.OWNER, 1000000000);
        employee.calculateSalaries();
    }
}
