package lesson3;

import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Employee[] array = new Employee[5];
        String[] emplPosition = new String[]{"lawyer", "secretary", "security", "worker", "driver"};
        Employee manager = new Employee("Pupkov S.S.", "manager", "987654320", 60000, 50);
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                array[i] = manager;
            } else {
                array[i] = new Employee("Employee " + i, Employee.getRandomPosition(emplPosition), "12345678" + i, Employee.getRandomSalary(), Employee.getRandomAge());
            }
        }

        for (Employee employee : array) {
            System.out.println(employee.toString());
        }

//        Manager.salaryPlus(array, 45,12000);
        Manager.salaryPlus(array);

        System.out.println("\nAverage age of employees = " + Employee.averageAge(array));
        System.out.println("Average salary of employees = " + Employee.averageSalary(array) + "\n");

        for (Employee e : array) {
            System.out.println(e.displayEmployee());
        }

        Iterator<Employee> emplIterator = Arrays.asList(array).iterator();

        Arrays.sort(array, new ComparatorByAge());

        System.out.println("\nAfter sorting by age:\n");

        while (emplIterator.hasNext()) {
            System.out.println(emplIterator.next());
        }

        Arrays.sort(array, new ComparatorBySalary());

        System.out.println("\nAfter sorting by salary:\n");

        for (Employee e : array) {
            System.out.println(e.displayEmployee());
        }
    }
}
