package lesson4.task2;

public class TooMuchSaleException extends Exception {

    public TooMuchSaleException() {
        super("Your discount more then 50%.");
    }

}
