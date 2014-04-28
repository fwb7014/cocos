package com.wyx.web;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyx.web.util.SecurityUtil;
import com.wyx.web.util.WebProperties;

@Controller
public class FirstStep {
	
	private static final Logger logger = Logger.getLogger(FirstStep.class);

	/**
	 * 开通的第一步 激活开发者模式
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	@ResponseBody
	@RequestMapping("kt.do")
	public String ktWinXin(String signature, String timestamp, String nonce,
			String echostr) {

		String[] str = { timestamp, nonce, WebProperties.token };
		Arrays.sort(str);
		StringBuffer bf = new StringBuffer();
		for(String temp:str){
			bf.append(temp);
		}
		if (checkSignature(bf.toString(),signature)) {
			System.out.println("通过返回"+echostr);
			return echostr;
		}
		return "";
	}
	
	public static void main(String[] args) {
		new FirstStep().ktWinXin("123","abc","ddd","haha");
	}
	

	/**
	 * 检验加密是否正确
	 * @param sourceParam
	 * @param signature
	 * @return
	 */
	private boolean checkSignature(String sourceParam, String signature) {
		logger.info("开始进行加密检验");
		logger.info("原文" +sourceParam);
		String securityStr = SecurityUtil.SHA1(sourceParam); 
		logger.info("自己计算的密文" +securityStr);
		logger.info("接收的密文" +signature);
		return securityStr.equals(signature);
	}
}
