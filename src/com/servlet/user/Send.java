package com.servlet.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.util.MsgCode;

import redis.clients.jedis.Jedis;



/**
 * 发送短信验证码
 *@author FFFF
 *
 */
@WebServlet(name="Send",urlPatterns={"/Send"})
public class Send extends HttpServlet {
	
	private static final long serialVersionUID = -373318473462955835L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String phone = request.getParameter("phone");
		
		
		response.setContentType("application/text");
		response.setCharacterEncoding("utf-8");
		
		
		if(phone != null && !"".equals(phone)){
			
			if(11 == phone.length()){
				
				String code = MsgCode.rendom();
				
				
				PrintWriter out = null;
				BufferedReader in = null;
				String result = "";
				
				
				URL url = new URL("http://121.43.192.197:8888/sms.aspx");
				URLConnection httpConn = url.openConnection();
				httpConn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
				
				
				httpConn.setDoOutput(true);
				httpConn.setDoInput(true);
				httpConn.setUseCaches(false);
				
				
				out = new PrintWriter(httpConn.getOutputStream());
				out.print("action=send&userid=3303&account=giy20160909&password=123456&mobile="+phone+"&content=你好，你的验证码是"+code+"。10分钟内有效！【国健医疗】&sendTime=&extno=");
				out.flush();
				
				
				in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
	            String line;
	            
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	            
	            
				try {
					DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
					DocumentBuilder db = dbf.newDocumentBuilder();
					
					Document document = db.parse(new InputSource(new StringReader(result)));
					NodeList returnsms = document.getChildNodes();
					
					
					Map<String, String> map = new HashMap<String, String>();
					
					for(int i = 0;i < returnsms.getLength();i++){
						Node node = returnsms.item(i);
						NodeList nodeList = node.getChildNodes();
						
						for(int j = 0;j < nodeList.getLength();j++){
							Node nodeValue = nodeList.item(j);
							
							map.put(nodeValue.getNodeName(), nodeValue.getTextContent());
						}
					}
					//System.out.println(map);
					
					
					if("ok".equals(map.get("message"))){
						
						@SuppressWarnings("resource")
						Jedis jedis = new Jedis("127.0.0.1", 6379);
						jedis.set(phone, code);
						
						response.getWriter().print(0);
					}else{
						response.getWriter().print(2);
					}
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
					response.getWriter().print(2);
				} catch (SAXException e) {
					e.printStackTrace();
					response.getWriter().print(2);
				}
				
			}else{
				response.getWriter().print(1);//手机号格式不对
			}
		}else{
			response.getWriter().print(1);//手机号不能为空
		}
	}
	
	
	
}
