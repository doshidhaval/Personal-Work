package com.shopping.supplychain;


import java.util.ArrayList;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.shopping.DAO.AddressDAO;
import com.shopping.DAO.CustomerOrderDAO;
import com.shopping.DAO.ManufacturerDAO;
import com.shopping.DAO.OrderItemDAO;
import com.shopping.DAO.ProductDAO;
import com.shopping.DAO.StockItemDAO;
import com.shopping.DAO.UserAccountDAO;
import com.shopping.DAO.PersonDAO;
import com.shopping.DAO.WarehouseDAO;
import com.shopping.beans.Address;
import com.shopping.beans.Manufacturer;
import com.shopping.beans.CustomerOrder;
import com.shopping.beans.OrderItem;
import com.shopping.beans.Product;
import com.shopping.beans.StockItem;
import com.shopping.beans.UserAccount;
import com.shopping.beans.Person;
import com.shopping.beans.Warehouse;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private UserAccountDAO userDAO;
	@Autowired
	private PersonDAO personDAO;
	@Autowired
	private AddressDAO addressDAO;
	@Autowired
	private ManufacturerDAO manufacturerDAO;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private WarehouseDAO warehouseDAO;
	@Autowired
	private StockItemDAO stockItemDAO;
	@Autowired
	private OrderItemDAO orderItemDAO;
	@Autowired
	private CustomerOrderDAO customerOrderDAO;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = {"/","/home.htm"}, method = RequestMethod.GET)


	protected ModelAndView home(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Cookie [] cookies = request.getCookies();
		if(cookies!=null){
			
			UserAccount userAccount = new UserAccount();
			String username = null;
			String password = null;
			for(Cookie c : cookies){
				if(c.getName().equals("username")){
					username=c.getValue();
				}
				if(c.getName().equals("password")){
					password=c.getValue();
				}
				userAccount = userDAO.findUserAccountByUserName(username, password);
			}
			if(userAccount!=null)
			if(userAccount.getRole()!=null)
			{
			request.getSession().setAttribute("loggedUser", userAccount);
			if(userAccount.getRole().equalsIgnoreCase(UserAccount.Admin))
				
			return callAdminView(request, response);
			
			if(userAccount.getRole().equalsIgnoreCase(UserAccount.Manufacturer))
				return callSellerView(request, response);
			
			if(userAccount.getRole().equalsIgnoreCase(UserAccount.Customer))
				return callCustomerView(request, response);
			}	
		}
		
		return new ModelAndView("home");
	}
			
	@RequestMapping(value = "/contactUs.htm", method = RequestMethod.GET)
	protected ModelAndView contactUs(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		return new ModelAndView("contact");
	}
	
	@RequestMapping(value="/seller_reg.htm", method=RequestMethod.GET)
	protected ModelAndView sellerRegisterationPage(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		return new ModelAndView("seller_registeration","message",null);
	}
	
	@RequestMapping(value="/submit_seller_reg.htm", method=RequestMethod.POST)
	protected ModelAndView registerSeller(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		String message= "";
		String zip = request.getParameter("zip");
		String username = request.getParameter("username");
		String mname = request.getParameter("mname");
		String email = request.getParameter("email");
		if(userDAO.checkUserName(username))
		{
			message="The given UserName already exists";
			return new ModelAndView("seller_registeration","message",message);
		}
		if(personDAO.checkEmail(email))
		{
			message="The given Email already exists";
			return new ModelAndView("seller_registeration","message",message);
		}
		if(manufacturerDAO.checkMName(mname))
		{
			message="The given Manufacturer Name already exists";
			return new ModelAndView("seller_registeration","message",message);
		}
		
		Person person = new Person();
		UserAccount userAccount = new UserAccount();

		Manufacturer manufacturer = new Manufacturer();
		
		Address address = new Address();
		
		address.setPerson(person);
		address.setCity(request.getParameter("city"));
		address.setCountry(request.getParameter("country"));
		address.setPerson(person);
		address.setState(request.getParameter("state"));
		address.setStreet1(request.getParameter("street1"));
		address.setStreet2(request.getParameter("street2"));
		address.setZip(request.getParameter("zip"));
		
		
		ArrayList<Address> addressList = new ArrayList<Address>();
		addressList.add(address);
		
		person.setFname(request.getParameter("fname"));
		person.setLname(request.getParameter("lname"));
		
		person.setContact_no(request.getParameter("phone"));
		person.setEmail(request.getParameter("email"));
		person.setUser_Account(userAccount);
		person.setManufacturer(manufacturer);
		person.setAddress_List(addressList);
		person.setOrder_List(null);
		
		manufacturer.setName(request.getParameter("mname"));
		manufacturer.setProduct_List(new ArrayList<Product>());
		manufacturer.setWarehouse_List(new ArrayList<Warehouse>());
				
		ArrayList<Person> personList =new ArrayList<Person>(); 
		personList.add(person);
		manufacturer.setPerson_List(personList);
	
		userAccount.setUsername(request.getParameter("username"));
		userAccount.setPassword(request.getParameter("password"));
		userAccount.setRole(UserAccount.Manufacturer);
		userAccount.setStatus(UserAccount.Waiting);
		userAccount.setPerson(person);
		
		manufacturerDAO.persist(manufacturer);
		return new ModelAndView("seller_registeration");
	}
	
