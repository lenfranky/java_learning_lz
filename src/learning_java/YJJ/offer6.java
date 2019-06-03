package learning_java.YJJ;


public class offer6 {
    class TreeNode{
        int val;
        TreeNode lefttree;
        TreeNode righttree;
        TreeNode(int x){val = x;}
    }
    public TreeNode reConstructBinary(int []prearray,int []inarray){
        if (prearray.length==0 || inarray.length==0) return null;
        else
            return reConstructBinarytree(prearray,0, inarray,0,inarray.length-1);
    }
    public TreeNode reConstructBinarytree(int [] pre,int pre_start,int [] in,int in_start,int in_end){
        if(in_start > in_end) return null;
        int rootval = pre[pre_start];
        TreeNode root = new TreeNode(rootval);
        int rootindex = 0;
        while(in[rootindex]!=pre[pre_start] && rootindex<=in.length)
            rootindex++;
        int left_num = rootindex-in_start;
        int right_num = in_end-rootindex;
            // always here
        root.lefttree = reConstructBinarytree(pre,pre_start+1, in, in_start,in_start+left_num-1);//根据左子树和右子树的前序和中序分别构建左子树和右子树
        root.righttree = reConstructBinarytree(pre,pre_start+left_num+1, in,in_start+left_num+1,in_end);
        return root;
    }
    //打印该子树的前序遍历结果
    public  void printpreOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            printpreOrder(root.lefttree);
            printpreOrder(root.righttree);
        }
    }

    public static void main(String args[]){
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in = {4,7,2,1,5,3,8,6};
        offer6 func = new offer6();
        TreeNode result = func.reConstructBinary(pre,in);
        func.printpreOrder(result);
    }
}
