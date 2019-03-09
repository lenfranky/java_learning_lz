package learning_java.GrammarTest;

public class ArrayTry {
    public static void main(String[] args){
        int[][] triangleArray = {
            {1,2,3,4,5},
            {2,3,4,5},
            {3,4,5},
            {4,5},
            {5},
        };

        // System.out.println(triangleArray);

        System.out.println(triangleArray.length);
        System.out.println(triangleArray[3].length);
        System.out.println(triangleArray[3]);

        for (int row = 0; row < triangleArray.length; row++) {
            for (int column = 0; column < triangleArray[row].length; column++) {
                System.out.print(triangleArray[row][column] + "\t");
            }

            System.out.println();
        }

        System.out.println(Math.random());

        int [][] newMatrix = new int [5][];
        int [][][] newMatrix_2 = new int [5][5][5];
    }
}
