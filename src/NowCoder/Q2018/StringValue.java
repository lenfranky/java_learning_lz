package NowCoder.Q2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringValue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int[] charCount = new int[26];
        for (char c: string.toCharArray()) {
            charCount[c - 'a'] += 1;
        }

        for (int i: charCount)
            System.out.print(i + " ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            if (charCount[i] > 0)
                list.add(charCount[i]);
        }
        Collections.sort(list);
        while (n > 0) {
            n --;
            if (list.get(list.size() - 1) > 0) {
                list.set(list.size() - 1, list.get(list.size() - 1) - 1);
                Collections.sort(list);
            }
        }
        int res = 0;
        for (int i: list) {
            res += (i * i);
        }
        System.out.println(list);
        System.out.println(res);
    }
}
