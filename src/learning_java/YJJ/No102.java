package learning_java.YJJ;

import java.util.*;
public class No102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).push(root);
        while(!queue.isEmpty()){
            List<Integer>temp = new ArrayList<>();
            int size = queue.size();
            while(size>0){
                TreeNode node = queue.peek();
                ((LinkedList<TreeNode>) queue).pop();
                System.out.println(node.val);
                temp.add(node.val);
                if(node.left!=null)
                    ((LinkedList<TreeNode>) queue).push(node.left);

                if(node.right!=null)
                    ((LinkedList<TreeNode>) queue).push(node.right);
                size-=1;
            }
            result.add(temp);
        }
        System.out.println(result);
        return result;
    }

    public static void main(String args[]){
        Integer nums [] = {3,9,20,null,null,15,7};
        TreeNode root = TreeOperation.constructTree(nums);
        TreeOperation.show(root);
        No102 func = new No102();
        func.levelOrder(root);
    }
}