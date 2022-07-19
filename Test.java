import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[][] ps = { { 72, 98 }, { 62, 27 }, { 32, 7 }, { 71, 4 }, { 25, 19 }, { 91, 30 }, { 52, 73 }, { 10, 9 },
                { 99, 71 }, { 47, 22 }, { 19, 30 }, { 80, 63 }, { 18, 15 }, { 48, 17 }, { 77, 16 }, { 46, 27 },
                { 66, 87 }, { 55, 84 }, { 65, 38 }, { 30, 9 }, { 50, 42 }, { 100, 60 }, { 75, 73 }, { 98, 53 },
                { 22, 80 }, { 41, 61 }, { 37, 47 }, { 95, 8 }, { 51, 81 }, { 78, 79 }, { 57, 95 } };

        // for (int[] two : ps) {
        //     System.out.println(two[0]+","+two[1]);
        // }
        System.out.println(new Solution().minimumLines(ps));
    }
    

}

class Solution {
    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length < 2)
            return 0;
        qsort(stockPrices, 0, stockPrices.length - 1);
        // Arrays.sort(stockPrices, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] o1, int[] o2) {
        //         return o1[0] < o2[0] ? -1 : o1[0] > o2[0] ? 1 : 0;
        //     }

        // });
        int y2 = stockPrices[1][1];
        int x2 = stockPrices[1][0];
        int y1 = stockPrices[0][1];
        int x1 = stockPrices[0][0];
        int y0 = 0;
        int x0 = 0;
        int cnt = 1;
        for (int i = 2; i < stockPrices.length; ++i) {
            x0 = x1;
            y0 = y1;
            x1 = x2;
            y1 = y2;
            y2 = stockPrices[i][1];
            x2 = stockPrices[i][0];
            if ((y2 != y1 || y1 != y0) && (y2 * x1 - y2 * x0 + y1 * x0) != (y1 * x2 - y0 * x2 + y0 * x1)) {
                cnt++;
            }
        }
        return cnt;
    }

    private void qsort(int[][] ar, int L, int R) {
        if (L < R) {
            int k = part(ar, L, R);
            qsort(ar, L, k-1);
            qsort(ar, k+1, R);
        }
    }
    
    private int part(int[][] ar, int L, int R) {
        int l = L;
        int r = R;
        int f = ar[L][0];
        int y = ar[L][1];
        for (; l < r;) {
            for (; ar[r][0] >= f && l < r;)
                r--;
            ar[l][0] = ar[r][0];
            ar[l][1] = ar[r][1];
            for (; ar[l][0] <= f && l < r;)
                l++;
            ar[r][0] = ar[l][0];
            ar[r][1] = ar[l][1];
        }
        ar[l][0] = f;
        ar[l][1] = y;
        return l;
    }
}