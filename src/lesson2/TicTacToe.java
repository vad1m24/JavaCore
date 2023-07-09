package lesson2;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static int SIZE;
    public static final String HEADER_FIRST_SYMBOL = "¤";
    public static final String SPACE_MAP = " ";
    private static char[][] MAP;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();
    private static int WIN_TIMES;
    private static int turnsCount;
    private static int lastTurnRow;
    private static int lastTurnColumn;

    public static void start() {
        do {
            System.out.println("\n\nИгра наинается!");
            System.out.println("\nВведите размеры поля для игры (не менее 3)");
            makingSize();
            inputWinTimes();
            init();
            printMap();
            playGame();
        } while (isContinueGame());
        endGame();
    }

    private static int makingSize() {
        while (true) {
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (n >= 3) {
                    SIZE = n;
                    return SIZE;
                }
                System.out.println("Ошибка! Проверьте размеры поля. Допускается от 3 ячеек");
            } else {
                System.out.println("Ошибка! Ввод допускает лишь целые числа!");
                in.next();
            }
        }
    }

    private static int inputWinTimes() {
        if (SIZE >= 3 && SIZE <= 6) {
            WIN_TIMES = 3;
            System.out.println("\nДля победы необходимо совпадение " + WIN_TIMES + " элементов подряд. Удачи!");
        } else if (SIZE > 6 && SIZE < 11) {
            WIN_TIMES = 4;
            System.out.println("\nДля победы необходимо совпадение " + WIN_TIMES + " элементов подряд. Удачи!");
        } else if (SIZE > 11) {
            WIN_TIMES = 5;
            System.out.println("\nДля победы необходимо совпадение " + WIN_TIMES + " элементов подряд. Удачи!");
        }
        return WIN_TIMES;
    }

    private static void init() {
        turnsCount = 0;
        initMap();
    }

    private static void initMap() {
        MAP = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printMapHeader();
        printMapBody();
    }

    private static void printMapHeader() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + SPACE_MAP);
    }

    private static void printMapBody() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP);
            }
            System.out.println();
        }
    }

    private static void playGame() {
        while (true) {
            humanTurn();
            printMap();
            if (checkEnd(DOT_HUMAN)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEnd(DOT_AI)) {
                break;
            }
        }
    }

    private static void humanTurn() {
        System.out.println("\nХод человека");

        while (true) {
            System.out.print("Ведите координату строки: ");
            lastTurnRow = getValidNumberFromScanner() - 1;

            System.out.print("Ведите координату столбца: ");
            lastTurnColumn = getValidNumberFromScanner() - 1;

            if (isCellFree(lastTurnRow, lastTurnColumn)) {
                break;
            }
            System.out.printf("ОШИБКА! Ячейка с координатами %s:%s уже используется%n%n", lastTurnRow + 1, lastTurnColumn + 1);
        }
        MAP[lastTurnRow][lastTurnColumn] = DOT_HUMAN;
        turnsCount++;
    }

    private static int getValidNumberFromScanner() {
        while (true) {
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (isNumberValid(n)) {
                    return n;
                }
                System.out.println("Ошибка! Проверьте значение координаты. Допускается от 1 до " + SIZE);
            } else {
                System.out.println("Ошибка! Ввод допускает лишь целые числа!");
                in.next();
            }
        }
    }

    private static boolean isNumberValid(int n) {
        return n >= 1 && n <= SIZE;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static boolean checkEnd(char symbol) {
        if (checkWin()) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Поздравляем, Вы победили!");
            } else {
                System.out.println("Железо оказалось мощнее, Вы проиграли!");
            }
            return true;
        }

        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean checkWin() {
        int counter = 0;
//        Check row
        for (int i = lastTurnRow; i == lastTurnRow; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if ((MAP[i][j] == MAP[i][j + 1] && MAP[i][j] != DOT_EMPTY)) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == WIN_TIMES - 1) {
                    return true;
                }
            }
        }
//          Check column
        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = lastTurnColumn; j == lastTurnColumn; j++) {
                if ((MAP[i][j] == MAP[i + 1][j]) && MAP[i][j] != DOT_EMPTY) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == WIN_TIMES - 1) {
                    return true;
                }
            }
        }

        return false;
    }


    private static boolean checkDraw() {
        return turnsCount >= SIZE * SIZE;
    }

    private static void aiTurn() {
        System.out.println("\nХод железа");
        do {
            lastTurnRow = random.nextInt(SIZE);
            lastTurnColumn = random.nextInt(SIZE);

        } while (!isCellFree(lastTurnRow, lastTurnColumn));

        MAP[lastTurnRow][lastTurnColumn] = DOT_AI;
        turnsCount++;
    }

    private static boolean isContinueGame() {
        System.out.println("Хотите продолжить? y/n");
        switch (in.next()) {
            case "y":
            case "yes":
            case "да":
            case "д":
            case "+":
                return true;
            default:
                return false;
        }
    }

    private static void endGame() {
        in.close();
        System.out.println("Ты заходи, если что!");
    }
}