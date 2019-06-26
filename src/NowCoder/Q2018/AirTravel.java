package NowCoder.Q2018;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static learning_java.GrammarTest.IOTools.print;

public class AirTravel {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strings = line.trim().split(" ");
        int n = Integer.parseInt(strings[0]);
        int v = Integer.parseInt(strings[1]);
        line = br.readLine();
        strings = line.trim().split(" ");
        int[] nums = new int[n];
        int res = 0;
        for (int i = 0; i < n; i ++) {
            nums[i] = Integer.parseInt(strings[i]);
            v -= nums[i];
            if (v < 0) break;
            res ++;
        }
        System.out.println(res);
    }
}
