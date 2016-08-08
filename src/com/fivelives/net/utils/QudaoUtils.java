package com.fivelives.net.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class QudaoUtils {
	/**
	 * MD5 生成数据
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String qudao = "qudao1";
		String seat = "1";
		
		String str = getQudaoID(qudao, seat);
		System.err.println(str);
	}
	
	public static String getQudaoID(String qudao,String seat) throws Exception{
		String str = md5Encode(qudao+"_"+seat);
//		System.err.println(str);
		return str;
	}
	
	public static String getShenmiToken(String appid,String key,String lid,String time) throws Exception{
		return md5Encode(appid+key+lid+time);
	}
	
	public static String md5Encode(String inStr) throws Exception {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
	}
}
