package od2023;

import java.util.*;

public class Main2 {

    /*

    垃圾信息拦截

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

        int id = sc.nextInt();      //A的ID

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
