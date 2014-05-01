package com.wyx.service.msg.handler;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyx.dto.KeyMsg;
import com.wyx.model.receive.ReceiveMsg;
import com.wyx.service.msg.IMsgHandler;
import com.wyx.service.support.KeyWorkUtil;

/**
 * 通用的消息处理类
 */
public abstract class AbsMsgHandler implements IMsgHandler {

	private static final Logger logger = Logger.getLogger(TextMsgHandler.class);

	@Autowired
	private KeyWorkUtil keyWorkUtil;

	// 公共
	@Override
	public String getSendMsgFromReceive(ReceiveMsg receiveMsg) {
		logger.info("收到消息" + ToStringBuilder.reflectionToString(receiveMsg));
		KeyMsg sendMsg = keyWorkUtil
				.getKeyMsgByKeyWord(receiveMsg.getContent());
		if (sendMsg != null) {
			return handleReceiveMsg(receiveMsg, sendMsg);
		} else {
			logger.info("ReceiveMsg="
					+ ToStringBuilder.reflectionToString(receiveMsg)
					+ " 没有找到可用的关键字");
			return null;
		}
	}

}
