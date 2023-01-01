import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class PasswordGenerator {
    static Console console = System.console();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static boolean isConsole;

    public static void main(String[] args) throws IOException {
        if (console == null) {
            isConsole = false;
            lengthInputIDE();
        } else {
            isConsole = true;
            lengthInputConsole();
        }
    }

    public static void lengthInputIDE() throws IOException {
        System.out.println("Введите длину пароля:");
        passwordGeneration(Integer.parseInt(reader.readLine()));
    }

    public static void lengthInputConsole() throws IOException {
        System.out.println("Введите длину пароля:");
        passwordGeneration(Integer.parseInt(console.readLine()));
    }

    public static void passwordGeneration(int length) throws IOException {
        char[] passwordBuffer = new char[length];
        String numsAndLettersAndSigns = "1234567890qwertyuiopdfghjklzxcvbnmm!@#$%^&*()";
        Random random = new Random();
        for (int i = 0; i < passwordBuffer.length; i++) {
            passwordBuffer[i] = numsAndLettersAndSigns.charAt(random.nextInt(numsAndLettersAndSigns.length()));
            if (random.nextInt(100) > 60) {
                passwordBuffer[i] = Character.toUpperCase(passwordBuffer[i]);
            }
        }
        System.out.println("Ваш сгенерированный пароль: " + String.valueOf(passwordBuffer));
        repeatGeneration();
    }

    public static void repeatGeneration() throws IOException {
        System.out.println("Повторить генерацию? \"Y\"/\"N\"");
        char entry;
        if (isConsole) {
            entry = Character.toLowerCase(console.readLine().charAt(0));
            if (entry == 'y' || entry == 'н') {
                System.out.println("Повторяем генерацию...");
                lengthInputConsole();
            }
            else if (entry == 'n' || entry == 'т') {
                System.out.println("Выходим из программы...");
                System.exit(0);
            } else {
                System.out.println("Ввод неясен, повторяем...");
                repeatGeneration();
            }
        }
        if (!isConsole) {
            entry = Character.toLowerCase(reader.readLine().charAt(0));
            if (entry == 'y' || entry == 'н') {
                System.out.println("Повторяем генерацию...");
                lengthInputIDE();
            }
            else if (entry == 'n' || entry == 'т') {
                System.out.println("Выходим из программы...");
                System.exit(0);
            } else {
                System.out.println("Ввод неясен, повторяем...");
                repeatGeneration();
            }
        }
    }
}
