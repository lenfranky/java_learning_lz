package LeetCode;

import java.util.Arrays;

public class No621 {
    /*
    思路：
    先找到出现频率最高的字母，假设共有m个最高频词，则需要(freq - 1)个完整的长度至少为(n + 1)的块，
    之后为1个长度为m的不完整的块
    针对最高频词有两种情况：
    1）m <= n，也是最容易想到的情况，在这种情况下，前(freq - 1)确实是不满的，而其它频率较低的字母，可以自由的放入这(freq - 1)个块中
       在这种情况下，如果没有将空填满，则所需的长度为(freq - 1) * (n - 1) + m，而如果将所有的空填满了，甚至还有多处的字母，
       这时，可以先将所有的空填满，然后将多出的字母放入前(freq - 1)个块中即可，因其频率低于freq，因此可以保证在不发生冲突的前提下
       放入这些块中，且并不会影响之前所放入的字母
    2）m > n，这时，前(freq - 1)个块仅仅放最高频词时也是可以填满的，不会留空，因此，在这种情况下，所需要的长度即为给出的字符数组的长度
    综上，可以看出，只有在1）中的第一种情况下是需要(freq - 1) * (n - 1) + m个时间间隔，且在这种情况下，这个数值是肯定大于tasks的长度的
    （因为此时的工作安排中还有空闲存在），而在其它情况下，所需的时间间隔都是tasks的长度的，而在这些情况下，结果都是大于
    (freq - 1) * (n + 1) + m的，因为，这两种情况下，不光把由最高频词所搭建出的框架填满了，还有着多余的字母，因此，结果可以取
    max(tasks.length, (freq - 1) * (n - 1) + m)
     */

    /*
    还有一点可以借鉴的是，在本题中，用一个数组来进行字符的频率的统计，比起用Map要更加简洁，所需空间也大大减少
    之后，通过一个Arrays.sort()就可以找到最大的字符，且可以方便地找出有几个最高频词。
     */
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        for (char task: tasks) {
            freqs[task - 'A'] ++;
        }
        Arrays.sort(freqs);
        int freq = freqs[25], m = 1;
        // 这里要注意m的取值
        while(m < 26 && freqs[25 - m] == freq) m ++;
        return Math.max(tasks.length, (freq - 1) * (n + 1) + m);
    }

    // 时间效率更高
    public int leastIntervalFast(char[] tasks, int n) {
        int num = 0, maxFreq = 0;
        int[] freq = new int [26];
        // 这种写法不需要两次遍历
        for (char t : tasks) freq[t-'A']++;
        for (int f : freq) {
            if (f == maxFreq) num++;
            else if (f > maxFreq) {
                maxFreq = f;
                num = 1;
            }
        }
        return Math.max(tasks.length, (maxFreq-1)*(n+1)+num);
    }

    public static void main(String[] args) {
        System.out.println(new No621().leastInterval("AAABBB".toCharArray(), 2));
    }
}
