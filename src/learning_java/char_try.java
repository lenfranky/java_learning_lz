package learning_java;

public class char_try {
    public static void main(String[] args){
        char lowerChar = 'a';
        char upperChar = 'A';
        System.out.println("lowerChar is :" + lowerChar + "\t upperChar is :" + upperChar);
        System.out.println(Character.toLowerCase(upperChar));
        System.out.println(Character.toLowerCase(lowerChar));
    }
}
