package com.ssi.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ssi.model.Product;
import com.ssi.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("savechanges")
	public ModelAndView saveChanges(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		ModelAndView mv=new ModelAndView("redirect:allproducts");
		return mv;
	}
	@RequestMapping("update")
	public ModelAndView showUpdateForm(@RequestParam("code") int pcode) {
		Product product=productService.productDetails(pcode);
		ModelAndView mv=new ModelAndView("pupdate");
		mv.addObject("product",product);
		
		List<String> names=Arrays.asList("Mouse","KeyBoard","LED","LCD","DVD","USBDrive","HDD");
		mv.addObject("pnames",names);
		return mv;
	}
	@RequestMapping("remove")
	public ModelAndView removeProduct(@RequestParam("code") int code) {
		Product product=productService.deleteProduct(code);
		ModelAndView mv=new ModelAndView("delete-confirm");
		mv.addObject("product", product);
		return mv;
	}
	
	//mapping to show product list
	@RequestMapping("allproducts")
	public ModelAndView showProductList() {
		//we will fetch products from DB, add them to ModelAndView object
		List<Product> products=productService.getAllProducts();
		ModelAndView mv=new ModelAndView("product-list");
		mv.addObject("products", products);
		return mv;
	}
	//mapping for save product form submission
	@RequestMapping("saveproduct")
	public ModelAndView saveProductDetails(@Valid @ModelAttribute("product") Product product, BindingResult result) { 
		if(result.hasErrors()) {
			//some errors are there
			//ModelAndView mv=new ModelAndView("errpage");
			ModelAndView mv=new ModelAndView("pentry");
			return mv;
		}
		productService.saveProduct(product);
		ModelAndView mv=new ModelAndView("save-confirm");
		return mv;
	}
	
	
	//mapping to show product entry page
	@RequestMapping("newproduct")
	public String showEntryForm() {
		return "pentry";
	}
	
	//mapping to process search
	@RequestMapping("dosearch")
	public ModelAndView searchProduct(@RequestParam("pcode") int code) {
		//talk to service to get the product-details
		Product product=productService.productDetails(code);
		//ModelAndView modelAndView=new ModelAndView("/WEB-INF/pages/details.jsp");
		ModelAndView modelAndView=new ModelAndView("details");
		modelAndView.addObject("product", product);
		return modelAndView;
	}
	//mapping to show input-page
	@RequestMapping("searchinput")
	public String showSearchForm() {
		//return "/WEB-INF/pages/searchpage.jsp";
		return "searchpage";
	}

}
