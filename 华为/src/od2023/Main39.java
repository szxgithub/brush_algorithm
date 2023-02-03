package od2023;

import java.util.*;

public class Main39 {

    /*
    快递投放问题
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();

        Map<String,String> mapPkg = new HashMap<>();
        for (int i =0;i <M; i++){
            String[] s = sc.nextLine().split(" ");
            mapPkg.put(s[0],s[1] + s[2]);
        }

        Map<String, List<String>> mapNo = new HashMap<>();
        for (int i =0; i<N; i++){
            String[] s = sc.nextLine().split(" ");
            List<String> noList = new ArrayList<>();
            for (int j = 2; j < s.length; j++){
                noList.add(s[j]);
            }
            mapNo.put(s[0] + s[1],noList);
        }

        List<String> resList = new ArrayList<>();
        for (Map.Entry<String,List<String>> map :  mapNo.entrySet()){
            String key = map.getKey();
            List<String> value = map.getValue();
            for (String s : value){
                if (key.equals(mapPkg.get(s))){
                    resList.add(s);
                }
            }
        }

        System.out.println(resList);


    }

}
