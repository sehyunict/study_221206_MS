package sehyunict.admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AdminInterceptor implements HandlerInterceptor {

	
	 @Override
	 public boolean preHandle(HttpServletRequest req,HttpServletResponse res, Object obj) throws Exception {
	  
	  HttpSession session = req.getSession();
	  String member_Id = (String) session.getAttribute("adminId");
	  
	  if(member_Id == null || !member_Id.equals("admin")) {
		  
	   res.sendRedirect("/admin");
	   
	   return false;
	   
	  }
	  
	  return true;
	  
	 }
		
}
