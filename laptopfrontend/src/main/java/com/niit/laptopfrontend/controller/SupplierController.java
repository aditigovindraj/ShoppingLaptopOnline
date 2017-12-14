package com.niit.laptopfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.laptopbackend.Dao.ProductDao;
import com.niit.laptopbackend.Dao.SupplierDao;
import com.niit.laptopbackend.model.Product;
import com.niit.laptopbackend.model.supplier;
@Controller
public class SupplierController 
{
	@Autowired
	supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/supplier")
	public ModelAndView supplier()
	{
		ModelAndView obj= new ModelAndView("supplier");
			obj.addObject("supplier", new supplier());
		List<supplier> ls=supplierDao.list();
			obj.addObject("suppliers", ls);
			return obj;
	}
			
	@RequestMapping("/addsup")
	public ModelAndView addsup(@ModelAttribute("supplier")supplier supplier)
	{
		ModelAndView obj=new ModelAndView("redirect:/supplier");
		if(supplierDao.saveupdate(supplier))
		{
			obj.addObject("msg", "Supplier added successfully");
		}
		else
		{
			obj.addObject("msg1", "Supplier not saved");
		}
		return obj;
		}
	
	@RequestMapping("/editsupplier/{sid}")
	public ModelAndView viewprod(@PathVariable("sid")String sid)
	{
		ModelAndView obj1= new ModelAndView("supplier");
		supplier=supplierDao.get(sid);
		List<supplier> ls1= supplierDao.list();
		obj1.addObject("suppliers", ls1);
		obj1.addObject("supplier", supplier);
		return obj1;
	}
	
	@RequestMapping("/deletesupplier/{sid}")
	public ModelAndView deletesup(@PathVariable("sid")String sid)
	{
		ModelAndView obj=new ModelAndView("redirect:/supplier");
		supplier=supplierDao.get(sid);
		List<Product> lists=productDao.getProductBySupplier("supplier");
		if(lists==null||lists.isEmpty())
		{
			supplierDao.delete(supplier);
			obj.addObject("msg","supplier deleted successfully");
		}
		else
		{
			for(Product p:lists)
			{
				productDao.delete(p);
			}
			supplierDao.delete(supplier);
			obj.addObject("msg1","supplier and list of product is been deleted");
			}
		
	return obj;
	}
	
}
