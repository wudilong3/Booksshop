package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bean.Address;
import com.bean.User;
import com.hibernate.hibernateUtil;

public class MyInterceptor2 extends HandlerInterceptorAdapter{
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion方法被执行");
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		boolean aaa=false;
		System.out.println("postHandleaaaaaaaaaaaaa方法被执行");
		int i=(int)request.getSession().getAttribute("user");
		Session session = hibernateUtil.openSession();
	    Transaction tran = session.beginTransaction();
	    User u=session.get(User.class, i);
	    tran.commit();
	    session.close();
	    Address s=u.getAddress();
	    if(s==null) {
	    	response.sendRedirect(request.getContextPath()+"/jiaAddress.jsp");
	    }
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle方法被执行aaaaaaaaaa");
		return true;
}
}