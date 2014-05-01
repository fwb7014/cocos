package com.wyx.web.util;


public class WebProperties {
	
	public static String token="fwb7014";
	public static String appID="wxf798660dd249ec1a";
	public static String appsecret="477f7776b838e61c1c1c4853117a08d8";
	
	/**
	 * 获得主动发送消息的地址
	 * @param access_token
	 * @return
	 */
	public static String getSendMsgUrl(String access_token){
		return "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+access_token;
	}
	
	/**
	 * 获得请求access_token的地址
	 * @param appID
	 * @param appsecret
	 * @return
	 */
	public static String getAccessTokenUrl(String appID,String appsecret){
		return "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appID+"&secret="+appsecret ;
	}
}
