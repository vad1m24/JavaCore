package lesson3;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getAge() - e2.getAge();
    }
}
