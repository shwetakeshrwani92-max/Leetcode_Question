import java.util.PriorityQueue;
public class MaxTotalSubarrrayValueII {
    static class Node {
        long val;
        int l, r;
        Node(long val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }
    }
    int[][] mx;
    int[][] mn;
    int[] lg;
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i / 2] + 1;
        }
        int m = lg[n] + 1;
        mx = new int[m][n];
        mn = new int[m][n];
        for (int i = 0; i < n; i++) {
            mx[0][i] = nums[i];
            mn[0][i] = nums[i];
        }
        for (int j = 1; j < m; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                mx[j][i] = Math.max(
                        mx[j - 1][i],
                        mx[j - 1][i + (1 << (j - 1))]
                );
                mn[j][i] = Math.min(
                        mn[j - 1][i],
                        mn[j - 1][i + (1 << (j - 1))]
                );
            }
        }
        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));
        for (int l = 0; l < n; l++) {
            pq.offer(new Node(value(l, n - 1), l, n - 1));
        }
        long ans = 0;
        while (k-- > 0) {
            Node cur = pq.poll();
            ans += cur.val;
            if (cur.r > cur.l) {
                int nr = cur.r - 1;
                pq.offer(new Node(value(cur.l, nr), cur.l, nr));
            }
        }

        return ans;
    }
    private long value(int l, int r) {
        int len = r - l + 1;
        int j = lg[len];
        int mxVal = Math.max(
                mx[j][l],
                mx[j][r - (1 << j) + 1]
        );
        int mnVal = Math.min(
                mn[j][l],
                mn[j][r - (1 << j) + 1]
        );
        return (long) mxVal - mnVal;
    }
    public static void main(String[] args) {
        MaxTotalSubarrrayValueII sol = new MaxTotalSubarrrayValueII();
        int[] nums1 = {1, 3, 2};
        int k1 = 2;
        System.out.println("Output 1: " + sol.maxTotalValue(nums1, k1));
        int[] nums2 = {4, 2, 5, 1};
        int k2 = 3;
        System.out.println("Output 2: " + sol.maxTotalValue(nums2, k2));
    }
}