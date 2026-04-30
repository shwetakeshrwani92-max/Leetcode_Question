public class WaterFill {
    public int maxArea(int[] height) {
    int left=0;
    int right=height.length-1;
    int maxarea=0;
    while(left<right){
        int width=right-left;
        int minheight=Math.min(height[left],height[right]);
        int area=width*minheight;
        maxarea=Math.max(maxarea,area);
        if(height[left]<height[right]){
            left++;
        }else{
            right--;
        }
    }
    return maxarea;     
    }
    public static void main(String args[]){
        WaterFill obj=new WaterFill();
        int height[]={1,8,6,2,5,4,8,3,7};
        System.out.println(obj.maxArea(height));
    }
}    

