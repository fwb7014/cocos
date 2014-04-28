package com.wyx.service.msg;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.wyx.dto.receive.ReceiveMsg;
import com.wyx.web.ReceiveController;

/**
 * 异步处理类
 * 
 * @author Administrator
 *
 */
@Service
public class SimpleMsgHandler implements IMsgHandler {
	private static final Logger logger = Logger
			.getLogger(SimpleMsgHandler.class);
	/**
	 * 消息的处理器
	 */
	private XStream genMsgStream;

	public void init() {
		genMsgStream = new XStream(new DomDriver());
		genMsgStream.processAnnotations(ReceiveMsg.class);
	}

	/**
	 * 处理普通的消息
	 * 
	 * @param msg
	 */
	@Async
	public void handleGenMsg(String receiveMsg) {
		ReceiveMsg msg = (ReceiveMsg) genMsgStream.fromXML(receiveMsg);
		logger.info("解析得到的实体"+ToStringBuilder.reflectionToString(msg));
	}
}
