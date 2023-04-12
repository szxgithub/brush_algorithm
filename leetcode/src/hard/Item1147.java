package hard;

public class Item1147 {

    /*
    段式回文

     */

    public int longestDecomposition(String text) {

        if (text.isEmpty())
            return 0;
        for (int i = 1, n = text.length(); i <= n / 2; ++i) // 枚举前后缀长度
            if (text.substring(0, i).equals(text.substring(n - i))) // 立刻分割
                return 2 + longestDecomposition(text.substring(i, n - i));
        return 1; // 无法分割

    }


}
