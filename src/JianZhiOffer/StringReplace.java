package JianZhiOffer;

public class StringReplace {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
//        char[] chars = str.toString().toCharArray();
        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) == ' ') sb.append("%20");
            else sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuffer bf = new StringBuffer("We Are Happy");
        System.out.println(new StringReplace().replaceSpace(bf));
    }
}
