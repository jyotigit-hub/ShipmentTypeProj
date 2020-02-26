package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;

@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {
	@Autowired
	IOrderMethodService service;
	@RequestMapping("/show")
	public String ShowOrderMethod(Model model) {
		model.addAttribute("orderMethod",new OrderMethod());
		return "OrderMethodRegister";
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveOrderMethod(@ModelAttribute OrderMethod orderMethod,Model model) {
	         Integer id= service.saveOrderMethod(orderMethod);
	         String msg="record   "+id+ "   insert";
	         model.addAttribute("msg", msg);
	         model.addAttribute("orderMethod",new OrderMethod());
		return "OrderMethodRegister";
	}
	@RequestMapping("/all")
	public String viewOrderMethod(Model model) {
		List<OrderMethod> list=service.getAllOrderMethod();
		model.addAttribute("list",list);
		return "OrderMethodData";
	}
	@RequestMapping("/delete")
	public String deleteOrderMethod(@RequestParam("oid")Integer id ,Model model) {
		service.deleteOrderMethod(id);
		List<OrderMethod> list=service.getAllOrderMethod();
		model.addAttribute("list",list);
		return "OrderMethodData";
		
	}
	@RequestMapping("/edit")
	public String editOrderMethod(@RequestParam("oid")Integer id,Model model) {
	   OrderMethod odm=service.getOneOrderMethod(id);
	   model.addAttribute("orderMethod",odm);
		return "OrderMethodEdit";
	}
	@RequestMapping(value = "/update" ,method = RequestMethod.POST)
	public String updateOrderMethod(@ModelAttribute OrderMethod orderMethod ,Model model) {
		service.updateOrderMethod(orderMethod);
		List<OrderMethod> list=service.getAllOrderMethod();
		model.addAttribute("list",list);
		return "OrderMethodData";
	}
	}
