package com.Dao;





import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bean.Address;
import com.bean.Book;
import com.bean.Hotbook;
import com.bean.Manager;
import com.bean.Newbook;
import com.bean.Orders;
import com.bean.Shopcur;
import com.bean.User;
import com.bean.kind;
import com.hibernate.hibernateUtil;
@Repository 
public class ManagerDaoImpl implements ManagerDao{

///////////////////////管理员	
	@Override
	public boolean select(String username,String password) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Manager where name=? and password=?");
        query.setParameter(0, username);
        query.setParameter(1, password);
        List<Manager> an = query.list();
        tran.commit();
        session.close();
        if(an.size()>0) {
        	return true;
        }else {
        	return false;
        }
		
	}

	@Override
	public List<Manager> AllselectManager() {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Query query = session.createQuery("from Manager");
        List<Manager> an = query.list();
        tran.commit();
        session.close();
		return an;
	}

	@Override
	public boolean Managerjia(Manager manager) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Manager m=new Manager();
        m.setManagerId(manager.getManagerId());
        m.setName(manager.getName());
        m.setPassword(manager.getPassword());
        session.save(m);
        tran.commit();
        session.close();
		return true;
	}
//////////////////////////////////////////////////图书
	@Override
	public List<Book> AllselectBook() {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Query query = session.createQuery("from Book");
        List<Book> an = query.list();
        tran.commit();
        session.close();
		return an;
	}

	@Override
	public Book selectBookById(Integer id) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Query query = session.createQuery("from Book where bookId=?");
        query.setParameter(0, id);
        List<Book> an = query.list();
        tran.commit();
        session.close();
		return an.get(0);
	}

	@Override
	public boolean updatebook(Book book) { 
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Book b=session.get(Book.class, book.getBookId());
        b.setName(book.getName());
        b.setPrice(book.getPrice());
        b.setIntroduce(book.getIntroduce());
        b.setImgUrl(book.getImgUrl());
        tran.commit();
        session.close();
		return true;
	}

	@Override
	public boolean deleteBook(Integer id) {
		System.out.println(id);
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Book b=session.get(Book.class, id);
        session.delete(b);
        tran.commit();
        session.close();
		return true;
	}

	@Override
	public boolean insertAbook(Book book) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Book b=new Book();
        b.setName(book.getName());
        b.setIntroduce(book.getIntroduce());
        b.setPrice(book.getPrice());
        b.setImgUrl(book.getImgUrl());
        session.save(b);
        tran.commit();
        session.close();
		return true;
	}

	////////////////////////////////////////图书种类
	@Override
	public List<kind> Allselectkind() {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Query query = session.createQuery("from kind");
        List<kind> an = query.list();
        tran.commit();
        session.close();
		return an;
	}

	@Override
	public boolean deletekind(Integer id) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        kind k=session.get(kind.class, id);
        session.delete(k);
        tran.commit();
        session.close();
		return true;
	}

	@Override
	public boolean insertAkind(kind akind) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        kind k=new kind();
        k.setKindName(akind.getKindName());
        session.save(k);
        tran.commit();
        session.close();
		return true;
	}
