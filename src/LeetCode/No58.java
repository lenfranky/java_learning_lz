package LeetCode;

// badcas : " "
public class No58 {
    public int lengthOfLastWordOne(String s) {
        String[] strs = s.split(" ");
        if (strs.length == 0) return 0;
        return strs[strs.length - 1].length();
    }

    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int i = chars.length - 1;
        int zeroNum = 0;
        while (chars[i] == ' ') {
            i --;
            if (i < 0) {
                return 0;
            }
            zeroNum ++;
        }
        for (; i >= 0; i --) {
            if (chars[i] == ' ') return chars.length - 1 - i;
        }
        i = 0;
        while(chars[i] == ' ') {
            i ++;
            if (i == chars.length)
                return 0;
            zeroNum ++;
        }
        return chars.length - zeroNum;
    }

    public static void main(String[] args) {
        System.out.println(new No58().lengthOfLastWord(" a "));
    }
}
