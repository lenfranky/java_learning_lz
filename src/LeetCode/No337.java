package LeetCode;

import learning_java.GrammarTest.ConstructTree;

public class No337 {
    /*
    // 思路：用最基本的递归思路，AC，但是用时较多
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int res_with_self = root.val + (root.left == null ? 0 : (rob(root.left.left) + rob(root.left.right))) + (root.right == null ? 0: rob(root.right.left) + rob(root.right.right));
        int res_without_self = rob(root.left) + rob(root.right);
        return Math.max(res_with_self, res_without_self);
    }
    */

    /*
    // 思路：用一个map来储存每个节点往下的最大钱数，动态规划思想
    public int rob(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        return getNodeMaxValue(root, map);
    }

    public int getNodeMaxValue(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root))
            return map.get(root);
        else {
            int resWithSelf = root.val;
            if (root.left != null)
                resWithSelf += getNodeMaxValue(root.left.left, map) + getNodeMaxValue(root.left.right, map);
            if (root.right != null)
                resWithSelf += getNodeMaxValue(root.right.left, map) + getNodeMaxValue(root.right.right, map);

            int resWithoutSelf = 0;
            resWithoutSelf += getNodeMaxValue(root.left, map) + getNodeMaxValue(root.right, map);

            int res = Math.max(resWithSelf, resWithoutSelf);

            map.put(root, res);

            return res;
        }
    }
    */

    // 在这里定义一种新的数据结构来存储该节点的使用该节点与不使用该节点时的最大钱数
    public class NodeMoney{
        public int moneyWithThisNode = 0;
        public int moneyWithoutThisNode = 0;
        public NodeMoney(){ }
    }


    public int rob(TreeNode root) {
        if (root == null) return 0;
        NodeMoney rootMoney = getNodeMoney(root);
        return Math.max(rootMoney.moneyWithoutThisNode, rootMoney.moneyWithThisNode);
    }

    public NodeMoney getNodeMoney(TreeNode root) {
        NodeMoney currNodeMoney = new NodeMoney();
        if (root == null) return currNodeMoney;

        NodeMoney leftNodeMoney = getNodeMoney(root.left);
        NodeMoney rightNodeMoney = getNodeMoney(root.right);

        currNodeMoney.moneyWithThisNode = root.val + leftNodeMoney.moneyWithoutThisNode + rightNodeMoney.moneyWithoutThisNode;
        currNodeMoney.moneyWithoutThisNode = Math.max(leftNodeMoney.moneyWithThisNode, leftNodeMoney.moneyWithoutThisNode) + Math.max(rightNodeMoney.moneyWithThisNode, rightNodeMoney.moneyWithoutThisNode);

        return currNodeMoney;
    }

    // 更进一步的，可以将NodeMoney结构替换为一个数组，可以进一步加快程序的速度

    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[] {3,4,5,1,3,null,1});
        System.out.println(new No337().rob(root));
    }
}
