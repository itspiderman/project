package com.smeshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.smeshop.pojo.WXMessage;
import com.smeshop.util.CheckUtil;
import com.smeshop.util.Message;

/**
 * Servlet implementation class WeiXinServlet
 */
@WebServlet(description = "WeiXinServlet", urlPatterns = { "/servlet/WeiXinServlet" })
public class WeiXinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WeiXinServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// http://localhost:8080/smeshop/servlet/WeiXinServlet?signature=kevin&timestamp=20170814&nonce=none&echostr=Y
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		PrintWriter out = response.getWriter();
		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
			// Èç¹ûÐ£Ñé³É¹¦£¬½«µÃµ½µÄËæ»ú×Ö·û´®Ô­Â··µ»Ø
			out.print(echostr);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String str = null;
		try {
			// 将request请求，传到Message工具类的转换方法中，返回接收到的Map对象
			Map<String, String> map = Message.xmlToMap(request);
			// 从集合中，获取XML各个节点的内容
			String ToUserName = map.get("ToUserName");
			String FromUserName = map.get("FromUserName");
			String CreateTime = map.get("CreateTime");
			String MsgType = map.get("MsgType");
			String Content = map.get("Content");
			String MsgId = map.get("MsgId");
			if (MsgType.equals("text")) {// 判断消息类型是否是文本消息(text)
				WXMessage message = new WXMessage();
				message.setFromUserName(ToUserName);// 原来【接收消息用户】变为回复时【发送消息用户】
				message.setToUserName(FromUserName);
				message.setMsgType("text");
				message.setCreateTime(new Date().getTime());// 创建当前时间为消息时间
				message.setContent("您好，" + FromUserName + "\n我是：" + ToUserName
						+ "\n您发送的消息类型为：" + MsgType + "\n您发送的时间为" + CreateTime
						+ "\n我回复的时间为：" + message.getCreateTime() + "您发送的内容是"
						+ Content);
				str = Message.objectToXml(message); // 调用Message工具类，将对象转为XML字符串
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		out.print(str); // 返回转换后的XML字符串
		out.close();
	}

}
