package hard;

public class Item1163 {

    /*

    按字典序排在最后的子串
     */
    public String lastSubstring(String s) {

        int n = s.length();
        int i = 0;
        for (int j = 1, k= 0;  j + k < n;){
            int d = s.charAt(i + k) - s.charAt(j + k);
            if (d == 0){
                k++;
            }else if (d < 0){
                i += k + 1;
                k = 0;
                if (i >= j){
                    j = i + 1;
                }
            }else {
                j += k + 1;
                k = 0;
            }
        }

        return s.substring(i);

    }

}
