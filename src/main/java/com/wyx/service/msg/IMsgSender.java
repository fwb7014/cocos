package com.wyx.service.msg;

import com.wyx.dto.receive.ReceiveMsg;

/**
 * 回复消息
 * @author Administrator
 *
 */
public interface IMsgSender {
	public void doMsgSender(ReceiveMsg msg);
}
