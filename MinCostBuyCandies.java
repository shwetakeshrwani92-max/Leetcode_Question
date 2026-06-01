import java.util.Arrays;
public class MinCostBuyCandies {
    public int minimumCost(int[] cost) {
    Arrays.sort(cost);
    int ans=0;
    int count=0;
    for(int i=cost.length-1;i>=0;i--){
        count++;
        if(count==3){
            count=0;
            continue;
        }
        ans += cost[i];
    }    
    return ans;
    }
    public static void main(String[] args) {
        int cast[]={6,5,7,9,2,2};
        MinCostBuyCandies obj=new MinCostBuyCandies();
        System.out.println(obj.minimumCost(cast));
    }
}    

