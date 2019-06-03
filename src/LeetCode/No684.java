package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static Tools.IOTools.print;

public class No684 {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges.length == 0) return null;
        // 若只多出一条边，则边的条数与点的个数相同
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i ++) parent[i] = i;

        int a, b, root_a, root_b;
        for (int[] edge: edges) {
            a = edge[0];
            b = edge[1];
            root_a = findRoot(parent, a);
            root_b = findRoot(parent, b);
            if (root_a == root_b) return edge;
            else parent[root_b] = root_a;
        }
        return null;
    }

    public int findRoot(int[] parent, int vertex) {
        while (vertex != parent[vertex])
            vertex = parent[vertex];
        return vertex;
    }

    public static void main(String[] args) {
        int[][] edges = ArrayOperation.getIntArray("[[1,2], [1,3], [2,3]]");
        print(edges);
        print(new No684().findRedundantConnection(edges));
    }
}
