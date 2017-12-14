package com.niit.laptopfrontend.controller;


	import java.util.List;


    import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;

	import com.niit.laptopbackend.Dao.CategoryDao;
	import com.niit.laptopbackend.model.category;
	import com.niit.laptopbackend.Dao.ProductDao;
	import com.niit.laptopbackend.model.Product;
	import com.niit.laptopbackend.Dao.UserDao;
	import com.niit.laptopbackend.model.user;
	import com.niit.laptopbackend.Dao.SupplierDao;
	import com.niit.laptopbackend.model.supplier;
	
	
	@Controller
	public class HomeController 
	{
//	@Autowired
//	category category;
//	@Autowired
//	CategoryDao categoryDao;
	@Autowired
	supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	user user;
	@Autowired
	UserDao userDao;

	    @RequestMapping("/")
	    public String homepage()
	    {
	    	return "laptop";
	    }
	    @RequestMapping("/laptop")
	    public ModelAndView home()
	    {
	    	return new ModelAndView("laptop");
	    }
	    
	    @RequestMapping("/aboutus")
	    public String aboutus()
	    {
	    	return "aboutus";
	    }
	    @RequestMapping("/payment")
	    public String payment()
	    {
	    	return "payment";
	    }
	    @RequestMapping("/contact")
	    public String contact()
	    {
	    	return "contact";
	    }
	    @RequestMapping("/addrorder")
	    public String addrorder()
	    {
	    	return "addrorder";
	    }
//	    @RequestMapping("/login")
//	    public String login()
//	    {
//	    	return "login";
//	    }
	    @RequestMapping("/signup")
	    public String signup()
	    {
	    	return "signup";
	    }
	    @RequestMapping("/dell")
	    public String dell()
	    {
	    	return "dell";
	    }
	    @RequestMapping("/mac")
	    public String mac()
	    {
	    	return "mac";
	    }
	    @RequestMapping("/hp")
	    public String hp()
	    {
	    	return "hp";
	    }
	    
//	    @RequestMapping("/category")
//	    public ModelAndView category()
//	    {
//	    	ModelAndView obj=new ModelAndView("category");
//	   	obj.addObject("category",category);
//	   	List<category> lc=categoryDao.list();
//	   	obj.addObject("categories",lc);
//	    	return obj;
//	    }
//	    @RequestMapping("/supplier")
//	    public ModelAndView supplier()
//	    {
//	    	ModelAndView obj=new ModelAndView("supplier");
//	   	obj.addObject("supplier",supplier);
//	   	List<supplier> ls=supplierDao.list();
//	   	obj.addObject("suppliers",ls);
//	    	return obj;
//	    }
//	    @RequestMapping("/product")
//	    public ModelAndView product()
//	    {
//	    	ModelAndView obj=new ModelAndView("products");
//	   	obj.addObject("prod", new Product());
//	   	List<Product> lp=productDao.list();
//	   	obj.addObject("products",lp);
//	    	return obj;
//	    }
//	    @RequestMapping("/user")
//	    public ModelAndView user()
//	    {
//	    	ModelAndView obj=new ModelAndView("user");
//	   	obj.addObject("user",user);
//	   	List<user> lu=userDao.list();
//	   	obj.addObject("supplieres",lu);
//	    	return obj;
//	    }
//	    
	}
	


