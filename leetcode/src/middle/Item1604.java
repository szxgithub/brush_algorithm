package middle;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Item1604 {

    /*

    警告一小时内使用相同员工卡大于等于三次的人
     */

    public List<String> alertNames(String[] keyName, String[] keyTime){

        HashMap<String,List<Integer>> map = new HashMap<>();

        for (int i =0; i<keyName.length; i++){
            String name = keyName[i];
            String time = keyTime[i];
            map.putIfAbsent(name,new ArrayList<>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            map.get(name).add(hour*60 + minute);
        }

        List<String> res = new ArrayList<>();
        Set<String> keySet = map.keySet();
        for (String name : keySet){
            List<Integer> list = map.get(name);
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i <size; i++){
                Integer time1 = list.get(i - 2);
                Integer time3 = list.get(i);
                if (time3 - time1 <= 60){
                    res.add(name);
                    break;
                }
            }
        }

        Collections.sort(res);

        return res;

    }

}
