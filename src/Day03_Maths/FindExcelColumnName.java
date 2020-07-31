package Day03_Maths;

public class FindExcelColumnName {
    public void solve(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int rem = num % 26;
            if (rem == 0) {
                sb.append("Z");
                num = num / 26 - 1;
            } else {
                sb.append((char)((rem - 1) + 'A'));
                num /= 26;
            }
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
}
