package learning_java.Other;

public class ParamsTest {
    // 用于测试在IDE中如何向main中输入参数
    // 方法，在run处的edit configuration中设置program arguments
    public static void main(String[] args) {
        double res = 0;
        for (int i = 0; i < args.length; i ++) {
            res += Double.valueOf(args[i]);
        }
        System.out.println(res);
    }
}
