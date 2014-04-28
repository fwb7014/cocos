package com.wyx.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyx.service.DoFirstService;

@Controller
public class ReceiveController {
	
	private static final Logger logger = Logger.getLogger(ReceiveController.class);
	
	@Autowired
	private DoFirstService doFirst ;

	/**
	 * 开通的第一步 激活开发者模式
	 * 
	 * @param signature
	 * @param timestampba 
	 * 
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	@ResponseBody
	@RequestMapping("receive.do")
	public String ktWinXin(HttpServletRequest request) {
		System.out.println("ToUserName"+request.getParameter("ToUserName"));
		System.out.println(ToStringBuilder.reflectionToString(request));
		return doFirstService(request);
	}
	
	
	
	/**
	 * 验证
	 * @param request
	 * @return
	 */
	public String doFirstService(HttpServletRequest request){
		String signature =request.getParameter("signature");
		String timestamp =request.getParameter("timestamp");
		String nonce =request.getParameter("nonce");
		String echostr =request.getParameter("echostr");
		logger.info("timestamp="+timestamp+",nonce="+nonce+",echostr="+echostr+",signature="+signature);
		return doFirst.doFirstService(signature, timestamp, nonce, echostr);
		
		
	}
	
}
