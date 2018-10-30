package learning_java;

public class StringOperation {
    public static void main(String[] args){
        String s1 = "Welcome to Java";
        String s2 = "Welcome to Java";
        String s3 = "Welcome to C++";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));

        // compareTo方阿飞返回的实际值是依据是s1和s2从左到右数第一个不同字符之间的距离得出的。
        System.out.println(s1.compareTo(s3));

        System.out.println(s1.startsWith("We"));
        System.out.println(s1.startsWith("We"));

        System.out.println("################################");
        String s4 = "This is the No.";
        String s5 = s4 + 4 + " string";
        System.out.println(s5);

        String s6 = String.valueOf(5.44);
        System.out.println(s6);

        char[] chars = s6.toCharArray();
        System.out.print("the chars is : \t");
        System.out.println(chars);
        for(int i=0; i < chars.length; i ++) {
            System.out.println(chars[i]);
        }

        for (char c: chars) {
            System.out.print(c);
        }

        System.out.println(" ");
        System.out.println(s6.length());
    }
}
