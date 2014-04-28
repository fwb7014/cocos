package com.wyx.service.msg;

import org.springframework.scheduling.annotation.Async;

import com.wyx.dto.receive.ReceiveMsg;
/**
 * 异步处理类
 * @author Administrator
 *
 */
public abstract class CommonMsgHandler implements MsgHandler {
	/**
	 * 处理普通的消息
	 * @param msg
	 */
	@Async
	public void handleGenMsg(ReceiveMsg msg){
		
	}
}
