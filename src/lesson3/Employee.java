package lesson3;

import java.util.Random;

public class Employee {

    private final String fio;
    private final String position;
    private final String phone;
    private int salary;
    private int age;

    public Employee(String fio, String position, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fio='" + fio + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public String displayEmployee() {
        return String.format("Employee fio %s, position %s, phone %s< salary %d, age %d", fio, position, phone, salary, age);
    }


    public static float averageAge(Employee[] array) {
        int sum = 0;
        for (Employee e : array) {
            sum += e.getAge();
        }
        return (float) sum / array.length;
    }

    public static float averageSalary(Employee[] array) {
        int sum = 0;
        for (Employee e : array) {
            sum += e.getSalary();
        }
        return (float) sum / array.length;
    }

    public static String getRandomPosition(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static int getRandomAge() {
        return 40 + new Random().nextInt(50 - 40);
    }

    public static int getRandomSalary() {
        return 40000 + new Random().nextInt(50000 - 40000);
    }
}