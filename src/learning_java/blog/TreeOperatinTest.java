package learning_java.blog;

public class TreeOperatinTest {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,1});
        TreeOperation.show(root);
    }
}
