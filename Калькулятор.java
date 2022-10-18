import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                *******************************************\s
                ********* МОЙ ПЕРВЫЙ КАЛЬКУЛЯТОР **********\s
                *******************************************\s
                ******** СДЕЛАНО АНДРЕЕМ ДАНИЛЕНКО ********\s
                *******************************************""");
        System.out.println("Введите первое число:");
        double num1 = getNumber();
        System.out.println("Введите второе число:");
        double num2 = getNumber();
        System.out.println("Выберите действие: ");
        char i = getAction();
        System.out.println(i);
        System.out.println(num1 + " " + i + " " + num2 + " = " + getResult(i, num1, num2));
    }
    public static double getNumber() {
        double num;
        if (scan.hasNextDouble()) {
            num = scan.nextDouble();
        } else {
            System.out.println("Это не число. Повторяем...");
            scan.next();
            num = getNumber();
        }
        return num;
    }
    public static double getResult(char i, double num1, double num2) {
        double result = 0;
        switch (i) {
            case ('*'):
            result = num1*num2;
            break;
            case ('/'):
            result = num1/num2;
            break;
            case('+'):
            result = num1+num2;
            break;
            case('-'):
            result = num1-num2;
            break;
        }
        return result;
    }
    public static char getAction() {
        char action;
        action = scan.next().charAt(0);
        if (scan.hasNext()) {
            switch (action) {
                case ('*'):
                case ('/'):
                case ('-'):
                case ('+'):
                    break;
                default:
                    System.out.println("Не могу распознать операцию. Повторяем...");
                    action = getAction();
            }
        } else {
            System.out.println("Не могу распознать операцию. Повторяем...");
            action = getAction();
        }
        return action;
    }
}