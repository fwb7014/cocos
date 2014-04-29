package com.wyx.service.msg;

import org.springframework.scheduling.annotation.Async;

import com.wyx.dto.KeyMsg;
import com.wyx.dto.receive.ReceiveMsg;

/**
 * 回复消息
 * @author Administrator
 *
 */
public interface IMsgSender {
	
	
	/**
	 * 接受消息
	 * @param msg
	 */
	public void doMsgSender(ReceiveMsg msg);
	
	/**
	 * 处理消息 具体消息 具体处理
	 * 
	 * @param msg
	 */
	@Async
	public void handleMsg(KeyMsg keyMsg);
	
	/**
	 * 获取消息处理器支持的类型
	 * 
	 * @return
	 */
	public String getMsgHandlerType();
}
