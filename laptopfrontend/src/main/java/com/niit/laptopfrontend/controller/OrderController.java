package com.niit.laptopfrontend.controller;


	import java.util.List;

	import javax.servlet.http.HttpSession;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.authentication.AnonymousAuthenticationToken;
	import org.springframework.security.core.Authentication;
	import org.springframework.security.core.context.SecurityContextHolder;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;

import com.niit.laptopbackend.Dao.BillingAddrDao;
import com.niit.laptopbackend.Dao.CardDao;
import com.niit.laptopbackend.Dao.CartDao;
import com.niit.laptopbackend.Dao.CartItemDao;
import com.niit.laptopbackend.Dao.OrderDao;
import com.niit.laptopbackend.Dao.OrderItemDao;
import com.niit.laptopbackend.Dao.PayDao;
import com.niit.laptopbackend.Dao.ProductDao;
import com.niit.laptopbackend.Dao.ShippingAddrDao;
import com.niit.laptopbackend.Dao.UserDao;
import com.niit.laptopbackend.model.BillingAddr;
import com.niit.laptopbackend.model.Card;
import com.niit.laptopbackend.model.Cart;
import com.niit.laptopbackend.model.CartItem;
import com.niit.laptopbackend.model.Order;
import com.niit.laptopbackend.model.OrderItem;
import com.niit.laptopbackend.model.Pay;
import com.niit.laptopbackend.model.Product;
import com.niit.laptopbackend.model.ShippingAddr;
import com.niit.laptopbackend.model.user;
import com.niit.laptopfrontend.otp.Otpganarater;

	
	@Controller
	public class OrderController {


		@Autowired
		Cart cart;
		@Autowired
		CartDao cartDao;
		@Autowired
		CartItem cartItem;
		@Autowired
		CartItemDao cartItemDao;
		@Autowired
		Card card;
		@Autowired
		CardDao cardDao;
		@Autowired
		BillingAddr billingAddr;
		@Autowired
		BillingAddrDao billingAddrDao;
		@Autowired
		ShippingAddr shippingAddr;
		@Autowired
		ShippingAddrDao shippingAddrDao;
		@Autowired
		Pay pay;
		@Autowired
		PayDao payDao;
		@Autowired
		Order order;
		@Autowired
		OrderDao orderDao;
		@Autowired
		OrderItem orderItem;
		@Autowired
		OrderItemDao orderItemDao;
		@Autowired
		Product product;
		@Autowired
		ProductDao productDao;
		@Autowired
		user user;
		@Autowired
		UserDao userDao;
		@Autowired
		List<CartItem> cartItems;
		
		@Autowired
	    private JavaMailSender mailSender;
		
		String o;
		

		@RequestMapping("/Buyall")
		public String orderall(Model model,HttpSession session) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
				String currusername = authentication.getName();
				user = userDao.email(currusername);
				cart = user.getCart();
				product=null;
				cartItem = CartItemDao.getlist(cart.getC_id());
				if(cartItem==null || cartItem.isEmpty())
				{
					return "redirect:/viewcart";
				}
				else
				{
					billingAddr = billingAddrDao.get(user.getUid());
					List<ShippingAddr> shippingAddresies = shippingAddrDao.getAddrByUser(user.getUid());
					
					model.addAttribute("billing", billingAddr);
					model.addAttribute("user", user);
					model.addAttribute("shippingAddresies", shippingAddresies);
					model.addAttribute("shippingAddress", new ShippingAddr());
					session.setAttribute("p", product);
				}
				return "addressorder";
			} else {
				return "redirect:/";
			}

		}

		@RequestMapping("/Buy/{p_id}/{ci_id}")
		public String order(@PathVariable("p_id") String id, Model model,HttpSession session) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
				String currusername = authentication.getName();
				user = userDao.email(currusername);
				cart = user.getCart();
				cartItems=null;
				product = productDao.get(id);
				billingAddr = billingAddrDao.get(user.getUid());
				List<ShippingAddr> shippingAddresies = shippingAddrDao.getAddrByUser(user.getUid());
				
				model.addAttribute("billing", billingAddr);
				model.addAttribute("user", user);
				model.addAttribute("shippingAddresies", shippingAddresies);
				model.addAttribute("shippingAddress", new ShippingAddr());
				session.setAttribute("p", product);
				return "addressorder";
			} else {
				return "redirect:/";
			}

		}

		@RequestMapping("/orderConfirm")
		public String payment(@ModelAttribute("shippingAddress") ShippingAddr sh, Model model) {
//			if(cartItems==null || cartItems.isEmpty())
//			{
//				System.out.println("sorry");
//			}
			sh.setUser(user);
			shippingAddr = sh;
			model.addAttribute("billing", billingAddr);
			model.addAttribute("shippingAddress", shippingAddr);
			model.addAttribute("prot", product);
			model.addAttribute("cartItem",cartItem);
			model.addAttribute("cart",cart);
			return "orderconfirm";
		}

		@RequestMapping("/previous")
		public String previous(Model model) {
			List<ShippingAddr> shippingAddresies = shippingAddrDao.getAddrByUser(user.getUid());
			model.addAttribute("shippingAddresies", shippingAddresies);
			model.addAttribute("billing", billingAddr);
			model.addAttribute("shippingAddress", shippingAddr);
			model.addAttribute("product", product);
			
			return "addressorder";
		}

		@RequestMapping("/pay")
		public String pay(Model model) {
//			List<Card> cards = cardDao.getcardbyuser(user.getUid());
//			model.addAttribute("cards", cards);
//			model.addAttribute("card", new Card());
			return "Payment";
		}

		@RequestMapping("/pay")
		public String payment(@RequestParam("payb") String str, @RequestParam("otp")String otp, @ModelAttribute("card")Card c, Model model) {
					
	 		System.out.println(1324);
			int a;
			System.out.println(str);
					
			if (str.equalsIgnoreCase("Start Subscription")) {
				a = 2;
			} else {
				a = Integer.parseInt(str);
			}
			System.out.println(a);
			
			switch (a) {
			case 1:
					if(otp.equals(o))
					{
						pay.setPmethod("COD");
						pay.setPstatus("no");
					}
					else
					{
						return "redirect:/pay";
					}
				 
				break;
			case 2:
				pay.setPmethod("card");
				pay.setPstatus("yes");
				payDao.saveupdate(pay);
				cardDao.saveupdate(c);

				break;
			case 3:
				pay.setPmethod("Internet Banking");
				pay.setPstatus("yes");

			}

			return "redirect:/orderconfirmation";
		}

		@RequestMapping("/orderconfirmation")
		public String orderconformation(HttpSession session) {
			System.out.println(32);
			order.setBillingAddr(billingAddr);
			order.setShippingAddr(shippingAddr);
			order.setPay(pay);
			order.setUser(user);
			System.out.println(524);
			if (cartItems == null || cartItems.isEmpty()) 
			{
				order.setGrandtotal(product.getP_price());
				orderDao.saveupdate(order);
				orderItem.setOrder(order);
				orderItem.setP_id(product.getP_id());
				orderItemDao.saveupdate(orderItem);
				cart.setC_grandtotal(cart.getC_grandtotal() - cartItem.getPrice());
				cart.setC_totalitems(cart.getC_totalitems() - 1);
				session.setAttribute("items", cart.getC_totalitems());
				cartDao.saveupdate(cart);
				cartItemDao.delete(cartItemDao.getListall(cart.getC_id(),product.getP_id()).getCt_id());
				System.out.println(324);
			}
			else
			{ 
				System.out.println(656);
				order.setGrandtotal(cart.getC_grandtotal());
				orderDao.saveupdate(order);
				for(CartItem c:cartItems)
				{
					System.out.println(3444);
					orderItem.setOrder(order);
					orderItem.setP_id(c.getProduct().getP_id());
					System.out.println(3443);
					orderItemDao.saveupdate(orderItem);
					cartItemDao.delete(c.getCt_id());
				}
				cart.setC_grandtotal(0.0);
				cart.setC_totalitems(0);
				System.out.println(346);
				session.setAttribute("items", cart.getC_totalitems());
				cartDao.saveupdate(cart);
			}
			cartItem=null;
			cartItem=null;
			product=null;
			order=new Order();
			orderItem=new OrderItem();
			System.out.println(565);
			return "thankyou";
		}

	@RequestMapping(value="/SendMail")
	public void SendMail() {
		System.out.println(21312);
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	if (!(authentication instanceof AnonymousAuthenticationToken)) {
		String currusername = authentication.getName();
		user = userDao.email(currusername);      
		Otpganarater ot=new Otpganarater();
//		String o=ot.Otpga();
		o=ot.Otpga();
		String recipientAddress = user.getEmail();
		String subject="OTP";
	//String subject = request.getParameter("subject");
	String message = "your one time password is "+o+" ";

	// prints debug info
	System.out.println("To:" + recipientAddress);
	System.out.println("Subject: " + subject);
	System.out.println("Message: " + message);

	    
	//System.out.println("OTP:"+ otp);
	// creates a simple e-mail object
	SimpleMailMessage email = new SimpleMailMessage();
	email.setTo(recipientAddress);
	email.setSubject(subject);
	email.setText(message);
	//email.setSubject(otp);
	// sends the e-mail
	mailSender.send(email);

	 
	// forwards to the view named "Result"
	//return "Result";
	}
	}
	}

