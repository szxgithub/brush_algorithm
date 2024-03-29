package middle;

import java.util.Arrays;

public class Item1054 {

    /*
    距离相等的条形码
     */

    public int[] rearrangeBarcodes(int[] barcodes){
        int n = barcodes.length;
        Integer[] t = new Integer[n];
        int mx = 0;
        for (int i = 0; i <n; i++){
            t[i] = barcodes[i];
            mx = Math.max(mx,barcodes[i]);
        }
        int[] cnt = new int[mx + 1];
        for (int x : barcodes){
            cnt[x]++;
        }
        Arrays.sort(t,(a,b)->cnt[a] == cnt[b] ? a - b : cnt[b] - cnt[a]);

        int[] ans = new int[n];
        for (int k = 0, j = 0; k < 2; k++){
            for (int i = k; i < n; i += 2){
                ans[i] = t[j++];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Item1054 item1054 = new Item1054();
        int[] barcodes = {1,1,1,1,2,2,3,3};
        int[] ints = item1054.rearrangeBarcodes(barcodes);
        System.out.println(Arrays.toString(ints));
    }

}