//	@RequestMapping(value = {"/#openModal"}, method = RequestMethod.GET)
//	public String displayCustomerForm(ModelMap model) {
//		
//		return "home";
//	}
	
	@RequestMapping(value = {"/decisionManu.htm"}, method = RequestMethod.POST)
	public ModelAndView acceptManu(HttpServletRequest request,HttpServletResponse response) {
		int manuId = Integer.parseInt(request.getParameter("manuId"));
		Manufacturer manufacturer = null;
		String decision = request.getParameter("decision");
		ArrayList<Manufacturer> manuList = manufacturerDAO.returnUnverifiedManufacturerList();
		
		for(int i=0;i<manuList.size();i++)
		{
			manufacturer = manuList.get(i);
			if(manufacturer.getId() == manuId)
			{
				if(decision.equalsIgnoreCase("accept"))
				{
					manufacturer.getPerson_List().get(0).getUser_Account().setStatus(UserAccount.Active);
					break;
				}
				if(decision.equalsIgnoreCase("reject"))
				{
					manufacturer.getPerson_List().get(0).getUser_Account().setStatus(UserAccount.Suspended);
					break;
				}
			}
		}
		if(manufacturer!=null)
		manufacturerDAO.update(manufacturer);
		else
			System.out.println("null");
		return callAdminView(request, response);
	}
	
	@RequestMapping(value="/signUp.htm", method=RequestMethod.POST)
	protected ModelAndView customerSignUp(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Person person = new Person();
		person.setFname(request.getParameter("name"));
		person.setContact_no(request.getParameter("phone"));
		person.setEmail(request.getParameter("email"));
		person.setAddress_List(new ArrayList<Address>());
		person.setOrder_List(new ArrayList<CustomerOrder>());
		
		UserAccount userAccount = new UserAccount();
		userAccount.setUsername(request.getParameter("username"));
		userAccount.setPassword(request.getParameter("password"));
		userAccount.setRole(UserAccount.Customer);
		userAccount.setStatus(UserAccount.Active);
		userAccount.setPerson(person);
		person.setUser_Account(userAccount);
		personDAO.persist(person);	
		
		return new ModelAndView("home" );
	}
	
	@RequestMapping(value="/logout.htm", method=RequestMethod.GET)
	protected ModelAndView logout(HttpServletRequest request,HttpServletResponse response, HttpSession httpSession) throws Exception
	{
		httpSession.invalidate();
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/signIn.htm", method=RequestMethod.POST)
	protected ModelAndView signIn(HttpServletRequest request,HttpServletResponse response, HttpSession httpSession) throws Exception
	{
		System.out.println("welcome");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + password);
		UserAccount userAccount = userDAO.findUserAccountByUserName(username, password);
	if(userAccount!=null)
	{
				System.out.println("Correct");
				httpSession.setAttribute("loggedUser", userAccount);
				if (userAccount.getStatus().equalsIgnoreCase(UserAccount.Active)) {
					// cookie code here
					Cookie userCookie = new Cookie("username", username);
					Cookie passCookie = new Cookie("password", password);
					Cookie typeCookie = new Cookie("role", userAccount.getRole());
					response.addCookie(userCookie);
					response.addCookie(passCookie);
					response.addCookie(typeCookie);
				}
				else if(!userAccount.getStatus().equalsIgnoreCase(UserAccount.Active))
				{
					return new ModelAndView("inactive");
				}
				if(userAccount.getRole().equalsIgnoreCase(UserAccount.Admin))
				{
					return callAdminView(request, response);
				}
				
				if(userAccount.getRole().equalsIgnoreCase(UserAccount.Manufacturer))
				{
					return callSellerView(request, response);
					
				}
				if(userAccount.getRole().equalsIgnoreCase(UserAccount.Customer))
				{
					return callCustomerView(request, response);
				}
			} else {
				System.out.println("incorrect");
				
			}
			
			return new ModelAndView("home");
		}

	@RequestMapping(value="/addProduct.htm", method=RequestMethod.POST)
	protected ModelAndView addProduct(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws Exception
	{
		Manufacturer manufacturer;
		ArrayList<Product> productList = new ArrayList<Product>();
		UserAccount userAccount = (UserAccount) session.getAttribute("loggedUser");
		
		if(userAccount.getPerson()!=null)
			{
			 manufacturer = userAccount.getPerson().getManufacturer();}
		else
			{ manufacturer = new Manufacturer();}
		Product product = new Product();
		
		product.setManufacturer(manufacturer);
		product.setName(request.getParameter("name"));
		product.setPrice(Integer.parseInt(request.getParameter("price")+""));
		product.setType(request.getParameter("productType"));
		product.setOrderItemList(null);
		product.setStockItem(new StockItem());
		
		if(productDAO.findProductByManufacturer(manufacturer)!=null)
		{
			productList = productDAO.findProductByManufacturer(manufacturer); 
		}
		
		productList.add(product);
		manufacturer.setProduct_List(productList);
		manufacturerDAO.update(manufacturer);
		
		return callSellerView(request,response);
	}
	
	@RequestMapping(value="/addInventory.htm", method=RequestMethod.POST)
	protected ModelAndView addToInventory(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws Exception
	{
		
		StockItem stockItem = new StockItem();
		ArrayList<StockItem> stockItemList = new ArrayList<StockItem>();
		
		String[] idList = request.getParameterValues("checked");
		System.out.print(idList[0]);
		UserAccount userAccount= (UserAccount)request.getSession().getAttribute("loggedUser");
		Manufacturer manufacturer = (Manufacturer)userAccount.getPerson().getManufacturer();
		
		ArrayList<Warehouse> warehouseList = warehouseDAO.findWarehouseByManufacturer(manufacturer);
		Warehouse warehouse = new Warehouse();
		if(warehouseList==null )
		{
			warehouseList = new ArrayList<Warehouse>();
			warehouse.setManufacturer(manufacturer);
			warehouse.setLocation("Boston");
			warehouse.setStockItem_List(stockItemList);
			warehouseList.add(warehouse);
			warehouseDAO.persist(warehouse);
		}
		else
		{
			warehouse = warehouseList.get(0);
		}
		
		for(int i=0;i<idList.length;i++)
		{	
			Product product=productDAO.findProductById(Integer.parseInt(idList[i]));
			System.out.println("product"+product.getName());
			stockItem=stockItemDAO.checkStockItemList(product, warehouse);
			if(stockItem==null)
				{
				System.out.println("product"+product.getName());
					stockItem =new StockItem();
					stockItem.setProduct(product);
					stockItem.setWarehouse(warehouse);
					stockItemList.add(stockItem);
					stockItem.setQuantity(Integer.parseInt(request.getParameter(idList[i])));
					stockItemDAO.persist(stockItem);
				}
			else{
					System.out.println(stockItem.getId()+"Stock");
					int quantity = stockItem.getQuantity();
					quantity+=Integer.parseInt(request.getParameter(idList[i]));
					stockItem.setQuantity(quantity);
					stockItemDAO.update(stockItem);
			}	
		}
		
		return callSellerView(request,response);
	}
			
	@RequestMapping(value="/myCart.htm", method=RequestMethod.GET)
	protected ModelAndView viewCart(HttpServletRequest request,HttpServletResponse response, HttpSession httpSession) throws Exception
	{
		UserAccount userAccount  = (UserAccount) request.getSession().getAttribute("loggedUser");
		ArrayList<CustomerOrder> customerOrders = customerOrderDAO.findIncompleteOrdersByCustomer(userAccount.getPerson());
		return new ModelAndView("myCart","orderList",customerOrders);
		
	}
	
	
	private ModelAndView callSellerView(HttpServletRequest request,HttpServletResponse response)
	{
		ArrayList<StockItem> stockItemList = new ArrayList<StockItem>();
		UserAccount userAccount= (UserAccount)request.getSession().getAttribute("loggedUser");
		ArrayList<Warehouse> warehouseList = warehouseDAO.findWarehouseByManufacturer(userAccount.getPerson().getManufacturer());
		if(warehouseList!=null)
		{
			for(int i=0;i<warehouseList.size();i++)
			{
				ArrayList<StockItem> stockItems = stockItemDAO.findStockItemByWarehouse(warehouseList.get(i));
				for(int j=0;j<stockItems.size();j++)
				{
					stockItemList.add(stockItems.get(j));
				}
			}
		}
		ArrayList<OrderItem> orderItemList =orderItemDAO.findOrderItemsByStatusandManufacturer(CustomerOrder.OrderApproved, userAccount.getPerson().getManufacturer());
		request.setAttribute("stockItemList", stockItemList);
		request.setAttribute("orderItemList", orderItemList);
		ArrayList<Product> productList = productDAO.findProductByManufacturer(userAccount.getPerson().getManufacturer());
		return new ModelAndView("seller_view","productList",productList);
		
	}
	
	private ModelAndView callAdminView(HttpServletRequest request,HttpServletResponse response){
		
		ArrayList<Manufacturer> manuList = manufacturerDAO.returnUnverifiedManufacturerList();
		ArrayList<CustomerOrder> orderList = customerOrderDAO.findOrderItemsByStatus(CustomerOrder.Ordered);
		request.setAttribute("orderList", orderList);
		return new ModelAndView("admin_view","manuList",manuList);
	}
	
	private ModelAndView callCustomerView(HttpServletRequest request,HttpServletResponse response){
		
		UserAccount userAccount= (UserAccount)request.getSession().getAttribute("loggedUser");
		ArrayList<Product> productList = productDAO.returnProductList();
		ArrayList<CustomerOrder> orderList = customerOrderDAO.findOrdersByCustomer(userAccount.getPerson());
		request.setAttribute("orderList", orderList);
		return new ModelAndView("customerView","productList",productList);
	}
}
