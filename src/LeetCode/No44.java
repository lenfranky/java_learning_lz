package LeetCode;

public class No44 {
    public boolean isMatch(String s, String p) {
        int sIndex = 0, pIndex = 0, starIndex = -1, matchIndex = 0;
        while(sIndex < s.length()) {
            if (pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')) {
                sIndex ++;
                pIndex ++;
            }
            else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                starIndex = pIndex;
                pIndex ++;
                matchIndex = sIndex;
            }

            // test case: s = "adcebcb"; p ="*a*b"
            // p里的b实际应该匹配s里的第二个
            // 这里的代码会在匹配第一个b之后，发现s中b后的c无法匹配，则将s中的指针一直向后，看后面是否还有第二个b来匹配p中的b
            else if (starIndex > -1) {
                matchIndex ++;
                pIndex = starIndex;
                sIndex = matchIndex;
            }
            else
                return false;
        }
        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex ++;
        }

        // s走完了但是p没有走完，说明灭有匹配成功
        return pIndex == p.length();
    }

    public static void main(String[] args) {
        No44 solution = new No44();
        String s = "acdcb";
        String p = "a*c?b";
        System.out.println(solution.isMatch(s, p));
    }
}