///////////////////////////////用户
	
	@Override
	public List<User> selectBuser(Integer i) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Query query = session.createQuery("from User where userId=?");
        query.setParameter(0, i);
        List<User> bn = query.list();
        tran.commit();
        session.close();
		return bn;
		}
	
	@Override
	public List<User> AllselectUser() {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Query query = session.createQuery("from User");
        List<User> an = query.list();
        tran.commit();
        session.close();
		return an;
	}
	
	@Override
	public boolean deleteUser(Integer id) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        User u=session.get(User.class, id);
        session.delete(u);
        tran.commit();
        session.close();
		return true;
	}
	/////////////////订单
	@Override
	public List<Orders> AllselectOrders() {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Query query = session.createQuery("from Orders");
        List<Orders> an = query.list();
        tran.commit();
        session.close();
		return an;
	}

	@Override
	public List<Book> findBookbyname(String name) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Book where name=?");
        query.setParameter(0, name);
        List<Book> an = query.list();
        tran.commit();
        session.close();
        return an;
	}

	@Override
	public List<User> findordersbyname(String name) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from User where name=?");
        query.setParameter(0, name);
        List<User> an = query.list();
        tran.commit();
        session.close();
        return an;
	}

	@Override
	public boolean deleteOrders(Integer id) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Orders s=session.get(Orders.class, id);
        session.delete(s);
        tran.commit();
        session.close();
		return true;
	}

	@Override
	public List<Hotbook> AllhotBook() {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Query query = session.createQuery("from Hotbook");
        List<Hotbook> an = query.list();
        tran.commit();
        session.close();
        return an;
	}

	@Override
	public boolean deleteAhotbook(Integer id) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Hotbook h=session.get(Hotbook.class, id);
        session.delete(h);
        tran.commit();
        session.close();
		return true;
	}

	@Override
	public boolean insertAhotbook(int bookId) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Hotbook h=new Hotbook();
        h.setBookId(bookId);
        session.save(h);
        tran.commit();
        session.close();
        return true;
	}

	@Override
	public List<Newbook> AllnewBook() {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Query query = session.createQuery("from Newbook");
        List<Newbook> an = query.list();
        tran.commit();
        session.close();
        return an;
	}

	@Override
	public boolean deleteAnewbook(Integer id) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Newbook h=session.get(Newbook.class, id);
        session.delete(h);
        tran.commit();
        session.close();
		return true;
	}

	@Override
	public boolean insertAnewbook(int bookId) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Newbook n=new Newbook();
        n.setBookId(bookId);
        session.save(n);
        tran.commit();
        session.close();
        return true;
	}















	
	@Override
	public List<kind> findAkindbyid(Integer id) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Query query = session.createQuery("from kind where kindId=?");
        query.setParameter(0, id);
        List<kind> an = query.list();
        tran.commit();
        session.close();
		return an;
	}

	@Override
	public List<Book> Allselectbook() {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Query query = session.createQuery("from Book");
        List<Book> an = query.list();
        tran.commit();
        session.close();
		return an;
	}

	@Override
	public List<Book> selectAbookbyid(Integer id) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Query query = session.createQuery("from Book where bookId=?");
        query.setParameter(0, id);
        List<Book> an = query.list();
        tran.commit();
        session.close();
		return an;
	}

/////////用户登录
	@Override
	public boolean userLogin(String auser, String password,HttpServletRequest request) {
		Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
        Query query1 = session.createQuery("from User where name=? and password=?");
        query1.setParameter(0, auser);
        query1.setParameter(1, password);
        List<User> u1=query1.list();
        Query query2 = session.createQuery("from User where email=? and password=?");
        query2.setParameter(0, auser);
        query2.setParameter(1, password);
        List<User> u2=query2.list();
        tran.commit();
        session.close();
        if(u1.size()>0 || u2.size()>0) {
        	if(u1.size()>0) {
        		int a1=u1.get(0).getUserId();
        		request.getSession().setAttribute("user", a1);
        	}
        	if(u2.size()>0) {
        		int a2=u2.get(0).getUserId();
        		request.getSession().setAttribute("user", a2);
        	}
        	return true;
        }else {
        	return false;
        }
		
	}

	/////////////添加购物车
@Override
public boolean jiaShopcur(int i, String bookId, String num) {
	Session session = hibernateUtil.openSession();
    Transaction tran = session.beginTransaction();
    Book b=session.get(Book.class,Integer.parseInt(bookId));
    int price=Integer.parseInt(b.getPrice());
    //int sum=price*Integer.parseInt(num);
    Query query = session.createQuery("from Shopcur where userId=? and bookId=?");
    query.setParameter(0, i);
    query.setParameter(1, Integer.parseInt(bookId));
    List<Shopcur> an = query.list();
    if(an.size()>0) {
    	int number=an.get(0).getNumber();
    	number=number+Integer.parseInt(num);
    	int sum=price*number;
    	int shopcurId1=an.get(0).getShopcurId();
    	Shopcur h=session.get(Shopcur.class, shopcurId1);
    	h.setNumber(number);
    	h.setSum(sum);
    	
    }
    if(an.size()==0) { 
    	int sum=price*Integer.parseInt(num);
    	Shopcur s=new Shopcur();
    	s.setUserId(i);
    	s.setBookId(Integer.parseInt(bookId));
    	s.setNumber(Integer.parseInt(num));
    	s.setSum(sum);
    	session.save(s);
    }
    tran.commit();
    session.close();
	return true;
}

