package lesson3;

public class Manager extends Employee {

    public Manager(String fio, String position, String phone, int salary, int age) {
        super(fio, position, phone, salary, age);
    }

    public static void salaryPlus(Employee[] array) {
        for (Employee e : array) {
            if (!e.getPosition().equals("manager")) {
                e.setSalary(e.getSalary() + 5000);
            }
        }

    }

    public static void salaryPlus(Employee[] array, int minAge, int salaryPlus) {
        for (Employee e : array) {
            if (e.getAge() >= minAge) {
                if (!e.getPosition().equals("manager")) {
                    e.setSalary(e.getSalary() + salaryPlus);
                }
            }
        }
    }
}
