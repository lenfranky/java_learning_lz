package learning_java.GrammarTest;

import java.util.Arrays;
import java.util.Comparator;

public class SortByCondition {
    public static void main1(String[] args) {
        Character[] a= {'j','c','e','o'};
        Integer[] b = {1, 2, 3, 4, 5};
        print(b);
        Arrays.sort(a);
        print(a);
    }

    public static void main(String[] args) {
        Character[] a= {'j','c','e','o'};
        Arrays.sort(a, new Comparator<Character>() {
            public int compare(Character n1,Character n2)
            {
                if(n1>n2)
                {
                    return -1;}
                else if(n1<n2)
                {return 1;}
                else return 0;
            }
        });
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }

    }

    public static <E> void print (E[] array) {
        for (E element: array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
