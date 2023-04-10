package middle;

public class Item1017 {

    /*
    负二进制转换

     */

    public String baseNeg2(int n) {
        if (n == 0){
            return "0";
        }
        int k = 1;
        StringBuilder ans = new StringBuilder();
        while (n != 0){
            if (n%2 != 0){
                ans.append(1);
                n -= k;
            }else {
                ans.append(0);
            }
            k *= -1;
            n /= 2;
        }
        return ans.reverse().toString();
    }

    public String baseNeg22(int n) {
        if (n == 0){
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        while (n != 0){
            if (Math.abs(n)%2 == 0){
                ans.append("0");
                n = -(n>>1);
            }else {
                ans.append("1");
                if (n < 0){
                    n = Math.abs(n) + 1 >> 1;
                }else {
                    n = -((n-1)>>1);
                }
            }
        }
        return ans.reverse().toString();
    }
}
