package Day16_String;

public class CheckForAnagrams {
    public void solve(String s1, String s2) {
        int count[] = new int[256];
        boolean flag = true;
        for (char c : s1.toCharArray()) count[c]++;
        for (char c : s2.toCharArray()) count[c]--;
        for (int x : count) if (x != 0) {
            flag = false;
        }
        System.out.println(flag);
    }
}
