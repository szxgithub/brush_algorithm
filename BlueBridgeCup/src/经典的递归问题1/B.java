package ����ĵݹ�����1;
//��n��Ԫ�ص�ȫ����
// abc acb  bac bca cba cab    
public class B {
	public static void main(String[] args) {
		char[] data = "ABC".toCharArray();
		f(data,0);
	}
	
	//k:��ǰ�Ľ���λ��(��ע��), ������Ԫ�ؽ���
	public static void f(char[] data, int k){
		if(k==data.length){
			for(int i=0;i<data.length;i++)
				System.out.print(data[i]+" ");
			System.out.println();
		}
		for(int i=k;i<data.length;i++){
			{char t = data[k];data[k]=data[i];data[i]=t;}	//��̽
			f(data,k+1);
			{char t = data[k]; data[k]=data[i];data[i]=t;}//����
		}
	}
}
