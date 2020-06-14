package Week_08;
/*
题目：输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
示例 1：
输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：
输入：arr = [0,1,2,1], k = 1
输出：[0]
限制：
0 <= k <= arr.length <= 10000
0 <= arr[i] <= 10000
*/

import java.util.PriorityQueue;
import java.util.Queue;

public class getLeastNumbers040 {
    public static void main (String[] args) {

    }
}

//恒有 n & (n - 1) == 0，这是因为：
//nn 二进制最高位为 11，其余所有位为 00；
//n - 1n−1 二进制最高位为 00，其余所有位为 11；
//一定满足 n > 0。
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        //
        Queue<Integer> pq = new PriorityQueue<> ((v1, v2) -> v2 - v1);
        for (int num: arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        //
        int[] res = new int[pq.size()];
        int idx = 0;
        for(int num: pq) {
            res[idx++] = num;
        }
    }
}
//数据范围有限时直接排序。
//遍历原数组，统计各个位数的个数，频次计入counter数组
//从小到大遍历counter数组,输出至res数组，直到k个数。
class Solution20200613 {
    public int[] getLeastNumbers(int[] arr, int k) {
       if(k==0 || arr.length == 0)return new int[0];
       int[] counter = new int[10001];
       for(int num : arr){
           counter[num] ++;
       }
       int[] res = new int[k];
       int index = 0;
       for(int num = 0;num<counter.length;num++){
           while (counter[num]-- > 0 && index < k){
               res[index++] = num;
           }
           if(index == k)break;;
       }
       return res;
    }
}