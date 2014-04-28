package com.wyx.service.msg;

import com.wyx.dto.receive.ReceiveMsg;

/**
 * 接受的消息的处理类
 * 
 * @author Administrator
 *
 */
public interface IMsgHandler {
	/**
	 * 处理普通的消息
	 * 
	 * @param msg
	 */
	public void handleGenMsg(String msg);
}
