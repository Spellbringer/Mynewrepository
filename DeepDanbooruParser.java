import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class DeepDanbooruParser {
    static String tags = "";
    static java.io.Console console = System.console();
    public static void main(String[] args) {
        if (console != null) {
            System.out.println("Enter your raw text below: ");
            consoleInput();
        }
        else {
            System.out.println("Console unavailable!");
        }
    }
    public static void consoleInput() {
        String nextScan = "null";
        while (!nextScan.isBlank()) {
            nextScan = console.readLine();
            if (nextScan.isBlank()) {
                break;
            }
            String[] tokens = nextScan.split("\n");
            if (hasWhiteSpace(tokens[0])) {
                tags += tokens[0].substring(0, tokens[0].length() - 6) + ", ";
            } else {
                tags += tokens[0].substring(0, tokens[0].length() - 5) + ", ";
            }

        }
        System.out.println("Your parsed tags are: \n" + tags);
    }
    public static boolean hasWhiteSpace(String token) {
        for (int i = 0; i < token.length(); i++) {
            if (Character.isWhitespace(token.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}