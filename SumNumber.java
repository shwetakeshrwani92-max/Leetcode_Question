public class SumNumber {
    public int[] twoSum(int[] num, int target) {  
        int add=0;
        for(int i=0;i<num.length;i++){
            for(int j=i+1;j<num.length;j++){
              if(num[i]+num[j]==target){
                return new int[]{i,j};
              }  
            }
        }
        return new int[]{}; 
    }
    public static void main(String [] args){
        SumNumber obj=new SumNumber();
        int num[]={2,7,11,15};
        int target=9;
        int result[]=obj.twoSum(num,target);
        System.out.println(result[0]+" "+result[1]);
    }  
}    
    

