package learning_java.blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ExerciseIO {
    public void stringIO() throws IOException {
        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取字符串
        String line = br.readLine();

        // 测试输入是否正确
        System.out.println(line);
    }

    public void numsIO() throws IOException {
        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取第一行数据
        String line = br.readLine();
        // 将字符串根据空格进行分隔
        String[] strings = line.trim().split(" ");
        // 分别将其中的每个数值读出
        int n = Integer.parseInt(strings[0]);
        int v = Integer.parseInt(strings[1]);
        // 读取第二行数据
        line = br.readLine();
        strings = line.trim().split(" ");
        // 创建一个int型的数组用来储存第二行的多个数字
        int[] nums = new int[n];
        for (int i = 0; i < n; i ++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        // 测试输入是否正确
        for (int num: nums) {
            System.out.print(num + " ");
        }
    }

    public void numIO() throws IOException {
        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取第一行数据
        String line = br.readLine();
        // 将字符串根据空格进行分隔
        String[] strings = line.trim().split(" ");
        // 分别将其中的每个数值读出
        int n = Integer.parseInt(strings[0]);
        int v = Integer.parseInt(strings[1]);

        // 测试输入是否正确
        System.out.println("n: " + n + "\tv: " + v);
    }

    public static void main(String[] args) throws IOException{
        ExerciseIO solution = new ExerciseIO();
        solution.numIO();
    }
}
