package Day9_Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    Map<String, List<String>> dp;

    public void solve(List<String> dict, String word) {
        dp = new HashMap<>();
        for (String x : go(dict, word)) {
            System.out.println(x);
        }
    }


    public List<String> go(List<String> dict, String word) {
        if (dp.containsKey(dict)) return dp.get(word);
        List<String> list = new ArrayList<>();
        if (word.length() == 0) {
            list.add("");
            return list;
        }
        for (String s : dict) {
            if (word.startsWith(s)) {
                List<String> cur = go(dict, word.substring(s.length()));
                for (String pos : cur) {
                    if (pos.length() == 0) {
                        list.add(s);
                    } else {
                        list.add(s + " " + pos);
                    }
                }
            }
        }
        dp.put(word, list);
        return list;
    }
}
