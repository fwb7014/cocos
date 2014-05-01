package com.wyx.service.msg;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wyx.model.receive.MessageType;
import com.wyx.model.send.SendMsg;
import com.wyx.service.support.AccessTokenUtil;
import com.wyx.web.msg.MsgController;
import com.wyx.web.util.WebProperties;

/**
 * 消息处理的服务层
 * 
 * @author Administrator
 *
 */
@Service
public class MsgService {
	private static final Logger logger = Logger.getLogger(MsgService.class);
	
	/**
	 * 主动推送消息 开发者在一段时间内（目前修改为48小时）可以调用客服消息接口
	 * 
	 * @param msgHandler
	 * @param sendMsg
	 */
	public void sendMsg(IMsgHandler msgHandler, SendMsg sendMsg) {
		// 主动发送消息的地址
		String sendMsgUrl = WebProperties
				.getSendMsgUrl(AccessTokenUtil.myAccessToken);

		if (msgHandler != null && sendMsg != null) {
			msgHandler.sendMsg(sendMsgUrl, sendMsg);
		}else{
			logger.info("消息不完整");
			
		}
	}
}
