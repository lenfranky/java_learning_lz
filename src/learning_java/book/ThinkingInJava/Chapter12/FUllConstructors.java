package learning_java.book.ThinkingInJava.Chapter12;

public class FUllConstructors {
    public static void f() throws MyException {
        System.out.println("throwing MyException from f()");
        throw new MyException();
    }
    public static void g() throws MyException {
        System.out.println("throwing MyException from g()");
        throw new MyException("Originated in g()");
    }
    public static void main(String[] args) {
//        try {
//            f();
//        }catch (MyException e){
//            e.printStackTrace(System.out);
//        }
        try {
            g();
        }catch (MyException e){
            e.printStackTrace();
        }
    }
}
