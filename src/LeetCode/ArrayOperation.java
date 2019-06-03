package LeetCode;

import java.util.Arrays;

import static Tools.IOTools.print;

class FalseInputException extends Exception {
    public FalseInputException() {}
    public FalseInputException(String msg) {super(msg);}
}

public class ArrayOperation {
    public static int[][] getIntArray(String str) {
        if (str.charAt(0) != '[' || str.charAt(1) != '[' || str.charAt(str.length() - 1) != ']' || str.charAt(str.length() - 2) != ']') {
            System.out.println("Wrong Input Format!");
            return null;
        }
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split("]");
        int[][] res = new int[strs.length][];
        for (int i = 0; i < res.length; i ++) {
            res[i] = strToIntArray(strs[i]);
        }
        return res;
    }

    private static int[] strToIntArray(String sourceStr) {
        sourceStr = sourceStr.replace("]", "").replace("[", "").replace(" ","");
        if (sourceStr.charAt(0) == ',') sourceStr = sourceStr.substring(1, sourceStr.length());
        String[] strs = sourceStr.split(",");
        int[] res = new int[strs.length];
        for (int i = 0; i < strs.length; i ++) {
            res[i] = Integer.parseInt(strs[i]);
        }
        return res;
    }


    public static char[][] getCharArray(String str){
        if (str.charAt(0) != '[' || str.charAt(1) != '[' || str.charAt(str.length() - 1) != ']' || str.charAt(str.length() - 2) != ']') {
            System.out.println("Wrong Input Format!");
            return null;
        }
        String[] strs = str.split("],\\[");
        char[][] res = new char[strs.length][];
        for (int i = 0; i < res.length; i ++) {
            res[i] = strToCharArray(strs[i]);
        }
        return res;
    }

    private static char[] strToCharArray(String sourceStr) {
        if (sourceStr.length() == 3) {
            return new char[] {sourceStr.charAt(1)};
        }
        while (sourceStr.length() > 0 && sourceStr.charAt(0) == '[') {
            sourceStr = sourceStr.substring(1, sourceStr.length());
        }
        while (sourceStr.length() > 0 && sourceStr.charAt(sourceStr.length() - 1) == ']') {
            sourceStr = sourceStr.substring(0, sourceStr.length() - 1);
        }
        String[] strs = sourceStr.split(",");
        char[] res = new char[strs.length];
        for (int i = 0; i < strs.length; i ++) {
            res[i] = strs[i].charAt(1);
        }
        return res;
    }

    public static void main (String[] args){
//        String str = "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
//        System.out.println(str);
//        print(ArrayOperation.getCharArray(str));

        String str_2 = "[[1,2], [1,3], [2,3]]";
        System.out.println(str_2);
        print(ArrayOperation.getIntArray(str_2));
    }
}
