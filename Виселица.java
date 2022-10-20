import java.awt.desktop.ScreenSleepEvent;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.io.Console;

public class Main {
    static int n = 5;
    static int num = 0;

    public static void main(String[] args) {
        String[] str = new String[]{"Собака", "Кот", "Голубь", "Шиншилла", "Зебра", "Муровей", "Слон", "Журавль", "Воробей", "Гепард", "Жираф"};
        String str1 = str[randomNumber(str)];
        String[] questarray = new String[str1.length()];
        for (int i = 0; i < questarray.length; i++) {
            questarray[i] = String.valueOf(str1.charAt(i)).toLowerCase();
        }
        String[] str3 = new String[questarray.length];
        znaki(str3);
        isGuessed(str3, questarray, str1);

    }

    static public int randomNumber(String[] str) {
        double random = Math.random() * str.length;
        return (int) random;
    }

    public static String[] znaki(String[] str3) {
        for (int i = 0; i < str3.length; i++) {
            str3[i] = "_";
        }
        return str3;
    }

    public static void isGuessed(String[] str3, String[] questarray, String str1) {
        Console console = System.console();
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Ваше слово: \n" + Arrays.toString(str3) + " \nВведите букву, которую хотите угадать: ");
            String ansletter = String.valueOf(scanner.next().charAt(0)).toLowerCase();
            int num2 = 0;
            for (int i = 0; i < questarray.length; i++) {
                if (Objects.equals(questarray[i], ansletter)) {
                    if (str3[i] == "_") {
                        str3[i] = ansletter;
                        num2++;
                        num++;
                    } else {
                        System.out.println("Эта буква уже была использована!");
                        continue;
                    }
                    if (num == questarray.length) {
                        System.out.println();
                        System.out.println("Поздравляю с победой! Вашим словом было " +
                                "'" + str1.toLowerCase() + "'");
                         return;
                    } else if (num2 >= 1) {
                        System.out.println();
                        System.out.println("Правильно! Ваша угаданная буква: " + ansletter + " \nВаше слово: " + Arrays.toString(str3));
                    }
                }
            }
            if (num2 < 1) {
                System.out.println();
                switch (n) {
                    case (5):
                        System.out.println("__________\n" +
                                "|        |\n" +
                                "|        0\n" +
                                "|      \n" +
                                "|        \n" +
                                "|      \n" +
                                "|    \n" +
                                "|      \n" +
                                "‾‾");
                        break;
                    case (4):
                        System.out.println("__________\n" +
                                "|        |\n" +
                                "|        0\n" +
                                "|      \n" +
                                "|        \n" +
                                "|      \n" +
                                "|     |‾‾‾‾‾|\n" +
                                "|     |     |\n" +
                                "‾‾\n");
                        break;
                    case (3):
                        System.out.println("__________\n" +
                                "|        |\n" +
                                "|        O\n" +
                                "|       /T\\\n" +
                                "|        | \n" +
                                "|       / \\\n" +
                                "|     |‾‾‾‾‾|\n" +
                                "|     |     |\n" +
                                "‾‾");
                        break;
                    case (2):
                        System.out.println("__________\n" +
                                "|        |\n" +
                                "|       (O)\n" +
                                "|       /T\\\n" +
                                "|        | \n" +
                                "|       / \\\n" +
                                "|     |‾‾‾‾‾|\n" +
                                "|     |     |\n" +
                                "‾‾\n");
                        break;
                    case (1):
                        System.out.println("__________\n" +
                                "|        |        \n" +
                                "|        |\n" +
                                "|       (O)\n" +
                                "|       /T\\ \n" +
                                "|        |\n" +
                                "|     | / \\ |\n" +
                                "|     |     | \n" +
                                "‾‾");

                }
                n--;
                if (n != 0) {
                    System.out.println("Неправильно! Ваше слово: " + " " + Arrays.toString(str3) + ". \nПопыток осталось: " + n);
                }
                if (n == 0) {
                    System.out.println();
                    System.out.println("Из-за Ваших ошибок умер человечек :( \nВашим словом было " + "'" + str1.toLowerCase() + "'");
                    return;
                }
            }
        isGuessed(str3, questarray, str1);
    }
}