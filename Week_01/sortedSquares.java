package Week_01;

public class sortedSquares {
    public int[] solution(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] newNums = new int[nums.length];
        for(int k  = nums.length-1;k>0;k--){
            if (Math.abs(nums[i]) <= Math.abs(nums[j])){
                newNums[k] = nums[i]*nums[i];
                i++;
            }
            else{
                newNums[k] = nums[j] *nums[j];
                j--;
            }
        }
        return newNums;
    }
}