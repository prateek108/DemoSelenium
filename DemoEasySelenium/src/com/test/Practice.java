package com.test;

public class Practice {

	public static void main(String args[]) {
		Vars varsObject = new Vars();
		//varsObject.setNum(5);
		//varsObject.number();
        int x = varsObject.getNum();
        System.out.println(x);
}
}

class Vars {
    private int num;
        public void setNum(int x){
            this.num = x;
        }
        public int getNum(){
            return num;
        }
        
        public void number(){
        	num=5;
        }
        
}
