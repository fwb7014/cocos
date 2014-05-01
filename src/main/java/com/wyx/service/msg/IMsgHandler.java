package com.wyx.service.msg;

import javax.servlet.http.HttpServletRequest;

import com.wyx.dto.KeyMsg;
import com.wyx.model.receive.ReceiveMsg;
import com.wyx.model.send.SendMsg;

/**
 * 消息
 * 
 * @author Administrator
 *
 */
public interface IMsgHandler {

	/**
	 * 接受消息
	 * 
	 * @param msg
	 */
	public String getSendMsgFromReceive(ReceiveMsg msg);

	/**
	 * 处理消息 具体消息 具体处
	 * 
	 * @param receiveMsg
	 *            接受的消息
	 * @param sendMsg
	 *            待回复的消息
	 */
	public String handleReceiveMsg(ReceiveMsg receiveMsg, KeyMsg sendMsg);

	/**
	 * 获取消息处理器支持的类型
	 * 
	 * @return
	 */
	public String getMsgHandlerType();

	/**
	 * 主动发送消息
	 * 
	 * @param url
	 * @param sendMsg
	 */
	public void sendMsg(String url, SendMsg sendMsg);
	
	/**
	 * 拼装要发送的消息
	 * @param url
	 * @param request
	 * @return
	 */
	public SendMsg getSendMsg(HttpServletRequest request);
}
