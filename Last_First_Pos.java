class Last_First_Pos{
    public int[] searchRange(int[] nums, int target) {
        int start=0 , end=nums.length-1 ;
        int first = -1, last = -1;
        while(start<=end){
        int mid=start+(end-start)/2;
        if(nums[mid]==target){
            first=mid;
            end=mid-1;
        }
        else if(nums[mid]<target){
            start=mid+1;
        }
        else{
            end=mid-1;
        }
    } 
        start = 0;
        end = nums.length - 1;
        while(start<=end){
        int mid=start+(end-start)/2;
        if(nums[mid]==target){
            last=mid;
            start=mid+1;
        }
        else if(nums[mid]<target){
            start=mid+1;
        }
        else{
            end=mid-1;
        }
    }  
    return new int[]{first,last}; 
    }
    public static void main(String args[]){
    int nums[]={5,7,7,8,8,10};
    int target=8;
    Last_First_Pos obj=new Last_First_Pos();
    int result[]=obj.searchRange(nums , target);
    System.out.println(result[0] + " " + result[1]);
    }
}