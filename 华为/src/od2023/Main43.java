package od2023;

import java.util.*;

public class Main43 {

    /*

    区间连接器

    输入：
    [1,10],[15,20],[18,30],[33,40]
    [5,4,3,2]
    输出：1

     */

    public static void main3(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        str = str.substring(str.indexOf("[") + 1, str.length() - 1);
        String[] split = str.split("],\\[");

        List<int[]> list= new ArrayList<>();
        for (int i = 0; i< split.length; i++){
            String[] arr = split[i].split(",");
            int[] ints = {Integer.parseInt(arr[0]), Integer.parseInt(arr[1])};
            list.add(ints);
        }

        String connectStr = sc.nextLine();
        connectStr = connectStr.substring(connectStr.indexOf("[") + 1, connectStr.length() - 1);
        String[] connect = connectStr.split(",");
        int[] connectNum = Arrays.stream(connect).mapToInt(value -> Integer.valueOf(value)).toArray();
        Arrays.sort(connectNum);

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<list.size(); i++){
            int[] first = list.get(i);
            for (int j = i+1; j < list.size(); j++){
                int[] second = list.get(j);
                int gab = Math.abs(first[1] - second[0]);

                boolean hebin = false;
                for (int k = 0; k <connectNum.length && !hebin; k++){
                    if (gab <= connectNum[k]){
                        connectNum[k] = 0;
                        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
                            if (entry.getValue() == i){
                                map.put(entry.getKey(),j);
                                hebin = true;
                                break;
                            }
                        }
                        if (!hebin){
                            map.put(i,j);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(map.size());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] regionsStr = sc.nextLine().replaceAll("\\[","")
                .replaceAll("]","")
                .split(",");
        String[] linksStr = sc.nextLine().replaceAll("\\[","")
                .replaceAll("]","")
                .split(",");;

        List<int[]> regions = new ArrayList<>();    //区间集合
        for( int i=0; i<regionsStr.length; i+=2){
            int left = Integer.valueOf(regionsStr[i]);
            int right = Integer.valueOf(regionsStr[i+1]);
            regions.add(new int[]{ left, right});
        }

        List<Integer> links = new ArrayList<>();    //连接器集合
        for(String s : linksStr){
            links.add(Integer.valueOf(s));
        }

        regions.sort((a, b) -> {    //区间进行升序排序
            if(b[0] == a[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] region = null;
        Iterator<int[]> iter = regions.iterator();
        // 对相邻区间进行合并
        while(iter.hasNext()) {
            int[] next = iter.next();
            if(region == null) {
                region = next;
            } else if(region[1] >= next[0]) {
                if(region[1] < next[1]) {
                    region[1] = next[1];
                }
                iter.remove();
            } else {
                region = next;
            }
        }

        List<Integer> gaps = new ArrayList<>();     //各区间所需连接器的长度集合
        iter = regions.iterator();
        region = null;
        // 计算剩余各个不重叠的区间的间隙
        while(iter.hasNext()) {
            int[] next = iter.next();
            if(region != null) {
                int gap = next[0] - region[1];
                gaps.add(gap);
            }
            region = next;
        }

        Collections.sort(gaps);
        Collections.sort(links);

        int i = 0; // gaps index
        int j = 0; // links index
        while(i < gaps.size() && j < links.size()) {
            if(links.get(j) >= gaps.get(i)) {   //连接器长度大于等于所需连接器长度，符合要求
                gaps.set(i, 0);     //可以连接的两个区间距离设置为0
                i++;
                j++;    //使用过的连接器不再使用
            } else {
                j++;
            }
        }

        int noneZoreNum = 0;
        for (int g :  gaps) {
            if(g > 0) {     //大于0，说明两个区间无法进行连接
                noneZoreNum++;
            }
        };
        System.out.println(noneZoreNum + 1);
    }
}
