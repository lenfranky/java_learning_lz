package learning_java.GrammarTest;

import java.util.ArrayList;
import java.util.List;

public class SortTwoSrotedList {
    public static void main(String[] args) {
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();

        listA.add(1);
        listA.add(3);
        listA.add(5);
        listB.add(2);
        listB.add(4);

        ArrayListOperation.print((ArrayList)combineSortedLists(listA, listB));
    }

    private static List<Integer> combineSortedLists(List<Integer>aList,List<Integer>bList){
        if(aList == null || aList.isEmpty()){
            return bList;
        }
        if(bList == null || bList.isEmpty()){
            return aList;
        }

        int cSize = aList.size()+bList.size();
        List<Integer> cList = new ArrayList<Integer>(cSize);
        int i = 0;
        int j = 0;
        for(int t = 0;t<cSize;t++){
            if(i >= aList.size()){
                cList.add(bList.get(j++));
            } else if(j >= bList.size()){
                cList.add(aList.get(i++));
            } else {
                if (aList.get(i) <= bList.get(j)) {
                    cList.add(aList.get(i++));
                } else {
                    cList.add(bList.get(j++));
                }
            }
            // Log.e("algo","t:"+t+";cList[t]:"+cList.get(t));
        }
        return cList;
    }
}
