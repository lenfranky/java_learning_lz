package JianZhiOffer;

import java.util.Collection;

public class IOTools {
    public static void print(int[] nums) {
        System.out.print("[");
        if (nums.length == 0) {
            System.out.println("]");
            return;
        }
        for (int i = 0; i < nums.length - 1; i ++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print(nums[nums.length - 1]);
        System.out.println("]");
    }

    public static void printWithoutLF(int[] nums) {
        System.out.print("[");
        if (nums.length == 0) {
            System.out.println("]");
            return;
        }
        for (int i = 0; i < nums.length - 1; i ++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print(nums[nums.length - 1]);
        System.out.print("]");
    }

    public static void print(char[] chars) {
        System.out.print("[");
        if (chars.length == 0) {
            System.out.println("]");
            return;
        }
        for (int i = 0; i < chars.length - 1; i ++) {
            System.out.print(chars[i] + " ");
        }
        System.out.print(chars[chars.length - 1]);
        System.out.println("]");
    }

    public static void print(boolean[] booleans) {
        System.out.print("[");
        if (booleans.length == 0) {
            System.out.println("]");
            return;
        }
        for (int i = 0; i < booleans.length - 1; i ++) {
            System.out.print(booleans[i] + " ");
        }
        System.out.print(booleans[booleans.length - 1]);
        System.out.println("]");
    }

    public static void print(String[] strings) {
        System.out.print("[");
        if (strings.length == 0) {
            System.out.println("]");
            return;
        }
        for (int i = 0; i < strings.length - 1; i ++) {
            System.out.print(strings[i] + " ");
        }
        System.out.print(strings[strings.length - 1]);
        System.out.println("]");
    }

    public static void print(boolean[][] booleans) {
        System.out.print("[\n");
        if (booleans.length == 0) {
            System.out.println("]");
            return;
        }
        for (int i = 0; i < booleans.length - 1; i ++) {
            print(booleans[i]);
        }
        print(booleans[booleans.length - 1]);
        System.out.println("]");
    }

    public static void print(char[][] chars) {
        if (chars == null || chars.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[\n");
        for (int i = 0; i < chars.length - 1; i ++) {
            print(chars[i]);
        }
        print(chars[chars.length - 1]);
        System.out.println("]");
    }

    public static void print(int[][] nums) {
        if (nums == null) return;
        System.out.print("[");
        if (nums.length == 0) {
            System.out.println("]");
            return;
        }
        if (nums.length > 1)
            print(nums[0]);
        for (int i = 1; i < nums.length - 1; i ++) {
            System.out.print(" ");
            print(nums[i]);
        }
        System.out.print(" ");
        printWithoutLF(nums[nums.length - 1]);
        System.out.println("]");
    }

    public static void print(int num) {
        System.out.println(num);
    }

    public static void print(double num) {
        System.out.println(num);
    }

    public static void print(char num) {
        System.out.println(num);
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static void print(boolean bool) {
        System.out.println(bool);
    }

    public static void print(Collection<?> collection) {System.out.println(collection);}

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        char[] chars1 = {'a','b', 'c', 'd', 'e'};
        char[] chars2 = {6, 7, 8, 9, 10};
        print(nums1);
        print(chars1);
//        print(chars2);
    }
}
