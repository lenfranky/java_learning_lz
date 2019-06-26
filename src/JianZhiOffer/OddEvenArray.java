package JianZhiOffer;

import java.util.ArrayList;
import java.util.List;

import static JianZhiOffer.IOTools.print;

public class OddEvenArray {
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0) return;
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();

        for (int num: array) {
            if ((num & 1) == 1) oddNumbers.add(num);
            else evenNumbers.add(num);
        }

        int oddNumbersCount = oddNumbers.size();
        int evenNumbersCount = evenNumbers.size();
        for (int i = 0; i < oddNumbersCount; i ++) {
            array[i] = oddNumbers.get(i);
        }
        for (int i = 0; i < evenNumbersCount; i ++) {
            array[oddNumbersCount + i] = evenNumbers.get(i);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7 ,8};
        new OddEvenArray().reOrderArray(array);
        print(array);
    }
}
