import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Niu3 {
	int N = 100;  
    static List<Integer> list = new ArrayList<Integer>();  
    public void getFactor(List<Integer> list,int index){  
        if(index>N) {  
            calculate();  
            return;  
        }  
        int temp = index;  
        for(int i=1;i<list.size();i++) {  
            int factor = list.get(i);  
            if(temp%factor==0)   
                temp = temp/factor;  
        }  
        list.add(temp);  
        getFactor(list,index+1);  
    }  
      
    public void calculate(){  
        BigInteger num = BigInteger.valueOf(1);  
        for(int i=0;i<list.size();i++) {  
            num = num.multiply(BigInteger.valueOf(list.get(i)));  
        }  
        list.clear();  
        System.out.println(num.mod(BigInteger.valueOf(987654321)));  
    }  
    
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        Niu3 test = new Niu3();  
        while(true){  
            System.out.println("用戶輸入：");  
            test.N = scanner.nextInt();  
            System.out.println("程序輸出:");  
            test.getFactor(list, 1);  
        }   
    }  
}
