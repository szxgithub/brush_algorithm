/*
 求能除尽1至n的最小整数
 
 为什么1小时有60分钟，而不是100分钟呢？这是历史上的习惯导致。
但也并非纯粹的偶然：60是个优秀的数字，它的因子比较多。
事实上，它是1至6的每个数字的倍数。即1,2,3,4,5,6都是可以除尽60。
我们希望寻找到能除尽1至n的的每个数字的最小整数。
不要小看这个数字，它可能十分大，比如n=100, 则该数为：
69720375229712477164533808935312303556800
为此，有必要使用BigInteger来记录这样的大数。
 */
import java.math.BigInteger;
import java.util.Scanner;
/*
 * 当n=100000, 可以跑出结果
 */
public class Niu2 {
	 // 求能除尽1~n 每个数字的最小整数  
    public static BigInteger f(int n)  
    {  
        int[] x = new int[n+1];  
          
        for(int i=1; i<=n; i++) 
        			x[i] = i;  
          
        for(int i=2; i<n; i++)  
        {  
            for(int j=i+1; j<=n; j++)  
            {  
                if(x[j] % x[i]==0)
                	x[j]=x[j]/x[i];   
            }  
        }  
          
        BigInteger m = BigInteger.ONE;  
        for(int i=2; i<=n; i++)  
        {  
            m = m.multiply(BigInteger.valueOf((long)x[i]));   //   
        }  
          
        return m;  
              
    }  
      
    public static void main(String[] args)  
    {  
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
        System.out.println(f(n).mod(BigInteger.valueOf(987654321)));     
    }  
}
