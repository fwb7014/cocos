package com.wyx.service.msg.handler;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.wyx.dto.KeyMsg;
import com.wyx.dto.receive.ReceiveMsg;
@Component
public class TextMsgHandler extends AbsMsgHandler {
	private static final Logger logger = Logger.getLogger(TextMsgHandler.class);
	
	/**
	 * 处理普通的消息
	 * 
	 * @param msg
	 */

	@Override
	public String getMsgHandlerType() {
		return "text";
	}

	@Override
	public String handleMsg(ReceiveMsg receiveMsg,KeyMsg sendMsg) {
		// 现在开始处理消息
		logger.info(ToStringBuilder.reflectionToString(this));
		String responseMsg = getResponseStr(receiveMsg,sendMsg);
		System.out.println("相应的信息"+responseMsg);
		return responseMsg;
		
	}
	
	
	/**
	 * 拼接返回的内容
	 * @param receiveMsg
	 * @param sendMsg
	 * @return
	 */
	private String getResponseStr(ReceiveMsg receiveMsg,KeyMsg sendMsg){
		StringBuffer bf = new StringBuffer("<xml><ToUserName><![CDATA[");
		bf.append(receiveMsg.getFromUserName()+"]]></ToUserName><FromUserName><![CDATA[");
		bf.append(receiveMsg.getToUserName()  +"]]></FromUserName><CreateTime>12345678</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[");
		bf.append(sendMsg.getContent()+"]]></Content></xml>");
		return bf.toString();
	}

}
