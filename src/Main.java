public class Main {

    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("Иванов Иваан Иванович", 1, 85000);
        employees[1] = new Employee("Смирнова Татьяна Викторовна", 2, 81000);
        employees[2] = new Employee("Петров Иван Сазонович", 3, 94000);
        employees[3] = new Employee("Васильев Александр Иванович", 4, 107000);
        employees[4] = new Employee("Петров Петр Петрович", 5, 121000);
        employees[5] = new Employee("Васильев Василий Николаевич", 1, 90000);
        employees[6] = new Employee("Страусов Валерий Анатольевич", 2, 101000);

        System.out.println("Базовая сложность");
        printEmployeeList();
        System.out.println("Общая сумма расходов на зарплату:" + calculateSalary());
        System.out.println("Сотрудник с минимальной зарплатой:" + findEmployeeMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой:" + findEmployeeMaxSalary());
        System.out.println("Средняя зарплата сотрудника:" + calculateAverageSalary());
        printEmployeeNames();
        System.out.println();

        System.out.println("Повышенная сложность, задание 1");
        System.out.println();
        indexSalary(10);
        printEmployeeList();

        System.out.println();
        System.out.println("Повышенная сложность, задание 2");
        System.out.println();

        System.out.println("Минимальная зарплата в отделе 1:" + findMinSalaryEmployeeInDepartment(1));
        System.out.println("Mаксималььная зарплата в отделе 2:" + findMaxSalaryEmployeeInDepartment(2));
        System.out.println("Общая сумма затрат на зарплату в отделе 1:" + calculateDepartmentSalary(1));
        System.out.println("Средняя зарплата по отделу 2:" + calculateAverageSalaryInDepartment(2));
        indexSalaryInDepartment(2,15);
        printEmployeesListInDepartment(2);

        System.out.println();
        System.out.println("Пов.сложность, задание 3");
        System.out.println();

        inputEmployeesWithLessSalary(100_000);
        System.out.println();
        inputEmployeesWithMoreSalary(100_000);

    }

    public static void printEmployeeList() {
        System.out.println("Список сотрудников:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
    }

    public static double calculateSalary() {
        double totalSalary = 0.00;
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null) {
                totalSalary += employees[i].getSalary();
            }
        }
        return totalSalary;
    }

    public static Employee findEmployeeMinSalary() {
        Employee minSalaryEmployee = null;
        double minSalary = employees[0].getSalary();

        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                minSalaryEmployee = employees[i];
            }
        }
        return minSalaryEmployee;
    }

    public static Employee findEmployeeMaxSalary() {
        Employee maxSalaryEmployee = null;
        double maxSalary = employees[0].getSalary();

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                maxSalaryEmployee = employees[i];
            }
        }
        return maxSalaryEmployee;
    }

    public static double calculateAverageSalary() {
        int countEmployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                countEmployees++;
            }
        }
        return calculateSalary()/countEmployees;
    }

    public static void printEmployeeNames() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getEmployeeName());
            }
        }
    }

    public static void indexSalary(double percent) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                double newSalary = employees[i].getSalary() * (1 + percent / 100);
                employees[i].setSalary(newSalary);
            }
        }
    }

    public static Employee findMinSalaryEmployeeInDepartment(int department) {
        Employee minSalaryEmployee = null;
        double minSalary = 1_000_000_000;

        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null && employees[i].getDepartment() == department &&
            employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                minSalaryEmployee = employees[i];
            }
        }
        return  minSalaryEmployee;
    }
    public static Employee findMaxSalaryEmployeeInDepartment(int department) {
        Employee maxSalaryEmployee = null;
        double maxSalary = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department &&
                    employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                maxSalaryEmployee = employees[i];
            }
        }
        return maxSalaryEmployee;
    }

    public static double calculateDepartmentSalary(int department) {
        double totalSalaryDepartment = 0.0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                totalSalaryDepartment += employees[i].getSalary();
            }
        }
        return totalSalaryDepartment;
    }


    public static double calculateAverageSalaryInDepartment(int department) {
        int countEmployeesInDepartment = 0;
        double totalSalaryInDepartment = 0;

        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null && employees[i].getDepartment() == department) {
                countEmployeesInDepartment++;
                totalSalaryInDepartment += employees[i].getSalary();
            }
        }
        return totalSalaryInDepartment / countEmployeesInDepartment;
    }

    public static void indexSalaryInDepartment(int department, double percent) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                double newSalary = employees[i].getSalary() * (1 + percent / 100);
                employees[i].setSalary(newSalary);
            }
        }
    }

    public static void printEmployeesListInDepartment(int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                System.out.println(employees[i]);
            }
        }
    }

    public static void inputEmployeesWithLessSalary(double number) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < number) {
                System.out.println(employees[i]);
            }
        }
    }

    public static void inputEmployeesWithMoreSalary(double number) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > number) {
                System.out.println(employees[i]);
            }
        }
    }
}