package Week_03;
/*
题目：
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

import java.util.*;

public class threeSum015 {
    public static void main(String[] args) {

    }
}

//利用哈希容器 map 降低时间复杂度
//遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
//如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
//如果最终都没有结果则抛出异常
//时间复杂度：O(n^2)

class solution1{
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i< nums.length;i++ ){
            if(nums[i] > 0)break;
            if(i > 0 && nums[i] == nums[i-1])continue;
            int m = i+1,n = nums.length - 1;
            while (m<n){
                int sum = nums[i] +nums[m] + nums[n];
                if(sum < 0){
                    while ((m<n && nums[m] == nums[++m] ));
                }else if(sum > 0 ){
                    while (m<n && nums[n] == nums[--n]);
                }else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[m],nums[n])));
                    while ((m<n && nums[m] == nums[++m] ));
                    while (m<n && nums[n] == nums[--n]);
                }
            }
        }
        return  res;
    }
}


/*
时间复杂度：O\left(n^{2}\right)O(n^2)，数组排序 O(N \log N)O(NlogN)，
遍历数组 O\left(n\right)O(n)，双指针遍历 O\left(n\right)O(n)，
总体 O(N\log N)+O\left(n\right)*O\left(n\right)O(NlogN)+O(n)∗O(n)，O\left(n^{2}\right)O(n^2)
空间复杂度：O(1)

*/
class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        //先排除特例
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<> ();
        if (len < 3)
            return null;
        //先将数组排序
        Arrays.sort (nums);
        List<List<Integer>> res = new ArrayList<> ();
        //遍历数组，当遍历到大于零，停止遍历
        int left , right , sum ;
        for(int i = 0 ; i < len - 2 ;i++){
            //遍历过程中，左右双指针，
            //当三数和小于零，移动左指针，当三数和大于零，移动右指针，等于零，返回数组
            if(nums[i] > 0)
            break;
            //当数组中i 和i-1的数相等，
            //continue：不再执行循环体中continue语句之后的代码，直接进行下一次循环
            if(i> 0 && nums[i] == nums[i-1])continue;
            left = i + 1; right = len - 1;
            while(left < right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum < 0){
                    //while空循环体，执行whlie中当function语句直到其为false，即执行到nums[]的值为不同时
                    while(left < right && nums[left] == nums [++left]);
                }else if (sum > 0){
                    while (left < right && nums[right] == nums [--right]);
                }else{
                    res.add (new ArrayList<> (Arrays.asList (nums[i],nums[left],nums[right])));
                    while(left < right && nums[left] == nums [++left]);
                    while (left < right && nums[right] == nums [--right]);
                }
            }
        }
        return res;
    }
}