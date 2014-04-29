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
	public String getSendMsg(ReceiveMsg msg);
	
	/**
	 * 处理消息 具体消息 具体处
	 * @param receiveMsg   接受的消息
	 * @param sendMsg      待回复的消息
	 */
	public String handleMsg(ReceiveMsg receiveMsg,KeyMsg sendMsg);
	
	/**
	 * 获取消息处理器支持的类型
	 * 
	 * @return
	 */
	public String getMsgHandlerType();
}
