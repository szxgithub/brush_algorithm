package 和为S的连续正数序列;
import java.util.ArrayList;

public class Main {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
		//暴力破解
		/*ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer>	list = new ArrayList<>();
		for(int i=1;i<=sum/2;i++){
			list.add(i);
			for(int j=i+1;j<=sum/2+1;j++){
				list.add(j);
				int total =0;
				for(int x=0;x<list.size();x++){
					total+=list.get(x);
				}
				if(total==sum){
					result.add(list);
					list = new ArrayList<Integer>();
					break;
				}else if(total>sum){
					list.clear();
					break;
				}
			}
		}
		return result;*/
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (sum < 3)
            return result;
        ArrayList<Integer> list;
        int left = 1;
        int right = 2;
        int total = 0;
        while (left < right && left < (1 + sum) / 2) {
            total = (left + right) * (right - left + 1) / 2;
            if (total == sum) {
                list = new ArrayList<Integer>();
                int temp = left;
                while (temp <= right) {
                    list.add(temp);
                    temp++;
                }
                result.add(list);
                left++;
                right++;
            } else if (total < sum) {
                right++;
            } else {
                left++;
            }
        }
        return result;
		
	}
}
