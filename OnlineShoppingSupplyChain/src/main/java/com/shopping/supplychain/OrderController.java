package com.shopping.supplychain;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.DAO.CustomerOrderDAO;
import com.shopping.DAO.ManufacturerDAO;
import com.shopping.DAO.OrderItemDAO;
import com.shopping.DAO.ProductDAO;
import com.shopping.DAO.StockItemDAO;
import com.shopping.DAO.WarehouseDAO;
import com.shopping.beans.CustomerOrder;
import com.shopping.beans.Manufacturer;
import com.shopping.beans.OrderItem;
import com.shopping.beans.Person;
import com.shopping.beans.Product;
import com.shopping.beans.StockItem;
import com.shopping.beans.UserAccount;
import com.shopping.beans.Warehouse;

@Controller
public class OrderController {
	
	@Autowired
	private ManufacturerDAO manufacturerDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private CustomerOrderDAO customerOrderDAO;
	@Autowired
	private OrderItemDAO orderItemDAO;
	@Autowired
	private StockItemDAO stockItemDAO;
	@Autowired
	private WarehouseDAO warehouseDAO;

	@RequestMapping(value="/processCart.htm", method=RequestMethod.POST)
	protected ModelAndView processCart(HttpServletRequest request,HttpServletResponse response, HttpSession httpSession) throws Exception
	{
		if(request.getParameter("submit").equalsIgnoreCase("View Details"))
		{
			CustomerOrder customerOrder = customerOrderDAO.findCustomerOrderById(Integer.parseInt(request.getParameter("customerOrder")));
			ArrayList<OrderItem> orderItems = orderItemDAO.findOrderItemByOrder(customerOrder);
			return new ModelAndView("viewOrderDetail","orderItemList",orderItems);
		}
		if(request.getParameter("submit").equalsIgnoreCase("Confirm"))
		{
			CustomerOrder customerOrder = customerOrderDAO.findCustomerOrderById(Integer.parseInt(request.getParameter("customerOrder")));
			customerOrder.setStatus(CustomerOrder.Ordered);
			customerOrderDAO.update(customerOrder);
			ArrayList<OrderItem> orderItems = orderItemDAO.findOrderItemByOrder(customerOrder);
			for(int i=0;i<orderItems.size();i++)
			{
				orderItems.get(i).setStatus(CustomerOrder.Ordered);
				orderItemDAO.update(orderItems.get(i));
			}
			//customerOrderDAO.findOrdersByCustomer(person);
			return viewCart(request, response, httpSession);
		}
		if(request.getParameter("submit").equalsIgnoreCase("Check Out"))
		{	
			ArrayList<OrderItem> orderItems= new ArrayList<OrderItem>();
			UserAccount userAccount  = (UserAccount) request.getSession().getAttribute("loggedUser");
			ArrayList<CustomerOrder> customerOrders = customerOrderDAO.findOrdersByCustomer(userAccount.getPerson());
			for(int i=0;i<customerOrders.size();i++)
			{
				customerOrders.get(i).setStatus(CustomerOrder.Ordered);
				customerOrderDAO.update(customerOrders.get(i));
				orderItems = orderItemDAO.findOrderItemByOrder(customerOrders.get(i));
				for(int j=0;j<orderItems.size();j++)
				{
					orderItems.get(j).setStatus(CustomerOrder.Ordered);
					orderItemDAO.update(orderItems.get(j));
				}
				
			}
			
			return new ModelAndView("customerView","productList",productDAO.returnProductList());
		}
		return new ModelAndView("home");
	}
	
	
	@RequestMapping(value="/customerOrder.htm", method=RequestMethod.POST)
	protected ModelAndView addOrder(HttpServletRequest request,HttpServletResponse response, HttpSession httpSession) throws Exception
	{
		CustomerOrder customerOrder = new CustomerOrder();
		int cost = 0;
		ArrayList<OrderItem> orderItemList  =new ArrayList<OrderItem>();
		UserAccount userAccount  = (UserAccount) request.getSession().getAttribute("loggedUser");
		Person person = userAccount.getPerson();
		String[] productList = request.getParameterValues("checked");
		
		customerOrder.setPerson(person);
		customerOrder.setOrderItem_List(orderItemList);
		customerOrder.setStatus(CustomerOrder.Ordering);
		customerOrderDAO.persist(customerOrder);
		for(int i =0; i<productList.length;i++)
		{
			OrderItem orderItem = new  OrderItem();
			Product product=productDAO.findProductById(Integer.parseInt(productList[i]));
			orderItem.setOrder(customerOrder);
			orderItem.setProduct(product);
			orderItem.setQuantity(Integer.parseInt(request.getParameter(productList[i])));
			orderItem.setTotal(product.getPrice()*orderItem.getQuantity());
			orderItem.setStatus(CustomerOrder.Ordering);
			orderItemList.add(orderItem);
			orderItemDAO.persist(orderItem);
			cost+=orderItem.getTotal();
		}
		customerOrder.setCost(cost);
		
		customerOrderDAO.update(customerOrder);
		return callCustomerView(request, response);
	}
	
