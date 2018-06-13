<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ page import="java.util.*" %>
    	<%@ page import="com.bean.Hotbook" %>
    	<%@ page import="com.bean.Book" %>
    	<%@ page import="org.hibernate.Session" %>
    	<%@ page import="org.hibernate.Transaction" %>
    	<%@ page import="com.hibernate.hibernateUtil" %>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<title>BookShop</title>
<link type="text/css" rel="stylesheet" href="css/reset.css" />
<link type="text/css" rel="stylesheet" href="css/1024_768.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:861px) and (max-width:960px)" href="css/pad_heng.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:601px) and (max-width:860px)" href="css/pad.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:481px) and (max-width:600px)" href="css/tel_heng.css" />
<link type="text/css" rel="stylesheet" media="screen and (max-width:480px)" href="css/tel.css" />
</head>

<body>
<div class="w_100_l top_title">
	<div class="main">
    	<p><a href="#">Buy more than one book and save big! </a><a href="#">Read more</a></p>
    </div>
</div>

<div class="w_100_l">
	<div class="main">
      <div class="top_banner">
            <div class="top_logo"><img src="Images/top_logo.jpg" alt="A BOOK APART LOGO" /></div>
            <div class="top_menu">
            	<ul>
                	<li class="sel"><a href="index.jsp">首页</a></li>
                	<li><a href="#">开始</a></li>
                	<li><a href="#">新闻</a></li>
                	<li><a href="gerenxinxi.do">个人信息</a></li>
                	<li><a href="error.jsp">登录/注册</a></li>
                </ul>
            </div>
            <div class="top_shop_cur"><a href="shopcurList.do"><img src="Images/top_shop_cur.jpg" alt="shopping car" /></a></div>
        </div>
        <span class="index_img"><img src="Images/banner_img.jpg" alt="Dan Cederholm" border="0" usemap="#Map" />
        <map name="Map" id="Map">
          <area shape="rect" coords="857,230,930,269" href="#" alt="buy now" />
        </map>
        </span>
 
        

        <p class="index_hr"></p>
      <div class="content">
            <h1 class="h1_book_title">Also from A Book Apart</h1>
            <%
            	int i=0;
            	List<Hotbook> asd=(List<Hotbook>)request.getAttribute("hotbooklist");
            %>
                      <table border="1">
                <tr><th>图书ID&nbsp;&nbsp;</th>
				<th>图书名&nbsp;&nbsp;单价</th>
				<th>&nbsp;&nbsp;BUY</th></tr>
				<c:forEach items="${hotbooklist}" var="hot">
				<tr>
				<td>${hot.bookId}&nbsp;&nbsp;</td>
				<td>
					<%
					Session se = hibernateUtil.openSession();
			        Transaction tran = se.beginTransaction();
			        Book b=se.get(Book.class, asd.get(i).getBookId());
			        %>
			        	<%=b.getName() %>&nbsp;&nbsp;<%=b.getPrice() %>
			        <% 
			        tran.commit();
			        se.close();
			        i++;
					%>
				</td>
				<td>
					&nbsp;&nbsp;<a href="Bookbuy.do?id=${hot.bookId}">BUY</a>
				</td>
				</tr>
				</c:forEach>
				</table>
      </div>
        <p class="index_hr"></p>
        <div class="content_press">
        	<div class="press_porsen_01">
                <h1>Press Room</h1>
            	<dl>
                	<dd><img src="Images/img_men.jpg" alt="person" /></dd>
                    <dt>
                    	<p class="date">Apr 03, 2014</p>
                        <p class="book_title"><a href="#" target="_blank">Design Is a Job audiobook</a></p>
                        <p class="book_intro">
                        We’re pleased to announce that <a href="#">Design Is a Job</a> by Mike Monteiro is now available in audiobook format, through <a href="#">Audible.com</a> and <a href="#">Amazon.com</a>. Narrated by the raconteur himself, experience the guidance, real-talk, and humor of our seminal book on design as a job.
                        </p>
                    </dt>
                </dl>
            </div>
            <div class="press_porsen_02">
                <h1><span class="span_2"><a href="#"> More Articles →</a></span><span class="span_1"><a href="#">Press Room RSS</a></span></h1>
            	<dl>
                	<dd><img src="Images/img_lives.jpg" alt="book img" /></dd>
                    <dt>
                    	<p class="date">Mar 31, 2014</p>
                        <p class="book_title"><a href="#" target="_blank">A Few of Our Faves: March 31st</a></p>
                        <p class="book_intro">
                        As the madness of March comes to a close, we gathered up a few things that caught our attention during the last half of the month. <a href="#">Read on for more.</a>                        </p>
                    </dt>
                </dl>
            </div>
        </div>
        <p class="index_hr"></p>
        <h1 class="news_title">Newsletter</h1>
        <p class="news_title_1"><span class="span_1">Keep up to date with new book releases and announcements with our newsletter.</span><span class="span_2"><img src="Images/img_inp.jpg" /></span></p>
        <p class="index_hr" style="margin-top:20px;"></p>
        <div class="footer">
           <span class="span_1">&copy; Copyright 2014, A Book Apart, LLC</span>&nbsp;&nbsp;
            <a href="#">Help & Contact us</a>
            <a class="a1" href="#">Press Room RSS feed</a>
            <a class="a2" href="#">abookapart on Twitter</a>
            <span class="span_2"><b>Published by</b><img src="Images/icon_hg.jpg" align="absmiddle" /></span>
        </div>
    </div>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>