public class BinarySer_Idx_Val {
    public int search(int[] nums, int target) {
           int start=0, end=nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[start]<=nums[mid]){
                if(target>=nums[start]&& target<nums[mid]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                if(target>nums[mid]&& target<=nums[end]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return -1; 
    }   
public static void main(String args[]){
    int nums[]={4,5,6,7,0,1,2};
    int target=3;
    BinarySer_Idx_Val obj=new BinarySer_Idx_Val();
    int result=obj.search(nums,target);
    System.out.println("index for the value: "+result);
}
}

