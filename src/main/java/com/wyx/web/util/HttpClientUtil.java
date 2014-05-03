package com.wyx.web.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
	
	
	/**
	 * post 请求
	 * 
	 * @param url
	 *            请求的地址
	 * @param content 内容块
	 * @return 返回的string 内容
	 */
	public static String sendPostRequestBlock(String url, String content) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		
		try {
			httppost.setEntity(new StringEntity(content,ContentType.create("text/plain", "UTF-8")));
			HttpResponse response;
			response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
			}else{
				System.out.println("httpclient 返回的HttpEntity 为null");
			}
			return EntityUtils.toString(entity, "UTF-8");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			httpclient.getConnectionManager().shutdown();
		}
		return "";
	}
	

	/**
	 * post 请求
	 * 
	 * @param url
	 *            请求的地址
	 * @param params
	 *            参数集合
	 * @return 返回的string 内容
	 */
	public static String sendPostRequest(String url, Map<String, String> params) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		// 创建参数队列
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			formparams.add(new BasicNameValuePair(entry.getKey(), entry
					.getValue()));
		}

		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);
			HttpResponse response;
			response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
			}else{
				System.out.println("httpclient 返回的HttpEntity 为null");
			}
			return EntityUtils.toString(entity, "UTF-8");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			httpclient.getConnectionManager().shutdown();
		}
		return "";
	}

	/**
	 * get 请求
	 * @param url
	 * @return
	 */
	public static String sendGetRequest(String url) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);

		try {
			HttpResponse response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
			}
			return EntityUtils.toString(entity, "UTF-8");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			httpclient.getConnectionManager().shutdown();
		}
		return "";
	}

}
