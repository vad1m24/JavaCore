package lesson4.task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� �����: ");
        String login = scanner.nextLine();
        System.out.println("������� ������: ");
        String password = scanner.nextLine();
        System.out.println("������� ������: ");
        String secondPass = scanner.nextLine();
        try{
            if(!(Main.checkData(login,password,secondPass))){
                System.out.println("������ ����������");
            }
        } catch (WrongLoginException e){
            System.out.println(e.getMessage());
        } catch (WrongPasswordException exception){
            exception.printStackTrace();
        }

    }

    private static boolean checkData(String log, String pass, String secPass) throws WrongLoginException, WrongPasswordException {
        if(log.isEmpty() || pass.isEmpty() || secPass.isEmpty() ){
            throw new RuntimeException("Empty string");
        } else if (log.length() >= 20){
            throw new WrongLoginException("������ ������ ����� 19 ��������.");
        } else if (pass.length() >= 20 || secPass.length() >= 20){
            throw new WrongPasswordException();
        } else if(pass.equals(secPass)){

        }
        return true;
    }
}
