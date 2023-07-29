package lesson5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TicTacToe {

    /**
     * ѕредположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представл€ют собой,
     * например, состо€ни€ €чеек пол€ дл€ игры в крестикинолики, где 0 Ц это пустое поле, 1 Ц это поле с крестиком,
     * 2 Ц это поле с ноликом, 3 Ц резервное значение.
     * “акое предположение позволит хранить в одном числе типа int всЄ поле 3х3.
     * «аписать в файл состо€ние пол€ и добавить возможность восстановить состо€ние пол€ из файла (*)
     * сделать доп возможность в игре крестики-нолики - метод дл€ сохранени€ состо€ни€ игры и восстановление из файла
     */


    public static void main(String[] args) {

        byte[] arrTicTacToe = {0, 2, 3, 1, 2, 1, 1, 0, 0};

        int serializedArr = serializeArr(arrTicTacToe);

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("TicTacToe.dat"))) {
            outputStream.writeInt(serializedArr);
            System.out.println("Saved successfully.");
        } catch (IOException e) {
            System.out.println("Data entry error.");
            e.printStackTrace();
        }
    }

    private static int serializeArr(byte[] arrTicTacToe) {
        if (arrTicTacToe == null || arrTicTacToe.length != 9) {
            throw new IllegalArgumentException("The number of elements must be nine.");
        }

        int serializedArr = 0;
        for (int i = 0; i < arrTicTacToe.length; i++) {
            if (arrTicTacToe[i] < 0 || arrTicTacToe[i] > 3) {
                throw new IllegalArgumentException("The range of elements must be between 0 and 3.");
            }
            serializedArr |= (arrTicTacToe[i] << (i * 2));
        }
        return serializedArr;
    }
}