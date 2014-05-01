package com.wyx.web.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wyx.web.util.WebProperties;

@Controller
public class OAuthController {
	@RequestMapping("turnToAuth")
	public ModelAndView turnToAuth(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		//String redirectUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WebProperties.appID
		https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
			
		return model ;
	}
}
