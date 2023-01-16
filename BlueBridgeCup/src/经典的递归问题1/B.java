package 经典的递归问题1;
//求n个元素的全排列
// abc acb  bac bca cba cab    
public class B {
	public static void main(String[] args) {
		char[] data = "ABC".toCharArray();
		f(data,0);
	}
	
	//k:当前的交换位置(关注点), 与其后的元素交换
	public static void f(char[] data, int k){
		if(k==data.length){
			for(int i=0;i<data.length;i++)
				System.out.print(data[i]+" ");
			System.out.println();
		}
		for(int i=k;i<data.length;i++){
			{char t = data[k];data[k]=data[i];data[i]=t;}	//试探
			f(data,k+1);
			{char t = data[k]; data[k]=data[i];data[i]=t;}//回溯
		}
	}
}
