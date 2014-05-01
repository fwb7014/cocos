package com.wyx.web.msg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.wyx.model.receive.ReceiveMsg;
import com.wyx.model.send.SendMsg;
import com.wyx.service.DoFirstService;
import com.wyx.service.msg.IMsgHandler;
import com.wyx.service.msg.MsgService;

/**
 * 消息的处理类
 * 
 * @author Administrator
 * 
 */
@Controller
public class MsgController {

	private static final Logger logger = Logger.getLogger(MsgController.class);

	@Autowired
	private DoFirstService doFirst;

	@Autowired
	private List<IMsgHandler> handlers = new ArrayList<IMsgHandler>();
	
	@Autowired
	private MsgService msgService;

	/**
	 * 消息的处理器
	 */
	private XStream xstream;

	public void init() {
		xstream = new XStream(new DomDriver());
		xstream.processAnnotations(ReceiveMsg.class);
	}

	/**
	 * 开通的第一步 激活开发者模式
	 * 
	 * @param signature
	 * @param timestampba
	 * 
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	@ResponseBody
	@RequestMapping("receive.do")
	public void ktWinXin(HttpServletRequest request, Writer writer) {
		/*
		 * try { writer.write(doFirstService(request)); } catch (IOException e)
		 * { logger.error("发生异常",e); }
		 */

		StringBuilder sb = new StringBuilder();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					request.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

			logger.info("socket消息 " + sb.toString());
			ReceiveMsg receiveMsg = getReceiveMsg(sb.toString());
			for (IMsgHandler handle : handlers) {
				if (handle.getMsgHandlerType().equals(receiveMsg.getMsgType())) {
					writer.write(handle.getSendMsgFromReceive(receiveMsg));
					writer.flush();
					writer.close();
					return;
				}
			}
			logger.info("没有次消息的处理能力,消息的类型为 " + receiveMsg.getMsgType());
		} catch (Exception e) {
			logger.error("没有次消息的处理能力,消息为 " + sb.toString(), e);
		}
	}

	@ResponseBody
	@RequestMapping("sendMsg.do")
	public void sendMsg(HttpServletRequest request, String msgType) {
		for (IMsgHandler handle : handlers) {
			if (handle.getMsgHandlerType().equals(msgType)) {
				SendMsg sendMsg = handle.getSendMsg(request);
				msgService.sendMsg(handle, sendMsg);
				return ;
			}
		}
		logger.info("没有发送消息的处理能力,消息的类型为 " + msgType);
	}

	/**
	 * 解析参数
	 * 
	 * @param requestMsg
	 * @return
	 */
	private ReceiveMsg getReceiveMsg(String requestMsg) throws Exception {
		ReceiveMsg msg = (ReceiveMsg) xstream.fromXML(requestMsg);
		return msg;
	}

	/**
	 * 验证
	 * 
	 * @param request
	 * @return
	 */
	public String doFirstService(HttpServletRequest request) {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		logger.info("timestamp=" + timestamp + ",nonce=" + nonce + ",echostr="
				+ echostr + ",signature=" + signature);
		return doFirst.doFirstService(signature, timestamp, nonce, echostr);

	}

}
