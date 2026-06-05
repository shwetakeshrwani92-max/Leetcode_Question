import java.util.*;
public class TotalWavinessINRangeII {
    static class Pair {
        long cnt;  
        long sum;   
        Pair(long cnt, long sum) {
            this.cnt = cnt;
            this.sum = sum;
        }
    }
    private String digits;
    private Pair[][][][] memo;
    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }
    private long solve(long n) {
        if (n <= 0) return 0;
        digits = String.valueOf(n);
        int len = digits.length();
        memo = new Pair[len][11][11][2];
        return dfs(0, 10, 10, 0, true).sum;
    }
    private Pair dfs(int pos, int prev2, int prev1,
                     int started, boolean tight) {
        if (pos == digits.length()) {
            return new Pair(1, 0);
        }
        if (!tight && memo[pos][prev2][prev1][started] != null) {
            return memo[pos][prev2][prev1][started];
        }
        int limit = tight ? digits.charAt(pos) - '0' : 9;
        long totalCnt = 0;
        long totalSum = 0;
        for (int d = 0; d <= limit; d++) {
            boolean ntight = tight && (d == limit);
            if (started == 0 && d == 0) {
                Pair nxt = dfs(pos + 1, 10, 10, 0, ntight);
                totalCnt += nxt.cnt;
                totalSum += nxt.sum;
            }
            else if (started == 0) {
                Pair nxt = dfs(pos + 1, 10, d, 1, ntight);
                totalCnt += nxt.cnt;
                totalSum += nxt.sum;
            }
            else {
                long add = 0;
                if (prev2 != 10) {
                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        add = 1;
                    }
                }
                Pair nxt = dfs(pos + 1, prev1, d, 1, ntight);
                totalCnt += nxt.cnt;
                totalSum += nxt.sum + add * nxt.cnt;
            }
        }
        Pair ans = new Pair(totalCnt, totalSum);
        if (!tight) {
            memo[pos][prev2][prev1][started] = ans;
        }
        return ans;
    }
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter num1: ");
    long num1 = sc.nextLong();
    System.out.print("Enter num2: ");
    long num2 = sc.nextLong();
    TotalWavinessINRangeII obj = new TotalWavinessINRangeII();
    long result = obj.totalWaviness(num1, num2);
    System.out.println("Total Waviness = " + result);
    sc.close();
}

