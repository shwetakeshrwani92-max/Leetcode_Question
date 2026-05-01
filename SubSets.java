
 import java.util.*;
public class SubSets{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(nums, 0, new ArrayList<>(), result);
        return result;
    }
    public void generate(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);              // include
            generate(nums, i + 1, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }
    public static void main(String args[]) {
        int[] nums = {1, 2, 3};

        SubSets obj = new SubSets();
        List<List<Integer>> ans = obj.subsets(nums);

        System.out.println(ans);
    }
}   

