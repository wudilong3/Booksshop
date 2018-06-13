package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Dao.ManagerDao;
import com.bean.User;
import com.hibernate.hibernateUtil;

/**
 * Servlet implementation class AjaxDemo1
 */
@WebServlet("/AjaxDemo1")
public class AjaxDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("name");  
        response.setCharacterEncoding("utf-8"); 
        List<User> u=null;
    	Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Query query = session.createQuery("from User where name=?");
        query.setParameter(0, userName);
        List<User> an = query.list();
        tran.commit();
        session.close();
        if(an.size()>0) {
        	response.getWriter().write("<font color='red'>用户名已存在</font>");  
            return; 
        }
        if(an.size()==0) {
        	 response.getWriter().write("<font color='green'>用户名可用</font>");  
             response.getWriter().flush();  
        }
        
	}

}
