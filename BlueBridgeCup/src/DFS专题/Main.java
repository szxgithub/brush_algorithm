package DFS专题;


public class Main {
	
	public static int[] arr = new int[3];
	public static boolean[] hasVisited = new boolean[3];
	
	public static void main(String[] args) {
		dfs(0);
	}
	
	public static void dfs(int pos){
		
		if(pos==3){	//全排列长度到了3，要进行输出
			for(int i=0;i<arr.length;i++){
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
		
		for(int i=0;i<=2;i++){
			if(!hasVisited[i]){
				arr[pos] = i;
				hasVisited[i] = true;
				dfs(pos+1);
				hasVisited[i] = false;
			}
		}
	}
}
