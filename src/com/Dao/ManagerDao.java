package com.Dao;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.bean.Book;
import com.bean.Hotbook;
import com.bean.Manager;
import com.bean.Newbook;
import com.bean.Orders;
import com.bean.Shopcur;
import com.bean.User;
import com.bean.kind;
import com.bean.Address;
import com.bean.Shopcur;

public interface ManagerDao {
	/////////管理员
	public boolean select(String username,String password);
	public List<Manager> AllselectManager();
	public boolean Managerjia(Manager manager);
	///////////图书
	public List<Book> AllselectBook();
	public Book selectBookById(Integer id);
	public boolean updatebook(Book book);
	public boolean deleteBook(Integer id);
	public boolean insertAbook(Book book);
	///////////////热门图书
	public List<Hotbook> AllhotBook();
	public boolean deleteAhotbook(Integer id);
	public boolean insertAhotbook(int bookId);
	/////////////////最新商品
	public List<Newbook> AllnewBook();
	public boolean deleteAnewbook(Integer id);
	public boolean insertAnewbook(int bookId);
	////////////图书种类
	public List<Book> findBookbyname(String name);
	public List<kind> Allselectkind();
	public boolean deletekind(Integer id);
	public boolean insertAkind(kind akind);
	//////////////////用户
	public List<User> AllselectUser();
	public boolean deleteUser(Integer id);
	//////////////////订单
	public List<Orders> AllselectOrders();
	public List<User> findordersbyname(String name);
	public boolean deleteOrders(Integer id);
	//////////////
	public List<kind> findAkindbyid(Integer id);
	/////////////
	public List<Book> Allselectbook();
	public List<Book> selectAbookbyid(Integer id);
	//////////////////////////
	public boolean jiaShopcur(int i,String bookId,String num);
	public boolean userLogin(String auser,String password,HttpServletRequest request);
	public List<Shopcur> Allselectshopcur(int i);
	public boolean deleteAshopcur(Integer id);
	public boolean deleteAllshopcur(int i);
	/////////////////////////////
	public boolean jiaOrders(int i,List<Shopcur> shopcur);
	public List<User> OrdersList(int i);
	public boolean jiaAddress(Address address);
	public boolean insertUser(User user);
	///////////////////
	public List<Hotbook> AllselectHotbook();
	public List<Newbook> AllselectNewbook();
	//////////////////////////
	public List<Book> findAbook(String name);
	public boolean deleteAordersbyId(Integer id);
	public List<Shopcur> findAshopcur(int userId,int bookId);
	public List<User> selectBuser(Integer i);    	
}
