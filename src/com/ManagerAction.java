package com;




import java.io.File;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Address;
import com.bean.Book;
import com.bean.Hotbook;
import com.bean.Manager;
import com.bean.Newbook;
import com.bean.Orders;
import com.bean.Shopcur;
import com.bean.User;
import com.bean.kind;
import com.service.ManagerService;

@Controller
public class ManagerAction {
	@Autowired
	private ManagerService managerService;

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
////////////////////////////////////////
	//����������Ʒ
	@RequestMapping("/insertAnew")
	public String insertAnewbook(String bookId) {
		boolean b=managerService.iNewbook(Integer.parseInt(bookId));
		return "general";
	}
	
	//������Ʒ�б�
	@RequestMapping("/newbookList")
	public String newBookList(HttpServletRequest request) {
		List<Newbook> list=managerService.SNewbook();
		request.setAttribute("newbooklist", list);
		return "newbookList";
	}
	
	//ɾ��������Ʒ
		@RequestMapping("/deleteAnewbook")
		public String deleteAnewbook(Integer id) {
			boolean b=managerService.dNewbook(id);
			return "general";
		}
//////////////////////////////////////
	//������Ʒ�б�
	@RequestMapping("/hotbookList")
	public String hotBookList(HttpServletRequest request) {
		List<Hotbook> list=managerService.SHotbook();
		request.setAttribute("hotbooklist", list);
		return "hotbookList";
	}
	
	//ɾ��������Ʒ
	@RequestMapping("/deleteAhotbook")
	public String deleteAhotbook(Integer id) {
		boolean b=managerService.dHotbook(id);
		return "general";
	}
	
	//����������Ʒ
	@RequestMapping("/insertAhot")
	public String insertAhotbook(String bookId) {
		boolean b=managerService.iHotbook(Integer.parseInt(bookId));
		return "general";
	}
/////////////////////////////////////	
	
	//ɾ������
	@RequestMapping("/deleteOrders")
	public String deleteOrders(Integer id) {		
		boolean an=managerService.dOrders(id);
		return "basic_form";
	}
	
	
	
	//ͨ���û����������ж���
	@RequestMapping(value="/findorders",method=RequestMethod.POST)
	public String findOrdersByName(String name,HttpServletRequest request) {
		List<User> as=managerService.findordersby(name);
		if(as.size()==0 || as.get(0).getOrdersSet().isEmpty()) {
			request.setAttribute("errorgsy", "�û������ڻ���û��޶���");
			return "basic_form";
		}else {
			request.setAttribute("findorder", as);
			return "AfindOrder";
		}
	}
	
	//�����б���Ϣ
	@RequestMapping("/orderList")
	public String orderlist(HttpServletRequest request) {
		List<Orders> list=managerService.SOrders();
		request.setAttribute("orderlist", list);
		return "orderList";
	}
//////////////////////////////////////////	
	//�û��б�
		@RequestMapping("/userList")
		public String userlist(Model model) {
			List<User> list=managerService.SUser();
			model.addAttribute("userlist", list);
			return "userList";
		}
	
	//ɾ���û�
		@RequestMapping("/deleteUser")
		public String deleteuser(Integer id) {		
			boolean an=managerService.dUser(id);
			return "basic_form";
		}
/////////////////////////////////////////////////		
	//ɾ��ͼ������
	@RequestMapping("/deletekind")
	public String deletekind(Integer id) {		
		boolean an=managerService.dkind(id);
		return "general";
	}
	
	//ͼ�������б�
	@RequestMapping("/kindList")
	public String kindlist(Model model) {
		List<kind> list=managerService.Skind();
		model.addAttribute("kindlist", list);
		return "kindList";
	}
	
