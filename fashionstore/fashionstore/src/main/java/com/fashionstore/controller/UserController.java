package com.fashionstore.controller;

import java.io.ByteArrayInputStream;





import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.fashionstore.domain.User;
import com.fashionstore.service.UserService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
public class UserController {

	@Autowired
    private UserService service;

    @GetMapping("/")
    public String viewHomePage(Model model , @Param("keyword") Long keyword) {
        List<User> listuser = service.listAll(keyword);
        model.addAttribute("listuser", listuser);
        model.addAttribute("keyword", keyword);
        System.out.print("Get / ");	
       
        return "indexfeedback";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("User", new User());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("User") User us) {
        service.save(us);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String showEditUserPage(@PathVariable(name = "id") int id,Model model) {
      
        User us = service.get(id);
        model.addAttribute("User", us);
         return "new";
         
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteUserPage(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
    
    @GetMapping("/Thankufd")
    public String thank() {
        return "Thankufd";
    }

    @GetMapping("/homepage")
    public String home() {
        return "homepage";
    }

    
   
    @GetMapping("/contactus")
    public String contact() {
        return "contactus";
    }
    
   
    @GetMapping("/export")
	public ResponseEntity<Resource> generateExcelReport() throws IOException, DocumentException {
		List<User> users = service.listAll(null);

		Document document = new Document(PageSize.A4, 25, 25, 25, 25);

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		PdfWriter.getInstance(document, os);

		document.open();

		Paragraph title = new Paragraph("  Eleonora Online Fashionstore Feedbacks ",
				FontFactory.getFont(FontFactory.HELVETICA, 25, Font.BOLD, new BaseColor(0, 255, 0)));

		document.add(title);

		PdfPTable table = new PdfPTable(3);
		table.setSpacingBefore(25);
		table.setSpacingAfter(25);

		PdfPCell c1 = new PdfPCell(new Phrase("User ID"));
		table.addCell(c1);

		PdfPCell c2 = new PdfPCell(new Phrase("Feedback"));
		table.addCell(c2);

		PdfPCell c3 = new PdfPCell(new Phrase("Helpfull"));
		table.addCell(c3);


		for (User user : users) {
			table.addCell(String.valueOf(user.getId()));
			table.addCell(user.getFeedback());
			table.addCell(String.valueOf(user.getHelpfull()));
			
		}

		document.add(table);
		
		document.close();

		ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Eleonora Online Fashionstore.pdf");

		ResponseEntity<Resource> response = new ResponseEntity<Resource>(new InputStreamResource(is), headers,
				HttpStatus.OK);

		return response;
	}
    
}