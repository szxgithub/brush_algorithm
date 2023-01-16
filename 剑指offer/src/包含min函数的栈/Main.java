package 包含min函数的栈;

import java.util.Stack;

public class Main {
	
}

class Solution{
	
	Stack<Integer> data = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();
	Integer temp = null;
	
	public void push(int node){
		if(temp!=null){
			if(node<=temp){
				temp = node;
				min.push(node);
			}
			data.push(node);
		}else{
			temp = node;
			data.push(node);
			min.push(node);
		}
	}
	
	public void pop(){
		int num = data.pop();
		int num2 = min.pop();
		if(num!=num2){
			min.push(num2);
		}
	}
	
	public int top(){
		int num = data.pop();
		data.push(num);
		return num;
	}
	
	public int min(){
		int num = min.pop();
		min.push(num);
		return num;
	}
}
