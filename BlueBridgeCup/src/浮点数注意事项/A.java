package 浮点数注意事项;
//啤酒与饮料
//求啤酒的数量，啤酒的数量比饮料少
public class A {
	public static void main(String[] args) {
		
		//浮点数: 足够接近
		//System.out.println(0.2+0.1);
		//System.out.println(Math.abs(0.2+0.1-0.3)<1E10);
		
		/*
		 这种做法是危险的 
		 for(int i=0;i<45;i++){
			for(int j=0;j<45;j++){
				if(i<j && (2.3*i+1.9*j)==82.3){
					System.out.println(i);
				}
			}
		}
		*/
		
		for(int i=0;i<45;i++){
			for(int j=0;j<45;j++){
				if(i<j && (23*i+19*j)==823){
					System.out.println(i);
				}
			}
		}
	}
}
