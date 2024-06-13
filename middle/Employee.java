package middle;

import java.util.Objects;

public class Employee {
    private String name;
    private Type type;
    private long salary;

    public Employee(final String name, final Type type, final long salary) {
        this.name = name;
        this.type = type;
        this.salary = salary;
    }

    public long getSalaryIncrease(Employee employee) {
        double salaryIncreaseRate = employee.getSalaryIncreaseRate();
        return (long) (employee.getSalary() * salaryIncreaseRate) + employee.getSalary();
    }

    public void calculateSalaries() {
        Employee[] employees = {
            new Employee("John", Type.OWNER, 1000000000),
            new Employee("Anna", Type.MANAGER, 100000000),
            new Employee("Tom", Type.DESIGNER, 70000000),
            new Employee("Alice", Type.ARCHITECT, 80000000),
            new Employee("Bob", Type.DEVELOPER, 60000000)
        };

        for (Employee employee : employees) {
            long increasedSalary = getSalaryIncrease(employee);
            System.out.println(employee.getName() + " = " + increasedSalary);
        }
    }

    public String getName() {
        return name;
    }


    public long getSalary() {
        return salary;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setType(final Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setSalary(final long salary) {
        this.salary = salary;
    }

    public double getSalaryIncreaseRate() {
        return (double) type.getIncreaseRate() / 100;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Employee employee = (Employee) object;
        return type == employee.type && salary == employee.salary && Objects.equals(name,
            employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, salary);
    }
}
