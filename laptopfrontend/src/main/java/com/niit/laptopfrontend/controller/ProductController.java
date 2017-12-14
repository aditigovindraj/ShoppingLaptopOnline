package com.niit.laptopfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.fileinput.Fileinput;

import com.niit.laptopbackend.Dao.ProductDao;
import com.niit.laptopbackend.model.Product;



@Controller
public class ProductController
{
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
		String path="c:\\Users\\Dell\\workspace\\laptopfrontend\\src\\main\\webapp\\resources\\images\\";
	@RequestMapping("/product")
	public ModelAndView product()
	{
		ModelAndView obj= new ModelAndView("product");
			obj.addObject("product", new Product());
		List<Product> lp=productDao.list();
			obj.addObject("products", lp);
			return obj;
	}
	
	@RequestMapping("/addprod")
	public ModelAndView addprod(@ModelAttribute("product")Product product)
	{
		ModelAndView obj=new ModelAndView("redirect:/product");
		if(productDao.saveupdate(product))
		{
			Fileinput.upload(path, product.getPimg(),product.getP_id()+".jpg");
			obj.addObject("msg", "Product added successfully");
		}
		else
		{
			obj.addObject("msg1", "Product not saved");
		}
		return obj;
		}
	
	@RequestMapping("/editproduct/{p_id}")
	public ModelAndView viewprod(@PathVariable("p_id")String p_id)
	{
		ModelAndView obj1= new ModelAndView("product");
		product=productDao.get(p_id);
		List<Product> lp1= productDao.list();
		obj1.addObject("products", lp1);
		obj1.addObject("product", product);
		return obj1;
	}
	@RequestMapping("/deleteproduct/{p_id}")
	public ModelAndView delete(@PathVariable("p_id")String p_id)
	{
		ModelAndView obj=new ModelAndView("redirect:/product");
		product=productDao.get(p_id);
		if(productDao.delete(product))
		{
			obj.addObject("msg1","product is been deleted");
			}
		else
		{
			obj.addObject("msg2", "product is not deleted");
		}
	return obj;
	}
		
}
