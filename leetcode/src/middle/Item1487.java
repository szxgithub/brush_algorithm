package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item1487 {

    /*

    保证文件名唯一


     */

    public String[] getFolderNames(String[] names){

       String[] res = new String[names.length];

       Map<String,Integer> table = new HashMap<>();

       for (int i = 0; i < names.length; i++){
           String name = names[i];
           if (table.containsKey(name)){
               for (int k = table.get(name) + 1;;k++){
                   String newName = name + "(" + k + ")";
                   if (!table.containsKey(newName)){
                       res[i] = newName;
                       table.put(name,k);
                       table.put(newName,0);
                       break;
                   }
               }
           }else {
               res[i] = name;
               table.put(name,0);
           }
       }

       return res;
    }

    public static void main(String[] args) {

    }

}
