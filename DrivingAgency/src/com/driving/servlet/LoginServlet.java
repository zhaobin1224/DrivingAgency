package com.driving.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.Base64;
import com.driving.Service.Service;
import com.driving.User.Agency;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=utf-8");
	     response.setHeader("Access-Control-Allow-Origin", "*");
	     response.setHeader("Access-Control-Allow-Origin", "GET,POST");
	     request.setCharacterEncoding("UTF-8");
	     
	   /* BufferedReader reader=new BufferedReader(new InputStreamReader(request.getInputStream()));
	     System.out.println(reader.readLine());*/
         String agent_name = request.getParameter("agent_name");
         String agent_passwd = request.getParameter("agent_passwd");
         String code = request.getParameter("code");
         System.out.println(code);
         

         
         Agency agency = new Agency();
         agency.setAgent_name(agent_name);
         agency.setAgent_passwd(agent_passwd);
         
         Service service = new Service();
         System.out.println(request.getSession());
         
         Boolean is_bind = false;
         
         try {
			List<Agency> list = service.Login(agency);
			if(list != null) {
				is_bind=true;
				}
			/*JSONArray jsonArray = (JSONArray) JSON.toJSON(list);
			for(int i = 0;i<jsonArray.size();i++) {
			  response.getWriter().println(jsonArray.getJSONObject(i));
			}*/
			Map<String,Object> map =new HashMap<String,Object>();
			map.put("agent_name",agent_name );
			map.put("is_bind", is_bind);
		    String uuid = UUID.randomUUID().toString();
		    map.put("token", uuid);
		    request.getSession().setAttribute("token", uuid);
		    request.getSession().setAttribute(uuid, agent_name);
			JSONObject dJsonObject = JSONObject.parseObject(JSON.toJSONString(map));
			response.getWriter().println(dJsonObject);
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
			//response.getWriter().println("用户名或密码错误！");
			response.getWriter().flush();
		}finally{
			response.getWriter().close();
		}
         
         
	}
	
	
	
}
