package od;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main52 {

    /*

    日志排序

    输入：
    2
    01:41:8.9
    1:1:09.211
    输出：
    1:1:09.211
    01:41:8.9


     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        List<String> list = new ArrayList<>();

        for (int i =0 ;i < N; i++){
            list.add(sc.nextLine());
        }

        String format = "HH:mm:ss.SSS";
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        Map<String,Long> map = new HashMap<>();
        for (int i =0; i<list.size(); i++){
            String s = list.get(i);
            try {
                Date parse = sdf.parse(s);
                map.put(s,parse.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        ArrayList<Map.Entry<String, Long>> sortList = new ArrayList<>(map.entrySet());

        sortList.sort((o1, o2) -> (int) (o1.getValue() - o2.getValue()));

        for (Map.Entry<String,Long> entry : sortList){
            System.out.println(entry.getKey());
        }

    }

}
