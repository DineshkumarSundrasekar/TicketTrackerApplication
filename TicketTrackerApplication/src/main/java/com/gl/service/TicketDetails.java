package com.gl.service;

import java.util.List;
import java.util.Optional;

import com.gl.model.ListOfTicket;

public interface TicketDetails {
	public void save(ListOfTicket lot);
	public List<ListOfTicket> findAll();
	public void deleteById(int id);
	public ListOfTicket findById(int id);
	List<ListOfTicket> findByTittle(String ticketTittle);
}
