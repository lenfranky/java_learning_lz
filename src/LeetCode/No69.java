package LeetCode;

public class No69 {
    public int mySqrtOld(int x) {
        int res = (int) Math.sqrt(x);
        return res;
    }

    public int mySqrt(int x) {
        if (x == 0) return 0;
        long left = 1, right = x;
        while (true) {
            long mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            }
            else {
                if ((mid + 1) * (mid + 1) > x)
                    return (int)mid;
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE * (Integer.MAX_VALUE - 1));
        System.out.println(new No69().mySqrt(4));
    }
}
