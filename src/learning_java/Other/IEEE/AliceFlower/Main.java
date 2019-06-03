package learning_java.Other.IEEE.AliceFlower;

import java.util.*;

public class Main {
    class Pair{
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public static int getFlowerCountWithArray(String s) {
        int n = s.length();
        boolean test[] = new boolean[n];
        boolean dp[][] = new boolean[n][n];
        Set<Pair> pairSet = new HashSet<>();
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j <= i; j ++) {
                if (chars[i] == chars[j] && ((j + 1 > i - 1) || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    res = (res + 1) % 100000007;
                }
            }
        }
        return res;
    }

    public static int getFlowerCountWithArrayList(String s) {
        int n = s.length();
        List<boolean[]> dp = new ArrayList<>(n);
        for (int i = 0; i < n; i ++) {
            dp.add(new boolean[n]);
        }
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j <= i; j ++) {
                if (chars[i] == chars[j] && ((j + 1 > i - 1) || dp.get(j + 1)[i - 1])) {
                    dp.get(j)[i] = true;
                    res = (res + 1) % 100000007;
                }
            }
        }
        return res;
    }

    public static int getFlowerCount(String s) {
        int n = s.length();
        List<Integer> currPair = new ArrayList<>();
        currPair.add(0);
        currPair.add(1);
        Set<int[]> pairSet = new HashSet<>();
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j <= i; j ++) {
                if (chars[i] == chars[j] && ((j + 1 > i - 1) || pairSet.contains(new int[]{j + 1, i - 1}))) {
                    pairSet.add(new int[] {j, i});
                    res = (res + 1) % 100000007;
                }
            }
        }
        return res;
    }

    public static String createString(int n) {
        if (n == 0) return null;
        StringBuilder sb = new StringBuilder();
        Random random = new Random(47);
        for (int i = 0; i < n; i ++) {
            sb.append((char) (random.nextInt(26) + 97));
        }
        return sb.toString();
    }

    public static void main(String[] args)  throws InterruptedException{
        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
//        String s = in.nextLine();
//        if (n == 0) System.out.println(0);
        // 2000000
        String s = Main.createString(5);
//        System.out.println(s);
//        Thread.sleep(10000);
        if (1 == 0) System.out.println(0);
        else {
            System.out.println(Main.getFlowerCount(s));
        }
    }
}
