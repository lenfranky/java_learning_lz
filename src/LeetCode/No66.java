package LeetCode;

public class No66 {
    public int[] plusOne(int[] digits) {
        int flagCarry = 1;
        int currentIndex = digits.length - 1;
        int currentNum = 0;
        while(flagCarry == 1 && currentIndex >= 0) {
            currentNum = digits[currentIndex] + 1;
            flagCarry = currentNum / 10;
            digits[currentIndex] = currentNum % 10;
            currentIndex --;
        }
        if (flagCarry == 1) {
            int[] res = new int[digits.length + 1];
            for (int i = 0; i < digits.length; i ++) {
                res[i + 1] = digits[i];
            }
            res[0] = 1;
            return res;
        }

        return digits;
    }

    public static void main(String[] args) {
        for (int num: new No66().plusOne(new int[] {9, 9, 9})){
            System.out.println(num);
        }
    }
}
