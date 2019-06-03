package learning_java.Other.IEEE.AliceBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    /*
    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.HashMap.resize(HashMap.java:704)
	at java.util.HashMap.putVal(HashMap.java:663)
	at java.util.HashMap.put(HashMap.java:612)
	at learning_java.Other.IEEE.AliceBook.Main.helper(Main.java:14)
	at learning_java.Other.IEEE.AliceBook.Main.main(Main.java:44)
     */
    public static void helperWithMap(int n, int[] luckyNumbers) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int res = 0;
        for (int luckyNumber: luckyNumbers) {
            int currNum = luckyNumber;
            while (currNum <= n) {
                numMap.put(currNum, numMap.getOrDefault(currNum, 0) + 1);
                currNum += luckyNumber;
            }
        }
        for (Map.Entry<Integer, Integer> entry: numMap.entrySet()) {
            if ((entry.getValue() & 1) == 1) {
                res += 1;
            }
        }
        System.out.println(res);
    }

    public static void helperWithMod(int n, int[] luckyNumbers) {
        int res = 0;
        int xorCount;
        for (int i = 1; i <= n; i ++) {
            xorCount = 0;
            for (int luckyNumber: luckyNumbers) {
                if (i % luckyNumber == 0)
                    xorCount += 1;
            }
            if ((xorCount & 1) == 1)
                res += 1;
        }
        System.out.println(res);
    }

    public static void helper(int n, int[] luckyNumbers) {
        int res = 0;
        int luckyNumberCount = luckyNumbers.length;
        int[] lastNumber = new int[luckyNumberCount];
        int xorCount;
        for (int i = 1; i <= n; i ++) {
            xorCount = 0;
            for (int j = 0; j < luckyNumberCount; j ++) {
                if (i - lastNumber[j] == luckyNumbers[j]) {
                    xorCount += 1;
                    lastNumber[j] = i;
                }
            }
            if ((xorCount & 1) == 1)
                res += 1;
        }
        System.out.println(res);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();
        int testCasesCount = Integer.parseInt(temp);
        int i = 0;
        int n, m;
        int[] luckyNumbers;
        while (i < testCasesCount) {
            temp = in.nextLine();
            String[] ss = temp.trim().split(" ");
            n = Integer.parseInt(ss[0]);
            m = Integer.parseInt(ss[1]);
            temp = in.nextLine();
            luckyNumbers = new int[m];
            ss = temp.trim().split(" ");
            for (int j = 0; j < m; j ++) {
                luckyNumbers[j] = Integer.parseInt(ss[j]);
            }
            Main.helper(n, luckyNumbers);
            i ++;
        }
    }
}

/*
2
10 1
3
10 1
1

1
1000000000 1
5

 */
