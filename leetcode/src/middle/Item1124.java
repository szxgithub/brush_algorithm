package middle;

public class Item1124 {

    /*

    表现良好的最长时间段

     */

    public int longestWPI(int[] hours){
        int n = hours.length;
        for (int i =0; i<n; i++){
            hours[i] = hours[i] > 8 ? 1:-1;
        }
        int res = 0;
        for (int i = 0; i<n; i++){
            int count = 0;
            for (int j = i; j<n; j++){
                count += hours[j];
                if (count > 0){
                    res = Math.max(res,j-i+1);
                }
            }
            if (n - i <= res){
                return res;
            }
        }
        return res;
    }

}
