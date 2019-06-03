package LeetCode;

import static Tools.IOTools.print;

public class No685 {
    public int[] findRedundantDirectedConnectionOld(int[][] edges) {
        if (edges == null || edges.length == 0) return null;

        int[] root = new int[edges.length + 1];
        for (int i = 0; i < root.length; i ++) root[i] = i;

        int root_a, root_b;
        for (int[] edge: edges) {
            if (root[edge[1]] != edge[1]) return edge;
            root_a = findRoot(root, edge[0]);
            root_b = findRoot(root, edge[1]);
            if (root_a == root_b) return edge;
            root[root_b] = root_a;
        }
        return null;
    }

    public int findRoot(int[] root, int vertex) {
        while (vertex != root[vertex])
            vertex = root[vertex];
        return vertex;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0) return null;

        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i ++) parent[i] = i;

        int u, v;
        Integer target = null;
        int[] candidate = new int[2];
        for (int[] edge: edges) {
            u = edge[0];
            v = edge[1];
            if (parent[v] != v) {
                target = v;
                candidate[0] = u;
                candidate[1] = edge[0];
            }
            else
                parent[v] = u;
        }
        if (target != null) {
            int temp = parent[target];
            while (temp != parent[temp]) {
                temp = parent[temp];
                if (temp == target) return new int[]{parent[target], target};
            }
            return new int[]{candidate[1], target};
        }
        else {
            int[] root = new int[edges.length + 1];
            for (int i = 0; i < root.length; i ++) root[i] = i;
            int root_a, root_b;
            for (int[] edge: edges) {
                if (root[edge[1]] != edge[1]) return edge;
                root_a = findRoot(root, edge[0]);
                root_b = findRoot(root, edge[1]);
                if (root_a == root_b) return edge;
                root[root_b] = root_a;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        int[][] edges = ArrayOperation.getIntArray("[[1,2], [2,3], [3,4], [4,1], [1,5]]");
        print(edges);
        print(new No685().findRedundantDirectedConnection(edges));
    }
}
