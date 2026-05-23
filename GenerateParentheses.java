 import java.util.*;

public class GenerateParentheses {

    public void solve(int open, int close, String s, List<String> ans, int n) {

        // Base condition
        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        // Add opening bracket
        if (open < n) {
            solve(open + 1, close, s + "(", ans, n);
        }

        // Add closing bracket
        if (close < open) {
            solve(open, close + 1, s + ")", ans, n);
        }
    }

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        solve(0, 0, "", ans, n);

        return ans;
    }

    public static void main(String[] args) {

        GenerateParentheses obj = new GenerateParentheses();

        int n = 3;

        List<String> result = obj.generateParenthesis(n);

        System.out.println(result);
    }
}
