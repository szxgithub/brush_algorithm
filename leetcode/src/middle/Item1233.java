package middle;

import java.util.*;

public class Item1233 {

    /*
    删除子文件夹

     */

    /*
    暴力搜索超时 28/32
     */
    public List<String> removeSubfolders(String[] folder){

        // 按照字典排序
        Arrays.sort(folder);

        List<String> res = new ArrayList<>(Arrays.asList(folder));
        List<String> delete = new ArrayList<>();
        for (int i =0; i<res.size(); i++){
            for (int j = i+1; j < res.size(); j++){
                if (res.get(j).startsWith(res.get(i) + "/") && !res.get(j).equals(res.get(i))){
                    delete.add(res.get(j));
                }
            }
        }

        res.removeAll(delete);
        return res;
    }

    /*
    排序方法，通过
     */
    public List<String> removeSubfolders2(String[] folder){

        // 按照字典排序
        Arrays.sort(folder);

        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        for (int i = 1; i <folder.length; i++){
            int m = ans.get(ans.size() - 1).length();
            int n = folder[i].length();
            if (m >= n || !folder[i].startsWith(ans.get(ans.size()-1) + "/")){
                ans.add(folder[i]);
            }
        }

        return ans;
    }

    /*
    利用hashset 重新定义hashset的比较器
     */
    public List<String> removeSubfolders3(String[] folder){

        Arrays.sort(folder);

        Set<String> set = new TreeSet<>((o1, o2) -> {
            if (o1.startsWith(o2+ "/")){
                return 0;
            }
            return o1.compareTo(o2);
        });

        Collections.addAll(set,folder);

        return new ArrayList<>(set);



    }

    public static void main(String[] args) {

        Item1233 item1233 = new Item1233();

         String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        // String[] folder = {"/a","/a/b/c","/a/b/d"};
         // String[] folder = {"/a/b/c","/a/b/ca","/a/b/d"};
         // String[] folder = {"/ah/al/am","/ah/al"};

        List<String> strings = item1233.removeSubfolders2(folder);
        System.out.println(strings);

    }

}
