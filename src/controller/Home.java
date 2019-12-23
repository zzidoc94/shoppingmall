package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import service.MemberMM;
import service.ProductMM;
@WebServlet({"/orderPrint","/cart","/menu","/newItem","/bestItem","/access","/logout","/joinfrm","/proupfrm","/insertproduct","/orderinsert"})
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String cmd=request.getServletPath();
		Forward fw=null;
		MemberMM mm=new MemberMM(request,response);
		ProductMM pm=new ProductMM(request,response);
		
		if(cmd.equals("/access")) {
			fw=mm.access();
		}else if(cmd.equals("/menu")) {
			fw=new Forward();
			fw.setPath("menu.jsp");
			fw.setRedirect(false);
		}else if(cmd.equals("/newItem")) {
			fw=pm.getItemList("new");
		}else if(cmd.equals("/bestItem")) {
			fw=pm.getItemList("best");
		}else if(cmd.equals("/logout")) {
			fw=mm.logout();
		}else if(cmd.equals("/proupfrm")) {
			fw=new Forward();
			fw.setPath("product/proupform.jsp");
			fw.setRedirect(false);
		}else if(cmd.equals("/insertproduct")) {
			fw=pm.insertproduct();
		}else if (cmd.equals("/cart")) {
			fw=pm.printCart();
		
		}else if (cmd.equals("/orderPrint")) {
	         fw=pm.purchasePrint();
	      }else if(cmd.equals("/orderinsert")) {
	    	  fw=pm.orderinsert();
	    	  System.out.println(request.getParameter("data"));
	      }
	     
		
		
		
		if(fw!=null) {
			if(fw.isRedirect()) {
				response.sendRedirect(fw.getPath());
			}else {
				RequestDispatcher dis= request.getRequestDispatcher(fw.getPath());
				dis.forward(request, response);
			}
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
