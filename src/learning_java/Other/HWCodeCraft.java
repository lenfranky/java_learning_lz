package learning_java.Other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Tools.IOTools.print;

public class HWCodeCraft {
    // 方法一：构建邻接矩阵来反映我们的有向图，再根据邻接矩阵进行后续的处理
    public boolean hasNoCycleOld(int numCars, int[][] carVecs) {
        if (carVecs.length == 0) return true;
        boolean[][] adjacencyTable = new boolean[numCars][numCars];
        for (int[] carVec: carVecs) {
            adjacencyTable[carVec[0]][carVec[1]] = true;
        }

        return !hasRingInDirectedGraph(adjacencyTable);
    }

    public static boolean hasRingInDirectedGraph(boolean[][] adjacencyTable) {
        List<Integer> deletedV = new ArrayList<>();
        int i = 0, j = 0;
        while(deletedV.size() < adjacencyTable.length) {
            print(adjacencyTable);
            boolean flagFindRootV = false;
            for (j = 0; j < adjacencyTable.length; j++) {
                if (deletedV.contains(j)) continue;
                for (i = 0; i < adjacencyTable.length; i++) {
                    if (adjacencyTable[i][j]) break;
                }
                if (i == adjacencyTable.length) {
                    flagFindRootV = true;
                    break;
                }
            }
            if (flagFindRootV) {
                // 存在无前驱节点的顶点，则将该顶点删除
                // 因为，一个没有前驱节点的顶点一定不属于任何环
                // 之后，将从该点出发的边删除，方法为，若第j列全为0，则找到顶点j，再将第j行全部清零
                print(j);
                for (i = 0; i < adjacencyTable.length; i ++) {
                    adjacencyTable[j][i] = false;
                }
                deletedV.add(j);
            }
            else if (deletedV.size() < adjacencyTable.length)
                return true;
        }
        return false;
    }

    // 方法二：不构建邻接矩阵，而是用两个列表（数组）来记录点的入度与边等信息，这样处理时更灵活，速度也更快
    public boolean hasNoCycle(int numCars, int[][] carVecs) {
        if (carVecs.length == 0) return true;

        int[] inDegrees = new int[numCars];
        List<Integer>[] edgeArray = new List[numCars];
        Queue<Integer> zeroInDegreeVertexes = new LinkedList<>();
        int zeroInDegreeVertexesCount = 0;

        // 遍历所有边，得到边的列表
        for (int i = 0; i < numCars; i ++) {
            edgeArray[i] = new ArrayList<Integer>();
        }

        // 遍历所有边，得到每个点的入度
        for (int[] carVec: carVecs) {
            edgeArray[carVec[0]].add(carVec[1]);
            inDegrees[carVec[1]] ++;
        }

        // 将所有入度为0的点放入队列中，并计数
        for (int i = 0; i < numCars; i ++) {
            if (inDegrees[i] == 0) {
                zeroInDegreeVertexes.offer(i);
                zeroInDegreeVertexesCount ++;
            }
        }

        // 不断删边，并在每次删边后计算变化的入度，若入度变为0，则入队列（入队列的同时计数）
        while (!zeroInDegreeVertexes.isEmpty()) {
            int currVertex = zeroInDegreeVertexes.poll();
            for (int vertex: edgeArray[currVertex]) {
                inDegrees[vertex] --;
                if (inDegrees[vertex] == 0) {
                    zeroInDegreeVertexes.offer(vertex);
                    zeroInDegreeVertexesCount++;
                }
            }
        }

        // 若删去了所有的边，则没有环，并返回true
        // 若没有删去所有的边，则存在环，并返回false
        return zeroInDegreeVertexesCount == numCars;
    }

    // Test
    public static void main(String[] args) {
    }
}
