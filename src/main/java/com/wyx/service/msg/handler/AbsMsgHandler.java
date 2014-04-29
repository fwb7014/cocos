package com.wyx.service.msg.handler;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.wyx.dto.KeyMsg;
import com.wyx.dto.receive.ReceiveMsg;
import com.wyx.service.msg.IMsgSender;
import com.wyx.web.support.KeyWorkUtil;

/**
 * 通用的消息处理类
 */
@Component
public abstract class AbsMsgHandler implements IMsgSender {

	private static final Logger logger = Logger.getLogger(TextMsgHandler.class);

	@Autowired
	private KeyWorkUtil keyWorkUtil;

	/**
	 * 获取消息处理器支持的类型
	 * 
	 * @return
	 */
	public abstract String getMsgHandlerType();

	/**
	 * 处理消息
	 * 
	 * @param msg
	 */
	@Async
	public abstract void handleMsg(KeyMsg keyMsg);
	

	@Override
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
