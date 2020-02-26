package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.Uom;
import in.nit.service.IUomService;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	IUomService service;
	@RequestMapping("/show")
	public String Showregister() {
		return "UnitOfMesure";
		
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST)
public String register(@ModelAttribute Uom uom,Model model) {
	Integer id=service.saveUom(uom);
	String msg="record "+id+" save";
	model.addAttribute("msg",msg);
	return "UnitOfMesure";
}
	@RequestMapping("/all")
public String getallUomdetails(Model model) {
	List<Uom> list=service.getAllUom();
	model.addAttribute("list",list);
	return "UomData";
}
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("uid")Integer id,Model model) {
		service.deleteUom(id);
		List<Uom> list=service.getAllUom();
		model.addAttribute("list",list);
		String msg="delete"+id+ " uom record";
		model.addAttribute("msg",msg);
		return "UomData";
		
	}
}
