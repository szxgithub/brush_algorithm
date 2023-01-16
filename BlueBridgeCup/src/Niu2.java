/*
 ���ܳ���1��n����С����
 
 Ϊʲô1Сʱ��60���ӣ�������100�����أ�������ʷ�ϵ�ϰ�ߵ��¡�
��Ҳ���Ǵ����żȻ��60�Ǹ���������֣��������ӱȽ϶ࡣ
��ʵ�ϣ�����1��6��ÿ�����ֵı�������1,2,3,4,5,6���ǿ��Գ���60��
����ϣ��Ѱ�ҵ��ܳ���1��n�ĵ�ÿ�����ֵ���С������
��ҪС��������֣�������ʮ�ִ󣬱���n=100, �����Ϊ��
69720375229712477164533808935312303556800
Ϊ�ˣ��б�Ҫʹ��BigInteger����¼�����Ĵ�����
 */
import java.math.BigInteger;
import java.util.Scanner;
/*
 * ��n=100000, �����ܳ����
 */
public class Niu2 {
	 // ���ܳ���1~n ÿ�����ֵ���С����  
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
