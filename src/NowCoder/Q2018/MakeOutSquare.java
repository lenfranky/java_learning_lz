package NowCoder.Q2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOutSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int[] nums = new int[4];
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i ++) {
            nums[i] = Integer.parseInt(strings[i]);
            if (nums[i] > minValue) minValue = nums[i];
            if (nums[i] < maxValue) maxValue = nums[i];
        }
        int res = Integer.MAX_VALUE;
        for (int i = minValue; i <= maxValue; i ++) {
            int temp = needCoins(nums, i);
            if (temp < res) res = temp;
        }
        System.out.println(res);
    }

    private static int needCoins(int[] lengths, int targetLength) {
        int res = 0;
        for (int length: lengths)
            res += Math.abs(targetLength - length);
        return res;
    }
}
