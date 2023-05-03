package middle;

public class Item1105 {

    /*
    填充书架

     */


    /*
    动态规划
     */
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        // f[i]表示前i本书摆放的最小高度， 初始时f[0] = 0， 答案为f[n]
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int w = books[i - 1][0], h = books[i - 1][1];
            f[i] = f[i - 1] + h;
            for (int j = i - 1; j > 0; --j) {
                w += books[j - 1][0];
                if (w > shelfWidth) {
                    break;
                }
                // 更新的当前层的最大高度
                h = Math.max(h, books[j - 1][1]);
                f[i] = Math.min(f[i], f[j - 1] + h);
            }
        }
        return f[n];
    }

}
