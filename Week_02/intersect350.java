package Week_02;

import java.util.Arrays;
import java.util.HashMap;

java.util.HashMap;/*
                  题目：给定两个数组，编写一个函数来计算它们的交集。
                  示例 1:
                  输入: nums1 = [1,2,2,1], nums2 = [2,2]
                  输出: [2,2]
                  示例 2:
                  输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
                  输出: [4,9]
                  说明：
                  输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
                  我们可以不考虑输出结果的顺序。
                  
                  */

public class intersect350 {
    private static void main(String args[]) {
        int[] s = { 1, 2, 3, 4 };
        int[] t = { 2, 3, 4 };
        solution1 a = new intersect(s, t);
        return a;
    }
}

class solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            // .getOrDefault(n,0):判断是否包含这个键，如没有，建立键并值加1，如有，值加1。
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            // 检查元素在m是否存在，若存在且计数为正：将元素拷贝到新数组，减少m中对应元素的计数
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}

class solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 1.检查nums1和2的长度，
        // 2.将nums1拷贝到Hashmap，重复元素计数
        // 3.遍历nums2是否存在相同的元素在m中
        // 4.存在的话，拷贝至nums1中，并使计数加1
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0 ;
        for(int n : nums2){
            int count = m.getOrDefault(n, 0);
            if(count > 0){
                nums1[k++] = n;
                m.put(n, count-1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}