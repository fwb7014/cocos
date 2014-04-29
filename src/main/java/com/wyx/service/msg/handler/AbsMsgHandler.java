package com.wyx.service.msg.handler;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.wyx.dto.KeyMsg;
import com.wyx.dto.receive.ReceiveMsg;
import com.wyx.service.msg.IMsgSender;
import com.wyx.service.support.KeyWorkUtil;

/**
 * 通用的消息处理类
 */
public abstract class AbsMsgHandler implements IMsgSender {
	
	public AbsMsgHandler(){
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}

	private static final Logger logger = Logger.getLogger(TextMsgHandler.class);

	@Autowired
	private KeyWorkUtil keyWorkUtil;

	// 公共
	public void doMsgSender(ReceiveMsg msg) {
		logger.info("收到消息" + ToStringBuilder.reflectionToString(msg));
		KeyMsg keyMsg = keyWorkUtil.getKeyMsgByKeyWord(msg.getContent());
		if (keyMsg != null) {
			handleMsg(keyMsg);
		} else {
			logger.info("ReceiveMsg=" + ToStringBuilder.reflectionToString(msg)
					+ " 没有找到可用的关键字");
		}
	}

}
