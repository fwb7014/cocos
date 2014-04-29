package com.wyx.dto.receive;

import org.springframework.util.StringUtils;

/**
 * 微信消息类型
 * 
 * @author Administrator
 *
 */
public class MessageType {
	private static String text = "text";
	private static String image = "image";
	private static String voice = "voice";
	private static String video = "video";
	private static String location = "location";
	private static String link = "link";
	
	/**
	 * 检查是否支持此类型
	 * @param type
	 * @return
	 */
	public static boolean checkIfSupportType(String type){
		if(StringUtils.isEmpty(type)){
			return false ;
		}
		if(text.equals(type)||image.equals(type)||voice.equals(type)||video.equals(type)||location.equals(type)||location.equals(link)){
			return true;
		}
		return false ;
	}
	
}
