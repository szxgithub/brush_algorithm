package easy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Item2446 {

    /*
    判断两个事件是否存在冲突
     */
    public boolean haveConflict(String[] event1, String[] event2){

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date event1Start = sdf.parse(event1[0]);
            Date event1End = sdf.parse(event1[1]);

            Date event2Start = sdf.parse(event2[0]);
            Date event2End = sdf.parse(event2[1]);

            if (event1Start.getTime() <= event2Start.getTime() && event1End.getTime() >= event2Start.getTime()){
                return true;
            }

            if (event1Start.getTime() >= event2Start.getTime() && event2End.getTime() >= event1Start.getTime()){
                return true;
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return false;

    }


    public boolean haveConflict2(String[] event1, String[] event2){

        return event1[0].compareTo(event2[1]) <= 0 && event1[1].compareTo(event2[0]) >= 0;

    }

}
