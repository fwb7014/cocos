package com.wyx.dto.receive;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class ReceiveMsg {
	@XStreamAlias("URL")
	private String url;
	@XStreamAlias("ToUserName")
	private String toUserName;
	@XStreamAlias("FromUserName")
	private String fromUserName;
	@XStreamAlias("CreateTime")
	private String createTime;
	@XStreamAlias("MsgType")
	private String msgType;
	@XStreamAlias("Content")
	private String content;
	@XStreamAlias("MsgId")
	private String msgId;
	@XStreamAlias("event")
	private String Event ;//subscribe(订阅)、unsubscribe(取消订阅)
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

}
