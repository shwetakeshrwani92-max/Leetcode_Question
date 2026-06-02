public class TimeAndLand {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
     int ans = Integer.MAX_VALUE; 
     for(int i=0;i<landStartTime.length;i++){
        for(int j=0;j<waterStartTime.length;j++){
         int landend=landStartTime[i]+landDuration[i];   
         int finish1=Math.max(landend,waterStartTime[j])+waterDuration[j];
         ans=Math.min(ans,finish1);
         int waterend=waterStartTime[j]+waterDuration[j];
         int finish2=Math.max(waterend,landStartTime[i])+landDuration[i];
         ans=Math.min(ans,finish2);
        }
     } 
     return ans; 
    }
 public static void main(String[] args) {
        int[] landStartTime = {2, 8};
        int[] landDuration = {4, 1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};
        TimeAndLand obj = new TimeAndLand();
        int ans = obj.earliestFinishTime(
                landStartTime,
                landDuration,
                waterStartTime,
                waterDuration);
        System.out.println(ans);
    }    
}    

