package com.wyx.dao;

import java.util.List;

import com.wyx.dto.KeyMsg;
/**
 * 关键字以及回复内容
 * @author Administrator
 *
 */
public interface IkeyWord {
	public List<KeyMsg> findAllKeyMsg();
}
