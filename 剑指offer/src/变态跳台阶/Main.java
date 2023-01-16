package 变态跳台阶;

public class Main {
	public static void main(String[] args) {
		
	}
	
	public int JumpFloorII(int target) {
		if(target<=0){
			return -1;
		}else if(target==1){
			return 1;
		}else{			
			return 2*JumpFloorII(target-1);   
		}
	}
}
