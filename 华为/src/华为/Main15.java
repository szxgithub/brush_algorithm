package 华为;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main15 {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int num = sc.nextInt();
      sc.nextLine();
      String[] arr = new String[num];
      for(int i = 0;i<arr.length;i++){
          String tmp = sc.nextLine();
          arr[i] = tmp;
      }
      /*List<String> strings = Arrays.asList(arr);
      Collections.sort(strings);
      for(int i = 0;i<strings.size();i++){
          System.out.println(strings.get(i));
      }*/
      Arrays.sort(arr);
      for(int i= 0;i<arr.length;i++){
          System.out.println(arr[i]);
      }
    }
}
