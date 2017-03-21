package com.demo.izo803;

public class Chapter1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chapter1 cp1=new Chapter1();
		System.out.println("result is "+cp1.chkEqual());
		System.out.println("result is "+cp1.chkEqual(1));
		System.out.println("result is "+cp1.chkEqual('Y'));
		System.out.println("result is "+cp1.chkEqual(0.01f));
		
		if(true){;};

	}
	//1.return 0
	int chkEqual(){
		String a="This is kv";
		String b=new String("This is kv");
		if(a==b){
		return 1;
		}else{
			return 0;
		}
	}
	
	//2.return 1
	int chkEqual(int i){
		String a="This is kv";
		String b="This is kv";
		if(a==b){
		return 1;
		}else{
			return 0;
		}
	}
	//3.return 1
	int chkEqual(char s){
		String a="This is kv";
		String b=new String("This is kv");
		if(a.equals(b)){
		return 1;
		}else{
			return 0;
		}
	}
	
	//4.return 1
	int chkEqual(float f){
		String a="This is kv";
		String b="This is kv";
		if(a.equals(b)){
		return 1;
		}else{
			return 0;
		}
	}

}
