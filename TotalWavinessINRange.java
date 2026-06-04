import java.util.Scanner;

public class TotalWavinessINRange {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for (int num = num1; num <= num2; num++) {
            String s = String.valueOf(num);
            for (int i = 1; i < s.length() - 1; i++) {
                int left = s.charAt(i - 1) - '0';
                int mid = s.charAt(i) - '0';
                int right = s.charAt(i + 1) - '0';
                if ((mid > left && mid > right) ||
                    (mid < left && mid < right)) {
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num1: ");
        int num1 = sc.nextInt();
        System.out.print("Enter num2: ");
        int num2 = sc.nextInt();
        TotalWavinessINRange obj=new TotalWavinessINRange();
        int result = obj.totalWaviness(num1, num2);
        System.out.println("Total Waviness = " + result);
        sc.close();
    }
}    

