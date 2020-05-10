package Week_01;
/*
题目：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
示例:
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:
必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
*/

public class moveZeroes293 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int next = 0;
        if (len < 2) {
            return;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[next] = nums[i];
                next++;
            }
        }

        for (int i = next; i < len; i++) {
            nums[i] = 0;
        }
    }
}

class solution {
    public void moveZeroes(int[] nums) {
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[next] = nums[i];
                if (i != next) {
                    nums[i] = 0;

                }
                next++;
            }
        }
    }
}
//思路：遍历数组元素，判断该位置数是否非零，真的时候将该数移到最新一位。
//时间复杂度O(n)，空间复杂度O(1)
class solution1 {
    public void moveZeroes(int[] nums){
        int len = nums.length;
        int count = 0 ;
        for (int i = 0;i<len;i++){
            if (!(nums[i] == 0)){
                nums[count] = nums[i];
                count++;
            }
        }
        for(int i = count;i<len;i--){
            nums[i] = 0;
        }
    }
}