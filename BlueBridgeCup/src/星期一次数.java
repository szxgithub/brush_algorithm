import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//跑不出来
public class 星期一次数 {
	public static void main(String[] args) {
		/*Calendar calendar = Calendar.getInstance();
		int count = 0;
		for(int i=1;i<=31;i++){
			calendar.set(2016, 1, i);
			if(Calendar.MONDAY==calendar.get(Calendar.DAY_OF_WEEK)){
				count++;
			}
		}
		System.out.println("星期一出现:"+count+"次");*/
		
		String startDate = "1901-01-01";//开始日期
		String endDate = "2001-01-01"; //结束日期
		
		 DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");        
		    Date bdate;
		    int count = 0; //星期一的次数
		    try {
		        while(true){
		            bdate = format1.parse(startDate);
		            if(bdate.getTime() <= format1.parse(endDate).getTime()){
		                Calendar cal = Calendar.getInstance();
		                cal.setTime(bdate);
		                if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY){
		                    count++;
		                }
		                //后一天
		                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		                Date ldate = df.parse(startDate);
		                startDate = df.format(
		                        new Date(ldate.getTime() + 1 * 24 * 60 * 60 * 1000))
		                        .toString();
		            }else{
		                break;
		            }
		        }
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		    System.out.println("星期一次数："+count);
	}
}