	//ͼ����������
	@RequestMapping("/insertkind")
	public String insert(kind akind) {
		boolean result = managerService.ikind(akind);
		return "general";

	}
	
/////////////////////////////////////////////////////////	
	//ͼ������
	@RequestMapping("/insertbook")
	public String insertbook(Book book,@RequestParam(value="files") MultipartFile file,HttpServletRequest request) {
		 if (!file.isEmpty()) {  
	            try {  
	                // �ļ�����·��  
	                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"  
	                        + file.getOriginalFilename();  
	                // ת���ļ�  
	                file.transferTo(new File(filePath));  
	                book.setImgUrl(filePath);
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        } 
		boolean an=managerService.iBook(book);
		return "general";
	}
	
	//ͼ��ɾ��
	@RequestMapping("/deleteBook")
	public String deleteBook(Integer id) {		
		boolean an=managerService.dBook(id);
		return "general";
	}
	
	//ͼ���޸ı��ύ
	@RequestMapping("/updateBooksubmit")
	public String updatesubmit(Book book,@RequestParam(value="files") MultipartFile file,HttpServletRequest request) {
		 if (!file.isEmpty()) {  
	            try {  
	                // �ļ�����·��  
	                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"  
	                        + file.getOriginalFilename();  
	                // ת���ļ�  
	                file.transferTo(new File(filePath));  
	                book.setImgUrl(filePath);
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        } 
		boolean re=managerService.jBook(book);
		return "general";
	}
	
	//ͼ���б�
	@RequestMapping("/bookList")
	public String booklist(Model model) {
		List<Book> list=managerService.SBook();
		model.addAttribute("booklist", list);
		return "booklist";
	}
	//�޸�ͼ����Ϣ
	@RequestMapping("/updateBook")
	public String updateBook(Model model,Integer id) {
		Book book=managerService.findBookId(id);
		model.addAttribute("book", book);
		return "updatebook";
	}
	
	//����ͼ����Ϣ
	@RequestMapping(value="/findBook",method=RequestMethod.POST)
	public String findbook(Model model,String name) {
		List<Book> d=managerService.findBookby(name);
		if(d.size()>0) {
			model.addAttribute("Abook", d);
			return "findbook";
		}else{
			model.addAttribute("errormsg", "��Ʒ��Ϣ������");
			return "findbookError";
		}
	}
//////////////////////////////////////////////////////////////////////////////////////	
	//����Ա��¼
	@RequestMapping(value="/ManagerDenglu",method=RequestMethod.POST)
	public String dengluManager(Model model,String username,String password) {
		boolean d=managerService.manDeng(username,password);
		if(d) {
			return "simple";
		}else {
			model.addAttribute("errormsg", "��½ʧ�ܣ������µ�¼");
			return "ManagerError";
		}
	}
	
	//����Ա�б�
	@RequestMapping("/managerList")
	public String managerlist(Model model,String errormsg) {
		List<Manager> list = managerService.SManager();
		model.addAttribute("managerlist",list);
		model.addAttribute("errormsg", errormsg);
		return "managerlist";
	}
	
	//���ӹ���Ա
	@RequestMapping("/jiaManager")
	public String insert(Model model,Manager manager) {
		boolean result = managerService.IManager(manager);
		return "simple";}
////////////////////////////////////////////////////////////////////
		///////////չʾ��Ʒ����
		@RequestMapping("/showAorders")
		public String showAorders(int userId,int bookId,HttpServletRequest request) {
			List<Shopcur> list=managerService.showaOrders(userId, bookId);
			request.setAttribute("Aordershow", list);
			return "showOrders";
		}
		
		////////////������Ʒ
		@RequestMapping("/findAbook")
		public String findABook(String bookname,Model model) {
			String aaa=null;
			List<Book> list=managerService.SAbook(bookname);
			if(list!=null) {
			model.addAttribute("Abooklist", list);
			aaa="findAbook";
			}
			if(list==null) {
				aaa="index";
			}
			return aaa;
			
		}
		
		///////////������Ʒ
		@RequestMapping("/newbookk")
		public String newbookList(HttpServletRequest request) {
			List<Newbook> list=managerService.SNewbook1();
			request.setAttribute("newbooklist", list);
			return "newbookListt";
		}
		
		////////////////������Ʒ
		@RequestMapping("/hotbookk")
		public String hotbookList(HttpServletRequest request) {
			List<Hotbook> list=managerService.SHotbook1();
			request.setAttribute("hotbooklist", list);
			return "hotbookListt";
		}
		
		
		//////////////�û�ע��
		@RequestMapping(value="/ZhuceUser",method=RequestMethod.POST)
		public String ZhuceUser(String name,String password,String repassword,String email,@RequestParam(value="files") MultipartFile file,HttpServletRequest request) {
			User u=new User();
			if (!file.isEmpty()) {  
	            try {  
	                // �ļ�����·��  
	                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"  
	                        + file.getOriginalFilename();  
	                // ת���ļ�  
	                file.transferTo(new File(filePath)); 
	                u.setImgUrl(filePath);
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        } 
			u.setName(name);
			u.setPassword(password);
			u.setEmail(email);
			boolean b=managerService.jUser(u);
			return "jihuo";
		}
		
		/////////////���ӵ�ַ
		@RequestMapping("/jiaaddress")
		public String insertAddress(Address address,HttpServletRequest request) {
			int i=(int)request.getSession().getAttribute("user");
			address.setAddressId(i);
			boolean b=managerService.jAddress(address);
			return "index";
		}
		
		/////////////ȡ������
		@RequestMapping("/deleteAorders")
		public String deleteAorders(Integer id) {
			boolean b=managerService.dOrders1(id);
			return "index";
		}
		
		///////////////�����б�
		@RequestMapping("/Orderslist")
		public String OrdersList(HttpServletRequest request) {
			int i=(int)request.getSession().getAttribute("user");
			List<User> list=managerService.SOrders(i);
			request.setAttribute("Orderslist", list);
			return "ordersList";
		}
		
		///////////////��Ӷ���
		@RequestMapping("/jiaOrders")
		public String jiaOrders(HttpServletRequest request) {
			int i=(int)request.getSession().getAttribute("user");
			List<Shopcur> list=managerService.SShopcur(i);
			boolean b=managerService.jOrders(i, list);
			return "index";
		}
		
		////////////////ɾ�����ﳵ������Ʒ
		@RequestMapping("/deleteAllshopcur")
		public String deleteAllShopcur(HttpServletRequest request) {
			int i=(int)request.getSession().getAttribute("user");
			boolean b=managerService.deleteAllshopcur(i);
			return "index";
		}
		
		//////////////ɾ�����ﳵһ����Ʒ
		@RequestMapping("/deleteAshopcur")
		public String deleteAShopcur(Integer id) {
			boolean b=managerService.deleteAshopcur(id);
			return "index";
		}
		
		///////////////���ﳵ�б�
		@RequestMapping("/shopcurList")
		public String shopcurlist(HttpServletRequest request) {
			int i=(int)request.getSession().getAttribute("user");
			List<Shopcur> list=managerService.SShopcur(i);
			request.setAttribute("shopcurlist", list);
			return "shopcur";
		}
		
		/////////////�û���¼
		@RequestMapping(value="/userLogin",method=RequestMethod.POST)
		public String userlogin(Model model,String auser,String password,HttpServletRequest request) {
			boolean b=managerService.userLogin(auser, password, request);
			if(b) {
				return "index";
			}else {
				model.addAttribute("errormsg", "��½ʧ�ܣ������µ�¼");
				return "error";
			}
			
		}
		
		
		///////////////////���ﳵ
		@RequestMapping("/jiaShopcur")
		public String jiaShopcur(Model model,HttpServletRequest request,String bookId,String num) {
			int i=(int)request.getSession().getAttribute("user");
			boolean b=managerService.iShopcur(i, bookId, num);
			return "index";
		}
		///////////////////���ﳵ
		@RequestMapping("/gerenxinxi")
		public String gerenxinxi(Model model,HttpServletRequest request) {
			int i=(int)request.getSession().getAttribute("user");
			List<User> list=managerService.QUser(i);
			model.addAttribute("abc", list);
			return "gerenxinxi";
		}
		
		////////////////////��Ʒ��Ϣ
		@RequestMapping("/Bookbuy")
		public String Abookfind(Model model,Integer id) {
			List<Book> list=managerService.idSbook(id);
			model.addAttribute("abook", list);
			return "bookbuy";
		}
		
		////////////��Ʒ�б�
		@RequestMapping("/booklistt")
		public String booklist1(Model model) {
			List<Book> list=managerService.Sbook();
			model.addAttribute("booklist", list);
			return "bookListt";
		}
		
		///////��Ʒ����
		@RequestMapping("/bookkindd")
		public String kindlist1(Model model) {
			List<kind> list=managerService.Skind1();
			model.addAttribute("kindlist", list);
			return "kindListt";
		}
		
		//////////////һ����Ʒ�����µ�������Ʒ
		@RequestMapping("/akindbook")
		public String akindBook(HttpServletRequest request,Integer id) {
			List<kind> list=managerService.findAbook(id);
			request.setAttribute("akindbook", list);
			return "akindbook";		
		}
		//////////////////////////�˳���¼
		@RequestMapping("/tuichudenglu")
		public String tuichudenglu(Model model,HttpServletRequest req) {
			HttpSession ht=req.getSession(true);
			ht.removeAttribute("user");
			return "index";	
		}
}
