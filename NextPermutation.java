class NextPermutation {
    public void Permutation(int nums[]) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int start = i + 1;
        int end = n - 1;

        while (start < end) {

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
    public static void main(String[] args ){
    int nums[]={1,2,3};
    NextPermutation obj=new NextPermutation();
    obj.Permutation(nums);
    for(int i=0;i<nums.length;i++){
        System.out.print(nums[i]+" ");
    }
    }
}