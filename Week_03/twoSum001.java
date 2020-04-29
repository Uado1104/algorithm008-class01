package Week_03;
/*
题目：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

*/

import java.util.HashMap;
import java.util.Map;

public class twoSum001 {
    public static void main(String[] args) {

    }
}

//利用哈希容器 map 降低时间复杂度
//遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
//如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
//如果最终都没有结果则抛出异常
//时间复杂度：O(n)

class solution1{
    public int[] twoSum(int[] nums,int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i< nums.length;i++){
            if(map.containsKey(target - nums[i])){
                return  new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}