package Week_03;
/*
题目：给定一个大小为n的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 [n/2] 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
示例 1:
输入: [3,2,3]
输出: 3
示例 2:
输入: [2,2,1,1,1,2,2]
输出: 2
*/

import java.util.HashMap;
import java.util.Map;

public class majorityElement169 {
    public static void main (String[] args) {

    }
}

//思路：遍历整个数组，对记录每个数值出现的次数(利用HashMap，其中key为数值，value为出现次数)；
//接着遍历HashMap中的每个Entry，寻找value值> nums.length / 2的key即可。
//时间复杂度：O(n)
//空间复杂度：O(n)

class Solution {
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer> ();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.put(num, counts.get(num)+1);
            }
        }
        return counts;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }


/*
候选人(cand_num)初始化为nums[0]，票数count初始化为1。
当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
当票数count为0时，更换候选人，并将票数count重置为1。
遍历完数组后，cand_num即为最终答案。
投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人。
 */
//时间复杂度：O(n)
//空间复杂度：O(1)
class Solution2020050702 {
    public int majorityElement(int[] nums) {
        int count_num = nums[0],count = 1 ;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == count_num){
                count++;
            }else if(--count == 0){
                count_num = nums[i];
                count = 1;
            }
        }
        return count_num;
    }
}