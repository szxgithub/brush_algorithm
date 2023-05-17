package middle;

public class Item1016 {

    /*
    子串能表示从 1 到 N 数字的二进制串

     */
    public boolean queryString(String s, int n){
        for (int i = 1; i <= n; i++){
            String s1 = Integer.toBinaryString(i);
            if (s.indexOf(s1) == -1){
                return false;
            }
        }
        return true;
    }

}
