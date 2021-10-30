class Solution {
public:
    vector<string> wordBreak(string s, vector<string>& dict) {
        unordered_map < string, bool > mp;
        for(auto x: dict) {
            mp[x] = 1;
        }

        int n = s.length();
        vector < int > dp(n + 1, -1);

        auto func = [&](int idx, auto &func) {
            if(idx == n) {
                return 1;
            }
            if(dp[idx] > -1) {
                return dp[idx];
            }
            bool res = 0;
            string s1 = "";
            for(int i = idx; i < n; i ++) {
                s1 += s[i];
                if(mp.count(s1)) {
                    res |= func(i + 1, func);
                }
                if(res) break;
            }
            return dp[idx] = res;
        };

        queue < pair < string, int > > q;
        q.push({"", 0});
        vector < string > ans;
        while(!q.empty()) {
            pair < string, int > p = q.front();
            q.pop();
            if(p.second == n) {
                p.first.pop_back();
                ans.push_back(p.first);
                continue;
            }
            string res = "";
            for(int i = p.second; i < n; i ++) {
                res += s[i];
                if(mp.count(res) and func(i + 1, func)) {
                    q.push({p.first + res + " ", i + 1});
                }
            }
        }
        return ans;
    }
};

