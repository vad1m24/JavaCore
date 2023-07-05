package lesson1.task2;

/**
 *  Основной публичный класс приложения. Здесь мы можем описать
 *  его основное назначение и способы взаимодействия с ним.
 */

public class Main {

    /**
     * Точка входа в программу. С неё всегда всё начинается.
     *
     * @param args стандартные аргументы командной строки
     */

    public static void main(String[] args) {

        /**
         * В данном методе создается экземпляр класса FirstClass
         * и запускается его метод выполнения.
         */

        FirstClass firstClass = new FirstClass();
        firstClass.run();

    }
}
