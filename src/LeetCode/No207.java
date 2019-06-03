package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Tools.IOTools.print;

public class No207 {
    public boolean canFinishOld(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;
        boolean[][] adjacencyTable = new boolean[numCourses][numCourses];
        for (int[] nums: prerequisites) {
            adjacencyTable[nums[0]][nums[1]] = true;
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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;

        int[] inDegrees = new int[numCourses];
        List<Integer>[] edgeArray = new List[numCourses];
        Queue<Integer> zeroInDegreeVertexes = new LinkedList<>();
        int zeroInDegreeVertexesCount = 0;

        for (int i = 0; i < numCourses; i ++) {
            edgeArray[i] = new ArrayList<Integer>();
        }

        for (int[] prerequisite: prerequisites) {
            edgeArray[prerequisite[0]].add(prerequisite[1]);
            inDegrees[prerequisite[1]] ++;
        }

        for (int i = 0; i < numCourses; i ++) {
            if (inDegrees[i] == 0) {
                zeroInDegreeVertexes.offer(i);
                zeroInDegreeVertexesCount ++;
            }
        }

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

        return zeroInDegreeVertexesCount == numCourses;
    }

    public static void main(String[] args) {
        print(new No207().canFinish(2, new int[][] {{0,1}}));
    }
}
