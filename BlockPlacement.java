import java.util.*;
public class BlockPlacement {
    class SegmentTree {
        int n;
        int[] tree;
        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }
        void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid)
                update(2 * node, start, mid, idx, val);
            else
                update(2 * node + 1, mid + 1, end, idx, val);
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }
        int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l)
                return 0;
            if (l <= start && end <= r)
                return tree[node];
            int mid = (start + end) / 2;
            return Math.max(
                query(2 * node, start, mid, l, r),
                query(2 * node + 1, mid + 1, end, l, r)
            );
        }
    }
    public List<Boolean> getResults(int[][] queries) {
        TreeSet<Integer> obstacles = new TreeSet<>();
        List<Boolean> ans = new ArrayList<>();
        int maxX = 0;
        for (int[] q : queries) {
            if (q[0] == 1)
                maxX = Math.max(maxX, q[1]);
            else
                maxX = Math.max(maxX, q[1]);
        }
        SegmentTree seg = new SegmentTree(maxX + 2);
        obstacles.add(0);
        obstacles.add(maxX + 1);
        seg.update(1, 0, maxX + 1, maxX + 1, maxX + 1);
        for (int[] q : queries) {
            if (q[0] == 1) {
                int x = q[1];
                Integer right = obstacles.higher(x);
                Integer left = obstacles.lower(x);
                seg.update(1, 0, maxX + 1, right, right - x);
                seg.update(1, 0, maxX + 1, x, x - left);
                obstacles.add(x);
            }
            else {
                int x = q[1];
                int sz = q[2];
                Integer prev = obstacles.floor(x);
                int maxGap = seg.query(
                    1,
                    0,
                    maxX + 1,
                    0,
                    prev
                );
                int lastGap = x - prev;
                ans.add(Math.max(maxGap, lastGap) >= sz);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
    BlockPlacement obj = new BlockPlacement();

    int[][] queries = {
        {1, 2},
        {2, 3, 3},
        {2, 3, 1},
        {2, 2, 2}
    };

    List<Boolean> result = obj.getResults(queries);

    System.out.println(result);
}
    }
     

