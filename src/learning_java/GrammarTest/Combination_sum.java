package learning_java.GrammarTest;

import java.util.ArrayList;

public class Combination_sum {
        private ArrayList<ArrayList<Integer>> all_result = new ArrayList<ArrayList<Integer>>();//二维数组
        public  ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {

            ArrayList<Integer> single_result = new ArrayList<Integer>();
            find(candidates,single_result,0,target);
            all_result.add(single_result);
            System.out.print(all_result.get(0));
            return all_result;


    }
        public  void find(int [] candidates,ArrayList<Integer> single_result, int start,int target) {
            if (target > 0) {
                for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                    single_result.add(candidates[i]);
                    find(candidates, single_result, i, target - candidates[i]);
                    single_result.remove((Integer) candidates[i]);
                }
            }
            else if (target == 0) {
                System.out.println("single_result:\t" + single_result);
                ArrayList<Integer> single_result_new = new ArrayList<Integer>(single_result);
                all_result.add(single_result);//这里有问题，添加不进去
                System.out.println("all_result:\t" + all_result + "\n");
            }
        }
        public static void main(String args[]){
                int [] candidate = {1,2,3,4,5,6,7};
            Combination_sum big = new Combination_sum();
            big.combinationSum(candidate,7);
        }

}
