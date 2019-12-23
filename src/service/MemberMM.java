package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;
import dao.MemberDao;

public class MemberMM {
	HttpServletRequest request;
	HttpServletResponse response;

	public MemberMM(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Forward access() {
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		MemberDao mDao=new MemberDao();
		int result=mDao.access(id,pw); //1이면 성공 ,0이면 아이디 오류 ,-1이면 비밀번호 오류 
		mDao.close();
		if(result==0) {
			request.setAttribute("msgAccess","id가 존재하지 않습니다");
		
		}else if(result==-1) {
			request.setAttribute("msgAccess","비밀번호가 존재하지 않습니다");
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("id",id);
		}
		Forward fw=new Forward();
		fw.setPath("index.jsp"); //= ("./") 같은 뜻
		fw.setRedirect(false);
		return fw;
	}

	public Forward logout() {
		Forward fw = new Forward();
		HttpSession session = request.getSession();
		session.invalidate();
		fw.setPath("index.jsp");
		fw.setRedirect(true);
		return fw;
	}
	
}
