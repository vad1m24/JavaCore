package lesson5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TicTacToe {

    /**
     * ������������, ��� ����� � �������� ������� �� 9 ��������� ����� ��������[0, 3], � ������������ �����,
     * ��������, ��������� ����� ���� ��� ���� � ��������������, ��� 0 � ��� ������ ����, 1 � ��� ���� � ���������,
     * 2 � ��� ���� � �������, 3 � ��������� ��������.
     * ����� ������������� �������� ������� � ����� ����� ���� int �� ���� 3�3.
     * �������� � ���� ��������� ���� � �������� ����������� ������������ ��������� ���� �� ����� (*)
     * ������� ��� ����������� � ���� ��������-������ - ����� ��� ���������� ��������� ���� � �������������� �� �����
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