package NowCoder.Q2018;
import java.util.Scanner;

public class DeleteRepeatChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        boolean[] charAppeared = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (char c: str.toCharArray()) {
            if (!charAppeared[c - 'a']) {
                charAppeared[c - 'a'] = true;
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}
