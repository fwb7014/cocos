package com.wyx.web.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import org.springframework.util.StringUtils;

public class SocketClient {
	public String sendSocketContent(String url, String content) {
		Socket socket = null;
		BufferedReader read = null;
		PrintStream print = null;
		try {
			socket = new Socket(InetAddress.getByName(url), 80);
			read = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			print = new PrintStream(socket.getOutputStream());
			if(!StringUtils.isEmpty(content))
				print.write(content.getBytes());
			StringBuffer result = new StringBuffer();
			String readline = null;
			while ((readline = read.readLine()) != null) {
				System.out.println(readline);
				result.append(readline);
			}
			return result.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "" ;
		} finally {
			if (read != null) {
				try {
					read.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (print != null) {
				print.close(); // 关闭Socket输入流
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				} // 关闭Socket
			}

		}
	}
}