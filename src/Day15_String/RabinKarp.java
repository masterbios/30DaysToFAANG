package Day15_String;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp {

    public void solve(String text, String pattern) {
        List<Integer> list = go(text.toCharArray(), pattern.toCharArray());
        System.out.println(list);
    }

    public List<Integer> go(char txt[], char pat[]) {
        final long prime = 31L;
        final long mod = (long) (1e9) + 9L;
        int t = txt.length, p = pat.length;

        List<Integer> occur = new ArrayList<>();
        long pow[] = new long[Math.max(t, p)];
        long hash[] = new long[t + 1];
        long phash = 0L;

        pow[0] = 1L;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = (pow[i - 1] * prime) % mod;
        }
        for (int i = 0; i < t; i++) {
            hash[i + 1] = (hash[i] + (txt[i] - 'a' + 1L) * pow[i]) % mod;
        }
        for (int i = 0; i < p; i++) {
            phash = (phash + (pat[i] - 'a' + 1L) * pow[i]) % mod;
        }
        for (int i = 0; i + p - 1 < t; i++) {
            long curhash = (hash[i + p] + mod - hash[i]) % mod;
            if (curhash == phash * pow[i] % mod) occur.add(i);
        }
        return occur;
    }
}
