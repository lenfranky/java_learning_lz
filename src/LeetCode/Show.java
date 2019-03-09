package LeetCode;

public class Show {

    public static void print(int num) {
        System.out.println(num);
    }

    public static void print(char ch) {
        System.out.println(ch);
    }

    public static void print(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length - 1; i ++) {
            System.out.print(nums[i] + ", ");
        }
        if (nums.length > 0)
            System.out.print(nums[nums.length-1]);
        System.out.println("]");
    }

    public static void print(char[] chars) {
        System.out.print("[");
        for (int i = 0; i < chars.length - 1; i ++) {
            System.out.print(chars[i] + ", ");
        }
        if (chars.length > 0)
            System.out.print(chars[chars.length-1]);
        System.out.println("]");
    }
}
