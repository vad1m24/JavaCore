package lesson4.task2;

public class NoItemFoundException extends Exception {

    public NoItemFoundException() {
    }

    public NoItemFoundException(String message) {
        super(message);
    }
}
