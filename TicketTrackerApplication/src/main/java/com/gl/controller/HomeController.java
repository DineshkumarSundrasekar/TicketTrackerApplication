package com.gl.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.model.ListOfTicket;
import com.gl.service.TicketDetailsImpl;

@Controller
public class HomeController {

	@Autowired
	TicketDetailsImpl service;
	
	@RequestMapping("/ticket")
	public String welcome(Model m) {
		m.addAttribute("listOfTickets", service.findAll());
		
		return "home";
	}
	@RequestMapping("/createticket")
	public String create(Model m) {
		m.addAttribute("ticket", new ListOfTicket());
		return "createticket";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute ListOfTicket lot, Model m) {
		
		lot.setTicketCreatedOn(LocalDate.now());
		service.save(lot);
		m.addAttribute("ticket", "Ticket added Succesfully");
		return "redirect:/ticket";
	}
	@RequestMapping("/AllListOfTickets")
	public String getAllListOfTickets(Model m)
	{
		List<ListOfTicket> lot = service.findAll();
		m.addAttribute("listOfTickets", lot);
		return "home";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id, Model m)
	{
		service.deleteById(id);
		List<ListOfTicket> lot = service.findAll();
		m.addAttribute("listOfTickets", lot);
		 return "home";
	}
	@RequestMapping("/edit/{id}")
	public String update(@PathVariable("id") int id, Model m)
	{
		
		m.addAttribute("ticket", service.findById(id));
		return "createticket";
	}
	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") int id, Model m)
	{
		m.addAttribute("listOfTickets", service.findById(id));
		return "view-form";
	}
	@RequestMapping("/search")
	public String search(@RequestParam String ticketTittle, Model m) {
	    List<ListOfTicket> lot = service.findByTittle(ticketTittle);
	    m.addAttribute("listOfTickets", lot);
	    System.out.println(lot);
	    System.out.println("Reached");
	    return "search-form"; // Corrected the return statement to "search-form"
	}

}