@Override
public List<Shopcur> Allselectshopcur(int i) {
	Session session = hibernateUtil.openSession();
    Transaction tran = session.beginTransaction();
    Query query = session.createQuery("from Shopcur where userId=?");
    query.setParameter(0, i);
    List<Shopcur> an = query.list();
    tran.commit();
    session.close();
	if(an.size()>0) {
		return an;
	}else {
		return null;
	}
}

@Override
public boolean deleteAshopcur(Integer id) {
	Session session = hibernateUtil.openSession();
    Transaction tran = session.beginTransaction();
    Shopcur s=session.get(Shopcur.class, id);
    session.delete(s);
    tran.commit();
    session.close();
	return true;
}

@Override
public boolean deleteAllshopcur(int i) {
	Session session = hibernateUtil.openSession();
    Transaction tran = session.beginTransaction();
    Query query = session.createQuery("delete from Shopcur where userId=?");
    query.setParameter(0, i);
    int ret=query.executeUpdate();
    tran.commit();
    session.close();
	return true;
}
/////////////订单
@Override
public boolean jiaOrders(int i,List<Shopcur> shopcur) {
	
    for(int a=0;a<shopcur.size();a++) {
    	Session session = hibernateUtil.openSession();
        Transaction tran = session.beginTransaction();
    	int ui=shopcur.get(a).getUserId();
    	User u=session.get(User.class, ui);
    	Orders s=new Orders();
    	s.setBookId(shopcur.get(a).getBookId());
    	u.getOrdersSet().add(s);
    	session.save(u);
    	session.save(s);
    	tran.commit();
    	session.close();
    }
    return true;
}

@Override
public List<User> OrdersList(int i) {
	Session session = hibernateUtil.openSession();
    Transaction tran = session.beginTransaction();
    Query query = session.createQuery("from User where userId=?");
    query.setParameter(0, i);
    List<User> an = query.list();
    tran.commit();
    session.close();
    if(an.size()>0) {
		return an;
	}else {
		return null;
	}
}

@Override
public boolean jiaAddress(Address address) {
	Session session = hibernateUtil.openSession();
    Transaction tran = session.beginTransaction();
    User u=session.get(User.class, address.getAddressId());
    Address a=new Address();
    a.setUser(u);
    a.setState(address.getState());
    a.setCity(address.getCity());
    a.setStreet(address.getStreet());
    session.save(a);
    tran.commit();
    session.close();
	return true;
}

@Override
public boolean insertUser(User user) {
	Session session = hibernateUtil.openSession();
    Transaction tran = session.beginTransaction();
    User u=new User();
    u.setName(user.getName());
    u.setPassword(user.getPassword());
    u.setEmail(user.getEmail());
    u.setImgUrl(user.getImgUrl());
    session.save(u);
    tran.commit();
    session.close();
	return true;
}

@Override
public List<Hotbook> AllselectHotbook() {
	Session session = hibernateUtil.openSession();
    Transaction tran = session.beginTransaction();
    Query query = session.createQuery("from Hotbook");
    List<Hotbook> an = query.list();
    tran.commit();
    session.close();
    return an;
}

@Override
public List<Newbook> AllselectNewbook() {
	Session session = hibernateUtil.openSession();
    Transaction tran = session.beginTransaction();
    Query query = session.createQuery("from Newbook");
    List<Newbook> an = query.list();
    tran.commit();
    session.close();
    return an;
}

@Override
public List<Book> findAbook(String name) {
	List<Book> aaa=null;
	Session session = hibernateUtil.openSession();
    Transaction tran = session.beginTransaction();
    Query query = session.createQuery("from Book where name=?");
    query.setParameter(0, name);
    List<Book> an = query.list();
    tran.commit();
    session.close();
    if(an.size()>0) {
    	aaa=an;
    }
    if(an.size()==0) {
    	aaa=null;
    }
    return aaa;
}

@Override
public boolean deleteAordersbyId(Integer id) {
	Session session = hibernateUtil.openSession();
    Transaction tran = session.beginTransaction();
    Orders o=session.get(Orders.class, id);
    session.delete(o);
    tran.commit();
    session.close();
    return true;
}

@Override
public List<Shopcur> findAshopcur(int userId, int bookId) {
	Session session = hibernateUtil.openSession();
    Transaction tran = session.beginTransaction();
    Query query = session.createQuery("from Shopcur where userId=? and bookId=?");
    query.setParameter(0, userId);
    query.setParameter(1, bookId);
    List<Shopcur> an = query.list();
    tran.commit();
    session.close();
	return an;
}
	


	

	

	

}
