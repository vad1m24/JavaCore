package lesson1.task2;

import java.util.Scanner;

/**
 * Публичный класс приложения. Здесь мописывается основная логика приложения.
 */

public class FirstClass {

    /**
     * Запускаем Scanner для взаимодействия приложения с пользователем
     * и получения вводимых им значений.
     */

    Scanner scanner;

    /**
     * Создается конструктор класса.
     */

    public FirstClass() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Публичный метод запуска приложения, без входных аргументов.
     * В методе получаем данные от пользователей и записываем их в переменные,
     * значения которых передается в качестве аргументов в метод класса-обертки.
     */

    public void run(){
        String name = setData("Input your name: ");
        String age_str = setData("Input your age: ");
        int age = 0;
        try{
            age = Integer.parseInt(age_str);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        Decorator.helloUser(name, age);
    }

    /**
     * Публичный метод, позволяющий общаться с пользователем при помщи
     * вывода в консоль вопросов и получения на них ответов.
     * @param msg Пользователю отправляется запрос для получения обратных данных.
     * @return данные от пользователя строкового типа.
     */

    public String setData(String msg){
        System.out.println(msg);
        return scanner.nextLine();
    }
}
