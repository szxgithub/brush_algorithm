package 华为;

import com.sun.xml.internal.ws.util.xml.CDATA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 微爱 试题
 */
public class Stat implements Comparable<Stat>{

    private String date;
    private int registerCount;
    private int activeCount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRegisterCount() {
        return registerCount;
    }

    public void setRegisterCount(int registerCount) {
        this.registerCount = registerCount;
    }

    public int getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(int activeCount) {
        this.activeCount = activeCount;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "date='" + date + '\'' +
                ", registerCount=" + registerCount +
                ", activeCount=" + activeCount +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + (int) (registerCount ^ (registerCount >>> 32));
        return result;
    }

    public Stat(String date, int registerCount, int activeCount) {
        super();
        this.date = date;
        this.registerCount = registerCount;
        this.activeCount = activeCount;
    }

    @Override
    public int compareTo(Stat dest) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int mark = 0;
        try {
            Date destDate = sdf.parse(dest.getDate());
            Date srcDate = sdf.parse(this.date);
            if(destDate.getTime() > srcDate.getTime()){
                mark = -1;
            }else if(destDate.getTime() < srcDate.getTime()){
                mark = 1;
            }else {
                mark = 0;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mark;
    }

    public static void main(String[] args) {
        List<Stat> list = new LinkedList<>();
        list.add(new Stat("2020-04-24",1,1));
        list.add(new Stat("2020-04-22",1,1));
        list.add(new Stat("2020-04-22",2,2));
        list.add(new Stat("2020-04-23",1,1));
        Collections.sort(list);
        for (Stat stat:list) {
            System.out.println(stat);
        }
        System.out.println("mergedList中的元素为：");
        List<Stat> mergeList = mergeList(list);
        for (Stat stat:mergeList) {
            System.out.println(stat);
        }

    }

    private static List<Stat> mergeList(List<Stat> list) {
        List<Stat> result = new ArrayList<Stat>();
        if(list == null){
            return result;
        }
        for(int i = 0; i< list.size();i++){
            Stat stat1 = list.get(i);
            if(!result.contains(stat1)){
                for(int j = i+1; j< list.size();j++){
                    Stat stat2 = list.get(j);
                    if(stat1.equals(stat2)){
                        stat1.setRegisterCount(stat1.getRegisterCount()+stat1.getRegisterCount());
                        stat1.setActiveCount(stat1.getActiveCount()+stat1.getActiveCount());
                    }
                }
                result.add(stat1);
            }
        }
        return result;
    }
}
