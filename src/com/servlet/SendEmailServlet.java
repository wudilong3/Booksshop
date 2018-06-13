package com.servlet;


import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class SendEmailServlet
 */
@WebServlet("/SendEmailServlet")
public class SendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String toemail = request.getParameter("email");
		//设置邮件服务器的参数
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.163.com");
		props.put("mail.smtp.auth", "true");
		//建立与邮箱服务器之间的连接，使用用户名和授权码
		Session session = Session.getInstance(props,new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() { 
				return new PasswordAuthentication("15176047392@163.com", "mnilzz123");
				}

		});
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("15176047392@163.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toemail));

			
			message.setSubject("激活账号");
			message.setText("您的密码已经初始化是：123456");
			MimeBodyPart mimeBodyPart =new MimeBodyPart();
			mimeBodyPart.setContent("请激活账号<a href='http://localhost:8080/JavaMaildemo/denglu.jsp'>激活</a>","text/html;charset=UTF-8");
	

			
			
			MimeMultipart mimeMultipart = new MimeMultipart();
			mimeMultipart.addBodyPart( mimeBodyPart);
			message.setContent(mimeMultipart);

			Transport.send(message);
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		response.setContentType("text/html");
//		response.getWriter().write("<html>邮件发送成功！");
		request.getRequestDispatcher("index.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
