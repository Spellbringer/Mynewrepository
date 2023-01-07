import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class DeepDanbooruParser {
    static String tags = "";
    static java.io.Console console = System.console();
    public static void main(String[] args) {
        System.out.println("Enter your raw text below: ");
       if (console != null) {
           consoleInput();
       }
       else {
           iDEInput();
       }
    }
    public static void iDEInput() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.isBlank()) {
                break;
            }
            String[] tokens = str.split(" ");
            tags += tokens[0] + ", ";

        }
        System.out.println("Your parsed tags are: \n" + tags);
    }
    public static void consoleInput() {
        String nextScan = "null";
        while (!nextScan.isBlank()) {
            nextScan = console.readLine();
            if (nextScan.isBlank()) {
                break;
            }
            String[] tokens = nextScan.split(" ");
            tags += tokens[0] + ", ";

        }
        System.out.println("Your parsed tags are: \n" + tags);
    }
}