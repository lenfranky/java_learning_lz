package learning_java.GrammarTest;

public class trap_water {
    int TrapWater(int [] A){

        int sum=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==0) continue;
            int index_1=i+1;
            int result_temp = 0;
            while(index_1<A.length && A[index_1]<A[i]) index_1+=1;//每次都找到当前位置后面的一个点，且该点的高度高于i点的
            if(index_1<A.length) {

                result_temp = (index_1 - i - 1) * A[i];//两点之间的容量

                for (int j = i + 1; j < index_1; j++)//两点之间的容量减去两点之间实心的方块数
                    result_temp -= A[j];

                sum += result_temp;//加上部分容量构成总容量
                i=index_1;//这里有问题
                System.out.println(i+"    "+result_temp);
            }

        }
    return sum;
    }
    public static void main(String args[]){
        int [] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        trap_water trap = new trap_water();
        int result = trap.TrapWater(A);
        System.out.print(result);
    }
}
