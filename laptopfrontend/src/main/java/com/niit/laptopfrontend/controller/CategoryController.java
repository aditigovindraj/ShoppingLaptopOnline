package com.niit.laptopfrontend.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.laptopbackend.Dao.CategoryDao;
import com.niit.laptopbackend.Dao.ProductDao;
import com.niit.laptopbackend.model.Product;
import com.niit.laptopbackend.model.category;
@Transactional
@Controller
public class CategoryController {

	@Autowired
	category category;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/category")
	public ModelAndView category()
	{
		ModelAndView obj= new ModelAndView("category");
			obj.addObject("category", new category());
		List<category> lc=categoryDao.list();
			obj.addObject("categories", lc);
			return obj;
	}
	
	@RequestMapping("/addcat")
	public ModelAndView addcat(@ModelAttribute("category")category category)
	{
		ModelAndView obj=new ModelAndView("redirect:/category");
		if(categoryDao.saveupdate(category)==true)
		{
			obj.addObject("msg", "Category added successfully");
		}
		else
		{
			obj.addObject("msg1", "Category not saved");
		}
		return obj;
		}
	
	@RequestMapping("/editcategory/{cid}")
	public ModelAndView viewcat(@PathVariable("cid")String cid)
	{
		ModelAndView obj1= new ModelAndView("category");
		category=categoryDao.get(cid);
		List<category> lc1= categoryDao.list();
		obj1.addObject("categories", lc1);
		obj1.addObject("category", category);
		return obj1;
	}
	@RequestMapping("/deletecategory/{cid}")
	public ModelAndView delete(@PathVariable("cid")String cid)
	{
		ModelAndView obj=new ModelAndView("redirect:/category");
		category=categoryDao.get(cid);
		List<Product> lists=productDao.getProductByCategory("category");
		if(lists==null||lists.isEmpty())
		{
			categoryDao.delete(category);
			obj.addObject("msg","category deleted successfully");
		}
		else
		{
			for(Product p:lists)
			{
				productDao.delete(p);
			}
			categoryDao.delete(category);
			obj.addObject("msg1","category and list of product is been deleted");
			}
		
	return obj;
	}
		
	}
	
		
	
	

