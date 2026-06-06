import java.util.Arrays;

class LeftRightSumDiffer{
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            answer[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        int nums[]={10,4,8,3};
        LeftRightSumDiffer obj=new LeftRightSumDiffer();
        int result[]=obj.leftRightDifference(nums);
        System.out.println(Arrays.toString(result));
    }
}