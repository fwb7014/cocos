package com.xyx.test;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;

import com.wyx.service.support.AccessTokenUtil;
import com.wyx.web.util.HttpClientUtil;

public class CommonTest {
	@Test
	public void test() {
		new AccessTokenUtil().getMyToken();
		//System.out.println(new SocketClient().sendSocketContent("www.baidu.com", "get"));
	}
	
	@Test
	public void testRequest(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("msgType", "text");
		map.put("touser", "oGup_twhtJvepWihFtGZMAT4Spgw");
		map.put("content", "你好范文博");
		HttpClientUtil.sendPostRequestBlock("http://localhost:8080/fanwb/sendMsg.do","范文博" );
	}
}
