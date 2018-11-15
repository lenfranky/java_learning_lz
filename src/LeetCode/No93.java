package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4) return res;
        List<String> currentRes = new ArrayList<>();

        backStracking(res, currentRes, 0, s);

        return res;
    }

    public boolean backStracking(List<String> res, List<String> currentRes, int index, String s) {
        if (currentRes.size() == 4) {
            String str = currentRes.get(0) + "." + currentRes.get(1) + "." + currentRes.get(2) + "." + currentRes.get(3);
            res.add(str);
            return true;
        }
        if (s.length() == index) return false;
        if (currentRes.size() == 3) {
            if (s.length() - index + 1 > 4 || Integer.valueOf(s.substring(index)) > 255)
                return false;
            else {
                currentRes.add(s.substring(index));
                backStracking(res, currentRes, index, s);
                currentRes.remove(currentRes.size() - 1);
                return true;
            }
        }
        for (int i = 1; i <= 3; i ++) {
//            System.out.println(index + "\t" + index + i);
            if (index + i >= s.length() || i == 3 && Integer.valueOf(s.substring(index, index + i)) > 255)
                continue;
            currentRes.add(s.substring(index, index + i));
            backStracking(res, currentRes, index + i, s);
            currentRes.remove(currentRes.size() - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new No93().restoreIpAddresses("010010"));
    }
}
