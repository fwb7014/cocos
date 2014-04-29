package com.wyx.service;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wyx.web.util.SecurityUtil;
import com.wyx.web.util.WebProperties;

@Service
public class DoFirstService {

	private static final Logger logger = Logger.getLogger(DoFirstService.class);

	public String doFirstService(String signature, String timestamp,
			String nonce, String echostr) {
		String[] str = { WebProperties.token, timestamp, nonce };
		Arrays.sort(str);
		StringBuffer bf = new StringBuffer();
		for (String temp : str) {
			bf.append(temp);
		}
		if (checkSignature(bf.toString(), signature)) {
			System.out.println("通过返回" + echostr);
			return echostr;
		}
		return "";

	}

	/**
	 * 检验加密是否正确
	 * 
	 * @param sourceParam
	 * @param signature
	 * @return
	 */
	private boolean checkSignature(String sourceParam, String signature) {
		logger.info("开始进行加密检验");
		logger.info("原文" + sourceParam);
		String securityStr = SecurityUtil.SHA1(sourceParam);
		logger.info("自己计算的密文" + securityStr);
		logger.info("接收的密文" + signature);
		return securityStr.equals(signature);
	}

}
