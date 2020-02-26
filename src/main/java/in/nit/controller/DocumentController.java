package in.nit.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import in.nit.model.Document;
import in.nit.service.IDocumentService;

@Controller
@RequestMapping("/doc")
public class DocumentController {
	@Autowired
	IDocumentService service;
	@RequestMapping("/show")
	public String showDocument() {
		return "Document";
	}
	//get the data and save to db
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public String saveDocument(@RequestParam ("fileId")Integer fileId ,@RequestParam CommonsMultipartFile fileob,Model model) throws IOException {
		Document d=new Document();
		d.setFileId(fileId);
		d.setFileName(fileob.getOriginalFilename());
		d.setFileData(fileob.getBytes());
		Integer id=service.saveDocument(d);
		String msg="data insort"+id;
		model.addAttribute("msg",msg);
		return "Document";
	}

}
