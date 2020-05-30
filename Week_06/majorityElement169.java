package Week_06;
/*
题目：给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
示例 1:
输入: [3,2,3]
输出: 3
示例 2:
输入: [2,2,1,1,1,2,2]
输出: 2
*/


public class majorityElement169 {
    public static void main (String[] args) {

    }
}

//摩尔投票法：多数元素个数大于n/2，所以当每个元素和其它元素两两抵消时，抵消到最后还剩余一个。
//枚举每个元素
class Solution2020052201 {
    public int majorityElement(int[] nums) {
        int cand_num = nums[0],count = 1;
        for(int i = 1; i < nums.length;i++){
            if (nums[i] == cand_num ){
                count++;
            }else if(--count == 0){
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }
 }