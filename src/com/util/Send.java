package com.util;

import java.io.IOException;
import java.io.StringReader;
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

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String phone = req.getParameter("phone");
		
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		
		
		if(phone != null && !"".equals(phone)){
			
			if(11 == phone.length()){
				
				String code = MsgCode.rendom();
				
				
				OkHttpClient client = new OkHttpClient();
				MediaType MEDIA_TYPE = MediaType.parse("application/x-www-form-urlencoded;charset=utf-8");
				String postBody = "action=send&userid=3303&account=giy20160909&password=123456&mobile="+phone+"&content=你好，你的验证码是"+code+"。10分钟内有效！【国健医疗】&sendTime=&extno=";
				
				Request request = new Request.Builder()
			            .url("http://121.43.192.197:8888/sms.aspx")
			            .post(RequestBody.create(MEDIA_TYPE, postBody))
			            .build();

			    Response response = client.newCall(request).execute();
			    String result = response.body().string();
	            
	           
	            
	            
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
					//System.out.print(map);
					
					
					if("ok".equals(map.get("message"))){
						
						@SuppressWarnings("resource")
						Jedis jedis = new Jedis("127.0.0.1", 6379);
						jedis.set(phone, code);
						
						resp.getWriter().print(0);
					}else{
						resp.getWriter().print(2);
					}
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
					resp.getWriter().print(2);
				} catch (SAXException e) {
					e.printStackTrace();
					resp.getWriter().print(2);
				}
				
			}else{
				resp.getWriter().print(1);//手机号格式不对
			}
		}else{
			resp.getWriter().print(1);//手机号不能为空
		}
	}
	
	
	
}
