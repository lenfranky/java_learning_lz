package LeetCode;

import java.util.Arrays;

public class No43 {
    public String multiply(String num1, String num2) {
        int length = num1.length() + num2.length();
        char[] res = new char[length];
        for (int i = 0; i < res.length; i ++) {
            res[i] = '0';
        }
        int currentRes;
        for (int i = num1.length() - 1; i >= 0 ; i -- ) {
            for (int j = num2.length() - 1; j >= 0 ; j -- ) {
                currentRes = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i + j + 1] += currentRes % 10;
                if (res[i + j+ 1] > '9') {
                    res[i + j + 1] -= 10;
                    res[i + j] += 1;
                }
                res[i + j] += currentRes / 10;
                if (res[i + j] > '9') {
                    res[i + j] -= 10;
                    res[i + j - 1] += 1;
                }
            }
            System.out.println(res);
        }

        int startIndex = 0;
        while(res[startIndex] == '0' && startIndex < length - 1){
            startIndex ++;
        }

        if (res[0] == '0') {
            char[] newRes = new char[length - startIndex];
            for (int i = 0; i < length - startIndex; i ++) {
                newRes[i] = res[i + startIndex];
            }
            return String.valueOf(newRes);
        }
        return String.valueOf(res);
    }

    public String multiply_2(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;  //大的数放在小的index, p1放高位数，p2放低位数
                int sum = product + res[p2]; //因为考虑新加的数会影响到i+j+1位的值, i+j 高位 i+j+1低一位

                res[p1] += sum / 10; //因为高位之前存在值，需要加原来值
                res[p2] = sum % 10; //低位已经通过先取和再去余进行了更新
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for(int i = 0; i < m + n; i++){
            //跳过最开始的0
            if(res[i] == 0 && isFirst) continue;
            else{
                isFirst = false;
                sb.append(res[i]);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String multiply_3(String num1, String num2) {
        if (isEmpty(num1) || isEmpty(num2)) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        int[] products = new int[m + n];
        Arrays.fill(products, 0);

        int val1, val2;
        for (int j = n - 1; j >= 0 ; j--) {
            val2 = num2.charAt(j) - '0';
            for (int i = m - 1; i >= 0; i--) {
                val1 = num1.charAt(i) - '0';
                products[j + i + 1] += val2 * val1;
            }
        }

        // Shift the carry's in the product values
        int carry = 0, sum;
        for (int i = products.length - 1; i >= 0; i--) {
            sum = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;

            products[i] = sum;
        }

        // Build the result String
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < products.length; i++) {
            result.append((char) (products[i] + '0'));
        }

        // Remove trailing 0's
        while (result.length() != 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return (result.length() == 0) ? "0" : result.toString();
    }

    private boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }

    public static void main(String[] args) {
        No43 solution = new No43();
        String num1 = "9133";
        String num2 = "0";
        System.out.println(solution.multiply_3(num1, num2));
    }
}
