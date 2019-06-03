package LeetCode;

import java.util.LinkedList;

import static Tools.IOTools.print;

public class No739 {
    /*
    使用单调递减栈，栈内存储的是索引
    1、如果栈为空，则入栈
    2、如果当前索引的温度大于栈顶元素索引的温度，则弹出栈顶元素index_peek，并令res[index_peek] = curr_index - index_peek
     */

    public int[] dailyTemperatures(int[] T) {
        if (T.length == 0) return null;
        int[] res = new int[T.length];
        LinkedList<Integer> indexStack = new LinkedList<>();
        for (int currIndex = 0; currIndex < T.length; currIndex ++) {
            if (indexStack.isEmpty()) indexStack.push(currIndex);
            else {
                if (T[indexStack.peek()] < T[currIndex]) {
                    int lastIndex = indexStack.pop();
                    res[lastIndex] = currIndex - lastIndex;
                    currIndex--;
                }
                else {
                    indexStack.push(currIndex);
                }
            }
        }
        return res;
    }

    // badcase: [89,62,70,58,47,47,46,76,100,70]
    public int[] dailyTemperaturesWithArray(int[] T) {
        int[] res = new int[T.length];
        int[] indexStackArray = new int[T.length];
        int top = -1;
        for (int currIndex = 0; currIndex < T.length; currIndex ++) {
            if (top == -1 || T[indexStackArray[top]] >= T[currIndex])
                indexStackArray[++top] = currIndex;
            else {
                res[indexStackArray[top]] = currIndex - indexStackArray[top];
                indexStackArray[top--] = 0;
                currIndex --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No739 solution = new No739();
//        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] T = {89,62,70,58,47,47,46,76,100,70};
        print(solution.dailyTemperaturesWithArray(T));
    }
}
