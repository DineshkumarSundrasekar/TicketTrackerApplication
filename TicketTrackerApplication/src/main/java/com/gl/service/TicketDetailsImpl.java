package com.gl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.model.ListOfTicket;
import com.gl.repository.TicketRepository;
@Service
public class TicketDetailsImpl implements TicketDetails {

	@Autowired
	TicketRepository dao;
	@Override
	public void save(ListOfTicket lot) {
		dao.save(lot);
	}
	@Override
	public List<ListOfTicket> findAll() {
		List<ListOfTicket> lot = dao.findAll();
		return lot;
	}
	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}
	@Override
	public ListOfTicket findById(int id) {
		Optional<ListOfTicket>  lot =dao.findById(id);
		return lot.get();
	}
	
	@Override
	public List<ListOfTicket> findByTittle(String ticketTittle) {
		return dao.findByTicketTittle(ticketTittle);
	}
	

}
