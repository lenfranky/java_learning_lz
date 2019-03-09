package Tools;

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

    public static void print(int num) {
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

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        char[] chars1 = {'a','b', 'c', 'd', 'e'};
        char[] chars2 = {6, 7, 8, 9, 10};
        print(nums1);
        print(chars1);
//        print(chars2);
    }
}
