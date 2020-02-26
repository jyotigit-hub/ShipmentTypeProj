package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
import in.nit.view.ShipmentTypeExcleView;
import in.nit.view.ShipmentTypePdfView;
import javassist.expr.NewArray;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	IShipmentTypeService service;
//register
	@RequestMapping("/register")
	public String ShowRgister(Model model) {
		model.addAttribute("shipmentType",new ShipmentType());
		
		return "ShipmentTypeRegister";
	}
	//save 
	@RequestMapping(value = "/save",method = RequestMethod.POST)
public String Regiester(@ModelAttribute ShipmentType shipmentType,Model model) {
		Integer id=service.saveShipmentType(shipmentType);
		String msg="Record " +id+"Save";
		model.addAttribute("msg", msg);
		model.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
		
}
	//show all
	@RequestMapping("/all")
	public String getAllShipmentType(Model model) {
	List<ShipmentType> list=service.getAllShipmentType();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}
	//delete
	@RequestMapping("/delete")
	public String deleteShipment(@RequestParam("sid")Integer id,Model model) {
		service.deleteShipmentType(id);
		String msg="Record"+id+"delete";
		model.addAttribute("msg",msg);
		List<ShipmentType> list=service.getAllShipmentType();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}
	//show edit page
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("sid")Integer
			id,Model model) {
		ShipmentType st=service.getOneShipmentType(id);
		model.addAttribute("shipmentType", st);
		return "ShipmentTypeEdit";
	}
	//update
	@RequestMapping(value = "update" ,method = RequestMethod.POST)
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType,Model model){
		   service.updateShipmentType(shipmentType);
		   String msg="update "+shipmentType.getShipId()+"id";
		   model.addAttribute("msg",msg);
		   List<ShipmentType> list=service.getAllShipmentType();
			model.addAttribute("list",list);
			return "ShipmentTypeData";
		
	}
	@RequestMapping("/view")
	public String showOneRow(@RequestParam("sid")Integer id,Model model) {
		 ShipmentType s=service.getOneShipmentType(id);
		model.addAttribute("ob",s);
		
		return "ShipmentTypeView";
	}
	//get modele data and send to the excel view
	@RequestMapping("/excel")
	public ModelAndView getDatainExcle(@RequestParam(value = "id",required = false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcleView());
		if(id==null) {
			//all data show in excel
			List<ShipmentType>	list=service.getAllShipmentType();
			m.addObject("list",list);
		}
		else {
			//only one data show in excel
			ShipmentType list=service.getOneShipmentType(id);
			m.addObject("list",Arrays.asList(list));
		}
	

	return m;
	}
	//get data in pdf format
	@RequestMapping("/pdf")
	public ModelAndView showpdf(@RequestParam(value = "id",required = false)Integer id) {
		ModelAndView m=new ModelAndView();
		//set view
		m.setView(new ShipmentTypePdfView());
		//get all data and keeping in model attribute
		if(id==null) {
	List<ShipmentType> list=service.getAllShipmentType();
	m.addObject("list",list);
		}
		else {
			//only one data show in pdf
			ShipmentType list=service.getOneShipmentType(id);
			m.addObject("list",Arrays.asList(list));
		}
	
	return m;
	}
	}

