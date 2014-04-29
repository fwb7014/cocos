package com.wyx.dto;

/**
 * 关键字以及回复内容
 * 
 * @author Administrator
 * 
 */
public class KeyMsg {
	private String key_word;
	private long source_id;
	private String content;
	private int media_id;
	private int img_id;
	private String content_type; // 回复内容的类型

	public String getKey_word() {
		return key_word;
	}

	public void setKey_word(String key_word) {
		this.key_word = key_word;
	}

	public long getSource_id() {
		return source_id;
	}

	public void setSource_id(long source_id) {
		this.source_id = source_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMedia_id() {
		return media_id;
	}

	public void setMedia_id(int media_id) {
		this.media_id = media_id;
	}

	public int getImg_id() {
		return img_id;
	}

	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}

	public String getContent_type() {
		return content_type;
	}

	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}
}
