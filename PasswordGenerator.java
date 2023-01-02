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
        System.out.println("Enter password length:");
        try {
            passwordGeneration(Integer.parseInt(reader.readLine()));
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Not a number. Repeat input.");
            lengthInputIDE();
        }
    }

    public static void lengthInputConsole() throws IOException {
        System.out.println("Enter password length:");
        try {
            passwordGeneration(Integer.parseInt(console.readLine()));
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Not a number. Repeat input.");
            lengthInputConsole();
        }
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
        System.out.println("Your generated password: " + String.valueOf(passwordBuffer));
        repeatGeneration();
    }

    public static void repeatGeneration() throws IOException {
        System.out.println("Regenerate? \"Y\"/\"N\"");
        char entry;
        try {
            if (isConsole) {
                entry = Character.toLowerCase(console.readLine().charAt(0));
                if (entry == 'y' || entry == 'н') {
                    System.out.println("Repeating generation...");
                    lengthInputConsole();
                } else if (entry == 'n' || entry == 'т') {
                    System.out.println("Exiting the program...");
                    System.exit(0);
                } else {
                    System.out.println("Input unclear, repeat...");
                    repeatGeneration();
                }
            }
            if (!isConsole) {
                    entry = Character.toLowerCase(reader.readLine().charAt(0));
                    if (entry == 'y' || entry == 'н') {
                        System.out.println("Repeating generation...");
                        lengthInputIDE();
                    } else if (entry == 'n' || entry == 'т') {
                        System.out.println("Exiting the program...");
                        System.exit(0);
                    } else {
                        System.out.println("Input unclear, repeat...");
                        repeatGeneration();
                    }
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Cannot be an empty field! Repeat input");
            repeatGeneration();
        }
    }
}