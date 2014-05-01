package com.wyx.service.msg.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.wyx.dto.KeyMsg;
import com.wyx.model.receive.ReceiveMsg;
import com.wyx.model.send.SendMsg;
import com.wyx.web.util.HttpClientUtil;
@Component
public class EventMsgHandler extends AbsMsgHandler {
	private static final Logger logger = Logger.getLogger(EventMsgHandler.class);
	
	/**
	 * 处理事件消息
	 * 
	 * @param msg
	 */

	@Override
	public String getMsgHandlerType() {
		return "event";
	}

	@Override
	public String handleReceiveMsg(ReceiveMsg receiveMsg,KeyMsg sendMsg) {
		// 现在开始处理消息
		String responseMsg = getResponseStr(receiveMsg,sendMsg);
		logger.info("回复内容"+responseMsg);
		return responseMsg;
		
	}
	
	
	/**
	 * 拼接返回的内容
	 * @param receiveMsg
	 * @param sendMsg
	 * @return
	 */
	private String getResponseStr(ReceiveMsg receiveMsg,KeyMsg sendMsg){
		StringBuffer bf = new StringBuffer("<xml><ToUserName><![CDATA[");
		bf.append(receiveMsg.getFromUserName()+"]]></ToUserName><FromUserName><![CDATA[");
		bf.append(receiveMsg.getToUserName()  +"]]></FromUserName><CreateTime>12345678</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[");
		bf.append(sendMsg.getContent()+"]]></Content></xml>");
		return bf.toString();
	}
	
	

	
	@Override
	public void sendMsg(String url, SendMsg sendMsg) {
		if(sendMsg == null)
			return ;
		logger.info("发送消息返回的结果"+HttpClientUtil.sendPostRequestBlock(url,  ((EventSendMsg)sendMsg).getJson()));
	}
	
	/**
	 * 主动发送的消息
	 * @author Administrator
	 *
	 */
	class EventSendMsg extends SendMsg{
		String touser;
		String msgtype="event";
		String content;
		public EventSendMsg(String touser, String content) {
			super();
			this.touser = touser;
			this.content = content;
		}
		public String getJson(){
			return "{\"touser\":\""+touser+"\",\"msgtype\":\"text\",\"text\":{\"content\":\""+content+"\"}}";
		}
	}

	@Override
	public SendMsg getSendMsg(HttpServletRequest request) {
		String touser=request.getParameter("touser");
		String content=request.getParameter("content");
		return new EventSendMsg(touser,content);
	}

}
