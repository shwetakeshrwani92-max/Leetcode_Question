import java.util.*;
public class PartionArrayAccToPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                ans[idx] = nums[i];
                idx++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == pivot) {
                ans[idx] = nums[i];
                idx++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > pivot) {
                ans[idx] = nums[i];
                idx++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        PartionArrayAccToPivot obj=new PartionArrayAccToPivot();
        int nums[]={9,12,5,10,14,3,10};
        int pivot=10;
        int result[]=obj.pivotArray(nums,pivot);
        System.out.println(Arrays.toString(result));
    }
}     

