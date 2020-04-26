package Week_02;

import java.util.HashMap;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
/*
题目：给你个整数数组 arr，其中每个元素都 不相同。
请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
示例 1：
输入：arr = [4,2,1,3]
输出：[[1,2],[2,3],[3,4]]
示例 2：
输入：arr = [1,3,6,10,15]
输出：[[1,3]]
示例 3：
输入：arr = [3,8,-10,23,19,-4,-14,27]
输出：[[-14,-10],[19,23],[23,27]]
提示：
2 <= arr.length <= 10^5
-10^6 <= arr[i] <= 10^6


*/
import java.util.List;

public class minimumAbsDifference2020 {
    private static void main(String args[]) {

    }
}


// 先将数组排序，因为arr.length >= 2，所以可以先初始化最小绝对差为arr[1] - arr[0],然后从索引1开始遍历数组，当这个索引的值和前一个索引的值得绝对值差==min时，添加到res里面，当<min时，清空res，因为之前添加的已经不算数了，更新min的值并且把当前索引的值和前一个索引的值添加到res里面。
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        //merge_sort(arr,0,arr.length,new int[arr.length]);//29ms
        //quicksort(arr,0,arr.length - 1);//24ms
        Arrays.sort(arr);//25ms
        //shellsort(arr);//39ms
        int min = arr[1] - arr[0];
        for(int i = 1;i < arr.length;i++){
            if(arr[i] - arr[i - 1] == min)
                res.add(Arrays.asList(arr[i - 1],arr[i]));
            else if(arr[i] - arr[i - 1] < min){
                res.clear();
                res.add(Arrays.asList(arr[i - 1],arr[i]));
                min = arr[i] - arr[i - 1];
            }
        }
        
        return res;
    }

}

