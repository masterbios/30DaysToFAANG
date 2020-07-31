package Day24_Graph;


public class KruskalAlgo {

    // edge[0] = u, edge[1] = v, edge[2] = cost;
    public void solve(int edge[][], int n) {
        DJSet set = new DJSet(n);

        int ans = 0;
        for (int i = 0, cnt = n - 1; cnt > 0 && i < edge.length; i++) {
            int u = edge[i][0], v = edge[i][1], cost = edge[i][2];
            boolean formsCycle = set.find(u) == set.find(v);
            if (formsCycle) continue;
            set.merge(u, v);
            ans += cost;
            cnt--;
        }

        System.out.println(ans);
    }

    class DJSet {
        int par[];
        int rank[];
        int n;
        public DJSet(int n) {
            this.n = n;
            this.par = new int[n];
            this.rank = new int[n];
            makeSet();
        }

        public void makeSet() {
            for (int i = 0; i < this.n; i++) {
                par[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int node) {
            if (node == par[node]) return node;
            return par[node] = find(par[node]);
        }

        public void merge(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b) {
                if (rank[b] > rank[a]) { int temp = a; a = b; b = temp; }
                par[b] = a;
                rank[a] += rank[b];
            }
        }
    }

}
