package LeetCode;

public class No67 {
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1, bIndex = b.length() - 1, c = 0;
        String res = "";
        while(aIndex >= 0 || bIndex >= 0 || c > 0) {
            c += aIndex >= 0 ? a.charAt(aIndex --) - '0' : 0;
            c += bIndex >= 0 ? b.charAt(bIndex --) - '0' : 0;
            res = (char)(c + '0')%2 + res;
            c /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No67().addBinary("101", "111"));
    }
}
