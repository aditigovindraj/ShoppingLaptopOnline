package com.niit.laptopfrontend.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.laptopbackend.Dao.UserDao;
import com.niit.laptopbackend.model.BillingAddr;
import com.niit.laptopbackend.model.user;

@Controller


public class UserController 
{
	@Autowired
	user user;
	@Autowired
	UserDao userDao;
	
	 @RequestMapping("/user")
	    public ModelAndView user()
	    {
	    	ModelAndView obj=new ModelAndView("user");
	    	BillingAddr bah = new BillingAddr();
	    	user.setBillingAddr(bah);
	   	obj.addObject("user",user);
	   	List<user> lu=userDao.list();
	   	obj.addObject("users",lu);
	    	return obj;
	    }

		@RequestMapping(value="/adduse",method=RequestMethod.POST)
		public ModelAndView adduse(@ModelAttribute("user")user user)
		{
			ModelAndView obj=new ModelAndView("redirect:/user");
			if(userDao.saveupdate(user))
			{
				obj.addObject("msg1","user added successfully");
			}
			else
			{
				obj.addObject("msg2","adding user failed ");
			}
			
			return obj;
		}
	

}
