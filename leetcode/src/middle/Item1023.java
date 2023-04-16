package middle;

import java.util.ArrayList;
import java.util.List;

public class Item1023 {

    /*
    驼峰式匹配

     */

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (String query : queries){
            ans.add(check(query,pattern));
        }
        return ans;
    }

    private Boolean check(String query, String pattern) {

        int m = query.length();
        int n = pattern.length();

        int i = 0, j = 0;
        for (;j < n; i++,j++){
            while (i < m && query.charAt(i) != pattern.charAt(j) && Character.isLowerCase(query.charAt(i))){
                i++;
            }
            if (i == m || query.charAt(i) != pattern.charAt(j)){
                return false;
            }
        }

        while (i < m && Character.isLowerCase(query.charAt(i))){
            i++;
        }

        return i == m;
    }

}
