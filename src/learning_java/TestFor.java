package learning_java;

public class TestFor {
    public static void main(String[] args){
        for(int i = 0; i < 10; i++){
            System.out.println(i);
        }
        //一个for循环同初始部分声明的变量，其作用域只限于循环体内。
        //int j = i;
        int j = 1;
        System.out.println(j);

        System.out.println((int)'a');
    }
}
