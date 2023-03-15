package od2023.twohundred;

import java.util.*;

public class Main9 {

    /*

    垃圾信息拦截(垃圾短信识别)
    发送者A符合以下条件之一的，则认为A是垃圾短信发送者:
        A发送的接受者中，没有给A发过短信的人数 L>5
        A发送的短信数 - A接收的短信数 M>10
        如果存在X，A发送给X的短信数 - A接收到X的短信数 N>5；

    输入描述：
        第一行条目数
        接下来几行是具体的条目，每个条目，一对ID，第一个数字是发送者ID，后面的数字是接收者ID
        最后一行为指定的ID
    输出描述：
        输出该ID是否为垃圾短信发送者，并按顺序输出L、M的值

输入：
15
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
1 11
1 12
1 13
1 14
14 1
1 15
1
输出：
true 13 13


     */

    /*
    逻辑分析
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int idFrom = sc.nextInt();
            int idTo = sc.nextInt();
            list.add(new int[]{ idFrom, idTo});
        }

        //指定的ID
        int id = sc.nextInt();

        // A为指定的ID
        Set<Integer> sendMailPersons = new HashSet<>();   //接收A短信的人集合
        Set<Integer> getMailPersons = new HashSet<>();   //发送短信给A的人集合
        Map<Integer, Integer> sendMail = new HashMap<>();       //A发送短信给X的数量
        Map<Integer, Integer> getMail = new HashMap<>();     //A接收X短信的数量
        int sendMailsNum = 0;   //A发送的短信数量
        int getMailsNum = 0;    //A接收的短信数量
        for(int[] ints : list){
            if(ints[0] == id){      //发送者是A
                sendMailPersons.add(ints[1]);
                sendMailsNum ++;
                sendMail.put( ints[1], sendMail.getOrDefault( ints[1], 0) + 1);
            }else if(ints[1] == id){    //接受者是A
                getMailsNum ++;
                getMailPersons.add(ints[0]);
                getMail.put( ints[0], getMail.getOrDefault( ints[0], 0) + 1);
            }
        }

        boolean isLaji = false;
        sendMailPersons.removeAll(getMailPersons);      //接收A短信的人的集合剔除发送短信给A的人集合
        int L = sendMailPersons.size();
        int M = sendMailsNum - getMailsNum;
        if(L > 5){
            isLaji = true;
        }else if(M > 10){
            isLaji = true;
        }else {
            // 判断指是否存在X，A发送给它的短信数 - 接收到的短信数 是否大于5
            for(Map.Entry<Integer, Integer> map : sendMail.entrySet()){
                int getId = map.getKey();
                int send = map.getValue();
                if(getMail.containsKey(getId)){
                    if(send - getMail.get(getId) > 5){
                        isLaji = true;
                        break;
                    }
                }
            }
        }

        System.out.println(isLaji + " " + L + " " + M);
    }


}
