package com.neuedu.myWMS.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * MD5加密的工具类--对于密码
 * @author admin
 *
 */
public class MD5Algroithm {

	public static String md(String password) throws NoSuchAlgorithmException{
		//构建16进制数包含的字符数组
		char[] hexCharacters = "0123456789abcdef".toCharArray();
		//生成原始密码对应的字节数组
		byte[] passByte = password.getBytes();
		
		//创建MessageDigest对象
		MessageDigest mdInstance = MessageDigest.getInstance("MD5");
		
		//更新消息摘要
		mdInstance.update(passByte);
		//调用digest方法生成哈希值
		byte[] mdByte  = mdInstance.digest();
		//定义返回的字符数组
		char[] reStr = new char[mdByte.length * 2];
		//定义返回数组的下标
		int index = 0;
		//遍历新生成的hash值的数组
		for(int i = 0 ; i < mdByte.length ; i++){
			//对数组中的每一个值进行编码
			byte newByte = mdByte[i];
			//对于第5-8位进行重新编码
			reStr[index++] = hexCharacters[newByte >>> 4 & 0xf];
			//对于第1-4位进行重新编码
			reStr[index++] = hexCharacters[newByte & 0xf];
		}
		//将字节转化为字符串输出
		return new String(reStr);
	}
}
