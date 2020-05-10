package Week_01;


//暴力方法1，双指针，指针
// TODO时间复杂度：O(n*k)
// 空间复杂度：O(1)
public class rotateNums {
    public void solution(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}

// 将数字放到新的数组中需要一遍遍历，另一边把原来的数组的元素拷贝回原数组。
// 空间复杂度：O(n)
// 时间复杂度：O(n)，
class solution2 {
    public void rotate2(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}

class solution3 {
    public void solution(int[] nums, int k) {
        k = k % nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, k, nums.length - 1);
        rotate(nums, 0, k - 1);
    }

    public void rotate(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

class Solution {
    public void solution(int[] nums, int k) {
        k = k % nums.length;
        nums = rotate(nums, 0, nums.length);
        nums = rotate(nums, k + 1, nums.length);
        nums = rotate(nums, 0, k);
    }

    public int[] rotate(int[] temps, int a,int b) {
        for (int i = 0;i < ((b-a)/2);i++) {
            int temp = temps[a+i];
            temps[a+i] = temps[b-i] ;
            temps[b-i] = temp ;
        }
        return temps;
    }
}
