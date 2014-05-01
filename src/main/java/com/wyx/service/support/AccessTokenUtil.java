package com.wyx.service.support;

import org.apache.log4j.Logger;

import com.wyx.web.util.HttpClientUtil;
import com.wyx.web.util.WebProperties;

/**
 * 请求的证书
 * @author Administrator
 *
 */
public class AccessTokenUtil {
	private static final Logger logger = Logger.getLogger(AccessTokenUtil.class);
//返回结果{"access_token":"L53iJQzacfkcccA_Ui_IPm74mh5ehQefb8c0kQFGAu20OJKw1GBm8TReiKAtfW-6","expires_in":7200}
	public static String myAccessToken;
	static {
		//调用接口查询myToken
				myAccessToken ="xPGQxe60SunGsRHSr07OxE3A-W8J3DHUe6Vang26-xf-qYnLE7nxeeEyNmMpFc44";
	}
	
	public void getMyToken(){
		String result = HttpClientUtil.sendGetRequest(WebProperties.getAccessTokenUrl(WebProperties.appID, WebProperties.appsecret));
		logger.info("返回结果"+result);
	}
}