	@RequestMapping(value="/approveOrder.htm", method=RequestMethod.POST)
	protected ModelAndView approveOrder(HttpServletRequest request,HttpServletResponse response, HttpSession httpSession) throws Exception
	{
		if(request.getParameter("submit").equalsIgnoreCase("View Details"))
		{
			CustomerOrder customerOrder = customerOrderDAO.findCustomerOrderById(Integer.parseInt(request.getParameter("order")));
			ArrayList<OrderItem> orderItems = orderItemDAO.findOrderItemByOrder(customerOrder);
			return new ModelAndView("viewOrderDetail","orderItemList",orderItems);
		}
		if(request.getParameter("submit").equalsIgnoreCase("Approve"))
		{
			CustomerOrder customerOrder = customerOrderDAO.findCustomerOrderById(Integer.parseInt(request.getParameter("order")));
			customerOrder.setStatus(CustomerOrder.OrderApproved);
			customerOrderDAO.update(customerOrder);
			ArrayList<OrderItem> orderItems = orderItemDAO.findOrderItemByOrder(customerOrder);
			for(int i=0;i<orderItems.size();i++)
			{
				orderItems.get(i).setStatus(CustomerOrder.OrderApproved);
				orderItemDAO.update(orderItems.get(i));
			}
			return callAdminView(request, response);
		}
		if(request.getParameter("submit").equalsIgnoreCase("Approve All"))
		{	
			ArrayList<OrderItem> orderItems= new ArrayList<OrderItem>();
			//CustomerOrder customerOrder = customerOrderDAO.findCustomerOrderById(Integer.parseInt(request.getParameter("order")));
			ArrayList<CustomerOrder> customerOrders = customerOrderDAO.findOrderItemsByStatus(CustomerOrder.Ordered);
			for(int i=0;i<customerOrders.size();i++)
			{
				customerOrders.get(i).setStatus(CustomerOrder.OrderApproved);
				customerOrderDAO.update(customerOrders.get(i));
				orderItems = orderItemDAO.findOrderItemByOrder(customerOrders.get(i));
				for(int j=0;j<orderItems.size();j++)
				{
					orderItems.get(j).setStatus(CustomerOrder.OrderApproved);
					orderItemDAO.update(orderItems.get(j));
				}
				
			}
			return callAdminView(request, response);
		}
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/shipOrder.htm", method=RequestMethod.POST)
	protected ModelAndView shipOrder(HttpServletRequest request,HttpServletResponse response, HttpSession httpSession) throws Exception
	{
		if(request.getParameter("submit").equalsIgnoreCase("View Details"))
		{
			CustomerOrder customerOrder = customerOrderDAO.findCustomerOrderById(Integer.parseInt(request.getParameter("order")));
			ArrayList<OrderItem> orderItems = orderItemDAO.findOrderItemByOrder(customerOrder);
			return new ModelAndView("viewOrderDetail","orderItemList",orderItems);
		}
		if(request.getParameter("submit").equalsIgnoreCase("Ship"))
		{
			int i;
			String msg = new String();
			OrderItem orderItem =orderItemDAO.findOrderItemById(Integer.parseInt(request.getParameter("orderItem")));
			UserAccount userAccount= (UserAccount)request.getSession().getAttribute("loggedUser");
			ArrayList<StockItem> stockItemList = stockItemDAO.findStockItemByWarehouse(warehouseDAO.findWarehouseByManufacturer(userAccount.getPerson().getManufacturer()).get(0));
			for( i=0;i<stockItemList.size();i++)
			{
				StockItem stockItem = stockItemList.get(i);
					if(stockItem.getProduct().getId()==orderItem.getProduct().getId())
					{
						if(stockItem.getQuantity()<orderItem.getQuantity())
						{
							msg="Not enough item in stock. Cannot ship now";	
						}
						else
						{
							stockItem.setQuantity(stockItem.getQuantity()-orderItem.getQuantity());
							msg="Items Shipped";
							orderItem.setStatus(CustomerOrder.Shipped);
							stockItemDAO.update(stockItem);
							orderItemDAO.update(orderItem);
							request.setAttribute("message",msg);
							return callSellerView(request, response);	
						}
					}
			}
			
				msg="Product not present in inventory";
			request.setAttribute("message",msg);
			return callSellerView(request, response);
		}
		if(request.getParameter("submit").equalsIgnoreCase("Approve All"))
		{	
			ArrayList<OrderItem> orderItems= new ArrayList<OrderItem>();
			CustomerOrder customerOrder = customerOrderDAO.findCustomerOrderById(Integer.parseInt(request.getParameter("order")));
			ArrayList<CustomerOrder> customerOrders = customerOrderDAO.findOrdersByCustomer(customerOrder.getPerson());
			for(int i=0;i<customerOrders.size();i++)
			{
				customerOrders.get(i).setStatus(CustomerOrder.Shipped);
				customerOrderDAO.update(customerOrders.get(i));
				orderItems = orderItemDAO.findOrderItemByOrder(customerOrders.get(i));
				for(int j=0;j<orderItems.size();j++)
				{
					orderItems.get(j).setStatus(CustomerOrder.Shipped);
					orderItemDAO.update(orderItems.get(j));
				}
			}
			return callSellerView(request, response);
		}
		return new ModelAndView("home");
	}
	@RequestMapping(value="/myorders.htm", method=RequestMethod.GET)
	protected ModelAndView myOrders(HttpServletRequest request,HttpServletResponse response, HttpSession httpSession) throws Exception
	{
		UserAccount userAccount = (UserAccount)httpSession.getAttribute("loggedUser");
		ArrayList<CustomerOrder> customerOrderList = customerOrderDAO.findOrdersByCustomer(userAccount.getPerson());
		int i,j;
		for(i=0;i<customerOrderList.size();i++)
		{
			CustomerOrder customerOrder = customerOrderList.get(i);
			if(customerOrder.getStatus().equalsIgnoreCase(CustomerOrder.OrderApproved))
			{
				customerOrder.setStatus(CustomerOrder.Processing);
				customerOrderDAO.update(customerOrder);
			}
			ArrayList<OrderItem> orderItemList = orderItemDAO.findOrderItemByOrder(customerOrderList.get(i));
			for(j=0;j<orderItemList.size();j++)
			{
				OrderItem  item = orderItemList.get(j);
				if(!item.getStatus().equalsIgnoreCase(CustomerOrder.Delivered))
				{
					break;
				}
			}
			if(j>=orderItemList.size())
			{
				customerOrder.setStatus(CustomerOrder.Delivered);
				customerOrderDAO.update(customerOrder);
			}
		}
		customerOrderList = customerOrderDAO.findOrdersByCustomer(userAccount.getPerson());
		return new ModelAndView("myorders","orderList",customerOrderList);
		
	}
	
	@RequestMapping(value="/confirmDelivery.htm", method=RequestMethod.POST)
	protected ModelAndView confirmDelivery(HttpServletRequest request,HttpServletResponse response, HttpSession httpSession) throws Exception
	{
		if(request.getParameter("submit").equalsIgnoreCase("View Details"))
		{
			CustomerOrder customerOrder = customerOrderDAO.findCustomerOrderById(Integer.parseInt(request.getParameter("order")));
			ArrayList<OrderItem> orderItems = orderItemDAO.findOrderItemByOrder(customerOrder);
			return new ModelAndView("viewOrderDetail","orderItemList",orderItems);
		}
		if(request.getParameter("submit").equalsIgnoreCase("Confirm Delivery"))
		{
			CustomerOrder customerOrder = customerOrderDAO.findCustomerOrderById(Integer.parseInt(request.getParameter("order")));
			customerOrder.setStatus(CustomerOrder.Shipped);
			customerOrderDAO.update(customerOrder);
			ArrayList<OrderItem> orderItems = orderItemDAO.findOrderItemByOrder(customerOrder);
			for(int i=0;i<orderItems.size();i++)
			{
				orderItems.get(i).setStatus(CustomerOrder.Delivered);
				orderItemDAO.update(orderItems.get(i));
			}
		}
		UserAccount userAccount =(UserAccount)httpSession.getAttribute("loggedUser");
		ArrayList<CustomerOrder> orderList= customerOrderDAO.findOrdersByCustomer(userAccount.getPerson());
		return new ModelAndView("myorders","orderList",orderList);
	}
	@RequestMapping(value="/updateOrder.htm", method=RequestMethod.POST)
	protected ModelAndView updateOrder(HttpServletRequest request,HttpServletResponse response, HttpSession httpSession) throws Exception
	{
		
		int cost = 0;
		ArrayList<OrderItem> orderItemList  =new ArrayList<OrderItem>();
		UserAccount userAccount  = (UserAccount) request.getSession().getAttribute("loggedUser");
		Person person = userAccount.getPerson();
		ArrayList<CustomerOrder> customerOrderList = customerOrderDAO.findOrdersByCustomer(person);
		String[] productsToUpdate = request.getParameterValues("checked");
		String[] productsToDelete = request.getParameterValues("toDelete");
		CustomerOrder customerOrder = customerOrderDAO.findCustomerOrderById(Integer.parseInt(request.getParameter("customerOrder")));
		if(request.getParameter("submit").equalsIgnoreCase("Delete"))
		{
			for(int i =0; i<productsToDelete.length;i++)
			{
				OrderItem orderItem = orderItemDAO.findOrderItemById(Integer.parseInt(productsToDelete[i]));
				cost-=orderItem.getTotal();
				orderItemDAO.delete(orderItem);
			}
		}
		if(request.getParameter("submit").equalsIgnoreCase("Update"))
		{
			for(int i =0; i<productsToUpdate.length;i++)
			{
				OrderItem orderItem = orderItemDAO.findOrderItemById(Integer.parseInt(productsToUpdate[i]));
				orderItem.setQuantity(Integer.parseInt(productsToUpdate[i]));
				orderItem.setTotal(orderItem.getProduct().getPrice()*orderItem.getQuantity());
				cost-=orderItem.getTotal();
				orderItemDAO.delete(orderItem);
			}	
		}
		if(request.getParameter("submit").equalsIgnoreCase("DeleteCustomerOrder"))
		{
			customerOrderDAO.delete(customerOrder);
			return new ModelAndView("myCart","orderList",customerOrderList);
		}
		
		customerOrder.setCost(cost);
		
		customerOrderDAO.update(customerOrder);
		
		return new ModelAndView("myCart","orderList",customerOrderList);
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
	
	
	protected ModelAndView viewCart(HttpServletRequest request,HttpServletResponse response, HttpSession httpSession) throws Exception
	{
		UserAccount userAccount  = (UserAccount) request.getSession().getAttribute("loggedUser");
		ArrayList<CustomerOrder> customerOrders = customerOrderDAO.findIncompleteOrdersByCustomer(userAccount.getPerson());
		return new ModelAndView("myCart","orderList",customerOrders);
		
	}
	private ArrayList<CustomerOrder> evaluateStatus(ArrayList<CustomerOrder> customerOrderList)
	{
		
		
		return customerOrderList;
	}
	
}
