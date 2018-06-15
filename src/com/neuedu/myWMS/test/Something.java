package com.neuedu.myWMS.test;

public class Something {

	public static void main(String[] args) {
		String thingString = "一个-两个-三个-四个";
		String oneString = thingString.split("-")[0];
		System.out.println(oneString);
		String goodId = "12";
		String goodName = "";
		String goodType = "";
		System.out.println("goodId=" + goodId + "goodName=" + goodName + "goodType=" + goodType);
		String condition = "";
		if("" != goodId){
			condition = "goodId=" + Integer.parseInt(goodId) + " and ";
		}
		if("" != goodName){
			condition +="goodName=" + goodName + " and ";
		}
		if("" != goodType){
			condition +="goodType=" + goodType + " and ";
		}
		//去掉字符串最后一个and
		condition = condition.substring(0, condition.length()-4);
		System.out.println("condition=" + condition);
	}
}
