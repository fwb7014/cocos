package com.wyx.web.support;

import com.wyx.web.util.HttpClientUtil;
import com.wyx.web.util.WebProperties;

/**
 * 请求的证书
 * @author Administrator
 *
 */
public class AccessTokenUtil {
	public static String myAccessToken;
	public void init(){
		//调用接口查询myToken
	}
	
	public void getMyToken(){
		HttpClientUtil.sendPostRequest(WebProperties.access_token,null);
	}
}
