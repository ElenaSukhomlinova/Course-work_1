public class Employee {

    private static int counter = 1;

    private final int id;
    private String employeeName;
    private int department;
    private double salary;


    public Employee(String employeeName, int department, double salary) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Отдел должен быть от 1 до 5");
        }
        this.id = counter++;
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment (int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Отдел должен быть от 1 до 5");
        }
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, ФИО: %s, Отдел: %s, Зарплата: %.2f", id, employeeName, department, salary);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Employee employee = (Employee) other;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }

}
