package Week_09;
/*
题目：给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
你需要返回给定数组中的重要翻转对的数量。
示例 1:
输入: [1,3,2,3,1]
输出: 2
示例 2:
输入: [2,4,3,5,1]
输出: 3
注意:
给定数组的长度不会超过50000。
输入数组中的所有数字都在32位整数的表示范围内。
*/

import java.util.ArrayList;
import java.util.List;

public class reversePairs493 {
    public static void main (String[] args) {

    }
}

//
class Solution {
    public int reversePairs(int[] nums) {
        if(nums.length<2)return 0;
        int pairCount = 0;
        //升序列表，维护已遍历的数值
        List<Integer> ascendSortedValues = new ArrayList<> ();
        //从后往前遍历
        for(int index = nums.length - 1;index >= 0;index--){
            //针对遍历到的当前元素，查找列表中第一个满足num[i] > 2num[j]的元素位置
            final int num = nums[index];
            int halfValuePos = finalPositionOfValueInList
        }
    }
}