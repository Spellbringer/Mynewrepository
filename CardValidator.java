import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Проверка номеров карт при помощи формулы Луна
public class CardValidator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String cardNum = reader.readLine();
        if (cardNum.length() != 16) {
            int[] reverseCardNum = new int[cardNum.length()];
            int sum = 0;
            for (int i = reverseCardNum.length, j = 0; i > 0; i--, j++) {
                reverseCardNum[j] = Integer.parseInt(String.valueOf(cardNum.charAt(i - 1)));
            }
            for (int i = 0; i < reverseCardNum.length; i++) {
                if (i % 2 != 0) {
                    reverseCardNum[i] *= 2;
                }
            }
            for (int i = 0; i < reverseCardNum.length; i++) {
                if (reverseCardNum[i] > 9) {
                    reverseCardNum[i] -= 9;

                }
            }
            for (int j : reverseCardNum) {
                sum += j;
            }
            if (sum % 10 == 0) {
                System.out.println("valid");
            } else {
                System.out.println("not valid");
            }
        } else {
            System.out.println("Card number should be exactly 16 digits!");
        }
    }
}