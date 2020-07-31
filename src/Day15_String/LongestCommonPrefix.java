package Day15_String;

public class LongestCommonPrefix {

    Node root;

    public void solve(String s[]) {
        root = new Node();
        System.out.println(go(s));
    }

    private String go(String s[]) {
        buildTrie(s);
        return getPrefix();
    }

    private void buildTrie(String s[]) {
        for (String words : s) {
            insert(words);
        }
    }

    private String getPrefix() {
        Node cur = root;
        StringBuilder sb = new StringBuilder();
        while (!cur.isEnd && cur.count == 1) {
            for (int i = 0; i < 26; i++) {
                if (cur.child[i] != null) {
                    char val = (char) ('a' + i);
                    sb.append(val);
                    cur = cur.child[i];
                    break;
                }
            }
        }
        return sb.toString();
    }

    private void insert(String s) {
        Node cur = root;
        for (char c : s.toCharArray()) {
            int idx = (int) (c - 'a');
            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
                cur.count++;
            }
            cur = cur.child[idx];
        }
        cur.isEnd = true;
    }

    class Node {
        Node child[] = new Node[26];
        int count;
        boolean isEnd;
    }

}
