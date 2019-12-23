package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import service.MemberMM;
import service.ProductMM;


@WebServlet({"/ajaxDetail","/cartinsert"})
public class RestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getServletPath();
		Forward fw=null;
		int flag=0;
		MemberMM mm=new MemberMM(request,response);
		ProductMM pm = new ProductMM(request, response);
		String json = null;
		if(cmd.equals("/ajaxDetail")) {
			json = pm.getAjaxDetail();
			//System.out.println(request.getParameter("pCode"));
		}
		else if(cmd.equals("/cartinsert")) {
			flag = pm.insertCart();
			//System.out.println(request.getParameter("pCode"));
		}
		if(flag!=0) {	//성공
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			System.out.println("flag:"+flag);
			out.write("{\"a\":\"1\"}");
		}
		if(json!=null) {
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.write(json);
		}
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
