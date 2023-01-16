package od;

import java.util.*;

/**
 *
 * 小朋友编号和是否同班的标志
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String classmates = sc.nextLine();

        String[] mateArr = classmates.split("\\s+");

        ArrayList<List<Integer>> res = new ArrayList<>();

        HashMap<Integer, List<Integer>> tmpMap = new HashMap<>();

        for (int i = 0;i<mateArr.length;i++){

            String tmp1 = mateArr[i];
            Integer tmp1Num = Integer.parseInt(tmp1.charAt(0) +"");
            if(tmp1Num <= 0 || tmp1Num >= 999){
                System.out.println("ERROR");
                return;
            }
            char tmp1Flag = tmp1.charAt(2);

            if (tmp1Flag == 'Y' && i-1 >= 0){

                //取出前一个同学
                String tmp2 = mateArr[i-1];
                Integer tmp2Num = Integer.parseInt(tmp2.charAt(0) + "");

                if (tmpMap.get(tmp2Num) == null){
                    ArrayList<Integer> sameList = new ArrayList<>();
                    tmpMap.put(tmp1Num,sameList);
                    sameList.add(tmp1Num);
                    sameList.add(tmp2Num);
                    res.add(sameList);
                }else{
                    tmpMap.get(tmp2Num).add(tmp1Num);
                }

            }

        }


        for (int i = 0; i<res.size();i++) {
            List<Integer> characters = res.get(i);
            Collections.sort(characters);
        }
       Collections.sort(res, new Comparator<List<Integer>>() {
           @Override
           public int compare(List<Integer> o1, List<Integer> o2) {
             return  o1.get(0) - o2.get(0);
           }
       });

        for (int i = 0; i<res.size();i++){
            List<Integer> characters = res.get(i);
            for (int j = 0;j<characters.size();j++){
                System.out.print(characters.get(j) + " ");
            }
            System.out.println();
        }

    }
}
