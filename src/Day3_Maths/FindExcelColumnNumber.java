package Day3_Maths;

public class FindExcelColumnNumber {

    public void solve(String s) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            ans = (ans * 26) + (c - 'A') + 1;
        }
        System.out.println(ans);
    }
}
