package JianZhiOffer;

import static JianZhiOffer.IOTools.print;

public class VerifySquenceBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return helper(sequence, 0, sequence.length - 1);
    }

    public boolean helper(int[] sequence, int startIndex, int endIndex) {
        if (endIndex - startIndex <= 2) return true;
        int rootValue = sequence[endIndex];
        int leftEndIndex = startIndex;
        while (leftEndIndex < endIndex) {
            if (sequence[leftEndIndex] > rootValue)
                break;
            leftEndIndex ++;
        }
        for (int i = leftEndIndex + 1; i < endIndex; i ++) {
            if (sequence[i] < rootValue) return false;
        }
        return helper(sequence, startIndex, leftEndIndex - 1) && helper(sequence, leftEndIndex, endIndex);
    }

    public static void main(String[] args) {
        VerifySquenceBST solution = new VerifySquenceBST();
        // int[] sequence = {5, 7, 6, 9, 11, 10, 8};
        int[] sequence = {2, 3, 5, 1, 4};
        print(solution.VerifySquenceOfBST(sequence));
    }
}
