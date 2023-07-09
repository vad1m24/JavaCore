package lesson3;

import java.util.Comparator;

public class ComparatorBySalary implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getSalary() - e2.getSalary();
    }
}
