public class Main {
    public static void main(String[] args) {
        int a[] = {1, 7, 11}, b[] = {2, 4, 6}, k = 3;
        solve(a, b, k);
    }

    private static void solve(int[] one, int[] two, int k) {
        // Hint: keys are one's indices, values are two's indices
        int idxMap[] = new int[one.length];
        int min = 0, INF = (100000);
        for (int i = 0; i < k; i++) {
            min = INF;
            int oneIdx = -1;
            int twoIdx = -1;

            for (int j = 0; j < one.length; j++) {
                if (idxMap[j] == two.length)
                    continue;


                if (one[j] + two[idxMap[j]] < min) {
                    min = one[j] + two[idxMap[j]];
                    oneIdx = j;
                    twoIdx = idxMap[j];
                }
            }

            idxMap[oneIdx]++;
            System.out.println(one[oneIdx] + " " + two[twoIdx]);
        }
    }

    private static int func(int a[]) {
        int low = 0, mid = 0, high = a.length - 1;
        while (mid <= high) {
            if (a[mid] == 0) {
                swap(a, low, mid);
                low++; mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else {
                swap(a, high, mid);
                high--;
            }
        }
        return low;
    }

    private static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void ha(char a[], int i) {
        if (i == a.length) {
            for (char val : a) System.out.print(val);
            System.out.println();
            return;
        }
        if (a[i] == '?') {
            a[i] = '0';
            ha(a, i + 1);
            a[i] = '1';
            ha(a,i + 1);
            a[i] = '?';
        } else {
            ha(a, i + 1);
        }
    }

}
