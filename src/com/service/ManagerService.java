package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.ManagerDao;
import com.bean.Book;
import com.bean.Hotbook;
import com.bean.Manager;
import com.bean.Newbook;
import com.bean.Orders;
import com.bean.User;
import com.bean.kind;
import com.bean.Address;
import com.bean.Shopcur;


@Service
public class ManagerService {
	@Autowired
	private ManagerDao managerDao;

	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	/////////////////最新商品
	public List<Newbook> SNewbook(){
		List<Newbook> h=managerDao.AllnewBook();
		return h;
	}
	
	public boolean dNewbook(Integer id) {
		boolean b=managerDao.deleteAnewbook(id);
		return b;
	}
	
	public boolean iNewbook(int bookId) {
		boolean b=managerDao.insertAnewbook(bookId);
		return b;
	}
	////////////////热门图书
	public List<Hotbook> SHotbook(){
		List<Hotbook> h=managerDao.AllhotBook();
		return h;
	}
	
	public boolean dHotbook(Integer id) {
		boolean b=managerDao.deleteAhotbook(id);
		return b;
	}
	
	public boolean iHotbook(int bookId) {
		boolean b=managerDao.insertAhotbook(bookId);
		return b;
	}
	///////////////////////////////订单
	public boolean dOrders(Integer id) {
		boolean b=managerDao.deleteOrders(id);
		return b;
	}
	
	public List<User> findordersby(String name){
		List<User> u=managerDao.findordersbyname(name);
		return u;
	}
	
	public List<Orders> SOrders(){
		List<Orders> b=managerDao.AllselectOrders();
		return b;
	}
	
	
	/////////////////////////////用户
	public List<User> SUser(){
		List<User> b=managerDao.AllselectUser();
		return b;
	}
	
	public boolean dUser(Integer id) {
		boolean b=managerDao.deleteUser(id);
		return true;
	}
	//////////////////////////////////////////图书种类
	public boolean dkind(Integer id) {		
		boolean b=managerDao.deletekind(id);
		return true;
	}
	
	public List<kind> Skind(){
		List<kind> b=managerDao.Allselectkind();
		return b;
	}

	public boolean ikind(kind akind) {
		boolean an=managerDao.insertAkind(akind);
		return true;
	}
	/////////////////////////////////////图书
	public List<Book> findBookby(String name) {
		List<Book> m=managerDao.findBookbyname(name);
		return m;
	}
	
	public boolean iBook(Book book) {
		boolean an=managerDao.insertAbook(book);
		return true;
	}
	
	public boolean dBook(Integer id) {		
		boolean b=managerDao.deleteBook(id);
		return true;
	}
	
	public boolean jBook(Book book) {
		boolean b=managerDao.updatebook(book);
		return true;
	}
	
	public List<Book> SBook(){
		List<Book> b=managerDao.AllselectBook();
		return b;
	}
	
	public List<User> QUser(Integer i){
		List<User> b=managerDao.selectBuser(i);
		return b;
	}
	
	public Book findBookId(Integer id) {
		Book book=managerDao.selectBookById(id);
		return book;
	}

	////////////////////////////////////管理员
	public boolean manDeng(String username,String password) {
		boolean m=managerDao.select(username, password);
		
		return m;
	}
	
	public List<Manager> SManager(){
		List<Manager> m=managerDao.AllselectManager();
		return m;
	}
	
	public boolean IManager(Manager manager) {
		boolean b=managerDao.Managerjia(manager);
		return true;}
		///////////////////////////////////////////////////////////
		public boolean iShopcur(int i, String bookId, String num) {
			boolean b=managerDao.jiaShopcur(i, bookId, num);
			return b;
		}
		/////////展示订单
		public List<Shopcur> showaOrders(int userId,int bookId) {
			List<Shopcur> s=managerDao.findAshopcur(userId, bookId);
			return s;
		}
		
		/////////取消订单
		public boolean dOrders1(Integer id) {
			boolean b=managerDao.deleteAordersbyId(id);
			return b;
		}
		
		//////////搜索商品
		public List<Book> SAbook(String name){
			List<Book> h=managerDao.findAbook(name);
			return h;
		}
		
		//////////////最新商品列表
		public List<Newbook> SNewbook1(){
			List<Newbook> h=managerDao.AllselectNewbook();
			return h;
		}
		
		//////////////热门商品列表
		public List<Hotbook> SHotbook1(){
			List<Hotbook> h=managerDao.AllselectHotbook();
			return h;
		}
		
		/////////////增加用户
		@Transactional
		public boolean jUser(User user) {
			boolean b=managerDao.insertUser(user);
			return b;
		}
		
		
		////////////////添加用户地址
		public boolean jAddress(Address address) {
			boolean b=managerDao.jiaAddress(address);
			return b;
		}
		
		/////////订单
		public List<User> SOrders(int i){
			List<User> u=managerDao.OrdersList(i);
			return u;
		}
		@Transactional
		public boolean jOrders(int i,List<Shopcur> shopcur) {
			boolean b=managerDao.jiaOrders(i, shopcur);
			return b;
		}
		
		///////购物车
		public List<Shopcur> SShopcur(int i){
			List<Shopcur> s=managerDao.Allselectshopcur(i);
			return s;
		}
		
		public boolean deleteAshopcur(Integer id) {
			boolean b=managerDao.deleteAshopcur(id);
			return b;
		}
		
		public boolean deleteAllshopcur(int i) {
			boolean b=managerDao.deleteAllshopcur(i);
			return b;
		}
		/////用户登录
		public boolean userLogin(String auser,String password,HttpServletRequest request) {
			boolean b=managerDao.userLogin(auser, password, request);
			return b;
		}
		
		////////////////书
		public List<Book> idSbook(Integer id){
			List<Book> b=managerDao.selectAbookbyid(id);
			return b;
		}
		
		public List<Book> Sbook(){
			List<Book> b=managerDao.Allselectbook();
			return b;
		}
		/////////////////////////种类
		public List<kind> Skind1(){
			List<kind> k=managerDao.Allselectkind();
			return k;
		}
		
		public List<kind> findAbook(Integer id){
			List<kind> k=managerDao.findAkindbyid(id);
			return k;
	}
}
