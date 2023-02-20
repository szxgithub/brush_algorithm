package od2022I;

import java.util.Scanner;
import java.util.TreeSet;

public class Main7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TreeSet<String> treeSet = new TreeSet<>();

        while (sc.hasNext()){

            String str = sc.nextLine();

            String prefix = sc.nextLine();

            String[] words = str.split("[^a-zA-Z]");

            for (String word : words){

                if (word.startsWith(prefix)){
                    treeSet.add(word);
                }

            }

            for(String word : treeSet){
                System.out.print(word + " ");
            }

        }

    }

}
