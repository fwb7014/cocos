package com.wyx.service.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.wyx.dao.IkeyWord;
import com.wyx.dto.KeyMsg;

@Component
public class KeyWorkUtil {
	private static final Logger logger = Logger.getLogger(KeyWorkUtil.class);

	@Autowired
	private IkeyWord keyWord;

	private ConcurrentHashMap<String, KeyMsg> keyMap = new ConcurrentHashMap<String, KeyMsg>();

	public void init() {
		Map<String, KeyMsg> tempMap = new HashMap<String, KeyMsg>();
		List<KeyMsg> list = keyWord.findAllKeyMsg();
		for (int i = 0; list != null && i < list.size(); i++) {
			tempMap.put(list.get(i).getKey_word(), list.get(i));
		}

		if (keyMap != null && keyMap.size() > 0) { // 先清空
			keyMap.clear();
		}
		logger.info(" 共有多少个关键字 " + tempMap.size());
		keyMap.putAll(tempMap);
	}

	/**
	 * 根据消息获得返回的内容
	 * 
	 * @param keyWord
	 * @return
	 */
	public KeyMsg getKeyMsgByKeyWord(String keyWord) {
		init(); // 目前每次都会刷新缓存
		if (StringUtils.isEmpty(keyWord)) {
			keyWord = "all";
		}
		KeyMsg result = keyMap.get(keyWord);
		if (result == null) {
			result = keyMap.get("all");
		}
		return result;
	}

}
